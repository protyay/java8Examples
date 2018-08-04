package com.java.eight.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


/**
 * This class contains example along with side notes that should be sufficient to
 * clearly revise concepts in minutes.
 * Functional Interface, Lambda Expression, Behavior parameterization, method reference.
 * All explained in a single example.
 * 26-Jul-2018
 * @author Protyay
 * @see <a href=""/>Lambda.java</a>
 *
 */
public class Lambda {
	
    //Predicate is a FUNCTIONAL interface.
	public static void main(String[] args) {
		//Functional Interface. Predicate.Type inferences happen in terms of the context.
		Predicate<String> testPredicate =  input -> input.contains("a");
				
		List<String> allString = Arrays.asList(new String[]{"witha","without"});
		
		allString.stream().filter(testPredicate).forEach(System.out::println);
		
	}

}
