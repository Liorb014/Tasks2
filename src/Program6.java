import java.util.Scanner;

public class Program6 {
    public static void main(String[] args) {
        operatorConfiguration();
    }
    public static boolean valid (String equation){
        boolean equationIsValid = false;
        if (equation.contains("x^2") && equation.contains("=0")&&(equation.contains("x+") || equation.contains("x-"))){
            equationIsValid = true;
        }
        return equationIsValid;
    }
    public static int parameterA(String equation){
        int a=0;
        if(equation.startsWith("-")){
            a = equation.charAt(2) * -1;
        }else {
            a = equation.charAt(0);
        }
        return a;
    }
    public static int parameterB(String equation){
        int b=0;
        if(equation.charAt(5) == '-'){
            b = equation.charAt(6) * -1;
        }else {
            b = equation.charAt(5);
        }
        return b;
    }
    public static int parameterC(String equation){
        int c=0;
        if(equation.charAt(8) == '-'){
            c = equation.charAt(9) * -1;
        }else {
            c = equation.charAt(8);
        }
        return c;
    }
    public static void solution(int a, int b , int c){
        double x1;
        double x2;
        double insideOfTheRoot = (b*b)-(4*a*c);
        if(insideOfTheRoot<0){
            System.out.println("there is no solution");
        }
        else if(insideOfTheRoot == 0){
            x1=-b/(a*2);
            System.out.println("x1 = "+x1);
        }
        else{
            x1 = (-b + Math.sqrt(insideOfTheRoot))/(a*2);
            x2 = (-b - Math.sqrt(insideOfTheRoot))/(a*2);
            System.out.println("x1 = "+x1+ " , x2 = "+x2);
        }
    }
    public static void operatorConfiguration(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter a quadratic equation:");
        String equation = scanner.nextLine();
        if (valid(equation)){
            int a = parameterA(equation);
            int b = parameterB(equation);
            int c = parameterC(equation);
            solution(a,b,c);
        }else {
            System.out.println("your input is invalid");
        }
    }
}
