package lc860LemonadeChange;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 10, 20}));
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5}));
    }

    private static boolean lemonadeChange(int[] bills) {
        int countFives = 0;
        int countTens = 0;
        for (int currentBill : bills) {
            if (currentBill == 5) {
                countFives++;
            } else if (currentBill == 10) {
                if (countFives == 0) {
                    return false;
                }
                countFives--;
                countTens++;
            } else {
                //Richten Sie die Bedingungen danach aus, was Sie brauchen, nicht danach, was Sie nicht brauchen. Wir müssen die größten Scheine zuerst ausgeben.
                if ((countTens > 0) && (countFives > 0)) {
                    countFives--;
                    countTens--;
                } else if (countFives >= 3) {
                    countFives -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
