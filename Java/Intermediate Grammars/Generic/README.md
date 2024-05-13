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

```
package generic.ex1;

public class GenericBox<T>{
    private T value;

    public void set(T value) {
        this.value = value;
    }
    
    public T get() {
        return value;
    }
}
```
- <> 를 사용한 클래스를 제네릭 클래스라 한다. 이 기호( <> )를 보통 다이아몬드라 한다.
- 제네릭 클래스를 사용할 때는 Integer , String 같은 타입을 미리 결정하지 않는다.
- 대신에 클래스명 오른쪽에 <T> 와 같이 선언하면 제네릭 클래스가 된다. 여기서 T 를 타입 매개변수라 한다. 이 타입 매개변수는 이후에 Integer , String 으로 변할 수 있다.
- 그리고 클래스 내부에 T 타입이 필요한 곳에 T value 와 같이 타입 매개변수를 적어두면 된다.

```
package generic.ex1;

public class main {
    public static void main(String[] args) {
        //원하는 모든 타입 사용 가능
        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.set("안녕");
        String stringValue = stringBox.get();
        System.out.println("stringValue = " + stringValue);

        GenericBox<Double> doubleBox = new GenericBox<Double>();
        doubleBox.set(10.5);
        Double doubleValue = doubleBox.get();
        System.out.println("doubleValue = " + doubleValue);

        //타입 추론: 생성하는 제네릭 타입 생략 가능
        GenericBox<Integer> integerBox2 = new GenericBox<>();
    }
}
```
실행 결과
```
stringValue = 안녕
doubleValue = 10.5
```
제네릭의 핵심은 사용할 타입을 미리 결정하지 않는다는 점이다. 클래스 내부에서 사용하는 타입을 클래스를 정의하는 시점에 결정하는 것이 아니라 실제 사용하는 생성 시점에 타입을 결정하는 것이다.

### 제네릭 활용 예제 (객체를 보관할 수 있는 제네릭 클래스)
```
package generic.animal;

public class Animal {
    private String name;
    private int size;

    public Animal(String name, int size) {
        this.name = name;
        this.size = size;
    }
    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void sound() {
        System.out.println("동물 울음 소리");
    }

    @Override
    public String toString() { // 객체를 문자열로 반환
        return "동물{" + "이름= " + name + ", 크기= " + size + "}";
    }
}

public class Cat extends Animal{
    public Cat(String name, int size) {
        super(name, size);
    }

    @Override
    public void sound() {
        System.out.println("냐옹");
    }
}

public class Dog extends Animal{
    public Dog(String name, int size) {
        super(name, size);
    }

    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}

package generic.ex2;

public class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class main {
    public static void main(String[] args) {
        Animal animal = new Animal("동물", 0);
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 60);

        Box<Dog> dogBox = new Box<>();
        dogBox.set(dog);
        System.out.println("findDog = " + dogBox.get());

        Box<Cat> catBox = new Box<>();
        catBox.set(cat);
        System.out.println("findCat = " + catBox.get());
    }
}
```
실행 결과
```
findDog = 동물{이름= 멍멍이, 크기= 100}
findCat = 동물{이름= 냐옹이, 크기= 60}
```
