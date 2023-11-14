package com.example;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUnitTest {

	MathUtils mathUtils;
	TestReporter testReporter;
	TestInfo testInfo;
	
	@BeforeAll
	static void beforeInit()
	{
		System.out.println("this needs to be run before all");
	}
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter)
	{
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
	}
	
	
	@AfterEach
	void cleanup()
	{
		System.out.println("cleaning up...!!");
	}
	
	@BeforeAll
	static void beforeAllTest()
	{
		System.out.println("this is needs before all");
	}
	@Test
	@DisplayName("testing add method")
	void testAdd() {
		//fail("Not yet implemented");
		//System.out.println("this test  ran");
		mathUtils = new MathUtils();
		int expected = 2;
		int actual = mathUtils.add(1,1);
		System.out.println(actual);
		assertEquals(expected,actual,"the adfd method should add the number");
	}

	@Nested
	@DisplayName("add method")
	@Tag("Math")
	class AddTest{


	@Test
	@DisplayName("testing add method for +")
	void testingAddPositive() {
		assertEquals(2, mathUtils.add(1, 1),"the add method should add two numbers");
	}
	
	@Test
	@DisplayName("testing add method for -")
	void testingAddNegitive() {
		assertEquals(-2, mathUtils.add(-1, -1),"the add method should add two numbers");
	}
	
	}
	
	

	@Test
	@DisplayName("testing add method for +")
	void testingAddPositive() {
		assertEquals(2, mathUtils.add(1, 1),"the add method should add two numbers");
	}
	
	@Test
	@DisplayName("testing add method for -")
	void testingAddNegitive() {
		assertEquals(-2, mathUtils.add(-1, -1),"the add method should add two numbers");
	}
	
	
	@Test
	@DisplayName("when adding two positive numbers")
	@Tag("Math")
	void testAddpositiveTest()
	{
		assertEquals(-1, mathUtils.add(1,1),"should return the right sum");
	}
	
	@Test
	@DisplayName("when adding two negitive numbers")
	void testAddNegativeTest()	
	{
		int expected = 2;
		int actual = mathUtils.add(-1, -1);
		assertEquals(expected,actual,"should return sum "+expected+" but returned "+actual);
	}
	
	@Test
	@DisplayName("multiply method")
	void testMultiply()
	{
		System.out.println("running "+testInfo.getDisplayName()+" With tags "+testInfo.getTags());
		//assertEquals(-1, mathUtils.add(-1,-1),"should return the right  product");
		assertAll(()->assertEquals(4, mathUtils.multiply(2,2)),
					()->assertEquals(0, mathUtils.multiply(2,0)),
					()->assertEquals(-2, mathUtils.multiply(2,-1)));
	}
	
	@Test
	@DisplayName("devide meth    od")
	void testDevide()
	{
		assumeTrue(true);
		mathUtils = new MathUtils();
		assertThrows(ArithmeticException.class,()-> mathUtils.devide(10,2),"devide by zero must throw");
	}
	
	
	
	
	
	@RepeatedTest(3)
	@Tag("circle")
	void testComputeCircleRadius(RepetitionInfo repetationinfo)
	{
		assumeTrue(true);
		mathUtils = new MathUtils();
		assertEquals(314.1592653589793,mathUtils.computeCircleArea(10),"should return circle area");
	}
	
	
	
}










