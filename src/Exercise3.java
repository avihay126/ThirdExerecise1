public class Exercise3 {
    public static final int MAX_SIZE_ARRAY=50;
    public static void main(String[] args) {
        factorization(1);
    }
    public static int [] factorization(int number){
        int factorizationArrayLength =0;
        int[]array =new int[MAX_SIZE_ARRAY];
        int indexArray=0;
        for (int i=0;i<=number;i++){
            if (isPrimeNumber(i)){
                while (number%i==0){
                    number=number/i;
                    factorizationArrayLength++;
                    array[indexArray]=i;
                    indexArray++;
                }
            }
        }
        int[]factorizationArray=new int[factorizationArrayLength];
        for (int i=0;i<factorizationArrayLength;i++){
            factorizationArray[i]=array[i];
        }
        return factorizationArray;
    }
    public static boolean isPrimeNumber(int number){
        boolean isPrimeNumber=true;
        if (number==0||number==1){
            isPrimeNumber=false;
        }else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
        }
        return isPrimeNumber;
    }
}
