//Author:  DawidPionk
//Date:    14/10/2024
//Purpose: Task 1 Ver Project

//package cm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PionkDawidTestTask1 {
    public class RateTest{
        @Test
        public void testRate(){

        }
        @Test
        public void testCalculate(){

        }
        
    }
    public class PeriodTest{
        private Period period;

        @Before
        public void setUp(){
          //  period = new Period();
        }
        // Below are test cases for the period method
        // Test Case 1: valid low startHour
        public void testPeriodValidLowStart(){
            period = new Period(0, 12);
            int startHour = period.getStartHour();
            assertTrue("startHour should be valid", startHour >= 0);
        }
        // Test Case 2: valid high startHour
        public void testPeriodValidHighStart(){
            period = new Period(23, 24);
            int startHour = period.getStartHour();
            assertTrue("startHour should be valid at max value", startHour <= 23);
        }
        // Test Case 3: valid low endhour
        public void testPeriodValidLowEnd(){
            period = new Period(0, 1);
            int endHour = period.getEndHour();
            assertTrue("endHour should be valid at minimum value", endHour>=1);
        }
        // Test Case 4: valid high endHour
        public void testPeriodValidHighEnd(){
            period = new Period(12, 24);
            int endHour = period.getEndHour();
            assertTrue("endHour should be valid at maximum value", endHour<=24);
        }
        // Test Case 5: valid middle of road
        public void testPeriodValidMiddleOfRoad(){
            period = new Period(12, 13);
            int startHour = period.getStartHour();
            int endHour = period.getEndHour();
            assertTrue("should be valid at middle of road values", startHour==12 && endHour==13);
        }
        // Test Case 6: invalid endHour Lower than startHour
        public void testPeriodInvalidEndLowerThanStart(){
            assertThrows("endHour can't be lower than startHour", IllegalArgumentException.class, () -> new Period(10, 9));
        }
        // Test Case 7: invalid too low startHour
        public void testPeriodInvalidTooLowStart(){
            assertThrows("startHour can't be negative", IllegalArgumentException.class, () -> new Period(-1, 12));
        }
        // Test Case 8: invalid too high endhour
        public void testPeriodInvalidTooHighEnd(){
            assertThrows("endHour can't be over 24", IllegalArgumentException.class, () -> new Period(12, 25));
        }
        // Test Case 9: invalid data type for startHour
        public void testPeriodInvalidStartHourDataType(){
            assertThrows("startHour can't accept other data types rather than int", IllegalArgumentException.class, () -> new Period("E", 12));
        }
        // Test Case 10: invalid data type for endhour
        public void testPeriodInvalidEndHourDataType(){
            assertThrows("endHour can't accept other data types rather than int", IllegalArgumentException.class, () -> new Period(12, "E"));
        }
        // Test Case 11: invalid startHour and endHour
        public void testPeriodInvalidStartEqualEnd(){
            assertThrows("startHour can't have the same value as endHour", IllegalArgumentException.class, () -> new Period(12, 12));
        }

        // Below are test cases for the duration method
        // Test Case 1: valid low duration
        public void testDurationValidLowDuration(){
            period = new Period(0, 1);
            int startHour = period.getStartHour();
            int endHour = period.getEndHour();
            int expected = 1;
            int actual = period.duration();
            assertEquals("The actual output should be 1",expected, actual); 
        }
        // Test Case 2: valid high duration
        public void testDurationValidHighDuration(){
            period = new Period(0, 24);
            int startHour = period.getStartHour();
            int endHour = period.getEndHour();
            int expected = 24;
            int actual = period.duration();
            assertEquals("The actual output should be 24",expected, actual); 
        }
        // Test Case 3: valid middle of road duration
        public void testDurationValidMiddleDuration(){
            period = new Period(6, 18);
            int startHour = period.getStartHour();
            int endHour = period.getEndHour();
            int expected = 12;
            int actual = period.duration();
            assertEquals("The actual output should be 12",expected, actual); 
        }
        
        // Below are Test Cases for the overlap class
    }
}