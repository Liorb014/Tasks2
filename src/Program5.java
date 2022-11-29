import java.util.Scanner;

public class Program5 {
    public static void main(String[] args) {
        //  char[] xando = {'x', 'x', 'o', 'x', 'o', 'x', 'o', 'o', 'x', 'o'};
        //printBoard(xando);
    }

    public static void printBoard(char[] xAndO) {
        if (xAndO.length==9){
            for (int i = 0; i < xAndO.length - 1; i++) {
                System.out.print(xAndO[i] + "\t");
                if (i == 2 || i == 5) {
                    System.out.println();
                }
            }
        }
    }

    public static boolean isAvailable(char[] board, int xAndODiscern) {
        boolean isEmpty = true;
        if (board[xAndODiscern] == 'x' || board[xAndODiscern] == 'o') {
            isEmpty = false;
        }
        return isEmpty;
    }
    public static int getPositionFromUser(char[] board) {
        Scanner scanner = new Scanner(System.in);
        int position = 0;
        position=scanner.nextInt();
        do {
            if (isAvailable(board, position) == true) {
            System.out.println("please enter a position to place your x/o (from 1-9)");
            position = scanner.nextInt();
            break;
            }
            if (position < 1 || position > 9 || !isAvailable(board, position)) {
                System.out.println("please try again your number already taken or out of boundary");
                position = scanner.nextInt();
            }
        } while (position < 1 || position > 9|| !isAvailable(board, position));
        return position;
    }
    public static char checkWinner(char[] board) {
        char theWinnerIs = '-';
        for (int i = 0; i < board.length; i++) {
            if (board[i] == board[i + 1] && board[i] == board[i + 2]) {
                if (board[i] == 'x') ;
                theWinnerIs = 'x';
            } else {
                theWinnerIs = 'o';
            }
            if (board[i] == board[i + 3] && board[i] == board[i + 5]) {
                if (board[i] == 'x') ;
                theWinnerIs = 'x';
            } else {
                theWinnerIs = 'o';
            }
            if ((board[0] == board[4] && board[0] == board[8]) || (board[2] == board[4] && board[2] == board[8])) {
                if (board[i] == 'x') ;
                theWinnerIs = 'x';
            } else {
                theWinnerIs = 'o';
            }
        }
        return theWinnerIs;
    }
    public static boolean placeSymbolOnBoard(char[] board, int placeOnBoard, char xOrO) {
        boolean wonExist = false;
        do {
            if (isAvailable(board, placeOnBoard)) {
                printBoard(board);
                board[placeOnBoard] = checkWinner(board);
            }
        }while (!wonExist || checkWinner(board)=='-');
        return wonExist;
    }
}
