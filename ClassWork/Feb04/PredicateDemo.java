import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Predicate<Integer> p1 = (arg) -> arg % 2 == 0;
        Predicate<Integer> p2 = (arg) -> arg > 5;
        process(arr, p1);
        process(arr, p1.negate());
        process(arr, p2);
        process(arr, p2.negate());
        process(arr, p1.and(p2));
        process(arr, p1.negate().and(p2.negate()));
        process(arr, p1.negate().or(p2));
        evenNumbers(arr);
        oddNumbers(arr);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.forEach((Integer arg) -> System.out.println(arg));
    }

    public static void process(int[] arr, Predicate<Integer> p1) {
        for (int i : arr) {
            if (p1.test(i))
                System.out.println(i);
        }
        System.out.println("-----------------------------");
    }

    public static void evenNumbers(int[] arr) {
        for (int i : arr) {
            if (i % 2 == 0)
                System.out.println(i);
        }
        System.out.println("-----------------------------");
    }

    public static void oddNumbers(int[] arr) {
        for (int i : arr) {
            if (i % 2 != 0)
                System.out.println(i);
        }
        System.out.println("-----------------------------");
    }
}