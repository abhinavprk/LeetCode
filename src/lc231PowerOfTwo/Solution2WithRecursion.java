package lc231PowerOfTwo;

public class Solution2WithRecursion {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(128));
        System.out.println(isPowerOfTwo(20));
    }

    private static boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        if(n==1){
            return true;
        }
        if(n%2==0){
            return isPowerOfTwo(n/2);
        } else{
            return false;
        }
    }
}
