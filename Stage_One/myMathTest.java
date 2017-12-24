package com.TestDemo;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class myMathTest {

	@Test
	public void testDiv() {
		try {
			TestCase.assertEquals(Math.div(10, 2) , 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
