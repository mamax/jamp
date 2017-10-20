package com.epam.cdp.m2.hw2.performance.sum;

import com.epam.cdp.m2.hw2.aggregator.Aggregator;
import com.epam.cdp.m2.hw2.performance.CommonMethods;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public abstract class PerformanceSumTest extends CommonMethods {

    @Parameterized.Parameter(0)
    public List<Integer> numbers;

    private Aggregator aggregator;

    public PerformanceSumTest(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{getRandomArray(5000)});
        data.add(new Object[]{getRandomArray(53000)});
        data.add(new Object[]{getRandomArray(180000)});
        return data;
    }

    private static List<Integer> getRandomArray(int value) {
        ArrayList<Integer> temp = new ArrayList<>();
        Random rand  = new Random();

        for (int i=0; i<value; i++){
            temp.add(rand.nextInt(47));
        }

        return temp;
    }

    @Test
    public void test() {
        Date start = getCurrentTime();
        aggregator.sum(numbers);
        Date end = getCurrentTime();

        long timeElapsed = end.getTime() - start.getTime();
        System.out.println("Time taken: "+ timeElapsed +" milliseconds");
    }

}