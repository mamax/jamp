package com.epam.cdp.m2.hw2.performance.frequency.impl;

import com.epam.cdp.m2.hw2.aggregator.Java7ParallelAggregator;
import com.epam.cdp.m2.hw2.performance.frequency.PerformanceFrequencyTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PerformanceJava7ParallelFrequencyTest extends PerformanceFrequencyTest {

    public PerformanceJava7ParallelFrequencyTest() {
        super(new Java7ParallelAggregator());
    }
}
