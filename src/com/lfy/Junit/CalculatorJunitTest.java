package com.lfy.Junit;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorJunitTest {

	@Test
    //���� add()����
    public void testAdd(){
        Calculator c = new Calculator();
        int result = c.add(1, 2);
        Assert.assertEquals(result, 3);
    }
     
    @Test
    //���� sub()����
    public void testSub(){
        Calculator c = new Calculator();
        int result = c.sub(2, 1);
        Assert.assertEquals(result, 1);
    }
}
