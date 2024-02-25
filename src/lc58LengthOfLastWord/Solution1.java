package lc58LengthOfLastWord;

public class Solution1 {

    public static void main(String[] args) {

        String sentence = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(sentence));
    }

    private static int lengthOfLastWord(String sentence) {
        int length = 1;
        StringBuilder sb = new StringBuilder(sentence);
        sentence = sb.reverse().toString().strip();
        if (!sentence.contains(" ")) {
            length = sentence.length();
        } else {
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    length = i;
                    break;
                }
            }
        }
        return length;
    }
}
