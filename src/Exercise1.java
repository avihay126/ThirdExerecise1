public class Exercise1 {
    public static void main(String[] args) {
        int number =456789;
        if ( number>0) {
            isRotatingNumber(number);
        }
        int[] array = {103, 96, 26};
        for (int i=0;i<array.length;i++){
            if (array[i]<=0){
                break;
            }
            else if (i==array.length-1){
                smallestSumOfRotatingNumber(array);
            }
        }
    }

    public static boolean isRotatingNumber(int number) {
        boolean isRotating = true;
        while (number != 0) {
            int units = number % 10;
            number = number / 10;
            if (number == 0) {
                break;
            }
            int tens = number % 10;
            if (isEven(units) == isEven(tens)) {
                isRotating = false;
                break;
            }
        }
        return isRotating;
    }

    public static boolean isEven(int number) {
        boolean isEven = false;
        if (number % 2 == 0) {
            isEven = true;
        }
        return isEven;
    }

    public static int smallestSumOfRotatingNumber(int[] array) {
        int index = -1;
        int minSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (isRotatingNumber(array[i])) {
                if (sumOfDigits(array[i]) < minSum || minSum == 0) {
                    minSum = sumOfDigits(array[i]);
                    index = i;
                }
            }
        }
        return index;
    }
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum = number % 10 + sum;
            number = number / 10;
        }
        return sum;
    }
}
