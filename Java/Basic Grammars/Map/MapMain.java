package map;

import java.util.HashMap;

public class MapMain {
    public static void main(String[] args) {
        java.util.Map<String, Integer> map = new HashMap<>();

        map.put("apple", 10);
        map.put("banana", 5);
        map.put("orange", 7);

        map.remove("orange");

        System.out.println(map.containsKey("orange")); // false 출력

        System.out.println(map);

        System.out.println(map.size()); // 요소 개수 출력

        Integer appleCount = map.get("apple");
        System.out.println(appleCount);
    }
}
