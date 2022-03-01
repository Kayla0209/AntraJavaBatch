package day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinalKeyword {
    public static void main(String[] args) {
        final int a = 2;
        //a = 3; // compile error

        final List<Integer> list = new ArrayList<>();
        list.add(3); // you can modify the content, but you cannot reassign the reference
        //list = new ArrayList<>(); // compile error, cannot reassign the reference
    }


}

class A {
    final void method() { // cannot override the method
        System.out.println("134");
    }
}

class B extends A {
/*    @Override
    void method() { // compile error, cannot be overriden

    }*/
}

/*final class C {} // final class cannot be extended
class D extends C {} // error*/


// Immutable class
final class ImmuClass { // 1. final class
    private final int id; //2. private final fields
    private final String name;
    private final Map<Integer, Integer> map;

    ImmuClass(int id, String name) {
        this.id = id;
        this.name = name;
        map = new HashMap<>();
    }

    // 3. No setter method

    // but can have getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // 4. return deep copy of the collections for getter
    public Map<Integer, Integer> getMap() {
        Map<Integer, Integer> newMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            newMap.put(entry.getKey(), entry.getValue());
        }
        return newMap;
    }
}