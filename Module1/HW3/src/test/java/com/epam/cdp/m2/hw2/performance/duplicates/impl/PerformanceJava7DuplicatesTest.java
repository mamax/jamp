package com.epam.cdp.m2.hw2.performance.duplicates.impl;

import com.epam.cdp.m2.hw2.aggregator.Java7Aggregator;
import com.epam.cdp.m2.hw2.performance.duplicates.PerformanceDuplicatesTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PerformanceJava7DuplicatesTest extends PerformanceDuplicatesTest {

    public PerformanceJava7DuplicatesTest() {
        super(new Java7Aggregator());
    }
}
