package org.ahmeteminsaglik;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stopwatch {
    private Timestamp timestampStart, timestampStop;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss.SSS");

    public void startTime() {
        timestampStart = new Timestamp(System.currentTimeMillis());
    }

    public void stopTime() {
        timestampStop = new Timestamp(System.currentTimeMillis());
    }

    public String getElapsedTimeString() {
        String time = null;
        Timestamp diffTimeStamp = StopwatchUtility.getTimeDiff(timestampStart, timestampStop);
        time = StopwatchUtility.getTime(diffTimeStamp);
        time = StopwatchUtility.fixMillisecond(time);

        return time;
    }

    public Timestamp getElapsedTimeWithTimeStamp() {
        Timestamp diffTimeStamp = null;
        try {
            diffTimeStamp = StopwatchUtility.getTimeDiff(timestampStart, timestampStop);
            String time = StopwatchUtility.getTime(diffTimeStamp);
            time = StopwatchUtility.fixMillisecond(time);
            diffTimeStamp = new Timestamp(dateFormat.parse(time).getTime());

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return diffTimeStamp;
    }

    public Timestamp getTimestampStart() {
        return timestampStart;
    }

    public void setTimestampStart(Timestamp timestampStart) {
        this.timestampStart = timestampStart;
    }

    public Timestamp getTimestampStop() {
        return timestampStop;
    }

    public void setTimestampStop(Timestamp timestampStop) {
        this.timestampStop = timestampStop;
    }

}
