package com.canadalife.demo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MathematicsTest {
	Mathematics maths=new Mathematics();

	private Integer no1, no2, result;

	public MathematicsTest(Integer no1, Integer no2, Integer result) {
		super();
		this.no1 = no1;
		this.no2 = no2;
		this.result = result;
	}
	
	 @Parameterized.Parameters
	    public static Collection<Object[]> data() {

	        return Arrays.asList(new Object[][] {
	            {2, 3, 5},
	            {10, 20, 30},
	            {5, 7, 12},
	            {100, 200, 300}
	        });
	    }
	    
	    @Test
	    public void addTest() {
	    	maths.setNo1(no1);
	    	maths.setNo2(no2);
	    	Integer expected=result;
	    	maths.add();
	    	Integer actual=maths.getResult();
	    	
	    	assertEquals(expected, actual);
	    }
}
