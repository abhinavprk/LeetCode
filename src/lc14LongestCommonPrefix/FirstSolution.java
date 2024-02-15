package lc14LongestCommonPrefix;

public class FirstSolution {
    public static void main(String[] args) {
        String [] strings = new String[]{"flower","flow","flight"};
        System.out.println(getLongestCommonPrefix(strings));
    }

    private static String getLongestCommonPrefix(String[] strings) {

        int shortestLen = 200;
        String shortestString = "";
        for (String valueAtIndex : strings) {
            if (valueAtIndex.length() < shortestLen) {
                shortestLen = valueAtIndex.length();
                shortestString = valueAtIndex;
            }
        }
        if(shortestString.isEmpty()) {
            return "";
        }

        StringBuilder prefix = new StringBuilder();
        outer:
        for (int i = 0; i < shortestLen; i++) {
            char curr = shortestString.charAt(i);
            for (String string : strings) {
                if (string.charAt(i) != curr) {
                    break outer;
                }
            }
            prefix.append(curr);

        }
        return prefix.toString();

    }
}
