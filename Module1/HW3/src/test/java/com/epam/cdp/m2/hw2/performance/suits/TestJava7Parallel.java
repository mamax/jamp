package com.epam.cdp.m2.hw2.performance.suits;

import com.epam.cdp.m2.hw2.performance.duplicates.impl.PerformanceJava7ParallelDuplicatesTest;
import com.epam.cdp.m2.hw2.performance.frequency.impl.PerformanceJava7ParallelFrequencyTest;
import com.epam.cdp.m2.hw2.performance.sum.impl.PerformanceJava7ParallelSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PerformanceJava7ParallelFrequencyTest.class,
        PerformanceJava7ParallelSumTest.class,
        PerformanceJava7ParallelDuplicatesTest.class,
})
public class TestJava7Parallel {
}
