# 클래스
클래스는 객체를 생성하기 위한 '틀' 또는 '설계도'이다. 

클래스는 객체가 가져야 할 속성(변수)과 기능(메서드)를 정의한다. 

클래스에 정의한 변수들을 `멤버 변수` 또는 `필드`라고 한다.

# 객체 
객체 (또는 인스턴스)는 클래스에서 정의한 속성과 기능을 가진 실체이다. 객체는 서로 독립적인 상태를 가진다.
```
Student student1 = new Student();
Student student1 = new Student();
```
예를 들어 위 코드에서 student1 은 학생1의 속성을 가지는 객체이고, 

student2 는 학생2의 속성을 가지는 객체이다. student1 과 student2 는 같은 클래스에서 만들어졌지만, 서로 다른 객체이다.

클래스를 통해 생성한 객체를 사용하려면 먼저 메모리에 존재하는 객체에 접근해야 한다. 

객체에 접근하려면 . (점, dot)을 사용하면 된다.

# 기본형과 참조형

변수의 데이터 타입을 가장 크게 보면 기본형과 참조형으로 분류할 수 있다.

`기본형(Primitive Type)` : int, long, double, boolean과 같이 변수에 사용할 값을 직접 넣을 수 있는 데이터 타입

`참조형(Reference Type)` : Student student, int[] students와 같이 데이터에 접근하기 위한 

참조값(주소) 저장하는 데이터 타입, 참조형은 객체 또는 배열에 사용됨

# 기본형과 참조형 변수 대입

자바는 항상 변수의 값을 복사해서 대입한다. 
```
int a = 10;
int b = a;
```
기본형은 변수에 값을 대입하더라도 실제 사용하는 값이 변수에 바로 들어있기 때문에 해당 값만 복사해서 대입한다.
```
Student s1 = new Student();
Student s2 = s1;
```
그런데 참조형의 경우 실제 사용하는 객체가 아니라 객체의 위치를 가리키는 참조값(주소값)만 복사된다. 

[참조형과 변수 대입 예제](https://github.com/skcy1515/Programming-Study/blob/main/Java/Basic%20Grammars/Class%20%26%20Primitive%20and%20Reference/VarChange.java)

# 기본형과 참조형 메서드 호출
자바는 항상 변수의 값을 복사해서 대입한다.

메서드 호출도 마찬가지이다. 메서드를 호출할 때 사용하는 매개변수(파라미터)도 결국 변수일 뿐이다. 

따라서 메서드를 호출할 때 매개변수에 값을 전달하는 것도 앞서 설명한 내용과 같이 값을 복사해서 전달한다.

`기본형` : 메서드로 기본형 데이터를 전달하면, 해당 값이 복사되어 전달된다. 

이 경우, 메서드 내부에서 매개변수(파라미터)의 값을 변경해도, 호출자의 변수 값에는 영향이 없다.

[기본형과 메서드 호출 예제](https://github.com/skcy1515/Programming-Study/blob/main/Java/Basic%20Grammars/Class%20%26%20Primitive%20and%20Reference/MethodChange1.java)

`참조형` : 메서드로 참조형 데이터를 전달하면, 참조값이 복사되어 전달된다. 

이 경우, 메서드 내부에서 매개변수(파라미터)로 전달된 객체의 멤버 변수를 변경하면, 호출자의 객체도 변경된다

[참조형과 메서드 호출 예제](https://github.com/skcy1515/Programming-Study/blob/main/Java/Basic%20Grammars/Class%20%26%20Primitive%20and%20Reference/MethodChange2.java)

# 문제
[상품명, 가격, 수량을 n번 입력받아 출력하고, 총 가격까지 출력하는 프로그램](https://github.com/skcy1515/Programming-Study/blob/main/Java/Basic%20Grammars/Class%20%26%20Primitive%20and%20Reference/ex/ProductOrderMain.java)
```
입력할 주문의 개수를 입력하세요: 3
1번째 주문 정보를 입력하세요.
상품명: 사과
가격: 5000
수량: 3
2번째 주문 정보를 입력하세요.
상품명: 배
가격: 10000
수량: 1
3번째 주문 정보를 입력하세요.
상품명: 귤
가격: 1000
수량: 4
상품명: 사과, 가격: 5000, 수량: 3
상품명: 배, 가격: 10000, 수량: 1
상품명: 귤, 가격: 1000, 수량: 4
총 가격은 29000입니다.
```