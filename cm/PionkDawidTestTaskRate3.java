//Date:             21/11/2024
//Purpose:          Task 2 Ver Project 
//Name:             Dawid Pionk
//Student Number:   C00273530

//////////////////////////////////////////////////////////////////
package cm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PionkDawidTestTaskRate3 {
    private Rate rate;
    ArrayList<Period> reducedPeriods;
    ArrayList<Period> normalPeriods;
    BigDecimal normalRate;
    BigDecimal reducedRate;
    RateStrategy strategy;

    @BeforeEach
    public void setUp(){
        reducedPeriods = new ArrayList<Period>();
        normalPeriods = new ArrayList<Period>();
    }

    // Test Case 1: Valid Test Visitor Strategy low free fare
    @Test
    public void testCalculateValidVisitorLowFreeFare(){
        reducedPeriods.add(new Period(11,15));
        normalPeriods.add(new Period(22,23));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        strategy = new VisitorStrategy();
        rate = new Rate(reducedPeriods, normalPeriods, normalRate, reducedRate, strategy);
        Period testPeriod = new Period(18,19);
        BigDecimal expectedOutput = BigDecimal.valueOf(0);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 2: Valid Visitor Strategy high price fare
    @Test
    public void testCalculateValidVisitorHighPriceFare(){
        normalPeriods.add(new Period(0,12));
        reducedPeriods.add(new Period(13,24));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        strategy = new VisitorStrategy();
        rate = new Rate(reducedPeriods, normalPeriods, normalRate, reducedRate, strategy);
        Period testPeriod = new Period(0,24);
        BigDecimal expectedOutput = BigDecimal.valueOf(12.5);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 3: Valid management Strategy minimum price
    @Test
    public void testCalculateValidManagementMinimumPrice(){
        normalPeriods.add(new Period(8,18));
        reducedPeriods.add(new Period(18,24));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        strategy = new ManagementStrategy();
        rate = new Rate(reducedPeriods, normalPeriods, normalRate, reducedRate, strategy);
        Period testPeriod = new Period(11,12);
        BigDecimal expectedOutput = BigDecimal.valueOf(4);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 4: Valid management Strategy High price
    @Test
    public void testCalculateValidManagementHighPrice(){
        normalPeriods.add(new Period(8,18));
        reducedPeriods.add(new Period(18,24));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        strategy = new ManagementStrategy();
        rate = new Rate(reducedPeriods, normalPeriods, normalRate, reducedRate, strategy);
        Period testPeriod = new Period(0,24);
        BigDecimal expectedOutput = BigDecimal.valueOf(26);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 5: Valid Student Strategy low price
    @Test
    public void testCalculateValidStudentLowPrice(){
        normalPeriods.add(new Period(8,18));
        reducedPeriods.add(new Period(18,24));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        strategy = new StudentStrategy();
        rate = new Rate(reducedPeriods, normalPeriods, normalRate, reducedRate, strategy);
        Period testPeriod = new Period(11,12);
        BigDecimal expectedOutput = BigDecimal.valueOf(2);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 6: Valid Student Strategy High price
    @Test
    public void testCalculateValidStudentHighPrice(){
        normalPeriods.add(new Period(8,18));
        reducedPeriods.add(new Period(18,24));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        strategy = new StudentStrategy();
        rate = new Rate(reducedPeriods, normalPeriods, normalRate, reducedRate, strategy);
        Period testPeriod = new Period(0,24);
        BigDecimal expectedOutput = new BigDecimal("19.50");
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 7: Valid Staff Strategy low price
    @Test
    public void testCalculateValidStaffLowPrice(){
        normalPeriods.add(new Period(8,18));
        reducedPeriods.add(new Period(18,24));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        strategy = new StaffStrategy();
        rate = new Rate(reducedPeriods, normalPeriods, normalRate, reducedRate, strategy);
        Period testPeriod = new Period(11,12);
        BigDecimal expectedOutput = BigDecimal.valueOf(2);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
    // Test Case 8: Valid Staff Strategy high price
    @Test
    public void testCalculateValidStaffHighPrice(){
        normalPeriods.add(new Period(8,18));
        reducedPeriods.add(new Period(18,24));
        normalRate = BigDecimal.valueOf(2);
        reducedRate = BigDecimal.valueOf(1);
        strategy = new StaffStrategy();
        rate = new Rate(reducedPeriods, normalPeriods, normalRate, reducedRate, strategy);
        Period testPeriod = new Period(0,24);
        BigDecimal expectedOutput = BigDecimal.valueOf(16);
        assertEquals(expectedOutput, rate.calculate(testPeriod));
    }
}