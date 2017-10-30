package com.epam.cdp.m2.hw2.aggregator;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class TestClass {

    public final static List<String> list = Arrays.asList("Apple", "Another", "Element", "Apple", "Element", "Another","Apple", "Another", "Element", "Apple", "World", "Plumb", "Cucumber", "Element", "Cucumber");
    public static long limit = 4;

    private final static List<Integer> listInteger = Arrays.asList(2,4,5,12,3,6,1);

    public static List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        return UtilsAggregator.getLimits(getFrequentWords(words), limit);
    }

    private static List<Pair<String, Long>> getFrequentWords(List<String> words) {
        List<Pair<String, Long>> lisResult = new ArrayList<>();

        final Map<String, Long> pair = new HashMap();

        for (String word : words){

            if (pair.containsKey(word)) {
                pair.put(word, pair.get(word)+1L);
            }
            else if (!pair.containsKey(word)){
                pair.put(word, 1L);
            }
        }

        Map<String, Long> sortedMap =  UtilsAggregator.sortByValues(pair);
        lisResult = UtilsAggregator.convertMapToList(sortedMap);

        return lisResult;
    }

    public static List<String> getDuplicates(List<String> words, long limit) {
        final Set<String> all = new HashSet<>();

        final List<String> duplicates = words.stream().
                map(String::toLowerCase).
                filter(n -> !all.add(n)).
                limit(limit).
                collect(Collectors.toList());

        return duplicates;
    }

    public static int sum(List<Integer> numbers) {
        int sum = 0;
        sum = numbers.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }

//    public static List<String> getDuplicates(List<String> words, long limit) {
//        return UtilsAggregator.getLimits(Java7Aggregator.getDuplicatedWords(words), limit);
//    }

//    public static List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
//        return words.stream()
//                .map(i -> new Pair<>(i, (long) Collections.frequency(words, i)))
//                .distinct()
//                .sorted(UtilsAggregator.PAIRS_COMPARATOR)
//                .limit(limit)
//                .collect(Collectors.toList());
//    }

    public static void main(String[] args) {

//        List<String> lism = getDuplicates(list, limit);
//        System.out.println(lism);

//        List<Pair<String, Long>> list11 = getMostFrequentWords(list, limit);
//        System.out.println(list11);

//        int aa = sum(listInteger);
        Java8ParallelAggregator aggregator = new Java8ParallelAggregator();
        System.out.println(aggregator.getDuplicates(list, 4));
    }

}

