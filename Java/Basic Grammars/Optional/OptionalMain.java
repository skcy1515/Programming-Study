package optional;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        // 값이 있는 경우 Optional.of
        String str = "Hello, World!";
        Optional<String> optionalStr = Optional.of(str);
        System.out.println(optionalStr.get());

        // 값이 있을 수도, 없을 수도 있는 경우 Optional.ofNullable
        String nullStr = "hello";
        Optional<String> optionalNullStr = Optional.ofNullable(nullStr);
        if (optionalNullStr.isPresent()) { // 값이 있는지 확인
            System.out.println(optionalNullStr.get());
        } else {
            System.out.println(optionalNullStr); // null이면 Optional.empty 반횐
        }
    }
}
