import java.util.Arrays;

public class Exercise4 {
    public static void main(String[] args) {
        int[] arr1 = {10, 9, 8, 7, 6, 3};
        int[] arr2 = {2, 4, 1, 5, 3, 5};
        isFullArraySort(arr1);
        isFullArray(arr2);
    }

    public static boolean isFullArray(int[] array) {
        boolean isFull = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int replaceIndex = 0;
                if (array[i] < array[j]) {
                    replaceIndex = array[i];
                    array[i] = array[j];
                    array[j] = replaceIndex;
                }
            }
        }
        if (isFullArraySort(array)){
            isFull=true;
        }
        return isFull;
    }
        public static boolean isFullArraySort ( int[] array){
            boolean isFull = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] != array[i + 1] + 1) {
                    isFull = false;
                    break;
                } else if (i == array.length - 2) {
                    isFull = true;
                }
            }
            return isFull;
        }
    }

