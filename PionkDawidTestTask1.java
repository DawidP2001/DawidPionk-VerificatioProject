//Date:    14/10/2024
//Purpose: Task 1 Ver Project

//package cm;
/*
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import cm.CarParkKind;
import cm.Period;
import cm.Rate;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.math.BigDecimal;

public class PionkDawidTestTask1 {
    public static class RateTest{
        private Rate rate;
        ArrayList<Period> reducedPeriods;
        ArrayList<Period> normalPeriods;
        BigDecimal normalRate;
        BigDecimal reducedRate;

        @Before
        public void setUp(){
          reducedPeriods = new ArrayList<Period>();
          normalPeriods = new ArrayList<Period>();
        }
        // Below are test cases for the Rate() method
        // Test Case 1: Valid Staff Rate
        @Test
        public void testRateValidStaff(){
            reducedPeriods.add(new Period(8, 18));
            normalPeriods.add(new Period(19, 24));
            normalRate = new BigDecimal(2.1);
            reducedRate = new BigDecimal(1.1);
            rate = new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);
            assertEquals("Kind value doesnt match when set to staff" ,CarParkKind.STAFF, rate.getKind());
        }
        // Test Case 2: Valid Student Rate
        @Test
        public void testRateValidStudent(){
            reducedPeriods.add(new Period(8, 18));
            normalPeriods.add(new Period(19, 24));
            normalRate = new BigDecimal(2.1);
            reducedRate = new BigDecimal(1.1);
            rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
            assertEquals("Kind value doesnt match when set to student" ,CarParkKind.STUDENT, rate.getKind());
        }
        // Test Case 3: Valid Management Rate
        @Test
        public void testRateValidManagement(){
            reducedPeriods.add(new Period(8, 18));
            normalPeriods.add(new Period(19, 24));
            normalRate = new BigDecimal(2.1);
            reducedRate = new BigDecimal(1.1);
            rate = new Rate(CarParkKind.MANAGEMENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
            assertEquals("Kind value doesnt match when set to management" ,CarParkKind.MANAGEMENT, rate.getKind());
        }
        // Test Case 4: Valid Visitor Rate
        @Test
        public void testRateValidVisitor(){
            reducedPeriods.add(new Period(8, 18));
            normalPeriods.add(new Period(19, 24));
            normalRate = new BigDecimal(2.1);
            reducedRate = new BigDecimal(1.1);
            rate = new Rate(CarParkKind.VISITOR, reducedPeriods, normalPeriods, normalRate, reducedRate);
            assertEquals("Kind value doesnt match when set to visitor" ,CarParkKind.VISITOR, rate.getKind());
        }

        // Test Case 5: Invalid null reducedPeriods
        @Test
        public void testRateInvalireducedPeriods(){
            normalPeriods.add(new Period(19, 24));
            normalRate = new BigDecimal(2.1);
            reducedRate = new BigDecimal(1.1);
            assertThrows(
                "Reduced Period should be invalid", 
                IllegalArgumentException.class, 
                () -> new Rate(CarParkKind.STUDENT, null, normalPeriods, normalRate, reducedRate));
        }
        // Test Case 6: Invalid null normalPeriods
        @Test
        public void testRateInvalidnormalPeriods(){
            reducedPeriods.add(new Period(8,18));
            normalRate = new BigDecimal(2.1);
            reducedRate = new BigDecimal(1.1);
            assertThrows(
                "Normal Period should be invalid", 
                IllegalArgumentException.class, 
                () -> new Rate(CarParkKind.STUDENT, reducedPeriods, null, normalRate, reducedRate));
        }
        // Test Case 7: Invalid reducedRate more than normalRate
        @Test
        public void testRateInvalidreducedRateMoreThannormalRate(){
            reducedPeriods.add(new Period(8,18));
            normalPeriods.add(new Period(19,24));
            normalRate = new BigDecimal(1.1);
            reducedRate = new BigDecimal(2.1);
            assertThrows(
                "normalRate should not be allowed to be lower than reducedRate", 
                IllegalArgumentException.class, 
                () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate));
        }
        // Test Case 8: Valid Low reducedRate
        @Test
        public void testRateValidLowreducedRate(){
            reducedPeriods.add(new Period(8,18));
            normalPeriods.add(new Period(19,24));
            normalRate = new BigDecimal(2.1);
            reducedRate = new BigDecimal(0);
            rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
            assertEquals("Hourly reduced rate failed to be set to 0",reducedRate, rate.getHourlyReducedRate());
        }
        // Test Case 9: Invalid too low reducedRate
        @Test
        public void testRateInvalidLowReducedRate(){
            reducedPeriods.add(new Period(8,18));
            normalPeriods.add(new Period(19,24));
            normalRate = new BigDecimal(2.1);
            reducedRate = new BigDecimal(-1);
            assertThrows(
                "reducedRate should not be allowed to be lower than 0", 
                IllegalArgumentException.class, 
                () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate));
        }
        // Test Case 10: Valid high normalRate
        @Test
        public void testRateValidHighNormalRate(){
            reducedPeriods.add(new Period(8,18));
            normalPeriods.add(new Period(19,24));
            normalRate = new BigDecimal(10);
            reducedRate = new BigDecimal(1.1);
            rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
            assertEquals("Hourly normal rate failed to be set to 10",normalRate, rate.getHourlyNormalRate());
        }
        // Test Case 11: Invalid too high normalRate
        @Test
        public void testRateInvalidTooHighNormalRate(){
            reducedPeriods.add(new Period(8,18));
            normalPeriods.add(new Period(19,24));
            normalRate = new BigDecimal(11);
            reducedRate = new BigDecimal(1.1);
            assertThrows(
                "normalRate should not be allowed to be higher than 10", 
                IllegalArgumentException.class, 
                () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate));
        }
        // Test Case 12: Valid high reducedRate
        @Test
        public void testRateValidHighReducedRate(){
            reducedPeriods.add(new Period(8,18));
            normalPeriods.add(new Period(19,24));
            normalRate = new BigDecimal(10);
            reducedRate = new BigDecimal(10);
            rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
            assertEquals("Hourly normal rate failed to be set to 10",reducedRate, rate.getHourlyReducedRate());
        }
        // Test Case 13: Valid low normalRate
        @Test
        public void testRateValidLowNormalRate(){
            reducedPeriods.add(new Period(8,18));
            normalPeriods.add(new Period(19,24));
            normalRate = new BigDecimal(0);
            reducedRate = new BigDecimal(0);
            rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
            assertEquals("Hourly normal rate failed to be set to 10",normalRate, rate.getHourlyNormalRate());
        }
        // Test Case 14: Invalid reducedPeriods overlap themselves
        @Test
        public void testRateInvalidReducedPeriodsOverlap(){
            reducedPeriods.add(new Period(8,18));
            reducedPeriods.add(new Period(16,18));
            normalPeriods.add(new Period(19,24));
            normalRate = new BigDecimal(2.1);
            reducedRate = new BigDecimal(1.1);
            assertThrows(
                "reducedPeriods should not be allowed to overlap themselves", 
                IllegalArgumentException.class, 
                () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate));
        }
        // Test Case 15: Invalid normalPeriods overlap themselves
        @Test
        public void testRateInvalidNormalPeriodsOverlap(){
            reducedPeriods.add(new Period(19,24));
            normalPeriods.add(new Period(8,18));
            normalPeriods.add(new Period(16,18));
            normalRate = new BigDecimal(2.1);
            reducedRate = new BigDecimal(1.1);
            assertThrows(
                "normalPeriods should not be allowed to overlap themselves", 
                IllegalArgumentException.class, 
                () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate));
        }
        // Test Case 16: Invalid normalPeriods overlap with reducedPeriods
        @Test
        public void testRateInvalidNormalPeriodsOverlapReducedPeriods(){
            reducedPeriods.add(new Period(8,18));
            normalPeriods.add(new Period(17,24));
            normalRate = new BigDecimal(2.1);
            reducedRate = new BigDecimal(1.1);
            assertThrows(
                "reducedPeriods should not be allowed to overlap with normalPeriods", 
                IllegalArgumentException.class, 
                () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate));
        }
        // Test Case 17: invalid reducedRate equal normalRate
        @Test
        public void testRateInvalidReducedRateEqualNormalRates(){
            reducedPeriods.add(new Period(8,18));
            normalPeriods.add(new Period(17,24));
            normalRate = new BigDecimal(2.1);
            reducedRate = new BigDecimal(2.1);
            assertThrows(
                "reducedRates and normalRates can't be equal", 
                IllegalArgumentException.class, 
                () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate));
        }

        // Below are test cases for the calculate() method
        // Test Case 1: Valid normalPeriod Stay
        @Test
        public void testCalculateValidNormalPeriodStay(){
            reducedPeriods.add(new Period(19,24));
            normalPeriods.add(new Period(8,18));
            normalRate = new BigDecimal(2);
            reducedRate = new BigDecimal(1);
            rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
            Period testPeriod = new Period(10, 18);
            BigDecimal expectedOutput = new BigDecimal(16);
            assertEquals("Result should have been 16",expectedOutput, rate.calculate(testPeriod));
        }
        // Test Case 2: Valid reducedPeriod Stay
        @Test
        public void testCalculateValidReducedPeriodStay(){
            reducedPeriods.add(new Period(19,24));
            normalPeriods.add(new Period(8,18));
            normalRate = new BigDecimal(2);
            reducedRate = new BigDecimal(1);
            rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
            Period testPeriod = new Period(19, 24);
            BigDecimal expectedOutput = new BigDecimal(5);
            assertEquals("Result should have been 5",expectedOutput, rate.calculate(testPeriod));
        }
        // Test Case 3: Valid Free Stay
        @Test
        public void testCalculateValidFreeStay(){
            reducedPeriods.add(new Period(19,24));
            normalPeriods.add(new Period(8,18));
            normalRate = new BigDecimal(2);
            reducedRate = new BigDecimal(1);
            rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
            Period testPeriod = new Period(0, 7);
            BigDecimal expectedOutput = new BigDecimal(0);
            assertEquals("Result should have been 0",expectedOutput, rate.calculate(testPeriod));
        }
        // Test Case 4: Valid full day stay
        @Test
        public void testCalculateValidFullDayStay(){
            reducedPeriods.add(new Period(19,24));
            normalPeriods.add(new Period(8,18));
            normalRate = new BigDecimal(2);
            reducedRate = new BigDecimal(1);
            rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
            Period testPeriod = new Period(0, 24);
            BigDecimal expectedOutput = new BigDecimal(21);
            assertEquals("Result should have been 21",expectedOutput, rate.calculate(testPeriod));
        }
        // Test Case 5: Valid low mixed stay
        @Test
        public void testCalculateValidLowMixStayStay(){
            reducedPeriods.add(new Period(19,24));
            normalPeriods.add(new Period(8,18));
            normalRate = new BigDecimal(2);
            reducedRate = new BigDecimal(1);
            rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
            Period testPeriod = new Period(17, 19);
            BigDecimal expectedOutput = new BigDecimal(3);
            assertEquals("Result should have been 3",expectedOutput, rate.calculate(testPeriod));
        }       
    }
    public static class PeriodTest{
        private Period period;
        private Period period2;

        @Before
        public void setUp(){
          //  period = new Period();
        }
        // Below are test cases for the period method
        // Test Case 1: valid low startHour
        @Test
        public void testPeriodValidLowStart(){
            period = new Period(0, 12);
            int startHour = period.getStartHour();
            assertTrue("startHour should be valid", startHour >= 0);
        }
        // Test Case 2: valid high startHour
        @Test
        public void testPeriodValidHighStart(){
            period = new Period(23, 24);
            int startHour = period.getStartHour();
            assertTrue("startHour should be valid at max value", startHour <= 23);
        }
        // Test Case 3: valid low endhour
        @Test
        public void testPeriodValidLowEnd(){
            period = new Period(0, 1);
            int endHour = period.getEndHour();
            assertTrue("endHour should be valid at minimum value", endHour>=1);
        }
        // Test Case 4: valid high endHour
        @Test
        public void testPeriodValidHighEnd(){
            period = new Period(12, 24);
            int endHour = period.getEndHour();
            assertTrue("endHour should be valid at maximum value", endHour<=24);
        }
        // Test Case 5: valid middle of road
        @Test
        public void testPeriodValidMiddleOfRoad(){
            period = new Period(12, 13);
            int startHour = period.getStartHour();
            int endHour = period.getEndHour();
            assertTrue("should be valid at middle of road values", startHour==12 && endHour==13);
        }
        // Test Case 6: invalid endHour Lower than startHour
        @Test
        public void testPeriodInvalidEndLowerThanStart(){
            assertThrows("endHour can't be lower than startHour", 
            IllegalArgumentException.class, 
            () -> new Period(10, 9));
        }
        // Test Case 7: invalid too low startHour
        @Test
        public void testPeriodInvalidTooLowStart(){
            assertThrows("startHour can't be negative", 
            IllegalArgumentException.class, 
            () -> new Period(-1, 12));
        }
        // Test Case 8: invalid too high endhour
        @Test
        public void testPeriodInvalidTooHighEnd(){
            assertThrows("endHour can't be over 24", 
            IllegalArgumentException.class, 
            () -> new Period(12, 25));
        }
        // Test Case 9: invalid startHour and endhour
        @Test
        public void testPeriodInvalidStartEqualEnd(){
            assertThrows("startHour can't have the same value as endHour", 
            IllegalArgumentException.class,
            () -> new Period(12, 12));
        }

        // Below are test cases for the duration method
        // Test Case 1: valid low duration
        @Test
        public void testDurationValidLowDuration(){
            period = new Period(0, 1);
            int expected = 1;
            int actual = period.duration();
            assertEquals("The actual output should be 1",expected, actual); 
        }
        // Test Case 2: valid high duration
        @Test
        public void testDurationValidHighDuration(){
            period = new Period(0, 24);
            int expected = 24;
            int actual = period.duration();
            assertEquals("The actual output should be 24",expected, actual); 
        }
        // Test Case 3: valid middle of road duration
        @Test
        public void testDurationValidMiddleDuration(){
            period = new Period(6, 18);
            int expected = 12;
            int actual = period.duration();
            assertEquals("The actual output should be 12",expected, actual); 
        }
        
        // Below are Test Cases for the overlap class
        // Test Case 1: Valid Overlap values the same
        @Test
        public void testOverlapValidOverlapEqualValues(){
            period = new Period(10,11);
            period2 = new Period(10,11);
            assertTrue("period should overlap with period2", period.overlap(period2));
        }
        // Test Case 2: valid nonOverlap Small difference
        @Test
        public void testOverlapValidNonOverlapSmallDifference(){
            period = new Period(10,11);
            period2 = new Period(11,12);
            assertFalse("period should not overlap with period2", period.overlap(period2));
        }
        // Test Case 3: invalid period is null
        @Test
        public void testOverlapInvalidPeriodNull(){
            period = new Period(10,11);
            period2 = null;
            assertThrows("Passed in Period is not allowed to be null", 
            IllegalArgumentException.class,
            () -> period.overlap(period2));
        }
        // Test Case 4: Valid NonOverlap large difference
        @Test
        public void testOverlapValidNonOverlapLargeDifference(){
            period = new Period(10,11);
            period2 = new Period(11,12);
            assertFalse("Periods don't overlap so Should be false", period.overlap(period2));
        }
        // Test Case 5: Valid Overlap currentPeriod high
        @Test
        public void testOverlapValidOverlapCurrentPeriodHigh(){
            period = new Period(0,24);
            period2 = new Period(11,12);
            assertTrue("period should overlap with period2", period.overlap(period2));
        }
        // Test Case 6: Valid Overlap period high
        @Test
        public void testOverlapValidNonOverlapPeriodHigh(){
            period = new Period(11,12);
            period2 = new Period(0,24);
            assertFalse("periods aren't overlaping", period.overlap(period2));
        }
    }
} */