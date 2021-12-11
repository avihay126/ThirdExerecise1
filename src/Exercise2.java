public class Exercise2 {
    public static void main(String[] args) {
        int[] arr1 = {12, 54, 14, 62};
        int[] arr2 = {90, 102, 126, 81, 603, 431};
        indexHighestOfProximity(arr1, arr2);
    }
    public static int indexHighestOfProximity(int[] arr1, int[] arr2) {
        int index = 0;
        int highestProximity = 0;
        for (int i = 0; i < arr1.length; i++) {
            int levelClosing = 0;
            for (int j = 0; j < arr2.length; j++) {

                if (sumOfDigits(arr1[i]) == sumOfDigits(arr2[j])) {
                    levelClosing++;
                    if (levelClosing > highestProximity) {
                        highestProximity = levelClosing;
                        index = i;
                    }
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
