package list;

import java.util.*;

public class ListGenericsMain {
    public static void main(String[] args) {
        ArrayList<String> pitches = new ArrayList<>();  // 제네릭스를 사용한 표현

        pitches.add("138");
        pitches.add("129");
        pitches.add("142");

        System.out.println(pitches);  // [138, 129, 142] 출력

        String[] data = {"1381", "1291", "1421"};  // 이미 투구수 데이터 배열이 있다.

        ArrayList<String> pitches2 = new ArrayList<>(Arrays.asList(data)); // java.util.Arrays 클래스의 asList 메서드를 사용하면 이미 존재하는 문자열 배열로 ArrayList를 만들 수 있다.

        System.out.println(pitches2);  // [138, 129, 142] 출력

        Map<String, Integer> map = new HashMap<>(); // map 사용

        map.put("apple", 10);
        map.put("banana", 5);
        map.put("orange", 7);

        List<Integer> list = new ArrayList<>(map.values());
        System.out.println(list);
    }
}
