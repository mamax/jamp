package com.epam.cdp.m2.hw2.aggregator;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java7Aggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        int sum =0;
        for (Integer i : numbers){
            sum+=i;
        }
        return sum;
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        return UtilsAggregator.getLimits(getSortedFrequentWords(words), limit);
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        return UtilsAggregator.getLimits(getDuplicatedWords(words), limit);
    }

    /**
     * Gets duplicates in list
     * @param words Input list
     * @return Result list of words
     */
    public static List<String> getDuplicatedWords(List<String> words){
        List<String> duplicates = new ArrayList<>();
        List<String> original = new ArrayList<>();

        for (String word : words){
            if (original.contains(word.toLowerCase())){
                    duplicates.add(word.toLowerCase());
            }
            else if (!original.contains(word.toLowerCase()) || original.isEmpty()){
                original.add(word.toLowerCase());
            }
        }

        return duplicates;
    }

    /**
     * Gets list sorted by frequency of words
     * @param words input list of words
     * @return list of words, sorted by frequency
     */
    public List<Pair<String, Long>> getSortedFrequentWords(List<String> words) {
        List<Pair<String, Long>> list;

        final HashMap<String, Long> pairs = new HashMap();
        for (String word : words){

            if (pairs.containsKey(word)) {
                pairs.put(word, pairs.get(word)+1L);
            }
            else if (!pairs.containsKey(word)){
                pairs.put(word, 1L);
            }
        }

        final Map<String, Long> sortedMap =  UtilsAggregator.sortByValues(pairs);
        list = UtilsAggregator.convertMapToList(sortedMap);
        return list;
    }

}
