//Date:             21/11/2024
//Purpose:          Task 2 Ver Project 
//Name:             Dawid Pionk
//Student Number:   C00273530

//////////////////////////////////////////////////////////////////
package Task2;

import cm.Period;
import cm.Rate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cm.CarParkKind;

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
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
        rate = new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 2: Valid Student Rate
    @Test
    public void testRateValidStudent(){
        reducedPeriods.add(new Period(8, 18));
        normalPeriods.add(new Period(19, 24));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 3: Valid Management Rate
    @Test
    public void testRateValidManagement(){
        reducedPeriods.add(new Period(8, 18));
        normalPeriods.add(new Period(19, 24));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
        rate = new Rate(CarParkKind.MANAGEMENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 4: Valid Visitor Rate
    @Test
    public void testRateValidVisitor(){
        reducedPeriods.add(new Period(8, 18));
        normalPeriods.add(new Period(19, 24));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
        rate = new Rate(CarParkKind.VISITOR, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }

    // Test Case 5: Invalid null reducedPeriods
    @Test
    public void testRateInvalidReducedPeriods(){
        normalPeriods.add(new Period(19, 24));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
        assertThrows(
            IllegalArgumentException.class, 
            () -> new Rate(CarParkKind.STUDENT, null, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 6: Invalid null normalPeriods
    @Test
    public void testRateInvalidNormalPeriods(){
        reducedPeriods.add(new Period(8,18));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
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
        normalRate = BigDecimal.valueOf(1.1);
        reducedRate = BigDecimal.valueOf(2.1);
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
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(0);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 9: Invalid too low reducedRate
    @Test
    public void testRateInvalidLowReducedRate(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(-1);
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
        normalRate = BigDecimal.valueOf(10);
        reducedRate = BigDecimal.valueOf(1.1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 11: Invalid too high normalRate
    @Test
    public void testRateInvalidTooHighNormalRate(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = BigDecimal.valueOf(11);
        reducedRate = BigDecimal.valueOf(1.1);
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
        normalRate = BigDecimal.valueOf(10);
        reducedRate = BigDecimal.valueOf(8);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 13: Valid low normalRate
    @Test
    public void testRateValidLowNormalRate(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = BigDecimal.valueOf(0.1);
        reducedRate = BigDecimal.valueOf(0);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 14: Invalid reducedPeriods overlap themselves
    @Test
    public void testRateInvalidReducedPeriodsOverlap(){
        reducedPeriods.add(new Period(8,18));
        reducedPeriods.add(new Period(16,18));
        normalPeriods.add(new Period(19,24));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
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
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
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
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
        assertThrows(
            IllegalArgumentException.class, 
            () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 17: invalid reducedRate equal normalRate
    @Test
    public void testRateInvalidReducedRateEqualNormalRates(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(2.1);
        assertThrows(
            IllegalArgumentException.class,
            () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
    }

    // Test Case 18: Invalid normalRate is null
    @Test
    public void testRateInvalidNormalRateIsNull(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = null;
        reducedRate = BigDecimal.valueOf(1.1);
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 19: Invalid reducedRate is null
    @Test
    public void testRateInvalidReducedRateIsNull(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(17,24));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = null;
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 20: Invalid normalRate is negative
    @Test
    public void testRateInvalidNormalRateIsNegative(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = BigDecimal.valueOf(-2.1);
        reducedRate = BigDecimal.valueOf(1.1);
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 21: Invalid 3 reducedPeriods overlap themselves
    @Test
    public void testRateInvalid3ReducedPeriodsOverlap(){
        reducedPeriods.add(new Period(8,18));
        reducedPeriods.add(new Period(8,18));
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 22: Invalid multiple periods overlap
    @Test
    public void testRateInvalidMultiplePeriodsOverlap(){
        reducedPeriods.add(new Period(1,2));
        reducedPeriods.add(new Period(3,4));
        reducedPeriods.add(new Period(5,6));
        normalPeriods.add(new Period(5,6));
        normalPeriods.add(new Period(1,2));
        normalPeriods.add(new Period(11,12));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 23: Invalid kind is null
    @Test
    public void testRateInvalidKindIsNull(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rate(null, reducedPeriods, normalPeriods, normalRate, reducedRate)
        );
    }
    // Test Case 24: valid normalPeriods is empty
    @Test
    public void testRateValidNormalPeriodsIsEmpty(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 25: valid reducedPeriods is empty
    @Test
    public void testRateValidReducedPeriodsIsEmpty(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = BigDecimal.valueOf(2.1);
        reducedRate = BigDecimal.valueOf(1.1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    // Test Case 26: invalid reducedRate and normalRate too high
    @Test
    public void testRateInvalidReducedRateAndNormalRateTooHigh(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(19,24));
        normalRate = BigDecimal.valueOf(12);
        reducedRate = BigDecimal.valueOf(11);
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
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period testPeriod = new Period(10, 18);
        BigDecimal expectedOutput = BigDecimal.valueOf(16);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 2: Valid reducedPeriod Stay
    @Test
    public void testCalculateValidReducedPeriodStay(){
        reducedPeriods.add(new Period(19,24));
        normalPeriods.add(new Period(8,18));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period testPeriod = new Period(19, 24);
        BigDecimal expectedOutput = BigDecimal.valueOf(5);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 3: Valid Free Stay
    @Test
    public void testCalculateValidFreeStay(){
        reducedPeriods.add(new Period(19,24));
        normalPeriods.add(new Period(8,18));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period testPeriod = new Period(0, 7);
        BigDecimal expectedOutput = BigDecimal.valueOf(0);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 4: Valid full day stay
    @Test
    public void testCalculateValidFullDayStay(){
        reducedPeriods.add(new Period(19,24));
        normalPeriods.add(new Period(8,18));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period testPeriod = new Period(0, 24);
        BigDecimal expectedOutput = BigDecimal.valueOf(25);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 5: Valid low mixed stay
    @Test
    public void testCalculateValidLowMixStayStay(){
        reducedPeriods.add(new Period(18,24));
        normalPeriods.add(new Period(8,18));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period testPeriod = new Period(17, 19);
        BigDecimal expectedOutput = BigDecimal.valueOf(3);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 6: Valid Visitor Stay
    @Test
    public void testCalculateValidVisitorStay(){
        reducedPeriods.add(new Period(18,24));
        normalPeriods.add(new Period(8,18));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        rate = new Rate(CarParkKind.VISITOR, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period testPeriod = new Period(17, 19);
        BigDecimal expectedOutput = BigDecimal.valueOf(0);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 7: Valid Check multiple reducedPeriods
    @Test
    public void testCalculateValidMultipleReducedPeriods(){
        reducedPeriods.add(new Period(1,10));
        reducedPeriods.add(new Period(11,15));
        normalPeriods.add(new Period(22,23));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period testPeriod = new Period(1,8);
        BigDecimal expectedOutput = BigDecimal.valueOf(7);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 8: Invalid null kind
    @Test
    public void testCalculateInvalidNullKind(){
        reducedPeriods.add(new Period(18,24));
        normalPeriods.add(new Period(8,18));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        rate = new Rate(null, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period testPeriod = new Period(17, 18);
        assertThrows(
                IllegalArgumentException.class,
                () -> rate.calculate(testPeriod)
        );
    }
    // Test Case 9: Valid Check multiple reducedPeriods
    @Test
    public void testCalculateValidMultipleReducedPeriods2(){
        reducedPeriods.add(new Period(1,10));
        reducedPeriods.add(new Period(11,15));
        normalPeriods.add(new Period(22,23));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period testPeriod = null;
        assertThrows(
                IllegalArgumentException.class,
                () -> rate.calculate(testPeriod)
        );
    }
    // Test Case 10: valid carParkKind of type visitor
    @Test
    public void testCalculateValidVisitorKind(){
        reducedPeriods.add(new Period(8,18));
        normalPeriods.add(new Period(18,24));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        rate = new Rate(CarParkKind.VISITOR, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period testPeriod = new Period(17, 19);
        BigDecimal expectedOutput = BigDecimal.valueOf(3);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
}
