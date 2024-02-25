package lc58LengthOfLastWord;

public class Solution3 {

    public static void main(String[] args) {

        String sentence = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(sentence));
    }

    private static int lengthOfLastWord(String sentence) {
        String[] list = sentence.split(" ");
        return list[list.length-1].length();
    }
}
