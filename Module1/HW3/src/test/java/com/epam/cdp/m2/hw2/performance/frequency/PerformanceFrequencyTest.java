package com.epam.cdp.m2.hw2.performance.frequency;

import com.epam.cdp.m2.hw2.aggregator.Aggregator;
import com.epam.cdp.m2.hw2.performance.CommonMethods;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.*;

public abstract class PerformanceFrequencyTest extends CommonMethods{

    @Parameterized.Parameter(0)
    public long limit;

    @Parameterized.Parameter(1)
    public List<String> words;

    private Aggregator aggregator;

    public PerformanceFrequencyTest(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{2, getRandomStringArray(10)});
        data.add(new Object[]{2, getRandomStringArray(100)});
        data.add(new Object[]{2, getRandomStringArray(500)});
        data.add(new Object[]{2,  getRandomStringArray(1000)});
        data.add(new Object[]{2, Collections.emptyList()});
        return data;
    }

    @Test
    public void test() {
        Date start = getCurrentTime();
        aggregator.getMostFrequentWords(words, limit);
        Date end = getCurrentTime();

        long timeElapsed = end.getTime() - start.getTime();
        System.out.println("Time taken: "+ timeElapsed +" milliseconds");
    }

}