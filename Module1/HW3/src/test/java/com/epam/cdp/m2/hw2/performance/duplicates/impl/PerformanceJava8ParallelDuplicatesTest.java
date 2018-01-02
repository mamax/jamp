package com.epam.cdp.m2.hw2.performance.duplicates.impl;

import com.epam.cdp.m2.hw2.aggregator.Java8ParallelAggregator;
import com.epam.cdp.m2.hw2.performance.duplicates.PerformanceDuplicatesTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PerformanceJava8ParallelDuplicatesTest extends PerformanceDuplicatesTest {

    public PerformanceJava8ParallelDuplicatesTest() {
        super(new Java8ParallelAggregator());
    }

}
