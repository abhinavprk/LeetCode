package lc2073TimeNeededToBuyTickets;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
        System.out.println(timeRequiredToBuy(new int[]{5, 1, 1, 1}, 1));
    }

    private static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int noOfTickets = tickets[k];;
        if(noOfTickets==1){
            time = k+1;
        }else {
            while(noOfTickets>0) {
                for (int i = 0; i < tickets.length; i++) {
                    int curr = tickets[i];
                     if(curr > 0){
                         time++;
                         tickets[i] = --curr;
                     }
                     if(i==k){
                         noOfTickets--;
                         if(tickets[i] == 0){
                             break;
                         }

                     }
                }
            }
        }
        return time;
    }
}
