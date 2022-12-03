import java.util.Scanner;

public class Program6 {
    public static void main(String[] args) {
        operatorConfiguration();
    }
    public static boolean valid (String equation){
        boolean equationIsValid = false;
        char[] array = new char[equation.length()];
        if (equation.contains("x^2") && equation.contains("=0")&&(equation.contains("x+") || equation.contains("x-"))){
            equationIsValid = true;
        }
        return equationIsValid;
    }
    public static int parameterA(String equation){
        int a=0;
        int numberLength=0;
        if(equation.startsWith("-")){
            for (int i = 0; i < equation.length(); i++) {
                if(equation.startsWith("-")){
                    i++;
                }
                if (equation.charAt(i)=='x'){
                    numberLength=i;
                    if(numberLength >1){
                        a= Integer.parseInt(equation.substring(0,numberLength));
                    }
                    break;
                }
            }
            a = Character.getNumericValue(equation.charAt(1)) * -1;
        }else {
            for (int i = 0; i < equation.length(); i++) {
                if(equation.startsWith("-")){
                    i++;
                }
                if (equation.charAt(i)=='x'){
                    numberLength=i;
                    if(numberLength >=1){
                        a= Integer.parseInt(equation.substring(0,numberLength));
                    }
                    break;
                }
            }
            // a = Character.getNumericValue(equation.charAt(0));
        }
        return a;
    }
    public static int parameterB(String equation){
        int b=0;
        int place=0;
        int numberLength = 0;
        if(equation.charAt(0)=='-'){
            if(parameterA(equation)>9){
                place++;
                if (parameterA(equation)/10 >=10){
                    place++;
                    if(equation.charAt(5+place) == '-'){
                        for (int i = 5; i < equation.length(); i++) {
                            if (equation.charAt(i)=='x'){
                                numberLength=i-5;
                                if(numberLength >= 1){
                                    b= Integer.parseInt(equation.substring(4,numberLength+1));
                                }
                                break;
                            }
                        }
                        b = Character.getNumericValue(equation.charAt(6))* -1;
                    }else {
                        b = Character.getNumericValue(equation.charAt(6));
                    }
                }
            }
        }else {
            if (equation.charAt(4) == '-') {
                for (int i = 4; i < equation.length(); i++) {
                    if (equation.charAt(i)=='x'){
                        numberLength=i-4;
                        if(numberLength >= 1){
                            b= Integer.parseInt(equation.substring(4,numberLength));
                        }
                        break;
                    }
                }

                b = Character.getNumericValue(equation.charAt(5))* -1;
            } else {
                for (int i = 5; i < equation.length(); i++) {
                    if (equation.charAt(i)=='x'){
                        numberLength=i-5;

                    }
                    if(numberLength >= 1){
                        b= Integer.parseInt(equation.substring(4,(4+numberLength+1)));
                        break;
                    }
                }
                // b = Character.getNumericValue(equation.charAt(5));
            }
        }
        return b;
    }

    public static int parameterC(String equation){
        int c=0;
        int numberLength=0;
        if(equation.charAt(0) == '-'||parameterA(equation)>9){
            if(equation.charAt(8) == '-'){
                for (int i = 8; i < equation.length(); i++) {
                    if (equation.charAt(i)=='x'){
                        numberLength=i-8;
                        if(numberLength >= 1){
                            c= Integer.parseInt(equation.substring(8,8+numberLength+1));
                        }
                        break;
                    }
                }
                c = Character.getNumericValue(equation.charAt(9))* -1;
            }else {
                c = Character.getNumericValue(equation.charAt(9));
            }
        }else {
            if (equation.charAt(7) == '-') {
                for (int i = 7; i < equation.length(); i++) {
                    if (equation.charAt(i)=='x'){
                        numberLength=i-7;
                        if(numberLength >= 1){
                            c= Integer.parseInt(equation.substring(7,7+numberLength));
                        }
                        break;
                    }
                }
                c = Character.getNumericValue(equation.charAt(8)) * -1;
            } else {
                for (int i = 7; i < equation.length(); i++) {
                    if (equation.charAt(i)=='x'){
                        numberLength=i-7;
                        if(numberLength >= 1){
                            c= Integer.parseInt(equation.substring(7,7+numberLength));
                        }
                        break;
                    }
                }

                // c = Character.getNumericValue(equation.charAt(8));
            }
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
