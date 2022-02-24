package Day2;

import java.util.*;

public class TreeMapSet {
    public static void main(String[] args) {
        Set<MSNode> ts = new TreeSet<>(new MyComparator());
        ts.add(new MSNode(1));
        ts.add(new MSNode(2));
        System.out.println(ts.size());
    }
}

//method 2
class MyComparator implements Comparator<MSNode> {
    @Override
    public int compare(MSNode o1, MSNode o2) {
        return o1.key - o2.key;
    }
}

class MSNode implements Comparable<MSNode>{
    int key;
    MSNode(int key) {
        this.key = key;
    }

    // method 1
    @Override
    public int compareTo(MSNode o) {
        return this.key - o.key;
    }
}
