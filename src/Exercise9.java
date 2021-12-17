import java.util.Random;
import java.util.Scanner;

public class Exercise9 {
    public static final int SECRET_CODE_SIZE = 4, LAST_INDEX_ARRAY = 3, SMALLEST_FOUR_DIGITS = 1000, LARGEST_FOUR_DIGITS = 9999;

    public static void main(String[] args) {
        gameProgress(createSecretCode());
    }

    public static int[] createSecretCode() {
        Random random = new Random();
        int[] secretCode = new int[SECRET_CODE_SIZE];
        for (int i = 0; i < secretCode.length; i++) {
            secretCode[i] = random.nextInt(6) + 1;
        }
        for (int i = 0; i < secretCode.length; i++) {
            for (int j = i + 1; j < secretCode.length; j++) {
                if (secretCode[i] == secretCode[j]) {
                    secretCode = createSecretCode();
                    break;
                }
            }
        }
        return secretCode;
    }
    public static int runOptions() {
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            System.out.println("Easy run choose 1: (20 opportunity) ");
            System.out.println("Medium run choose 2: (15 opportunity) ");
            System.out.println("Hard run choose 3: (10 opportunity) ");
            System.out.println("Special run choose 4: (5-25 opportunity) ");
            choose = scanner.nextInt();
            if (choose < 1 || choose > 4) {
                System.out.println("Invalid option. Try again!");
            }
        } while (choose < 1 || choose > 4);
        return choose;
    }

    public static int[] guessingTheSecretCode() {
        Scanner scanner = new Scanner(System.in);
        int[] guess = new int[SECRET_CODE_SIZE];
        System.out.println("Guess the secret code: ");
        int userGuess = scanner.nextInt();
        if (userGuess < SMALLEST_FOUR_DIGITS || userGuess > LARGEST_FOUR_DIGITS) {
            System.out.println("Exactly 4 numbers!");
            guess = guessingTheSecretCode();
        } else {
            int i = LAST_INDEX_ARRAY;
            while (userGuess != 0) {
                int unit = userGuess % 10;
                userGuess = userGuess / 10;
                if (unit < 1 || unit > 6) {
                    System.out.println("Only 1-6!");
                    guess = guessingTheSecretCode();
                    break;
                } else {
                    guess[i] = unit;
                    i--;
                }
            }
        }
        return guess;
    }

    public static int sortRuns(int choose) {
        Random random = new Random();
        int opportunity = 0;
        if (choose == 1) {
            opportunity = 20;
        } else if (choose == 2) {
            opportunity = 15;
        } else if (choose == 3) {
            opportunity = 10;
        } else if (choose == 4) {
            opportunity = random.nextInt(21) + 5;
        }
        return opportunity;
    }

    public static void gameProgress(int[] secretCode) {
//        for (int a = 0; a < secretCode.length; a++) {
//            System.out.print(secretCode[a] + " ");
//        }
        int choose = runOptions();
        int opportunity = sortRuns(choose);
        int[] guess;
        int countAccurateNumber = 0;
        int countPartialNumber = 0;
        int doubleNumber = 0;
        for (int i = opportunity; i > 0; i--) {
            if (choose != 4) {
                System.out.println("you have " + i + " opportunity:");
            }
            guess = guessingTheSecretCode();
            for (int j = 0; j < guess.length; j++) {
                for (int a = j + 1; a < guess.length; a++) {
                    if (guess[j] == guess[a]) {
                        doubleNumber++;
                    }
                }
                if (doubleNumber != 0) {
                    System.out.println("fine! you lost 2 opportunity.");
                    i = i - 2;
                    doubleNumber = 0;
                    break;
                }
                if (guess[j] == secretCode[j]) {
                    countAccurateNumber++;
                }
                for (int k = 0; k < guess.length; k++) {
                    if (guess[j] == secretCode[k] && k != j) {
                        countPartialNumber++;
                    }
                }
            }
            if (i <= 1) {
                System.out.println("you loose! the secret code is: ");
                for (int j = 0; j < secretCode.length; j++) {
                    System.out.print(secretCode[j] + " ");
                }
            } else if (countAccurateNumber == 4) {
                System.out.println("Congratulations! you win!");
                break;
            } else {
                System.out.println(countAccurateNumber + " accurate numbers");
                countAccurateNumber = 0;
                countPartialNumber = 0;
            }

        }
    }
}

