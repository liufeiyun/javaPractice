package com.lfy.Junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 使用更多的注解简写代码
 * 更多注解描述见JunitTestAnnotation.java
 * */
public class CalculatorJunitTest1 {

	Calculator c = null;
	
	@Before
	public void testBeforeClass(){
		c = new Calculator();
	}
	
	@Test
    //测试 add()方法
    public void testAdd(){
        int result = c.add(1, 2);
        Assert.assertEquals(result, 3);
    }
     
    @Test
    //测试 sub()方法
    public void testSub(){
        int result = c.sub(2, 1);
        Assert.assertEquals(result, 1);
    }
}
