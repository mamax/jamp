package com.epam.cdp.m2.hw2.performance.frequency.impl;

import com.epam.cdp.m2.hw2.aggregator.Java7Aggregator;
import com.epam.cdp.m2.hw2.performance.frequency.PerformanceFrequencyTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PerformanceJava7FrequencyTest extends PerformanceFrequencyTest {

    public PerformanceJava7FrequencyTest() {
        super(new Java7Aggregator());
    }

}
