package com.priv.test.leetCode;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String I = null;
    	System.out.println( "Hello World!" );
    	try {
    		Integer a = new Integer(I);
    		System.out.println("I'm in" + a);
    	} catch (NumberFormatException e){
    		System.out.println("I'm out");
    	}
        
    }
}
