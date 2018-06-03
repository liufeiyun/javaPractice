package com.lfy.Junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ʹ�ø����ע���д����
 * ����ע��������JunitTestAnnotation.java
 * */
public class CalculatorJunitTest1 {

	Calculator c = null;
	
	@Before
	public void testBeforeClass(){
		c = new Calculator();
	}
	
	@Test
    //���� add()����
    public void testAdd(){
        int result = c.add(1, 2);
        Assert.assertEquals(result, 3);
    }
     
    @Test
    //���� sub()����
    public void testSub(){
        int result = c.sub(2, 1);
        Assert.assertEquals(result, 1);
    }
}
