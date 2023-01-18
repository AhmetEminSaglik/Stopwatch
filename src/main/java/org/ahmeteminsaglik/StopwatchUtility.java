package org.ahmeteminsaglik;

import java.sql.Timestamp;

public class StopwatchUtility {
    public static Timestamp getTimeDiff(Timestamp start, Timestamp end) {
        long diff = 0;
        try {
            diff = end.getTime() - start.getTime() - (2 * 60 * 60 * 1000);
        } catch (NullPointerException e) {
            String parameter;
            if (start == null) {
                parameter = "start";
            } else {
                parameter = "end";
            }
            throw new ImproperUseOfStopwatchException(parameter);
        }
        return new Timestamp(diff);
    }

    public static String getTime(Timestamp timestamp) {
        String timeStampString = timestamp.toString();
        String[] timeStampSplit = timeStampString.split(" "); // split day and time
        return timeStampSplit[1]; // return time in String format
    }

    public static String fixMillisecond(String brokenTime) {
        String[] time = brokenTime.split("[.]"); //  : HH:MM:SS.SSS  --> [0]HH:MM:SS  |[1]SSS
        time[1] = complete3Digit(time[1]);
        String fixedTime = time[0] + "." + time[1];
        return fixedTime;
    }

    private static String complete3Digit(String millisecond) {
        while (millisecond.length() < 3) {
            millisecond += "0";
        }
        return millisecond;
    }

}
