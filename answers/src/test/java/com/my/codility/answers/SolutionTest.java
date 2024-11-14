package com.my.codility.answers;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SolutionTest {

	@Test
	public void testSolution() {
		Solution s = new Solution();
		System.out.println(s.add("1,2,2"));
	        System.out.println(s.add("1,2,\n3"));
	        System.out.println(s.add("1,\n2"));
	        System.out.println(s.add("1\n,2"));   // should fail
	        System.out.println(s.add("//**\n1**2**3"));
	        System.out.println(s.add("//**|::|***|,\n1,2**3::4***5"));
	        System.out.println(s.add("1, 2, 3"));
		System.out.println(app.add("1,2,-3,4,-5,6"));	// should fail
	}
}
