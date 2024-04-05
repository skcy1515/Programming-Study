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

참조형과 변수 대입 예제
```
package PrimaryReference;

// Data.java
public class Data {
    int value;
}

// VarChange.java
public class VarChange {
    public static void main(String[] args) {
        Data dataA = new Data(); // dataA 변수에 Data형 객체의 참조값 저장
        dataA.value = 10; // 객체의 value 값을 10으로 바꿔줌
        Data dataB = dataA; // dataA의 참조값을 복사하여 dataB에 저장
        // 즉, dataB가 가리키는 값은 dataA가 가리키는 값과 같아진다.

        System.out.println("dataA 참조값=" + dataA); // PrimaryReference.Data@2f4d3709
        System.out.println("dataB 참조값=" + dataB); // PrimaryReference.Data@2f4d3709
        System.out.println("dataA.value = " + dataA.value); // 10
        System.out.println("dataB.value = " + dataB.value); // 10

        //dataA 변경
        dataA.value = 20;
        System.out.println("변경 dataA.value = 20");
        System.out.println("dataA.value = " + dataA.value); // 20
        System.out.println("dataB.value = " + dataB.value); // 20

        //dataB 변경
        dataB.value = 30;
        System.out.println("변경 dataB.value = 30");
        System.out.println("dataA.value = " + dataA.value); // 30
        System.out.println("dataB.value = " + dataB.value); // 30
    }
}
```
# 기본형과 참조형 메서드 호출
자바는 항상 변수의 값을 복사해서 대입한다.

메서드 호출도 마찬가지이다. 메서드를 호출할 때 사용하는 매개변수(파라미터)도 결국 변수일 뿐이다. 

따라서 메서드를 호출할 때 매개변수에 값을 전달하는 것도 앞서 설명한 내용과 같이 값을 복사해서 전달한다.

`기본형` : 메서드로 기본형 데이터를 전달하면, 해당 값이 복사되어 전달된다. 

이 경우, 메서드 내부에서 매개변수(파라미터)의 값을 변경해도, 호출자의 변수 값에는 영향이 없다.

기본형과 메서드 호출 예제
```
package PrimaryReference;

public class MethodChange1 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("메서드 호출 전 a의 값: " + a); // 10
        changePrimitive(a);
        System.out.println("메서드 호출 후 a의 값: "+a); // 10
    }

    static void changePrimitive (int x) {
        x = 20;
        // 메서드가 종료되면 매개변수 x는 제거됨
    }
}
```

`참조형` : 메서드로 참조형 데이터를 전달하면, 참조값이 복사되어 전달된다. 

이 경우, 메서드 내부에서 매개변수(파라미터)로 전달된 객체의 멤버 변수를 변경하면, 호출자의 객체도 변경된다

참조형과 메서드 호출 예제
```
package PrimaryReference;

public class MethodChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("메서드 호출 전: dataA.value = " + dataA.value);
        changeReference(dataA);
        System.out.println("메서드 호출 후: dataA.value = " + dataA.value);
    }

    static void changeReference(Data dataX) { // Data dataX = dataA와 같음
        dataX.value = 20; // Data 객체의 값 변경
    }
}
```
# 문제
상품명, 가격, 수량을 n번 입력받아 출력하고, 총 가격까지 출력하는 프로그램
```
package PrimaryReference.ex;

// Product.java
public class Product {
    String productName;
    int price;
    int quantity;

    public Product createProduct(String productName, int price, int quantity) {
        Product products1 = new Product();
        products1.productName = productName;
        products1.price = price;
        products1.quantity = quantity;
        return products1;
    }

    public void printProduct(Product[] products) {
        for (Product product : products) {
            System.out.println("상품명: " + product.productName + ", 가격: " + product.price + ", 수량: " + product.quantity);
        }
    }

    public void getTotalAmount(Product[] products) {
        int totalAmount = 0;
        for (Product product : products) {
            totalAmount += product.price * product.quantity;
        }
        System.out.println("총 가격은 " + totalAmount + "입니다.");
    }
}

// ProductOrderMain.java
import java.util.Scanner;

public class ProductOrderMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // 엔터키를 통해 입력 버퍼 없앰
        Product[] products = new Product[n];
        Product product = new Product();

        for (int i=0; i<n; i++) {
            System.out.println((i + 1) + "번째 주문 정보를 입력하세요.");

            System.out.print("상품명: ");
            String productName = scanner.nextLine();

            System.out.print("가격: ");
            int price = scanner.nextInt();

            System.out.print("수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            products[i] = product.createProduct(productName, price, quantity);
        }
        product.printProduct(products);
        product.getTotalAmount(products);
        scanner.close();
    }
}
```
실행결과
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
