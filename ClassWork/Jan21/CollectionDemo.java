import java.util.*;

public class CollectionDemo{
    public static void main(String[] args) {
        // Create a new ArrayList
        // List<String> list = new ArrayList<>();
        // list.add("Apple");
        // list.add("Banana");
        // list.add("Cherry");
        // list.add("Date");
        // list.add("Elderberry");
        // System.out.println("Original List: " + list);
        // System.out.println("Size of the list: " + list.size());
        // System.out.println("Is the list empty? " + list.isEmpty());
        // System.out.println("Is the list null? " + list == null);

        // Vector v1 = new Vector(2);
        // v1.add("Hello");
        // v1.add(1232);
        // v1.add(new Thread());
        // v1.add(new Date());

        // Enumeration e = v1.elements();
        // while (e.hasMoreElements()) {
        //     System.out.println(e.nextElement());
        // }
        // System.out.println("-----------------------------------");

        // HashSet s1 = new HashSet();
        // LinkedHashSet s1 = new LinkedHashSet();
        // TreeSet s1 = new TreeSet();

        // ArrayList s1 = new ArrayList();
        // LinkedList s1 = new LinkedList();

        // PriorityQueue s1 = new PriorityQueue();
        // ArrayDeque s1 = new ArrayDeque();

        // s1.add("Cherry");
        // s1.add("Date");
        // s1.add("Elderberry");
        // s1.add("Apple");
        // s1.add("Banana");
        // s1.add("Apple");

        // addFirst() and addLast() methods
        // s1.addFirst("First");
        // s1.addLast("Last");


        // Iterator i = s1.iterator();
        // while (i.hasNext()) {
        //     System.out.println(i.next());
        // }

        // Map does not extend Collection 
        // no add method here but put () and offer() methods are available
        // offer() 
        // Hashtable h1 = new Hashtable();
        // HashMap h1 = new HashMap();
        // TreeMap h1 = new TreeMap();
        LinkedHashMap h1 = new LinkedHashMap();

        h1.put("Key1", "Value1");
        h1.put("Key2", "Value2");
        h1.put("Key3", "Value3");
        h1.put("Key4", "Value4");
        h1.put(null, "Value4"); // Not Allowed in Hashtable and TreeMap but allowed in HashMap and LinkedHashMap
        h1.put("Key5", null); // Not allowed in Hashtable and TreeMap but allowed in HashMap and LinkedHashMap

        Set s = h1.entrySet();
        Iterator i = s.iterator();

        while (i.hasNext()) {
            Map.Entry entry = (Map.Entry) i.next();
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }
}