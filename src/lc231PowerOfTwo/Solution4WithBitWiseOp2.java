package lc231PowerOfTwo;

public class Solution4WithBitWiseOp2 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(128));
        System.out.println(isPowerOfTwo(20));
    }

    private static boolean isPowerOfTwo(int n) {
       if(n==0){
           return false;
       }
       long x = n;
       return (x & (x-1)) == 0;
    }
}
