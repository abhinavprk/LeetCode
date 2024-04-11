package lc1544MakeStringGreatAgain;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood("s"));
        System.out.println(makeGood(""));
    }
    private static String makeGood(String s) {
        StringBuilder str = new StringBuilder(s);
        if(str.length() > 1){
            while (str.length()>1){
                boolean found = false;
                for(int i = 0; i< str.length()-1; i++){
                    int curr = str.charAt(i);
                    int next = str.charAt(i+1);
                    if(Math.abs(curr - next) == 32){
                        str.deleteCharAt(i);
                        str.deleteCharAt(i);
                        found = true;
                        break;
                    }
                }
                if(!found){
                    break;
                }
            }
        }
        return str.toString();
    }
}
