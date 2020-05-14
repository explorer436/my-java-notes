package collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectExamples {

	public static void main(String[] args) {
		
		List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
	    System.out.println("original list: " + numbers);	    
		System.out.print("Filter for even numbers : ");
		List<Integer> result = returnEvenNumbersFromAList_Collect(numbers);		
		System.out.println(Arrays.toString(result.toArray()));
		
		System.out.println();
		
		List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
		
		System.out.println("givenList converted to List : " + Arrays.toString(collectToList(givenList).toArray()));
		
		System.out.println();
		
		System.out.println("givenList converted to Set : " + Arrays.toString(collectToSet(givenList).toArray()));
		
		System.out.println();
		
		System.out.println("givenList converted to LinkedList : " + Arrays.toString(collectToLinkedList(givenList).toArray()));
		
		System.out.println();
		
		System.out.println("givenList converted to Map : " + collectToMap(givenList));
		
		System.out.println();
		
		System.out.println("result of joining : " + collectAndJoin(givenList));
		
		System.out.println();
		
		System.out.println("result of joining with custom separators : " + collectAndJoinUsingCustomSeparators(givenList));
		
		System.out.println();
		
		System.out.println("result of joining with pre and post : " + collectAndJoinWithPreAndPost(givenList));
		
		System.out.println();
		
		System.out.println("result of collect and count : " + collectAndCount(givenList));
		
		System.out.println();
		
		DoubleSummaryStatistics summaryStatistics = collectAndSummarize(givenList);
		System.out.println("result of collect and summarize - average : " + summaryStatistics.getAverage());
		System.out.println("result of collect and summarize - count : " + summaryStatistics.getCount());
		System.out.println("result of collect and summarize - max : " + summaryStatistics.getMax());
		System.out.println("result of collect and summarize - min : " + summaryStatistics.getMin());
		System.out.println("result of collect and summarize - sum : " + summaryStatistics.getSum());
		
		System.out.println();
		
		System.out.println("result of collect and average double : " + collectAndAveragingDouble(givenList));
		
		System.out.println();
		
		System.out.println("result of collect and summing double : " + collectAndSummingDouble(givenList));
		
		System.out.println();
		
		Optional<String> maxBy = collectAndMaxBy(givenList);
		if (maxBy.isPresent())
		{
			System.out.println("result of collect and max by : " + maxBy.toString());
		}
		
		System.out.println();
		
		Optional<String> minBy = collectAndMinBy(givenList);
		if (minBy.isPresent())
		{
			System.out.println("result of collect and max by : " + minBy.toString());
		}
		
		System.out.println();
		
		Map<Integer, Set<String>> stringLengthsGroupedByLength = storeStringLengthGroupingResulsInASet(givenList);
		MapUtils.printMap(stringLengthsGroupedByLength);
		
		System.out.println();
		
		Map<Boolean, List<String>> partitionByStringLength = partitionByStringLength(givenList);
		System.out.println("partitionByStringLength : ");
		MapUtils.printMap(partitionByStringLength);
		
		
		
	}
	
	/**
	 * Return only even numbers
	 */
	private static List<Integer> returnEvenNumbersFromAList_Collect(List<String> numbers)
	{
		List<Integer> even = numbers.stream()
                .map(s -> Integer.valueOf(s))
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
		
		return even;
	}
	
	/**
	 * ToList collector can be used for collecting all Stream elements into a List instance. 
	 * The important thing to remember is the fact that we can't assume any particular List implementation with this method. 
	 * If you want to have more control over this, use toCollection instead.
	 * 
	 */
	private static List collectToList(List<String> givenList)
	{
		List<String> result = givenList.stream().collect(Collectors.toList());
		
		return result;
		
	}
	
	/**
	 * ToSet collector can be used for collecting all Stream elements into a Set instance. 
	 * The important thing to remember is the fact that we can't assume any particular Set implementation with this method. 
	 * If we want to have more control over this, we can use toCollection instead.
	 * 
	 */
	private static Set collectToSet(List<String> givenList)
	{
		Set<String> result = givenList.stream().collect(Collectors.toSet());
		
		return result;
		
	}
	
	/**
	 * As you probably already noticed, when using toSet and toList collectors, you can't make any assumptions of their implementations. 
	 * If you want to use a custom implementation, you will need to use the toCollection collector with a provided collection of your choice.
	 * 
	 */
	private static List<String> collectToLinkedList(List<String> givenList)
	{
		List<String> result = givenList.stream()
				  .collect(Collectors.toCollection(LinkedList::new));
		
		return result;
		
	}
	
	/**
	 * ToMap collector can be used to collect Stream elements into a Map instance. To do this, we need to provide two functions:
	 * 
	 * 1. keyMapper
	 * 2. valueMapper
	 * 
	 * keyMapper will be used for extracting a Map key from a Stream element, and valueMapper will be used for extracting a value associated with a given key.
	 * 
	 * Let's collect those elements into a Map that stores strings as keys and their lengths as values.
	 * 
	 * Function.identity() is just a shortcut for defining a function that accepts and returns the same value.
	 * 
	 * What happens if our collection contains duplicate elements?
	 * If it sees duplicate keys, it immediately throws an IllegalStateException.
	 * 
	 */
	private static Map<String, Integer> collectToMap(List<String> givenList)
	{
		/* Map<String, Integer> result = givenList.stream()
				  .collect(Collectors.toMap(Function.identity(), String::length));*/
		
		/**
		 * For cases with key collision, we should use toMap with another signature.
		 * 
		 * The third argument here is a BinaryOperator, where we can specify how we want collisions to be handled.
		 * 
		 * In this example, we'll just pick any of these two colliding values because we know that the same strings will always have the same lengths, too.
		 */
		Map<String, Integer> result = givenList.stream()
				  .collect(Collectors.toMap(Function.identity(), String::length, (item, identicalItem) -> item));
		
		return result;
		
	}
	
	/**
	 * CollectingAndThen is a special collector that allows performing another action on a result straight after collecting ends.
	 */
	/*private static void collectingAndThen(List<String> givenList)
	{
		// Let's collect Stream elements to a List instance and then convert the result into an ImmutableList instance.
		List<String> result = givenList.stream()
				  .collect(collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
	}*/
	
	/**
	 * Joining collector can be used for joining Stream<String> elements.
	 */
	private static String collectAndJoin(List<String> givenList)
	{
		String result = givenList.stream()
				  .collect(Collectors.joining());
		
		return result;
	}
	
	private static String collectAndJoinUsingCustomSeparators(List<String> givenList)
	{
		String result = givenList.stream()
				  .collect(Collectors.joining(" "));
		
		return result;
	}
	
	private static String collectAndJoinWithPreAndPost(List<String> givenList)
	{
		String result = givenList.stream()
				  .collect(Collectors.joining(" ", "PRE-", "-POST"));
		
		return result;
	}
	
	/**
	 * Counting is a simple collector that allows simply counting of all Stream elements.
	 */
	private static Long collectAndCount(List<String> givenList)
	{
		Long result = givenList.stream()
				  .collect(Collectors.counting());
		
		return result;
	}
	
	/**
	 * SummarizingDouble/Long/Int is a collector that returns a special class containing statistical information about numerical data in a Stream of extracted elements.
	 */
	private static DoubleSummaryStatistics collectAndSummarize(List<String> givenList)
	{
		// We can obtain information about string lengths by doing
		DoubleSummaryStatistics result = givenList.stream()
				  .collect(Collectors.summarizingDouble(String::length));
		
		return result;
	}
	
	/**
	 * AveragingDouble/Long/Int is a collector that simply returns an average of extracted elements.
	 */
	private static Double collectAndAveragingDouble(List<String> givenList)
	{
		// We can get average string length by doing
		Double result = givenList.stream()
				  .collect(Collectors.averagingDouble(String::length));
		
		return result;
	}
	
	/**
	 * SummingDouble/Long/Int is a collector that simply returns a sum of extracted elements.
	 */
	private static Double collectAndSummingDouble(List<String> givenList)
	{
		// We can get a sum of all string lengths by doing
		Double result = givenList.stream()
				  .collect(Collectors.summingDouble(String::length));
		
		return result;
	}
	
	/**
	 * MaxBy/MinBy collectors return the biggest/the smallest element of a Stream according to a provided Comparator instance.
	 */
	private static Optional<String> collectAndMaxBy(List<String> givenList)
	{
		// We can pick the biggest element by doing
		Optional<String> result = givenList.stream()
				  .collect(Collectors.maxBy(Comparator.naturalOrder()));
		
		// Notice that returned value is wrapped in an Optional instance. This forces users to rethink the empty collection corner case.
		
		return result;
	}
	
	private static Optional<String> collectAndMinBy(List<String> givenList)
	{
		// We can pick the biggest element by doing
		Optional<String> result = givenList.stream()
				  .collect(Collectors.minBy(Comparator.naturalOrder()));
		
		// Notice that returned value is wrapped in an Optional instance. This forces users to rethink the empty collection corner case.
		
		return result;
	}
	
	/**
	 * GroupingBy collector is used for grouping objects by some property and storing results in a Map instance.
	 * 
	 */
	private static Map<Integer, Set<String>> storeStringLengthGroupingResulsInASet(List<String> givenList)
	{
		// We can group them by string length and store grouping results in Set instances
		
		// Notice that the second argument of the groupingBy method is a Collector and you are free to use any Collector of your choice.
		Map<Integer, Set<String>> result = givenList.stream()
				  .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
		
		return result;
	}
	
	/**
	 * PartitioningBy is a specialized case of groupingBy that accepts a Predicate instance and 
	 * collects Stream elements into a Map instance that stores Boolean values as keys and collections as values. 
	 * Under the “true” key, you can find a collection of elements matching the given Predicate, 
	 * and under the “false” key, you can find a collection of elements not matching the given Predicate.
	 * @return 
	 * 
	 */
	
	private static Map<Boolean, List<String>> partitionByStringLength(List<String> givenList)
	{
		Map<Boolean, List<String>> result = givenList.stream()
				  .collect(Collectors.partitioningBy(s -> s.length() > 2));
		
		return result;
	}

}
