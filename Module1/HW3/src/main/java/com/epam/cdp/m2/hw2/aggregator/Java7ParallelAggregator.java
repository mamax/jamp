package com.epam.cdp.m2.hw2.aggregator;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import static com.epam.cdp.m2.hw2.aggregator.UtilsAggregator.PAIRS_COMPARATOR;
import static com.epam.cdp.m2.hw2.aggregator.UtilsAggregator.STRINGS_COMPARATOR;

public class Java7ParallelAggregator implements Aggregator {
    private final static Integer THRESHOLD = 100000;
    private final Java7Aggregator java7Aggregator = new Java7Aggregator();

    @Override
    public int sum(List<Integer> numbers) {
        return new ForkJoinPool().invoke(new ValueSumCounter(numbers));
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        final List<Pair<String, Long>> wordsList = new ForkJoinPool().invoke(new GettingFrequencyTask(words));
        wordsList.sort(PAIRS_COMPARATOR);
        return UtilsAggregator.getLimits(wordsList,limit);
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        final HashMap<String, Integer> duplicatesWordsMap = new ForkJoinPool().invoke(new GettingDuplicatesTask(words));
        final List<String> duplicates = new ArrayList<>();
        for (Map.Entry<String, Integer> map : duplicatesWordsMap.entrySet()) {
            if (map.getValue() > 1) {
                duplicates.add(map.getKey());
            }
        }
        
        duplicates.sort(STRINGS_COMPARATOR);
        return UtilsAggregator.getLimits(duplicates, limit);
    }

    /**
     * This class illustrates how to create a ForkJoinTask that returns a sum result.
     */
    private class ValueSumCounter extends RecursiveTask<Integer> {
        private final List<Integer> numbers;

        public ValueSumCounter(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        protected Integer compute() {
            Integer sum;

            if (numbers.size() < THRESHOLD){
                sum  = java7Aggregator.sum(numbers);
            }else{
                int middle = (numbers.size()/2);
                ValueSumCounter subTask1 = new ValueSumCounter(numbers.subList(0, middle));
                ValueSumCounter subTask2 = new ValueSumCounter(numbers.subList(middle, numbers.size()));
                subTask1.fork();
                subTask2.fork();
                sum = subTask1.join() + subTask2.join();
            }
            return sum;
        }
    }

    /**
     * This class illustrates how to create a ForkJoinTask that returns a list of pairs.
     */
    private class GettingFrequencyTask extends RecursiveTask<List<Pair<String, Long>>> {
        private final List<String> words;

        public GettingFrequencyTask(List<String> words) {
            this.words = words;
        }

        @Override
        protected List<Pair<String, Long>> compute() {
            List<Pair<String, Long>> frequentWordsList = new ArrayList<>();
            List<GettingFrequencyTask> subTasks = new ArrayList<>();

            if (words.size() > THRESHOLD){
                int middle = (words.size()/2);
                final GettingFrequencyTask task1 = new GettingFrequencyTask(words.subList(0, middle));
                final GettingFrequencyTask task2 = new GettingFrequencyTask(words.subList(middle, words.size()));
                subTasks.add(task1);
                subTasks.add(task2);
                task1.fork();
                task2.fork();
            }
            else {
                frequentWordsList = java7Aggregator.getSortedFrequentWords(words);
            }

            for(GettingFrequencyTask task : subTasks) {
                final List joinList = task.join();
                frequentWordsList.addAll(joinList);
            }

            return frequentWordsList;
        }
    }

    /**
     * This class illustrates how to create a ForkJoinTask that returns a list of strings.
     */
    private class GettingDuplicatesTask extends RecursiveTask<HashMap<String, Integer>> {

        private final List<String> words;

        public GettingDuplicatesTask(List<String> words) {
            this.words = new ArrayList<>();
            for (String word : words){
                this.words.add(word.toLowerCase());
            }
        }

        @Override
        protected HashMap<String, Integer> compute() {
            List<GettingDuplicatesTask> subTasks = new ArrayList<>();
            HashMap<String, Integer> duplicateWordsMap = new HashMap<>();

            if (words.size() > THRESHOLD){
                int middle = (words.size()/2);
                final GettingDuplicatesTask task1 = new GettingDuplicatesTask(words.subList(0, middle));
                final GettingDuplicatesTask task2 = new GettingDuplicatesTask(words.subList(middle, words.size()));
                task1.fork();
                task2.fork();
            }
            else {
                for (String word : words){
                    if (duplicateWordsMap.containsKey(word)){
                        duplicateWordsMap.put(word, duplicateWordsMap.get(word)+1);
                    } else {
                        duplicateWordsMap.put(word, 1);
                    }
                }
            }

            for(GettingDuplicatesTask task : subTasks) {
                final HashMap<String, Integer> joinList = task.join();
                for (Map.Entry<String, Integer> map : joinList.entrySet()){
                    if (duplicateWordsMap.containsKey(map.getKey())){
                        int valueCounter = duplicateWordsMap.get(map.getKey());
                        duplicateWordsMap.put(map.getKey(), valueCounter);
                    }
                    else{
                        duplicateWordsMap.put(map.getKey(), map.getValue());
                    }
                }
            }

            return duplicateWordsMap;
        }
    }
}
