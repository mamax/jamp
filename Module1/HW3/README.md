# Home Work #3
    Implement simple interface, using Java 7 and Java 8 approaches. 
    
    Home task in details
    In attachments you may see ‘task.zip’ archive. Unzip it and you will find a simple Java application inside. 
    Your main goal is to implement Aggregator interface. There are already four classes implementing the interface, but all their methods throw UnsupportedOperationException:
    
    1.	Java7Aggregator – should use Java 7 approach to solve the problem (no packages from Java 8)
    2.	Java8Aggregator – should use Java 8 Stream API to solve the problem
    3.	Java8ParallelAggregator – should use parallel streams from Java 8 Stream API to solve the problem
    4.	Java7ParallelAggregator -  use Java 7 approach to do parallel tasks (e.g. you may use fork/join framework) to solve the problem
 
##Steps :
1. Import existing sources - empty skeleton into new module.
2. Implemented Java7 Aggregator{Aggregator, Java7Aggregator, UtilsAggregator}.
3. Implemented Java8Aggregator, Added PAIRS_COMPARATOR{Java8Aggregator, }.
4. Implemented Java7ParallelAggregator, added STRINGS_COMPARATOR.
5. Implemented methods with Java8ParallelAggregator.
6. Added performance unit tests.
7. Added aggregator unit tests.

##How to run tests

- Use 'com.epam.cdp.m2.hw2.aggregator.suits' package to run test by implementation;
- Use classes inside 'com.epam.cdp.m2.hw2.aggregator.[sum|duplicates|frequency].impl' package to test each separate method of each separate implementation.

- Use 'com.epam.cdp.m2.hw2.performance.suits' package to run performance test by implementation;
- Use classes inside 'com.epam.cdp.m2.hw2.performance.[sum|duplicates|frequency].impl' package to performance test each separate method of each separate implementation.

 author : `maksym_mazurkevych@epam.com`