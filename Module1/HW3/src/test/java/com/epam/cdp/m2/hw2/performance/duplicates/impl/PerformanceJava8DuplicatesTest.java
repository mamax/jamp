package com.epam.cdp.m2.hw2.performance.duplicates.impl;

import com.epam.cdp.m2.hw2.aggregator.Java8Aggregator;
import com.epam.cdp.m2.hw2.performance.duplicates.PerformanceDuplicatesTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PerformanceJava8DuplicatesTest extends PerformanceDuplicatesTest {

    public PerformanceJava8DuplicatesTest() {
        super(new Java8Aggregator());
    }
}

