package com.ideyatech.ut.lecture;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;
public class CasioCalculatorTest {
	
	private CasioCalculator casio;
	private CasioCalculator casio2;
	
	@BeforeClass
	public static void initClass(){
		/* This is usually done for processes that includes JAVA IO and as well as
		 * database retrievals. */
		System.out.println("I WILL RUN ONCE BEFORE!!!");
		
	}
	
	@Before
	public void init(){
		casio = new CasioCalculator();
		casio2 = new CasioCalculator();
		casio.setModel("Model 1");
		casio2.setModel("Model 2");
		System.out.println(casio.equals(casio2));
		
	}
	
	@After
	public void cleanUp(){
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("I WILL RUN ONCE AFTER!!!");
	}
	
	@Test
	public void testAdd(){
		long a = 5;
		long b = 10;
		assertEquals("Sum of 10 and 5 should be 15", 15l, casio.add(a, b));
	}
	
	@Test
	public void testSubtractPositiveResult(){
		long a = 10;
		long b = 5;
		assertEquals("Difference of 10 and 5 should be 5", 5l, casio.subtract(a, b));
	}
	
	@Test
	public void testSubtractNegativeResult(){
		long a = 5;
		long b = 10;
		assertEquals("Difference of 5 and 10 should be -5", -5l, casio.subtract(a, b));
	}
	
	@Test
	public void testMultiplyTwoPositives(){
		long a = 10;
		long b = 5;
		assertEquals("Product of 10 and 5 should be 50", 50l, casio.multiply(a, b));
	}
	
	@Test
	public void testMultiplyWithZero(){
		long a = 5;
		long b = 0;
		assertEquals("Product of 5 and 0 should be 0", 0l, casio.multiply(a, b));
	}

	@Test
	public void testMultiplyTwoNegatives(){
		long a = -10;
		long b = -5;
		assertEquals("Product of -10 and -5 should be 50", 50l, casio.multiply(a, b));
	}
	
	@Test
	public void testPower10RaisedTo5(){
		long a = 10;
		long pow = 5;	
		assertEquals("10 raised to 5 should be 100000", 100000, casio.power(a, pow), 0);
	}
	
	@Test
	public void testPower10RaisedTo0(){
		long a = 10;
		long pow = 0;	
		assertEquals("10 raised to 0 should be 1", 1, casio.power(a, pow), 0);
	}
}

