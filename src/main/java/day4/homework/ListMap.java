package day4.homework;

import java.util.*;

public class ListMap {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(10);
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "10");
        List<Integer> result = new ArrayList<>();
        result = inListNotInMap(list, map);
        System.out.println(result.toString());
    }

    public static List<Integer> inListNotInMap(List list, Map map) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Integer cur = (Integer) list.get(i);
            if (!map.containsValue(cur.toString())) {
                result.add((Integer) list.get(i));
            }
        }
        return result;
    }
}
