import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        aboveTheAverage();
    }
    public static void aboveTheAverage(){
        Scanner scanner = new Scanner(System.in);
        int average =0;
        int[] array =new int[10];
        for (int i =0; i < array.length;i ++ ){
            System.out.println("please enter your number");
            array[i] = scanner.nextInt();
            average +=array[i];
        }
        average = average/10;
        System.out.println("the next numbers are above the average: " );
        for (int j =0; j < array.length;j ++ ){
            if (array[j] > average ){
                System.out.print(array[j] + "\t");
            }
        }
    }
}
