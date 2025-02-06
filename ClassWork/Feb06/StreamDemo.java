import java.util.*;
import java.util.stream.*;
import java.util.function.*;
public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12,321,41,5114,746,731,725,672,8764,871,6437,9063,983);
        System.out.println("Original List: " + numbers);
        Predicate <Integer> isEven = n -> n % 2 == 0;


        Stream <Integer> s = numbers.stream();
        Stream<Integer> evenStream = s.filter(isEven);
        List <Integer> evenNumbers = evenStream.collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        List <Integer> oddNumbers = numbers.stream().filter(isEven.negate()).collect(Collectors.toList());
        System.out.println("Odd numbers: " + oddNumbers);

        List<Integer> doubleNumbers = numbers.stream().map(n -> n + n).collect(Collectors.toList());
        System.out.println("Doubled numbers: " + doubleNumbers);

        // Sort 
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted numbers: " + sortedNumbers);

        // Limit 5 after sorting
        List<Integer> sortedNumbersLimit = numbers.stream().sorted().limit(5).collect(Collectors.toList());
        System.out.println("Sorted numbers limit 5: " + sortedNumbersLimit);

        // Skip 2 and then sort
        List<Integer> sortedNumbersSkip = numbers.stream().skip(2).sorted().collect(Collectors.toList());
        System.out.println("Sorted numbers skip 2: " + sortedNumbersSkip);

        // Sort and then skip 2 and then limit 5
        List<Integer> sortedNumberSkipList = numbers.stream().sorted().skip(2).limit(5).collect(Collectors.toList());
        System.out.println("First Sorted then 2 skipped and limited to 5" + sortedNumberSkipList);


        Random random = new Random();
        random.ints(5, 0, 2).forEach(System.out :: println);
        random.ints().map(x -> Math.abs(x)).limit(5).forEach( System.out :: println);

        // IntStream.range(start, end) --> end is exclusive
        IntStream is2 = IntStream.range(1, 10);
        is2.forEach(System.out::println);

        // IntStream.rangeClosed(start, end) --> end is inclusive
        IntStream is = IntStream.rangeClosed(1, 10);
        is.forEach(System.out::println);

        // sum of numbers from 1 to 10
        OptionalInt result = IntStream.range(1, 6).reduce((a,b) -> a + b);
        System.out.println(" Sum of numbers from 1 to 5: " + result.getAsInt());

        int res1 = Stream.of(1, 2,3,4,5).reduce(10, (a,b) -> a + b);
        System.out.println("Sum of numbers from 1 to 5: " + res1);

        int res2 = Arrays.asList(1,2,3).parallelStream().reduce(10, (a,b) -> a + b, (c,d) -> c + d);

        // 10 + 1 --> 11
        // 10 + 2 --> 12
        // 10 + 3 --> 13

        // 11 + 12 --> 23
        // 23 + 13 --> 36
        System.out.println("Sum of numbers from 1 to 3: " + res2);

        IntSummaryStatistics statistics = IntStream.rangeClosed(1, 10).summaryStatistics();
        System.out.println("Stats: " + statistics);
        System.out.println("Count: " + statistics.getCount());
        System.out.println("Sum: " + statistics.getSum());
        System.out.println("Min: " + statistics.getMin());
        System.out.println("Average: " + statistics.getAverage());
        System.out.println("Max: " + statistics.getMax());
    }
}
