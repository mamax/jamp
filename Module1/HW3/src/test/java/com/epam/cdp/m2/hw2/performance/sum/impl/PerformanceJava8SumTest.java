package com.epam.cdp.m2.hw2.performance.sum.impl;

import com.epam.cdp.m2.hw2.aggregator.Java8Aggregator;
import com.epam.cdp.m2.hw2.performance.sum.PerformanceSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PerformanceJava8SumTest extends PerformanceSumTest {

    public PerformanceJava8SumTest() {
        super(new Java8Aggregator());
    }
}

