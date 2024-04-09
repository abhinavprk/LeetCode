package lc2073TimeNeededToBuyTickets;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{2,3,2}, 2));
        System.out.println(timeRequiredToBuy(new int[]{5,1,1,1}, 0));
        System.out.println(timeRequiredToBuy(new int[]{5,1,1,1}, 1));
    }
    private static int timeRequiredToBuy(int[] tickets, int k) {
        int time = tickets[k];
        int noOfTickets = time;
        for (int i = 0; i < tickets.length; i++) {
            int curr = tickets[i];
            if (i < k) {
                if (curr >= noOfTickets) {
                    time = time + noOfTickets;
                } else {
                    time = time + curr;
                }
            } else if (i > k) {
                if (curr >= noOfTickets) {
                    time = time + noOfTickets-1;
                } else {
                    time = time + curr;
                }
            }
        }
        return time;
    }
}
