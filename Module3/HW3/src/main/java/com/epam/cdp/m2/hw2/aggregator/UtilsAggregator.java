package com.epam.cdp.m2.hw2.aggregator;

import javafx.util.Pair;

import java.util.*;

public class UtilsAggregator {

     static final Comparator<? super Pair<String, Long>> PAIRS_COMPARATOR = new Comparator<Pair<String, Long>>() {
        @Override
        public int compare(Pair<String, Long> obj1, Pair<String, Long> obj2) {
            if (obj1 == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            if (obj1.equals( obj2 )) {
                return 0;
            }

            int i = obj2.getValue().compareTo(obj1.getValue());
            return i != 0 ? i : obj1.getKey().compareTo(obj2.getKey());
        }
    };

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
