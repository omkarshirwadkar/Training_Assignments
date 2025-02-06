import java.text.CollationElementIterator;
import java.util.*;
import java.util.stream.*;

public class StreamDemo2 {
    public static void main(String[] args) {
        Map <Integer, String> map = new HashMap<Integer, String>();
        map.put(11, "Anil");
        map.put(22, "Rahul");
        map.put(33, "Sahil");
        map.put(44, "Berry");
        map.put(55, "Dhruv");

        map.entrySet().stream().map(Map.Entry :: getKey).forEach(System.out :: println);
        map.entrySet().stream().map(Map.Entry :: getValue).forEach(System.out :: println);
        System.out.println("---------------------------");

        // can add .map(Map.Entry :: getKey) before forEach to print only keys
        map.entrySet().stream().filter(me -> me.getKey() > 30).forEach(System.out :: println);
        System.out.println("-------------------------------------------------");

        List<Integer> l1 = Arrays.asList(1,2,3);
        // List<Integer> l2 = Arrays.asList(4,5,6,7);
        Set <Integer> s1 = new HashSet<>();
        s1.add(4);
        s1.add(5);
        s1.add(6);
        s1.add(7);
        List<Integer> l3 = Arrays.asList(8,9,10);

        // List<List<Integer>> list = Arrays.asList(l1,l2,l3);
        List<Collection<Integer>> list = Arrays.asList(l1,s1,l3);
        System.out.println(list);
        
        
        // flatMap(List :: stream) or flatMap(lst -> lst.stream()) both works 
        List<Integer> res1 = list.stream().flatMap(lst -> lst.stream()).map(x -> x + x).collect(Collectors.toList());
        System.out.println(res1);
    }    
}
