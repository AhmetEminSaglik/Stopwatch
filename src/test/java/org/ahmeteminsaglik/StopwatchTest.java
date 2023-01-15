package org.ahmeteminsaglik;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StopwatchTest {
    static Stopwatch stopwatch;

    @BeforeAll
    static void prepareStopwatch() {
        stopwatch = new Stopwatch();
    }

    static LocalDateTime mockSleep(Timestamp timestamp, int hour, int minute, int second) {
        return new Timestamp(timestamp.getTime()).toLocalDateTime()
                .plusHours(hour)
                .plusMinutes(minute)
                .plusSeconds(second);

    }

    @Test
    @DisplayName("Reset TimeStamp Values")
    void testResetTimeStampValues() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        stopwatch.setTimestampStart(timestamp);
        Timestamp endTimeStamp = Timestamp.valueOf(mockSleep(timestamp, 0, 0, 8));
        stopwatch.setTimestampStop(endTimeStamp);
        String expectedTimeString = "00:00:08.000";
        String actualTimeString = stopwatch.getElapsedTimeString();
        String msg = "8 second is passed";
        assertEquals(expectedTimeString, actualTimeString, msg);


    }

    @Test
    @DisplayName("Real Time 3 Second Test")
    void testRealTimeFor3Second() {
        stopwatch.startTime();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stopwatch.stopTime();

        int expectedHour = 0;
        int actualHour = stopwatch.getElapsedTimeWithTimeStamp().toLocalDateTime().getHour();
        String msg = "0 Hour is elapsed";
        assertEquals(expectedHour, actualHour, msg);

        int expectedMinute = 0;
        int actualMinute = stopwatch.getElapsedTimeWithTimeStamp().toLocalDateTime().getMinute();
        msg = "0 Minute is elapsed";
        assertEquals(expectedMinute, actualMinute, msg);

        int expectedSecond = 0;
        int actualSecond = stopwatch.getElapsedTimeWithTimeStamp().toLocalDateTime().getHour();
        msg = "3 Seconds are elapsed";
        assertEquals(expectedHour, actualHour, msg);
    }

    @Test
    @DisplayName("Mock 1 Second Test")
    void testMockElapsedTimeFor1Second() {
        stopwatch.startTime();
        LocalDateTime mockEndTime = mockSleep(stopwatch.getTimestampStart(), 0, 0, 1);
        Timestamp endTime = Timestamp.valueOf(mockEndTime);
        stopwatch.setTimestampStop(endTime);
        Timestamp elapsedTime = stopwatch.getElapsedTimeWithTimeStamp();

        int expectedHour = 0;
        int actualHour = elapsedTime.toLocalDateTime().getHour();
        String msg = "0 Hour is elapsed.";
        assertEquals(expectedHour, actualHour, msg);

        int expectedMinute = 0;
        int actualMinute = elapsedTime.toLocalDateTime().getMinute();
        msg = "0 Minute is elapsed.";
        assertEquals(expectedMinute, actualMinute, msg);
        int expected = 1;
        int actual = elapsedTime.toLocalDateTime().getSecond();
        msg = "1 Second is elapsed.";
        assertEquals(expected, actual, msg);
    }

    @Test
    @DisplayName("Mock 5 Seconds Test")
    void testMockElapsedTimeFor5Second() {
        stopwatch.startTime();
        LocalDateTime mockEndTime = mockSleep(stopwatch.getTimestampStart(), 0, 0, 5);
        Timestamp endTime = Timestamp.valueOf(mockEndTime);
        stopwatch.setTimestampStop(endTime);
        Timestamp elapsedTime = stopwatch.getElapsedTimeWithTimeStamp();

        int expectedHour = 0;
        int actualHour = elapsedTime.toLocalDateTime().getHour();
        String msg = "0 Hour is elapsed.";
        assertEquals(expectedHour, actualHour, msg);

        int expectedMinute = 0;
        int actualMinute = elapsedTime.toLocalDateTime().getMinute();
        msg = "0 Minute is elapsed.";
        assertEquals(expectedMinute, actualMinute, msg);

        int expected = 5;
        int actual = elapsedTime.toLocalDateTime().getSecond();
        msg = "5 Seconds are elapsed.";
        assertEquals(expected, actual, msg);
    }

    @Test
    @DisplayName("Mock 1 Minute 10 Seconds Test")
    void testMockElapsedTimeFor1Minute10Seconds() {
        stopwatch.startTime();
        LocalDateTime mockEndTime = mockSleep(stopwatch.getTimestampStart(), 0, 1, 10);
        Timestamp endTime = Timestamp.valueOf(mockEndTime);
        stopwatch.setTimestampStop(endTime);
        Timestamp elapsedTime = stopwatch.getElapsedTimeWithTimeStamp();

        int expectedHour = 0;
        int actualHour = elapsedTime.toLocalDateTime().getHour();
        String msg = "0 Hour is elapsed.";
        assertEquals(expectedHour, actualHour, msg);

        int expectedMinute = 1;
        int actualMinute = elapsedTime.toLocalDateTime().getMinute();
        msg = "1 Minute is elapsed.";
        assertEquals(expectedMinute, actualMinute, msg);

        int expectedSecond = 10;
        int actualSecond = elapsedTime.toLocalDateTime().getSecond();
        msg = "10 Seconds are elapsed.";
        assertEquals(expectedSecond, actualSecond, msg);


    }

    @Test
    @DisplayName("Mock 25 Minutes 35 Seconds Test")
    void testMockElapsedTimeFor25Minutes35Second() {
        stopwatch.startTime();
        LocalDateTime mockEndTime = mockSleep(stopwatch.getTimestampStart(), 0, 25, 35);
        Timestamp endTime = Timestamp.valueOf(mockEndTime);
        stopwatch.setTimestampStop(endTime);
        Timestamp elapsedTime = stopwatch.getElapsedTimeWithTimeStamp();

        int expectedHour = 0;
        int actualHour = elapsedTime.toLocalDateTime().getHour();
        String msg = "0 Hour is elapsed.";
        assertEquals(expectedHour, actualHour, msg);

        int expectedMinute = 25;
        int actualMinute = elapsedTime.toLocalDateTime().getMinute();
        msg = "25 Minutes are elapsed.";
        assertEquals(expectedMinute, actualMinute, msg);

        int expectedSecond = 35;
        int actualSecond = elapsedTime.toLocalDateTime().getSecond();
        msg = "35 Seconds are elapsed.";
        assertEquals(expectedSecond, actualSecond, msg);
    }

    @Test
    @DisplayName("Mock 2 Hours 5 Minutes 55 Seconds Test")
    void testMockElapsedTimeFor2Hours5Minutes55Second() {
        stopwatch.startTime();
        LocalDateTime mockEndTime = mockSleep(stopwatch.getTimestampStart(), 2, 5, 55);
        Timestamp endTime = Timestamp.valueOf(mockEndTime);
        stopwatch.setTimestampStop(endTime);
        Timestamp elapsedTime = stopwatch.getElapsedTimeWithTimeStamp();

        int expectedHour = 2;
        int actualHour = elapsedTime.toLocalDateTime().getHour();
        String msg = "2 Hours are elapsed.";
        assertEquals(expectedHour, actualHour, msg);

        int expectedMinute = 5;
        int actualMinute = elapsedTime.toLocalDateTime().getMinute();
        msg = "5 Minutes are elapsed.";
        assertEquals(expectedMinute, actualMinute, msg);

        int expectedSecond = 55;
        int actualSecond = elapsedTime.toLocalDateTime().getSecond();
        msg = "55 Seconds are elapsed.";
        assertEquals(expectedSecond, actualSecond, msg);
    }
}