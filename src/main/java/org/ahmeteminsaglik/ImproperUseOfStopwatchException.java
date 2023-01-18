package org.ahmeteminsaglik;

public class ImproperUseOfStopwatchException extends NullPointerException {
    static String errMsg = " parameter is null in Stopwatch Object. Be sure startTime() and stopTime() functions are used.";

    public ImproperUseOfStopwatchException(String s) {
        super(s + errMsg);
    }
}
