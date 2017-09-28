package com.epam.cdp.m2.hw2.aggregator;

import javafx.util.Pair;

import java.util.*;

public class UtilsAggregator {

    static <T> List<T> getLimits(List<T> words, long limit) {
        ArrayList<T> limitedList = new ArrayList<>();

        if (words.size() <= limit){
            return words;
        }
        else{
            for (long i=0; i<limit; i++){
                limitedList.add(words.get((int) i));
            }
        }

        return limitedList;
    }

    static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =  new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0) return 1;
                else return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    static List<Pair<String, Long>> convertMapToList(Map<String, Long> sortedMap) {
        List<Pair<String, Long>> list = new ArrayList<>();
        for (Map.Entry<String, Long> entry : sortedMap.entrySet()) {
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }
        return list;
    }
}
