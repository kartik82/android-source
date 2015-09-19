package com.bloc.bestpractices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorstPractices extends Object {

	/************************************************
	 *	ASSIGNMENT:
	 *	Fix code and comments below this block
	/************************************************/

	public static void main(String [] args) {
		int MAGIC_NUMBER = WorstPractices.animals(false);
		MAGIC_NUMBER *= 5;
		if (MAGIC_NUMBER > 18) {
			while(MAGIC_NUMBER > 0)
			{
			MAGIC_NUMBER--;
			}
		}
	}

	// animals
	// this method takes in a single parameter, yesWellHeresTheThing. Using a very elaborate and complex algorithm, it calculate a magic number
	// yesWellHeresTheThing: a seed which helps generate the magic number
	// returns: a magical number
	private static int animals(boolean yesWellHeresTheThing)
	{
		/*
			Start off with one of these
		*/
			
		int aInt = yesWellHeresTheThing ? 34 : 21;
		float sparklesFairy = .5f;
		for (int brown = 0; brown < aInt; brown++) { 
			sparklesFairy *= aInt;
		} 
		return (int) sparklesFairy * aInt;
	}

	/************************************************
	 *	ASSIGNMENT
	 *	Fix code and comments above this block
	/************************************************/
}
