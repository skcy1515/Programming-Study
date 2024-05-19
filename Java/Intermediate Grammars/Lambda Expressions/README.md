# 람다 표현식 (Lambda Expressions)
람다 표현식은 익명 함수(anonymous function)를 생성하기 위한 간결한 방법이다. 이를 통해 불필요한 코드를 줄이고 함수형 프로그래밍 스타일을 사용할 수 있다.

### 기본 문법
```
(parameters) -> expression
```

### 예제
```
        List<String> list = Arrays.asList("apple", "banana", "cherry");

        // 전통적인 for 루프를 사용한 예제
        for (String item : list) {
            System.out.println(item);
        }

        // 람다 표현식을 사용한 예제
        list.forEach(item -> System.out.println(item));
```
위 예제에서 item -> System.out.println(item)은 item을 인자로 받아 System.out.println(item)을 실행하는 람다 표현식이다.

# 메소드 참조 (Method References)
메소드 참조는 기존 메소드나 생성자를 참조하기 위한 더 간결한 방법이다. 이는 람다 표현식의 축약형으로 볼 수 있다.

### 기본 문법
- ClassName::staticMethodName
- instance::instanceMethodName
- ClassName::new (생성자 참조)

### 예제
```
        List<String> list = Arrays.asList("apple", "banana", "cherry");

        // 메소드 참조를 사용한 예제
        list.forEach(System.out::println);
```
여기서 System.out::println은 System.out.println 메소드를 참조하는 메소드 참조이다. 이는 item -> System.out.println(item)과 동일하게 작동한다.
