package com.ibm.testing.Junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@TestInstance(Lifecycle.PER_CLASS)
public class AppTest
{
	App app;
	
	@BeforeAll
	static void callFirst() {
		System.out.println("Inside calFirst...");
	}
	
	@AfterAll
	static void callEnd() {
		System.out.println("Inside callEnd...");
	}
	
	
	@BeforeEach
	void callBeforeEveryMethodCall() {
			app = new App();
		
			System.out.println("Before a method is called..");
	}
	
	@AfterEach
	void callAfterEveryMethodCall() {
		System.out.println("After a method call is executed...");
	}
	
	
  
	@Test
	@DisplayName("Tests the add method")
//	@Disabled
	void testAdd() {
//		App app = new App();
		
//		int result = app.add(10, 20);
		
		assertEquals(30, app.add(10, 20));
//		assertEquals(120, app.add(1000, 20));
//		assertEquals(1000, app.add(100, 900));
		
//		assertEquals(30, result, "Should have been equal");	
		
		assertAll(
				() -> assertEquals(120, app.add(100, 20)),
				() -> assertEquals(500, app.add(40, 10)),
				() -> assertEquals(700, app.add(500, 200))	
				);
		
	}
	
	@Test
	@DisplayName("Tests the divide method")
//	@EnabledOnOs(OS.LINUX)
//	@EnabledOnJre(JRE.JAVA_13)
	void testDivide() {
		
//		App app = new App();
		
		assertEquals(5, app.divide(100, 20));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"ibm", "madam", "Shubham"})
	void testPalindrome(String value) {
		assertEquals(true, app.checkForPalindrome(value));
	}
	
	
	
}
