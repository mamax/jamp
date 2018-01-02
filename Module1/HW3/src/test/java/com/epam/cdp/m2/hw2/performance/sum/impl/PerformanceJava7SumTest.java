package com.epam.cdp.m2.hw2.performance.sum.impl;

import com.epam.cdp.m2.hw2.aggregator.Java7Aggregator;
import com.epam.cdp.m2.hw2.performance.sum.PerformanceSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PerformanceJava7SumTest extends PerformanceSumTest {

    public PerformanceJava7SumTest() {
        super(new Java7Aggregator());
    }

}
