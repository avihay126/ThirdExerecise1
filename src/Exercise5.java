public class Exercise5 {
    public static void main(String[] args) {
        String str = "take this text and test it";
        System.out.println(letterExchange(str));
    }
    public static String letterExchange(String str){
        int mostRepetitions=0;
        char mostCommonLetter='0';
        for (int i =0;i<str.length();i++){
            int counter =0;
            for (int j=i+1;j<str.length();j++){
                if (str.charAt(i)==str.charAt(j)){
                    counter++;
                    if (counter>mostRepetitions){
                        mostRepetitions=counter;
                        mostCommonLetter = str.charAt(i);
                    }
                }
            }
        }
        int secondMostRepetitions=0;
        char secondMostCommonLetter='0';
        for (int i=0;i<str.length();i++){
            int counter=0;
            for (int j =i+1;j<str.length();j++){
                if (str.charAt(i)==str.charAt(j)&&str.charAt(i)!=mostCommonLetter){
                    counter++;
                    if (counter>secondMostRepetitions){
                        secondMostRepetitions=counter;
                        secondMostCommonLetter=str.charAt(i);
                    }
                }
            }
        }
        char[] newString= new char[str.length()];
        for (int i =0;i<str.length();i++){
           if (str.charAt(i)==mostCommonLetter){
               newString[i]=secondMostCommonLetter;
           }else if (str.charAt(i)==secondMostCommonLetter){
               newString[i]=mostCommonLetter;
           }else {
               newString[i]=str.charAt(i);
           }
        }
        String letterExchange= new String(newString);
        return letterExchange;
    }
}
