package com.epam.innerclass;

import org.junit.Assert;
import org.junit.Test;

public class TestInnerClass {

    @Test
    public void testDemo(){
        int sum = InnerClass.C.add(InnerClass.A.getZ(), InnerClass.B.getY());
        Assert.assertEquals(6, sum);
    }
}
