package Day4;

public class GenericsDemo {
    public static void main(String[] args) {
        Node node1 = new Node("Tom", 123); // key is String, value is int
        Node2 node2 = new Node2(11, 22); // key is int, value is int

        // we don't have to create classes for different types, instead, we use the generic class
        GenNode<Integer, Integer> node3 = new GenNode<>(123, 321); // key is integer, value is integer
        GenNode<Double, Boolean> node4 = new GenNode<>(2.3, true); // key is double, value is boolean

        int[] arr1 = new int[]{1, 2, 3};
        Integer[] arr2 = new Integer[]{1, 2, 4};
        //getFirstElement(arr1); // int is not object, cannot use the generic function
        getFirstElement(arr2); // Integer is object
    }

    // generic method
    public static <E> E getFirstElement(E[] arr) {
        return arr[0];
    }

    public static <E, U> E getFirstElement(E[] arr1, U[] arr2) {
        return arr1[0];
    }
}
class Node {
    String key;
    int value;

    public Node(String key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Node2 {
    int key;
    int value;

    public Node2(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

// ...............
class GenNode<K, V> {
    K key;
    V value;

    public GenNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}