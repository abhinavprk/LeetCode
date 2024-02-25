package lc58LengthOfLastWord;

public class Solution4 {

    public static void main(String[] args) {

        String sentence = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(sentence));
    }

    private static int lengthOfLastWord(String s) {
        char[] arr = s.strip().toCharArray();
        int length = 0;
        int i = arr.length-1;
        while((i>=0) && (arr[i]!= ' ')){
            length++;
            i--;
        }
        return length;
    }
}
