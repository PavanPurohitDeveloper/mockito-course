package com.in28minutes.tdd;

import com.in28minutes.utils.MathUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MathUtilsTest {

   @Test
   public void testAdd(){
        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testComputeCircleRadius(){
        MathUtils mathUtils = new MathUtils();
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10));
    }
}
