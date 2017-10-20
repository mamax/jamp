package com.epam.cdp.m2.hw2.performance.sum.impl;

import com.epam.cdp.m2.hw2.aggregator.Java7ParallelAggregator;
import com.epam.cdp.m2.hw2.performance.sum.PerformanceSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PerformanceJava7ParallelSumTest extends PerformanceSumTest {

    public PerformanceJava7ParallelSumTest() {
        super(new Java7ParallelAggregator());
    }
}
