package com.epam.cdp.m2.hw2.aggregator;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Aggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        return words.stream()
                .map(i -> new Pair<>(i, (long) Collections.frequency(words, i)))
                .distinct()
                .sorted(UtilsAggregator.PAIRS_COMPARATOR)
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        final Set<String> all = new HashSet<>();

        return words.stream().
                map(String::toLowerCase).
                filter(n -> !all.add(n)).
                limit(limit).
                collect(Collectors.toList());
    }
}