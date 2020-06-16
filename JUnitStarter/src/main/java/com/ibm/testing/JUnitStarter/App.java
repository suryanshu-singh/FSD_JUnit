package com.ibm.testing.JUnitStarter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        App app = new App();
        
//        if(app.add(34, 34) == 68) {
//        	System.out.println("Correct");
//        }
//        else
//        	System.out.println("SOmething wrong with the logic....");
    }
    
    
    int add(int a, int b) {
    	return a + b;
    }
    
    int divide(int a, int b) {
    	return a / b;
    }
    
    boolean checkForPalindrome(String value) {
    	if(value.equals("madam")) {
    		return true;
    	}
    	return false;
    }
    
}
