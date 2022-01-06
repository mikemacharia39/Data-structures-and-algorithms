package leettests.arrayandstrings;

/**
 * 1344. Angle Between Hands of a Clock
 *
 * Given two numbers, hour and minutes. 
 * Return the smaller angle (in degrees) formed between the hour and the minute hand.
 *
 * Example 1:
 *
 * Input: hour = 12, minutes = 30
 * Output: 165
 * 
 * Example 2:
 * 
 * Input: hour = 3, minutes = 30
 * Output: 75
 * 
 * Example 3:
 *
 * Input: hour = 3, minutes = 15
 * Output: 7.5
 */
public class AngleBetweenHandsOfClock {
    public double angleClock(int hour, int minutes) {

        double constHrAngle = 30;
        double constMinuteAngle = 6;

        if (hour == 12) {
            hour = 0;
        }
        // here if for example you have 1:30 PM, mathematically that is 1.5
        // cater for the decimal .5 then cumulative
        double hourAngle = (hour + ((minutes * constMinuteAngle)/360)) * constHrAngle;

        // here calculate the angle the minute hand forms
        double minuteAngle = minutes * constMinuteAngle;

        double angle = Math.abs(hourAngle - minuteAngle);

        // If the angle is obtuse (>180), convert it to acute (0<=x<=180)
        if (angle > 180) angle = 360.0 - angle;

        // subtract the result of the hour hand and minute hand
        return angle;
    }

    public static void main(String[] args) {
        AngleBetweenHandsOfClock betweenHandsOfClock = new AngleBetweenHandsOfClock();
        
        int hour = 3;
        int minute = 30;
        
        System.out.println("Angle between 3 and 30 = " + betweenHandsOfClock.angleClock(hour, minute));

        hour = 1;
        minute = 59;
        System.out.println("Angle between 1 and 59 = " + betweenHandsOfClock.angleClock(hour, minute));
    }
}
