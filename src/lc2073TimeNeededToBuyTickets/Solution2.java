package lc2073TimeNeededToBuyTickets;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
        System.out.println(timeRequiredToBuy(new int[]{5, 1, 1, 1}, 1));
    }

    private static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int noOfTickets = tickets[k];;
        for (int i = 0; i < tickets.length; i++) {
            int curr = tickets[i];
            if (i <= k) {
                time = time + Math.min(curr, noOfTickets);
            } else {
                time = time + Math.min(curr, noOfTickets - 1);
            }
        }
        return time;
    }
}