public class Exercise6 {
    public static void main(String[] args) {
        isProperArithmeticExpression("(10/(5+2))");
        extractBrackets("(4+3)+(5*2)");
    }
    public static boolean isProperArithmeticExpression(String str){
        boolean isProper=false;
        if (operatorBetweenNumbersOrBrackets(str)&&operatorNextOperator(str)&& operatorAndBrackets(str)&&numberBeforeBrackets(str)&&properBrackets(str)){
            isProper=true;
        }
        return isProper;
    }
    public static boolean operatorNextOperator(String str){
        boolean flag=true;
        for (int i=0;i<str.length()-1;i++){
            if ((str.charAt(i)=='*'||str.charAt(i)=='/'||str.charAt(i)=='-'||str.charAt(i)=='+'||str.charAt(i)=='^')&&(str.charAt(i+1)=='*'||str.charAt(i+1)=='/'||str.charAt(i+1)=='+'||str.charAt(i+1)=='^'||str.charAt(i+1)=='-')){
                flag=false;
            }
        }
        return flag;
    }
    public static boolean properBrackets(String str){
        boolean flag =true;
        int counter=0;
        for (int i=0;i<str.length();i++){
            if ((i<str.length()-1)&&(str.charAt(i) == ')' && str.charAt(i + 1) == '(')) {
                flag=false;
            }
            if (str.charAt(i)=='('){
                counter++;
            }if (str.charAt(i)==')'){
                if (counter<=0){
                    flag=false;
                    break;
                }else {
                    counter--;
                }
            }
        }
        if (counter!=0){
            flag=false;
        }
        return flag;
    }
    public static boolean operatorAndBrackets(String str){
        boolean flag=true;
        for (int i=0;i<str.length()-1;i++){
            if ((str.charAt(i)=='(')&&(str.charAt(i+1)=='/'||str.charAt(i+1)=='*'||str.charAt(i+1)=='+'||str.charAt(i+1)=='^')){
                flag=false;
            }else if ((str.charAt(i)=='/'||str.charAt(i)=='*'||str.charAt(i)=='+'||str.charAt(i)=='^'||str.charAt(i)=='-')&&str.charAt(i+1)==')'){
                flag=false;
            }
        }
        return flag;
    }
    public static boolean isNumber(char c){
        boolean isNumber=false;
        if (c>=48&&c<=57){
            isNumber=true;
        }
        return isNumber;
    }
    public static boolean numberBeforeBrackets(String str){
        boolean flag=true;
        for (int i=0;i<str.length()-1;i++){
            if (isNumber(str.charAt(i))){
                if (str.charAt(i+1)=='('){
                    flag=false;
                }
            }
        }
        return flag;
    }
    public static boolean operatorBetweenNumbersOrBrackets(String str){
        boolean flag=true;
        for (int i=0;i<str.length();i++){
            if (i==0||i==str.length()-1){
                if (str.charAt(i)=='/'||str.charAt(i)=='*'||str.charAt(i)=='+'||str.charAt(i)=='^'||str.charAt(i)=='-') {
                    flag = false;
                }
            }else if (str.charAt(i)=='/'||str.charAt(i)=='*'||str.charAt(i)=='+'||str.charAt(i)=='^'||str.charAt(i)=='-'){
                if ((!isNumber(str.charAt(i-1))&&str.charAt(i-1)!=')')&&(!isNumber(str.charAt(i+1))&&str.charAt(i+1)!='(')){
                    flag=false;
                }
            }
        }
        return flag;
    }
    public static int connectionSolution(char a,char b){
        int sum=(a-'0')+(b-'0');
        return sum;
    }
    public static int subtractionSolution(char a, char b){
        int solution =(a-'0')-(b-'0');
        return solution;
    }
    public static int multiplicationSolution(char a,char b){
        int solution =(a-'0')*(b-'0');
        return solution;
    }
    public static double divisionSolution(char a, char b){
        double x= a-'0';
        double y= b-'0';
        double solution =x/y;
        return solution;
    }
    public static double exponentialSolution(char a,char b){
        double solution= Math.pow(a-'0',b-'0');
        return solution;
    }
    public static double extractBrackets(String str){
        double solution=0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)=='('){
               solution= brackets(subString(str,i+1,i+4));
            }
        }
        return solution;
    }
    public static double brackets(String str){
        double solution=0;
        if (str.charAt(1)=='+'){
            solution=connectionSolution(str.charAt(0),str.charAt(2));
        }else if (str.charAt(1)=='-'){
            solution = subtractionSolution(str.charAt(0),str.charAt(2));
        }else if (str.charAt(1)=='*'){
            solution =multiplicationSolution(str.charAt(0),str.charAt(2));
        }else if (str.charAt(1)=='/'){
            solution= divisionSolution(str.charAt(0),str.charAt(2));
        }else if (str.charAt(1)=='^'){
            solution=exponentialSolution(str.charAt(0),str.charAt(2));
        }
        return solution;
    }
    public static String subString(String str,int beginIndex, int endIndex) {
        char[] charArray = new char[endIndex - beginIndex];
        int j = 0;
        for (int i = beginIndex; i < endIndex; i++) {
            charArray[j] = str.charAt(i);
            j++;
        }
        String newString = new String(charArray);
        return newString;
    }
}
