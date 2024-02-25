package lc58LengthOfLastWord;

public class Solution2 {

    public static void main(String[] args) {

        String sentence = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(sentence));
    }

    private static int lengthOfLastWord(String sentence) {
        int length = 1;
        if(sentence.contains(" ")){
            sentence = sentence.trim().toLowerCase();
            int lastIndexOfSpace = sentence.lastIndexOf(' ');
            length = sentence.substring(lastIndexOfSpace+1).length();
        }
        return length;
    }
}
