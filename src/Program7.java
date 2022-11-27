import java.util.Random;
import java.util.Scanner;

public class Program7 {
    public static void main(String[] args) {
        gameStart();
    }
    public static int[] guessGame () {
        Random random = new Random();
        int min =1;
        int max =6;
        int[] numberForGuess = new  int[4];
        for (int i = 0; i < numberForGuess.length-1;i++ ){
            numberForGuess[i] = random.nextInt(max-min)+max;
            for (int j=i+1; j<numberForGuess.length-1;j++) {
                if (numberForGuess[i] != numberForGuess[j]) {
                    break;
                }else {
                    while (numberForGuess[i]==numberForGuess[j]){
                        numberForGuess[i]=random.nextInt(max-min)+max;
                    }
                }
            }
        }
        return numberForGuess;
    }
    public static int gettingGuess(int [] theNumberToGuess){
        int rightAnswer = 0;
        int partRightAnswer=0;
        Scanner scanner= new Scanner(System.in);
        int [] userGuess = new int[4];
        int i;
        System.out.println("please enter a 4 digit number for guess");
        for ( i = 0; i< userGuess.length;i++){
            userGuess[i]=scanner.nextInt();
            if (userGuess[i]<1){
                System.out.println(" please try again");
                userGuess[i]=scanner.nextInt();
            }
        }
        for (int j=0;j<userGuess.length;j++) {
            if (userGuess[j] == theNumberToGuess[j]) {
                rightAnswer ++;
            } else {
                if (userGuess[j]==theNumberToGuess[j+1]) {
                    partRightAnswer++;
                }
            }
        }
        return rightAnswer;
    }
    public static int gettingGuess2(int [] theNumberToGuess){
        int rightAnswer = 0;
        int partRightAnswer=0;
        Scanner scanner= new Scanner(System.in);
        int [] userGuess = new int[4];
        int i;
        System.out.println("please enter a 4 digit number for guess");
        for ( i = 0; i< userGuess.length;i++){
            userGuess[i]=scanner.nextInt();
            if (userGuess[i]<1){
                System.out.println(" please try again");
                userGuess[i]=scanner.nextInt();
            }
        }
        for (int j=0;j<userGuess.length;j++) {
            if (userGuess[j] == theNumberToGuess[j]) {
                rightAnswer ++;
            } else {
                if (userGuess[j]==theNumberToGuess[j+1]) {
                    partRightAnswer++;
                }
            }
        }
        return partRightAnswer;
    }
    public static int hinter(int right,int partRight) {
        int numbersOfTimes=0;
        if (right > 0) {
            System.out.println("u got " + right + "right digit in the number and in their location");
            if (partRight > 0) {
                System.out.println("u got " + partRight + "half right digit , the digit is right but not in the right place");
            }else {
                if (plansOfGames(hinter(gettingGuess(guessGame()),gettingGuess2(guessGame())))){
                    System.out.println("keep guessing");
                }else {
                    System.out.println("u got the whole number wrong please try again");
                    gettingGuess(guessGame());
                    numbersOfTimes++;
                }
            }
        }
        return numbersOfTimes;
    }
    public static boolean plansOfGames(int numbersOfTris){
        Scanner scanner = new Scanner(System.in);
        int option=0;
        System.out.println("please chose one of the game option from 1-4:");
        System.out.println("1.) easy level -20 trys");
        System.out.println("2.) medium level -15 trys");
        System.out.println("3.) hard level -10 trys");
        System.out.println("4. extreme -surprise mode -between 25-5 and without hints");
        System.out.println("please put your choice");
        option=scanner.nextInt();
        if(option<0||option>4){
            System.out.println("please enter only a number from 1 to 4:");
            option =scanner.nextInt();
        }
        if (option==1){
            numbersOfTris=20;
        }
        if (option==2){
            numbersOfTris=15;
        }
        if (option==3){
            numbersOfTris=10;
        }
        Random random = new Random();
        boolean surprise=false;
        if (option==4){
            numbersOfTris= random.nextInt(25-5)+5;
            surprise=true;
        }
        return surprise;
    }
    public static void gameStart(){
        plansOfGames(hinter(gettingGuess(guessGame()),gettingGuess2(guessGame())));

    }
}