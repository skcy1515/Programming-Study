# 추상화
```
public abstract class AbstractAnimal {
    public abstract void sound();

    public void move() {
        System.out.println("동물이 움직입니다.");
    }
}
```
동물( Animal )과 같이 부모 클래스는 제공하지만, 실제 생성되면 안되는 클래스를 추상 클래스라 한다.

추상 클래스는 이름 그대로 추상적인 개념을 제공하는 클래스이다. 따라서 실체인 인스턴스가 존재하지 않는다. 

대신에 상속을 목적으로 사용되고, 부모 클래스 역할을 담당한다.

추상 클래스는 클래스를 선언할 때 앞에 추상이라는 의미의 abstract 키워드를 붙여주면 된다.
```
//추상클래스 생성 불가
//AbstractAnimal animal = new AbstractAnimal();
```
추상 클래스는 기존 클래스와 완전히 같다. 다만 new AbstractAnimal() 와 같이 직접 인스턴스를 생성하지 못한다.

# 추상 메서드
```
public abstract void sound();
```
부모 클래스를 상속 받는 자식 클래스가 반드시 오버라이딩 해야 하는 메서드를 부모 클래스에 정의할 수 있다. 

이것을 추상 메서드라 한다. 추상 메서드는 이름 그대로 추상적인 개념을 제공하는 메서드이다. 

따라서 실체가 존재하지 않고, 메서드 바디가 없다. 

추상 메서드는 상속 받는 자식 클래스가 반드시 오버라이딩 해서 사용해야 한다.

추상 메서드는 선언할 때 메서드 앞에 추상이라는 의미의 abstract 키워드를 붙여주면 된다.

추상 메서드가 하나라도 있는 클래스는 추상 클래스로 선언해야 한다.

```
// AbstractAnimal.java
public abstract class AbstractAnimal {
    public abstract void sound();

    public void move() {
        System.out.println("동물이 움직입니다.");
    }
}

// Dog.java
public class Dog extends AbstractAnimal{
    @Override
    public void sound(){
        System.out.println("멍멍");
    }
}

// Cat.java
public class Cat extends AbstractAnimal{
    @Override
    public void sound() {
        System.out.println("냐옹");
    }
}

// AbstractMain.java
public class AbstractMain {
    public static void main(String[] args) {
        //추상클래스 생성 불가
        //AbstractAnimal animal = new AbstractAnimal();
        Dog dog = new Dog();
        Cat cat = new Cat();

        cat.sound();
        cat.move();

        soundAnimal(cat);
        soundAnimal(dog);
    }
    //동물이 추가 되어도 변하지 않는 코드
    private static void soundAnimal(AbstractAnimal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
```
추상 메서드의 장점

1. 추상 메서드는 반드시 오버라이딩 해야 한다.

2. 추상 클래스 덕분에 실수로 Animal 인스턴스를 생성할 문제를 근본적으로 방지해준다.

3. 추상 메서드 덕분에 새로운 동물의 자식 클래스를 만들때 실수로 sound() 를 오버라이딩 하지 않을 문제를 근본적으로 방지해준다.

# 인터페이스
자바는 순수 추상 클래스를 더 편리하게 사용할 수 있는 인터페이스라는 기능을 제공한다
```
// InterfaceAnimal.java
public interface InterfaceAnimal {
    void sound();
    void move();
}

// InterfaceCat.java
public class InterfaceCat implements InterfaceAnimal{
    @Override
    public void sound() {
        System.out.println("냐옹");
    }
    @Override
    public void move() {
        System.out.println("고양이 이동");
    }
}

// InterfaceDog.java
public class InterfaceDog implements InterfaceAnimal{
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
    @Override
    public void move() {
        System.out.println("개 이동");
    }
}
```
인터페이스를 사용해야 하는 이유

1. 제약: 인터페이스를 만드는 이유는 인터페이스를 구현하는 곳에서 인터페이스의 메서드를 반드시 구현하라는
규약(제약)을 주는 것이다. 순수 추상 클래스의 경우 미래에 누군가 그곳에 실행 가능한 메서드를 끼워 넣을 수 있다.
이렇게 되면 추가된 기능을 자식 클래스에서 구현하지 않을 수도 있고, 또 더는 순수 추상 클래스가 아니게 된다. 인터페이스는 모든 메서드가 추상 메서드이다.
따라서 이런 문제를 원천 차단할 수 있다.

3. 다중 구현: 자바에서 클래스 상속은 부모를 하나만 지정할 수 있다. 반면에 인터페이스는 부모를 여러명 두는 다중
구현(다중 상속)이 가능하다

다중 상속 예시
```
// InterfaceA.java
public interface InterfaceA {
    void methodA();
    void methodCommon();
}

// InterfaceB.java
public interface InterfaceB {
    void methodB();
    void methodCommon();
}

// InterfaceChild.java
public class InterfaceChild implements InterfaceA, InterfaceB{
    @Override
    public void methodA() {
        System.out.println("Child.methodA");
    }
    @Override
    public void methodB() {
        System.out.println("Child.methodB");
    }
    @Override
    public void methodCommon() {
        System.out.println("Child.methodCommon");
    }
}

// DiamondMain
public class DiamondMain {
    public static void main(String[] args) {
        InterfaceA a = new InterfaceChild();
        a.methodA();
        a.methodCommon();

        InterfaceB b = new InterfaceChild();
        b.methodB();
        b.methodCommon();
    }
}
```

