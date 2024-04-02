# 상속 
상속은 객체 지향 프로그래밍의 핵심 요소 중 하나로, 기존 클래스의 필드와 메서드를 새로운 클래스에서 재사용하게 해준다. 

상속을 사용하려면 extends 키워드를 사용하면 된다. 그리고 extends 대상은 하나만 선택할 수 있다.

`부모 클래스 (슈퍼 클래스)` : 상속을 통해 자신의 필드와 메서드를 다른 클래스에 제공하는 클래스
`자식 클래스 (서브 클래스)` : 부모 클래스로부터 필드와 메서드를 상속받는 클래스

# 상속과 메모리 구조
상속 관계를 객체로 생성할 때 메모리 구조를 확인해보자.

[CarMain](https://github.com/skcy1515/Programming-Study/blob/main/Java/Basic%20Grammars/Inheritance/CarMain.java)
```
GasCar gasCar = new GasCar();
```
new GasCar() 를 호출하면 GasCar 뿐만 아니라 상속 관계에 있는 Car 까지 함께 포함해서 인스턴스를 생성한다. 

참조값은 x001 로 하나이지만 실제로 그 안에서는 Car , GasCar 라는 두가지 클래스 정보가 공존하는 것이다.

상속이라고 해서 단순하게 부모의 필드와 메서드만 물려 받는게 아니다. 상속 관계를 사용하면 부모 클래스도 함께 포함해서 생성된다. 

외부에서 볼때는 하나의 인스턴스를 생성하는 것 같지만 내부에서는 부모와 자식이 모두 생성되고 공간도 구분된다.
```
gasCar.fillUp();
```
gasCar.fillUp() 를 호출하면 참조값을 확인해서 x001.fillUp() 를 호출한다. 따라서 x001 을 찾아서

fillUp() 를 호출하면 되는 것이다. 그런데 상속 관계의 경우에는 내부에 부모와 자식이 모두 존재한다. 

이때 부모인 Car 를 통해서 fillUp() 를 찾을지 아니면 GasCar 를 통해서 FillUp() 를 찾을지 선택해야 한다.

이때는 호출하는 변수의 타입(클래스)을 기준으로 선택한다. gasCar 변수의 타입이 gasCar 이므로

인스턴스 내부에 같은 타입인 gasCar 를 통해서 fillUp() 를 호출한다.
```
gasCar.move();
```
gasCar.move() 를 호출하면 먼저 x001 참조로 이동한다. 내부에는 Car , gasCar 두가지 타입이 있다. 

이때 호출하는 변수인 gasCar 의 타입이 gasCar 이므로 이 타입을 선택한다.

그런데 gasCar 에는 move() 메서드가 없다. 상속 관계에서는 자식 타입에 해당 기능이 없으면 부모 타입으로 올라가서 찾는다. 

이 경우 gasCar 의 부모인 Car 로 올라가서 move() 를 찾는다. 

부모인 Car 에 move() 가 있으므로 부모에 있는 move() 메서드를 호출한다.

요악하자면

1. 상속 관계의 객체를 생성하면 그 내부에는 부모와 자식이 모두 생성된다.

2. 상속 관계의 객체를 호출할 때, 대상 타입을 정해야 한다. 이때 호출자의 타입을 통해 대상 타입을 찾는다.
   
3. 현재 타입에서 기능을 찾지 못하면 상위 부모 타입으로 기능을 찾아서 실행한다. 기능을 찾지 못하면 컴파일 오류가 발생한다.

# 상속과 메서드 오버라이딩
부모에게서 상속 받은 기능을 자식이 재정의 하는 것을 메서드 오버라이딩(Overriding)이라 한다.

오버라이딩과 메모리 구조
```
ElectricCar electricCar = new ElectricCar();
electricCar.move();
```
1. electricCar.move() 를 호출한다.
   
2. 호출한 electricCar 의 타입은 ElectricCar 이다. 따라서 인스턴스 내부의 ElectricCar 타입에서 시작한다.

3. ElectricCar 타입에 move() 메서드가 있다. 해당 메서드를 실행한다. 메서드를 이미 찾았으므로 부모 타입을 찾지 않는다.

`오버로딩(Overloading)` 과 `오버라이딩(Overriding)`

`메서드 오버로딩` : 메서드 이름이 같고 매개변수(파라미터)가 다른 메서드를 여러개 정의하는 것을 메서드 오버로딩(Overloading)이라 한다.

`메서드 오버라이딩` : 메서드 오버라이딩은 하위 클래스에서 상위 클래스의 메서드를 재정의하는 과정을 의미한다.

따라서 상속 관계에서 사용한다. 부모의 기능을 자식이 다시 정의하는 것이다. 

메서드 오버라이딩 조건

1. 메서드 이름: 메서드 이름이 같아야 한다.
   
2. 메서드 매개변수(파라미터): 매개변수(파라미터) 타입, 순서, 개수가 같아야 한다.

3. 반환 타입: 반환 타입이 같아야 한다. 단 반환 타입이 하위 클래스 타입일 수 있다.

4. 접근 제어자: 오버라이딩 메서드의 접근 제어자는 상위 클래스의 메서드보다 더 제한적이어서는 안된다. 예를 들어, 상위 클래스의 메서드가 protected 로 선언되어 있으면 하위 클래스에서 이를
   public 또는 protected 로 오버라이드할 수 있지만, private 또는 default 로 오버라이드 할 수 없다.

5. static , final , private : 키워드가 붙은 메서드는 오버라이딩 될 수 없다.

6. final 메서드는 재정의를 금지한다.

7. 생성자 오버라이딩: 생성자는 오버라이딩 할 수 없다.

# super - 부모 참조
부모와 자식의 필드명이 같거나 메서드가 오버라이딩 되어 있으면, 자식에서 부모의 필드나 메서드를 호출할 수 없다.

이때 super 키워드를 사용하면 부모를 참조할 수 있다. super 는 이름 그대로 부모 클래스에 대한 참조를 나타낸다.

[ex.Child](https://github.com/skcy1515/Programming-Study/blob/main/Java/Basic%20Grammars/Inheritance/exSuper/Child.java)
```
public void call() {
        System.out.println("this value = " + this.value); //this 생략 가능
        System.out.println("super value = " + super.value);
        this.hello(); //this 생략 가능
        super.hello();
    }
```
call() 메서드를 보자.

this 는 자기 자신의 참조를 뜻한다. this 는 생략할 수 있다.

super 는 부모 클래스에 대한 참조를 뜻한다.

필드 이름과 메서드 이름이 같지만 super 를 사용해서 부모 클래스에 있는 기능을 사용할 수 있다

# super - 생성자
상속 관계를 사용하면 자식 클래스의 생성자에서 부모 클래스의 생성자를 반드시 호출해야 한다.

상속 관계에서 부모의 생성자를 호출할 때는 super(...) 를 사용하면 된다.

```
package Inheritance.exSuper;

public class ClassA {

    public ClassA() {
        System.out.println("ClassA 생성자");
    }
}

public class ClassB extends ClassA{

    public ClassB(int a) {
        super(); //기본 생성자 생략 가능
        System.out.println("ClassB 생성자 a="+a);
    }

    public ClassB(int a, int b) {
        super(); //기본 생성자 생략 가능
        System.out.println("ClassB 생성자 a="+a + " b=" + b);
    }
}

public class ClassC extends ClassB {

    public ClassC() {
        super(10, 20);
        System.out.println("ClassC 생성자");
    }
}
```
상속 관계의 생성자 호출은 결과적으로 부모에서 자식 순서로 실행된다. 

따라서 부모의 데이터를 먼저 초기화하고 그 다음에 자식의 데이터를 초기화한다. (Class A -> Class B -> ClassC)

부모 클래스의 생성자가 기본 생성자(파라미터가 없는 생성자)인 경우에는 super() 를 생략할 수 있다

# 문제
[상속을 이용하여 쇼핑몰 판매 상품 만들기](https://github.com/skcy1515/Programming-Study/tree/main/Java/Basic%20Grammars/Inheritance/ex)
