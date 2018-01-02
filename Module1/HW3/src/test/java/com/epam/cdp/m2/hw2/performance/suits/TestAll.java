package com.epam.cdp.m2.hw2.performance.suits;

import com.epam.cdp.m2.hw2.performance.duplicates.impl.PerformanceJava7DuplicatesTest;
import com.epam.cdp.m2.hw2.performance.duplicates.impl.PerformanceJava7ParallelDuplicatesTest;
import com.epam.cdp.m2.hw2.performance.duplicates.impl.PerformanceJava8DuplicatesTest;
import com.epam.cdp.m2.hw2.performance.duplicates.impl.PerformanceJava8ParallelDuplicatesTest;
import com.epam.cdp.m2.hw2.performance.frequency.impl.PerformanceJava7FrequencyTest;
import com.epam.cdp.m2.hw2.performance.frequency.impl.PerformanceJava7ParallelFrequencyTest;
import com.epam.cdp.m2.hw2.performance.frequency.impl.PerformanceJava8FrequencyTest;
import com.epam.cdp.m2.hw2.performance.frequency.impl.PerformanceJava8ParallelFrequencyTest;
import com.epam.cdp.m2.hw2.performance.sum.impl.PerformanceJava7ParallelSumTest;
import com.epam.cdp.m2.hw2.performance.sum.impl.PerformanceJava7SumTest;
import com.epam.cdp.m2.hw2.performance.sum.impl.PerformanceJava8ParallelSumTest;
import com.epam.cdp.m2.hw2.performance.sum.impl.PerformanceJava8SumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PerformanceJava7FrequencyTest.class,
        PerformanceJava7SumTest.class,
        PerformanceJava7DuplicatesTest.class,

        PerformanceJava8FrequencyTest.class,
        PerformanceJava8SumTest.class,
        PerformanceJava8DuplicatesTest.class,

        PerformanceJava7ParallelFrequencyTest.class,
        PerformanceJava7ParallelSumTest.class,
        PerformanceJava7ParallelDuplicatesTest.class,

        PerformanceJava8ParallelFrequencyTest.class,
        PerformanceJava8ParallelSumTest.class,
        PerformanceJava8ParallelDuplicatesTest.class,
})
public class TestAll {
}
