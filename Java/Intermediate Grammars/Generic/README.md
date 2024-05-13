# 제네릭
다형성을 활용한 덕분에 코드의 중복을 제거하고, 기존 코드를 재사용할 수 있게 되었다. 하지만 입력할 때 실수로 원하지 않는 타입이 들어갈 수 있는 타입 안전성 문제가 발생한다. 예를 들어서 integerBox 에는 숫자만 넣어야 하고,
stringBox 에는 문자열만 입력할 수 있어야 한다. 

```
 ObjectBox integerBox = new ObjectBox();
 integerBox.set(10);
 Integer integer = (Integer) integerBox.get(); //Object -> Integer 다운 캐스팅
 System.out.println("integer = " + integer);

 ObjectBox stringBox = new ObjectBox();
 stringBox.set("hello");
 String str = (String) stringBox.get(); //Object -> String 다운 캐스팅
 System.out.println("str = " + str);

 //잘못된 타입의 인수 전달시
 integerBox.set("문자100");
 Integer result = (Integer) integerBox.get(); // String -> Integer 캐스팅 예외, 오류
```
또한 박스에 값을 보관하는 set() 의 매개변수가 Object 이기 때문에 다른 타입의 값을 입력할 수 있다. (입력은 받지만 값을 꺼낼 때 문제 발생) 그리고 반환 시점에도 Object 를 반환하기 때문에 원하는 타입을 정확하게 받을 수 없고, 항상 위험한 다운 캐스팅을 시도해야한다. 결과적으로 이 방식은 타입 안전성이 떨어진다.

제네릭을 사용하면 코드 재사용과 타입 안전성이라는 두 마리 토끼를 한 번에 잡을 수 있다.


