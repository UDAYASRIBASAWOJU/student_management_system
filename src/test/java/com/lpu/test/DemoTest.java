package com.lpu.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DemoTest {
	
	@BeforeAll
	public static void m1() {
		System.out.println("Before All");
	}
	
	@AfterAll
	public static void m2() {
		System.out.println("After All");
	}
	
	@BeforeEach
	public void m3() {
		System.out.println("Before Each");
	}
	
	@AfterEach
	public void m4() {
		System.out.println("After Each");
	}
	
	@Test
	public void demo1() {
		Assertions.assertEquals("xyz", "xyz");   //checks values
	}
	
	@Test
	public void demo2() {
		Assertions.assertNotEquals(9, "null value not allowed");
	}
	
	@Test
	public void demo3() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			int res = 7 / 0;
		});
	}
	
	@Test
	public void demo4() {
		Assertions.assertDoesNotThrow(() -> {
			int res = 9 / 2;
		});
	}
	
	@Test
	public void demo5() {
		String s1 = "xyz";
		String s2 = "xyz";
		
		Assertions.assertSame(s1, s2);   //checks address
	}
	
	@Test
	public void demo6() {
		int age = 17;
		if(age < 18) 
			fail("Age is less than 18");
	}
	
	@Test
	public void demo7() {
		int[] arr1 = {10, 20};
		int[] arr2 = {10, 20, 7};
		
		Assertions.assertArrayEquals(arr1, arr2);
	}
	
	@Test
	public void demo8() {
		boolean res = true;
		
		Assertions.assertTrue(res);
	}
	
	@Test
	public void demo9() {
		boolean res = false;
		
		Assertions.assertFalse(res);
	}
	
	@ParameterizedTest
	@CsvSource({"2, 3, 5", "5, 2, 9"})
	public void testAddition(int a, int b, int expected) {
		int res = a + b;
		
		Assertions.assertEquals(expected, res);
	}
}
