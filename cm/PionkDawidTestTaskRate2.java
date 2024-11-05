package cm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class PionkDawidTestTaskRate2 {
    private Rate rate;
    ArrayList<Period> reducedPeriods;
    ArrayList<Period> normalPeriods;
    BigDecimal normalRate;
    BigDecimal reducedRate;

    @BeforeEach
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
        assertNotNull(rate);
    }
    // Test Case 2: Valid Student Rate
    @Test
    public void testRateValidStudent(){
        reducedPeriods.add(new Period(8, 18));
        normalPeriods.add(new Period(19, 24));
        normalRate = new BigDecimal(2.1);
        reducedRate = new BigDecimal(1.1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 3: Valid Management Rate
    @Test
    public void testRateValidManagement(){
        reducedPeriods.add(new Period(8, 18));
        normalPeriods.add(new Period(19, 24));
        normalRate = new BigDecimal(2.1);
        reducedRate = new BigDecimal(1.1);
        rate = new Rate(CarParkKind.MANAGEMENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 4: Valid Visitor Rate
    @Test
    public void testRateValidVisitor(){
        reducedPeriods.add(new Period(8, 18));
        normalPeriods.add(new Period(19, 24));
        normalRate = new BigDecimal(2.1);
        reducedRate = new BigDecimal(1.1);
        rate = new Rate(CarParkKind.VISITOR, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }

    // Test Case 5: Invalid null reducedPeriods
    @Test
    public void testRateInvalidReducedPeriods(){
        normalPeriods.add(new Period(19, 24));
        normalRate = new BigDecimal(2.1);
        reducedRate = new BigDecimal(1.1);
        assertThrows(
            IllegalArgumentException.class, 
            () -> new Rate(CarParkKind.STUDENT, null, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 6: Invalid null normalPeriods
    @Test
    public void testRateInvalidNormalPeriods(){
        reducedPeriods.add(new Period(8,18));
        normalRate = new BigDecimal(2.1);
        reducedRate = new BigDecimal(1.1);
        assertThrows(
            IllegalArgumentException.class, 
            () -> new Rate(CarParkKind.STUDENT, reducedPeriods, null, normalRate, reducedRate)
        );
    }
    // Test Case 7: Invalid reducedRate more than normalRate
    @Test
    public void testRateInvalidReducedRateMoreThanNormalRate(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = new BigDecimal(1.1);
        reducedRate = new BigDecimal(2.1);
        assertThrows(
            IllegalArgumentException.class, 
            () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 8: Valid Low reducedRate
    @Test
    public void testRateValidLowReducedRate(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = new BigDecimal(2.1);
        reducedRate = new BigDecimal(0);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 9: Invalid too low reducedRate
    @Test
    public void testRateInvalidLowReducedRate(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = new BigDecimal(2.1);
        reducedRate = new BigDecimal(-1);
        assertThrows(
            IllegalArgumentException.class, 
            () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 10: Valid high normalRate
    @Test
    public void testRateValidHighNormalRate(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = new BigDecimal(10);
        reducedRate = new BigDecimal(1.1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 11: Invalid too high normalRate
    @Test
    public void testRateInvalidTooHighNormalRate(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = new BigDecimal(11);
        reducedRate = new BigDecimal(1.1);
        assertThrows(
            IllegalArgumentException.class, 
            () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 12: Valid high reducedRate
    @Test
    public void testRateValidHighReducedRate(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = new BigDecimal(10);
        reducedRate = new BigDecimal(8);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 13: Valid low normalRate
    @Test
    public void testRateValidLowNormalRate(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = new BigDecimal(0.1);
        reducedRate = new BigDecimal(0);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
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
            IllegalArgumentException.class, 
            () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
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
            IllegalArgumentException.class, 
            () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 16: Invalid normalPeriods overlap with reducedPeriods
    @Test
    public void testRateInvalidNormalPeriodsOverlapReducedPeriods(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(17,24));
        normalRate = new BigDecimal(2.1);
        reducedRate = new BigDecimal(1.1);
        assertThrows(
            IllegalArgumentException.class, 
            () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 17: invalid reducedRate equal normalRate
    @Test
    public void testRateInvalidReducedRateEqualNormalRates(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(17,24));
        normalRate = new BigDecimal(2.1);
        reducedRate = new BigDecimal(2.1);
        assertThrows(
            IllegalArgumentException.class, 
            () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
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
        assertEquals(expectedOutput, rate.calculate(testPeriod));
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
        assertEquals(expectedOutput, rate.calculate(testPeriod));
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
        assertEquals(expectedOutput, rate.calculate(testPeriod));
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
        BigDecimal expectedOutput = new BigDecimal(25);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 5: Valid low mixed stay
    @Test
    public void testCalculateValidLowMixStayStay(){
        reducedPeriods.add(new Period(18,24));
        normalPeriods.add(new Period(8,18));
        normalRate = new BigDecimal(2);
        reducedRate = new BigDecimal(1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period testPeriod = new Period(17, 19);
        BigDecimal expectedOutput = new BigDecimal(3);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }       
}
