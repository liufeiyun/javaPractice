package com.lfy.Junit;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorJunitTest {

	@Test
    //测试 add()方法
    public void testAdd(){
        Calculator c = new Calculator();
        int result = c.add(1, 2);
        Assert.assertEquals(result, 3);
    }
     
    @Test
    //测试 sub()方法
    public void testSub(){
        Calculator c = new Calculator();
        int result = c.sub(2, 1);
        Assert.assertEquals(result, 1);
    }
}
