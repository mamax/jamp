package com.epam.cdp.m2.hw2.performance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CommonMethods {

    protected Date getCurrentTime() {
        return java.util.Calendar.getInstance().getTime();
    }

    protected static List<String> getRandomStringArray(int quantityOfItems) {
        List<String> randomStrings = new ArrayList();
        randomStrings.add("a");
        randomStrings.add("b");
        randomStrings.add("c");
        randomStrings.add("d");
        randomStrings.add("f");

        List<String> tempArray = new ArrayList<>();

        Random rand  = new Random();

        for (int i=0; i<quantityOfItems; i++){
            tempArray.add(randomStrings.get(rand.nextInt(randomStrings.size())));
        }

        return tempArray;
    }
}
