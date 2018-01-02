package com.epam.cdp.m2.hw2.performance.suits;

import com.epam.cdp.m2.hw2.performance.duplicates.impl.PerformanceJava8DuplicatesTest;
import com.epam.cdp.m2.hw2.performance.frequency.impl.PerformanceJava8FrequencyTest;
import com.epam.cdp.m2.hw2.performance.sum.impl.PerformanceJava8SumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PerformanceJava8FrequencyTest.class,
        PerformanceJava8SumTest.class,
        PerformanceJava8DuplicatesTest.class,
})
public class TestJava8 {
}
