package com.epam.cdp.m2.hw2.performance.suits;

import com.epam.cdp.m2.hw2.performance.duplicates.impl.PerformanceJava8ParallelDuplicatesTest;
import com.epam.cdp.m2.hw2.performance.frequency.impl.PerformanceJava8ParallelFrequencyTest;
import com.epam.cdp.m2.hw2.performance.sum.impl.PerformanceJava8ParallelSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PerformanceJava8ParallelFrequencyTest.class,
        PerformanceJava8ParallelSumTest.class,
        PerformanceJava8ParallelDuplicatesTest.class,
})
public class TestJava8Parallel {
}
