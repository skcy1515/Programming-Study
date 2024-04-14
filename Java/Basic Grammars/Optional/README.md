# Optional
Java8에서는 Optional<T> 클래스를 사용해 NPE(NullPointerException)를 방지할 수 있도록 도와준다. 

Optional 객체를 생성하려면, of(), ofNullable() 등의 정적 팩토리 메서드를 사용할 수 있다.
- of() 메서드 : 값이 null이 아닌 경우에만 Optional 객체를 생성 (만약 null이면 오류)
- ofNullable() 메서드 : 값이 null인 경우에도 Optional 객체를 생성. 명시된 값이 null이 아니면 명시된 값을 가지는 Optional 객체를 반환하며, 명시된 값이 null이면 비어있는 Optional 객체를 반환함.

### Optional 객체에 접근
get() 메소드를 사용하면 Optional 객체에 저장된 값에 접근할 수 있다. 만약 Optional 객체에 저장된 값이 null이면, NoSuchElementException 예외가 발생한다. 따라서 get() 메소드를 호출하기 전에 isPresent() 메소드를 사용하여 Optional 객체에 저장된 값이 null인지 아닌지를 먼저 확인한 후 호출하는 것이 좋다.

[OptionalMain]
```
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
```
실행 결과
```
Hello, World!
hello
```
