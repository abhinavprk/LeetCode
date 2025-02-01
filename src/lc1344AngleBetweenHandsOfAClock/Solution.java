package lc1344AngleBetweenHandsOfAClock;

public class Solution {
    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
        System.out.println(angleClock(3, 30));
        System.out.println(angleClock(3, 15));
        System.out.println(angleClock(1, 57));
    }

    private static double angleClock(int hour, int minutes) {
        double anglePerMinHourHand = (double) 360 /720;
        double anglePerMinMinHand = 6;

        double currentMinAngle = minutes * anglePerMinMinHand;
        double currentHourAngle = ((hour % 12) * 60 + minutes) * anglePerMinHourHand;
        double angle = Math.abs(currentMinAngle - currentHourAngle);
        return Math.min(angle, 360 - angle);

    }
}
