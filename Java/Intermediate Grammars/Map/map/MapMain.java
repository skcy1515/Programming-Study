package map;

import java.util.HashMap;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("apple", 10);
        map.put("banana", 5);
        map.put("orange", 7);

        map.remove("orange");

        System.out.println(map.containsKey("orange")); // false 출력

        System.out.println(map); // {banana=5, apple=10}

        System.out.println(map.size()); // 요소 개수 출력, 2

        int appleCount = map.get("apple");
        System.out.println(appleCount); // 10

        System.out.println(map.keySet()); // [banana, apple]
    }
}
