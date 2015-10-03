package com.bloc.exceptions;

/************************************************
 *	ASSIGNMENT:
 *	Catch exceptions thrown by the FunMethods class.
 *	Use as few try…catch statements as necessary.
 *
 *	However, avoid wrapping the entire method in a try…catch,
 *	this is bad practice.
/************************************************/

import java.util.Random;

public class Main extends Object {

	public static void main(String [] args) {
		tryGetMax();
		tryRemove();

		System.out.println("/************************/");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/*   If you see this,   */");
		System.out.println("/*   congratulations!   */");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/************************/\n");
	}

	/************************************************
	 *	ASSIGNMENT:
 	 *	Catch thrown exceptions
	/************************************************/
	private static final void tryGetMax() {
		int max = 0;

		try {
			max = FunMethods.getMax((Integer[])null);	
		} catch (IllegalArgumentException e) {
			// do nothing
		}

		Integer[] numbers = new Integer[50];
		Random rand = new Random();
		for (int i = 0; i < 50; i++) {
			numbers[i] = new Integer(rand.nextInt(500));
		}

		try {
			numbers[32] = null;
			max = FunMethods.getMax(numbers);			
		} catch (IllegalStateException e) {
			numbers[32] = new Integer(rand.nextInt(500));
			max = FunMethods.getMax(numbers);
		}
	}

	/************************************************
	 *	ASSIGNMENT:
 	 *	Catch thrown exceptions
	/************************************************/
	private static final void tryRemove() {

		try {
			FunMethods.remove(null, 2);
		} catch (IllegalArgumentException e) {
			// do nothing
		}
		
		Object[] someObjects = new Object[12];
		someObjects[0] = "a string!";
		someObjects[1] = new Integer(32);
		someObjects[2] = new Float(42.5f);
		someObjects[3] = "another string";
		for (int i = 4; i < someObjects.length; i++) {
			someObjects[i] = String.valueOf(i);
		}

		try {
			FunMethods.remove(someObjects, 12);
		} catch (IndexOutOfBoundsException e) {
			// do nothing
		}

		someObjects = FunMethods.remove(someObjects, 3);
	}
}
