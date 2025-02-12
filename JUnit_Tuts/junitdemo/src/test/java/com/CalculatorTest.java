package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing Arithmetic Operations")
class CalculatorTest {
	
	static Calculator c1;
	
	@BeforeAll
	static void createCalculator() {
		c1 = new Calculator();
		System.out.println("-----Started------");
	}
	
	@AfterAll
	static void removeCalculator() {
		c1 = null;
		System.out.println("-----Finished------");
	}
	
	@BeforeEach
	void abc() {
		System.out.println("--Before Test Case--");
	}
	
	@AfterEach
	void xyz() {
		System.out.println("--After Test Case");
	}
	
	@Test
	@Disabled
	void test() {
		assertTrue(true);
		System.out.println("-----Test Method------");
	}
	@Test
	@DisplayName("Testing Addition")
	void testAdd() {
		assertEquals(30, c1.add(10, 20), () -> "Wrong Addition");
		assertEquals(-10, c1.add(10, -20), () -> "Wrong Addition");
		assertEquals(90, c1.add(40, 50), () -> "Wrong Addition");
		assertEquals(50, c1.add(23, 27), () -> "Wrong Addition");
		System.out.println("-----Test Add------");
	}
	
	@Test
	@DisplayName("Testing Division")
	void testDiv() {
		assertEquals(2, c1.div(10, 5));
//		assertEquals(2, c1.div(90, 0));
		assertThrows(ArithmeticException.class, () ->c1.div(90, 0));
		System.out.println("-----Test Div------");
	}
	
	@Test
	@DisplayName("Testing Multiply")
	void testMul() {
		System.out.println("-----From testMulStart() method------");
		assertAll(
				() -> assertEquals(10, c1.mul(2, 5)),
				() -> assertEquals(20, c1.mul(4, 5)),
				() -> assertEquals(50, c1.mul(10, 5)),
				() -> assertEquals(29, c1.mul(29, 1)),
				() -> assertEquals(100, c1.mul(25, 4)),
				() -> assertEquals(28, c1.mul(4, 7))
				);
		System.out.println("-----From testMulEnd() method------");
	}

}
