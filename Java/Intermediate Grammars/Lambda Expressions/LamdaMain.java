package lamda;

import java.util.Arrays;
import java.util.List;

public class LamdaMain {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");

        // 전통적인 for 루프를 사용한 예제
        for (String item : list) {
            System.out.println(item);
        }

        // 람다 표현식을 사용한 예제
        list.forEach(item -> System.out.println(item));

        // 메소드 참조를 사용한 예제
        list.forEach(System.out::println);
    }
}
