public class Program3 {
    public static void main(String[] args) {
        int[] array = {1,2,3,3,4,3,1,5};
        System.out.print(deduction(array));
    }
    public static int[] deduction(int[] array) {
        int[] fixedArray = new int[array.length];
        int counter = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i + 1; j < array.length-1; j++) {
                if (array[i] != array[j]) {
                    fixedArray[j] = array[i];
                }else {
                    counter++;
                }
            }
            if (counter > 0) {
                fixedArray = new int[array.length - counter];
            }
        }
        return fixedArray;
    }
}
