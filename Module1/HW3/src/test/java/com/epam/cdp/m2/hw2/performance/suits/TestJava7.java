package com.epam.cdp.m2.hw2.performance.suits;

import com.epam.cdp.m2.hw2.performance.duplicates.impl.PerformanceJava7DuplicatesTest;
import com.epam.cdp.m2.hw2.performance.frequency.impl.PerformanceJava7FrequencyTest;
import com.epam.cdp.m2.hw2.performance.sum.impl.PerformanceJava7SumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PerformanceJava7FrequencyTest.class,
        PerformanceJava7SumTest.class,
        PerformanceJava7DuplicatesTest.class,
})
public class TestJava7 {
}
