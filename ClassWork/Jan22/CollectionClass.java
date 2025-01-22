import java.util.*;
public class CollectionClass {
    public static void main(String[] args) {
        List list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list. addAll(Arrays.asList("Fig", "Grape", "Honeydew"));
        list.add("Cherry");
        list.add("Date");
        list.add("Elderberry");
        System.out.println("List: " + list );

        Collections.reverse(list);
        System.out.println("Reversed List: " + list );

        Collections.sort(list);
        System.out.println("Sorted List: " + list);

        Collections.reverse(list);
        System.out.println("Reversed Sorted List: " + list );

        Collections.swap(list, 2, 5);
        System.out.println("Swapped 2nd and 5th element: " + list);

        Collections.shuffle(list);
        System.out.println("Shuffled List: " + list);

        int pos = Collections.binarySearch(list, "Apple");
        System.out.println("Binary Search Position: " + pos);


    }
}
