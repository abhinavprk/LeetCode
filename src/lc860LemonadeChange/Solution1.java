package lc860LemonadeChange;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 10, 20}));
        System.out.println(lemonadeChange(new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5}));
    }

    private static boolean lemonadeChange(int[] bills) {
        int countFives = 0;
        int countTens = 0;
        for (int currentBill : bills) {
            if(currentBill == 5){
                countFives++;
            } else if (currentBill == 10) {
                if(countFives < 1){
                    return false;
                } else {
                    countFives--;
                    countTens++;
                }
            } else {
                if(countTens < 1){
                    if(countFives < 3){
                        return false;
                    }else {
                        countFives = countFives - 3;
                    }
                }else {
                    if(countFives < 1){
                        return false;
                    }else {
                        countFives--;
                        countTens--;
                    }
                }
            }
        }
        return  true;
    }
}
