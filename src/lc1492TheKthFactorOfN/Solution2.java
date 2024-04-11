package lc1492TheKthFactorOfN;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(kthFactor(12,3));
        System.out.println(kthFactor(7,2));
        System.out.println(kthFactor(4,4));
    }

    private static int kthFactor(int n, int k) {
       for(int i = 1; i<=n; i++){
           if((n%i == 0) && --k == 0){
               return i;
           }
       }
       return -1;
    }
}
