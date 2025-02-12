package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

@DisplayName("Testing Arithmetic Operations")
@TestInstance(Lifecycle.PER_CLASS)
class CalculatorTest {
	CalculatorTest(){
		System.out.println("<<-------------------Calculator Test Created------------------------>>");
	}
	
	static Calculator c1;
	static int x = 5;
	static boolean condition = false;
	
	@BeforeAll
	@Tag("math")
	static void createCalculator() {
		c1 = new Calculator();
		System.out.println("-----Started------");
		if (x != 0) {
			condition = true;
		}
		
	}
	
	@AfterAll
	@Tag("math")
	static void removeCalculator() {
		c1 = null;
		System.out.println("-----Finished------");
	}
	
	@BeforeEach
	@Tag("demo")
	void abc() {
		System.out.println("--Before Test Case--");
	}
	
	@AfterEach

	@Tag("demo")
	void xyz() {
		System.out.println("--After Test Case");
	}
	
	@Test
	@Disabled

	@Tag("demo")
	void test() {
		assertTrue(true);
		System.out.println("-----Test Method------");
	}
	
	@Test
	@DisplayName("Testing Addition")
	@Tag("math")
	void testAdd() {
		assertEquals(30, c1.add(10, 20), () -> "Wrong Addition");
		assertEquals(-10, c1.add(10, -20), () -> "Wrong Addition");
		assertEquals(90, c1.add(40, 50), () -> "Wrong Addition");
		assertEquals(50, c1.add(23, 27), () -> "Wrong Addition");
		System.out.println("-----Test Add------");
	}
	
	@Test
	@DisplayName("Testing Division")
	@Tag("math")
	void testDiv() {
		assertEquals(2, c1.div(10, 5));
//		assertEquals(2, c1.div(90, 0));
		assertThrows(ArithmeticException.class, () ->c1.div(90, 0));
		System.out.println("-----Test Div------");
	}
	
	@Test
	@DisplayName("Testing Multiply")
	@Tag("math")
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
	
	@Test
	@DisplayName("Testing Modulus")
	@Tag("math")
	void testMod() {
		assertAll(
				() -> assertEquals(0, c1.mod(10, 10)),
				() -> assertEquals(0, c1.mod(20, 10)),
				() -> assertEquals(4, c1.mod(134, 10)),
				() -> assertEquals(1, c1.mod(10, 9)),
				() -> assertEquals(8, c1.mod(100, 92)),
				() -> assertEquals(5, c1.mod(100,19 )),
				() -> assertEquals(3, c1.mod(10, 7))
				);
	}
	
	@Test
//	@EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_17)
	@EnabledOnJre(value = JRE.JAVA_8)
	@Tag("os")
	void testLambda() {
		System.out.println("Testing for lambda expression");
	}
	
	@Test
	@EnabledOnOs(OS.WINDOWS)
	@Tag("os")
	void testDll() {
		System.out.println("Testing Dynamic Link Library Files");
	}
	
	@Test
	@EnabledOnOs(value = {OS.MAC, OS.LINUX})
	@Tag("os")
	void testShellScripts() {
		System.out.println("Testing Shell Scripts");
	}
	
	@Test
	@Tag("demo")
//	@Tags(value = {'demo', 'math'})
	@Tag("math")
	void testDynamically() {
		System.out.println("Test Dynamically Started");
		assertEquals(5, c1.div(25, 5));
		assumeTrue(condition);
		assertEquals(10, c1.div(50, x));
		assertEquals(4, c1.div(20, x));
		System.out.println("Test Dynamically Ended");
	}
	
	
	@Test
	@Tag("db")
	void testInsertEmp() {
		System.out.println("Testing emp record insert");
	}
	
	@Test
	@Tag("db")

	void testDeleteEmp() {
		System.out.println("Testing emp record Delete");
	}
	@Test
	@Tag("db")

	void testUpdateEmp() {
		System.out.println("Testing emp record update");
	}
	@Test
	@Tag("db")
	void testSelectEmp() {
		System.out.println("Testing emp record select");
	}
}
