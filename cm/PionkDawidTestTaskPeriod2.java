package cm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PionkDawidTestTaskPeriod2 {
    private Period period;
    private Period period2;

    // Below are test cases for the period method
    // Test Case 1: valid low startHour
    @Test
    public void testPeriodValidLowStart() {
        period = new Period(0, 12);
        assertNotNull(period);
    }

    // Test Case 2: valid high startHour
    @Test
    public void testPeriodValidHighStart() {
        period = new Period(23, 24);
        assertNotNull(period);
    }

    // Test Case 3: valid low endhour
    @Test
    public void testPeriodValidLowEnd() {
        period = new Period(0, 1);
        assertNotNull(period);
    }

    // Test Case 4: valid high endHour
    @Test
    public void testPeriodValidHighEnd() {
        period = new Period(12, 24);
        assertNotNull(period);
    }

    // Test Case 5: valid middle of road
    @Test
    public void testPeriodValidMiddleOfRoad() {
        period = new Period(12, 13);
        assertNotNull(period);
    }

    // Test Case 6: invalid endHour Lower than startHour
    @Test
    public void testPeriodInvalidEndLowerThanStart() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Period(10, 9)
        );
    }

    // Test Case 7: invalid too low startHour
    @Test
    public void testPeriodInvalidTooLowStart() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Period(-1, 12)
        );
    }

    // Test Case 8: invalid too high endhour
    @Test
    public void testPeriodInvalidTooHighEnd() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Period(12, 25)
        );
    }

    // Test Case 9: invalid startHour and endhour equal
    @Test
    public void testPeriodInvalidStartEqualEnd() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Period(12, 12)
        );
    }

    // Test Case 10: Invalid startHour over 24
    @Test
    public void testPeriodInvalidStartEqualOver24() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Period(25, 26)
        );
    }

    // Below are test cases for the duration method
    // Test Case 1: valid low duration
    @Test
    public void testDurationValidLowDuration() {
        period = new Period(0, 1);
        int expected = 1;
        int actual = period.duration();
        Assertions.assertEquals(expected, actual);
    }

    // Test Case 2: valid high duration
    @Test
    public void testDurationValidHighDuration() {
        period = new Period(0, 24);
        int expected = 24;
        int actual = period.duration();
        assertEquals(expected, actual);
    }

    // Test Case 3: valid middle of road duration
    @Test
    public void testDurationValidMiddleDuration() {
        period = new Period(6, 18);
        int expected = 12;
        int actual = period.duration();
        assertEquals(expected, actual);
    }

    // Below are Test Cases for the overlap class
    // Test Case 1: Valid Overlap values the same
    @Test
    public void testOverlapValidOverlapEqualValues() {
        period = new Period(10, 11);
        period2 = new Period(10, 11);
        assertTrue(period.overlaps(period2));
    }

    // Test Case 2: valid nonOverlap Small difference
    @Test
    public void testOverlapValidNonOverlapSmallDifference() {
        period = new Period(10, 11);
        period2 = new Period(11, 12);
        assertFalse(period.overlaps(period2));
    }

    // Test Case 3: Valid NonOverlap large difference
    @Test
    public void testOverlapValidNonOverlapLargeDifference() {
        period = new Period(10, 11);
        period2 = new Period(11, 12);
        assertFalse(period.overlaps(period2));
    }

    // Test Case 4: Valid Overlap currentPeriod high
    @Test
    public void testOverlapValidOverlapCurrentPeriodHigh() {
        period = new Period(0, 24);
        period2 = new Period(11, 12);
        assertTrue(period.overlaps(period2));
    }

    // Test Case 5: Valid Overlap period high
    @Test
    public void testOverlapValidNonOverlapPeriodHigh() {
        period = new Period(11, 12);
        period2 = new Period(0, 24);
        assertTrue(period.overlaps(period2));
    }
    // Test Case 6: Invalid null period parameter
    @Test
    public void testOverlapInvalidNullPeriodParameter() {
        period = new Period(11, 12);
        period2 = null;
        assertThrows(
                IllegalArgumentException.class,
                () -> period.overlaps(period2)
        );
    }
    // Test Case 7: Invalid null currentPeriod parameter
    @Test
    public void testOverlapInvalidNullPeriodParameter1() {
        period = null;
        period2 = new Period(11, 12);
        assertThrows(
                IllegalArgumentException.class,
                () -> period.overlaps(period2)
        );
    }
}