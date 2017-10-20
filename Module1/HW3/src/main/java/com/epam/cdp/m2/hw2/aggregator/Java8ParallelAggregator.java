package com.epam.cdp.m2.hw2.aggregator;

import javafx.util.Pair;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8ParallelAggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        return numbers.parallelStream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        return words.parallelStream()
                .map(i -> new Pair<>(i, (long) Collections.frequency(words, i)))
                .distinct()
                .sorted(UtilsAggregator.PAIRS_COMPARATOR)
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        final Set<String> all = new HashSet<>();

        return words.parallelStream().
                map(String::toLowerCase).
                filter(n -> !all.add(n)).
                limit(limit).
                collect(Collectors.toList());
    }
}
