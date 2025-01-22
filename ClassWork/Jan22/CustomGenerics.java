// package ClassWork.Jan22;


import java.lang.Math;
// <T> - generic type
class GenericClass <T> {
    public void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public void add(T a, T b) {
        System.out.println("Adding " + a + " and " + b);
    }
}

// generic class with more than one type parameter
// class GenericClass2 <T, K> {
//     public K getCircleArea(T radius) {
//         return (K) (int) (Math.PI * radius * radius);
//     }
// }
public class CustomGenerics {
    public static void main(String[] args) {
        GenericClass< Integer > genericClass1 = new GenericClass<>();
        Integer[] array = {1, 2, 3, 4, 5};
        genericClass1.printArray(array);
        genericClass1.add(10, 20);

        GenericClass <String> genericClass2 = new GenericClass<>();
        String[] array2 = {"apple", "banana", "cherry"};
        genericClass2.printArray(array2);
        genericClass2.add("Hello", "World");

        GenericClass <Character> genericClass3 = new GenericClass<>();
        Character[] array3 = {'a', 'b', 'c', 'd', 'e'};
        genericClass3.printArray(array3);
        genericClass3.add('A', 'B');

    }
}
