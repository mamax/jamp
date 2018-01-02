package com.epam.cdp.m2.hw2.performance.sum.impl;

import com.epam.cdp.m2.hw2.aggregator.Java8ParallelAggregator;
import com.epam.cdp.m2.hw2.performance.sum.PerformanceSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PerformanceJava8ParallelSumTest extends PerformanceSumTest {

    public PerformanceJava8ParallelSumTest() {
        super(new Java8ParallelAggregator());
    }
}
