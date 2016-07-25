Project to play around with java 8, lambda expression

Concept inside the java.util.stream.Collectors:
* GroupingBy collector is used for grouping objects by some property and storing results in a Map instance
* PartitioningBy is a specialized case of groupingBy that accepts a Predicate instance and collects Stream elements into a Map instance that stores Boolean values as keys and collections as values. Under the “true” key, you can find a collection of elements matching the given Predicate and under the “false” key, you can find a collection of elements not matching the given Predicate.
* 

