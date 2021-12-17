import java.util.Scanner;

public class Exercise8 {
    public static final int FIRST_INDEX =0;
    public static void main(String[] args) {
        allSubStrings("avihay");
        thePopularSubString(stringSmallestThanFour(FIRST_INDEX));
    }
    public static String[] stringSmallestThanFour(int i){
        Scanner scanner = new Scanner(System.in);
        String str;
        String []stringsArray;
        System.out.println("Enter a string of up to 4 characters: ");
        str= scanner.nextLine();
        if (str.length()>0&&str.length()<5){
            stringsArray=new String[i+1];
            stringsArray[i]=str;
        }else {
            i++;
            stringsArray=stringSmallestThanFour(i);
            stringsArray[i-1]=str;
        }
        return stringsArray;
    }
    public static String[] allSubStrings(String str){
        String[] temporaryArray= new String[ str.length()*str.length()];
        int indexTempArr=0;
        for (int i=0;i<str.length();i++){
            for (int j=i+2;j<=str.length();j++){
               temporaryArray[indexTempArr]= subString(str,i,j);
               indexTempArr++;
            }
        }
        String[]stringArrayWithAllSubString=new String[indexTempArr];
        for (int i =0;i<indexTempArr;i++){
            stringArrayWithAllSubString[i]=temporaryArray[i];
        }
        return stringArrayWithAllSubString;
    }
    public static String subString(String str,int beginIndex, int endIndex){
        char[] charArray =new char[endIndex-beginIndex];
        int j=0;
        for (int i=beginIndex;i<endIndex;i++){
            charArray[j]=str.charAt(i);
            j++;
        }
        String newString = new String(charArray);
        return newString;
    }
    public static String thePopularSubString(String[]stringsArray){
        String[]tempArray=new String[0];
        for (int i=0;i<stringsArray.length;i++){
            tempArray =new String[tempArray.length+allSubStrings(stringsArray[i]).length];
        }
        String[] allSubStringArray = new String[tempArray.length];
        int k=0;
        for (int i =0;i<stringsArray.length;i++){
            for (int j=0;j<allSubStrings(stringsArray[i]).length;j++){
                allSubStringArray[k]=allSubStrings(stringsArray[i])[j];
                k++;
            }
        }
        int mostRepetitions=0;
        String mostCommonSubString="";
        for (int i =0;i<allSubStringArray.length;i++){
            int counter=0;
            for (int j =i+1;j<allSubStringArray.length;j++){
                if (isSameString(allSubStringArray[i],allSubStringArray[j])){
                    counter++;
                    if (counter>mostRepetitions){
                        mostRepetitions=counter;
                        mostCommonSubString=allSubStringArray[i];
                    }
                }
            }
        }
        return mostCommonSubString;
    }
    public static boolean isSameString(String str1,String str2){
        boolean isSame=false;
        if (str1.length()==str2.length()) {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    isSame = false;
                    break;
                } else if (i == str1.length() - 1) {
                    isSame = true;
                }
            }
        }
        return isSame;
    }
}