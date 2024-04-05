# 생성자

프로그래밍을 하다보면 객체를 생성하고 이후에 바로 초기값을 할당해야 하는 경우가 많다. 

그래서 대부분의 객체 지향 언어는 객체를 생성하자마자 즉시 필요한 기능을 좀 더 편리하게 수행할 수 있도록 

생성자라는 기능을 제공한다. 생성자를 사용하면 객체를 생성하는 시점에 즉시 필요한 기능을 수행할 수 있다.

생성자는 메서드와 비슷하지만 다음과 같은 차이가 있다.
1. 생성자의 이름은 클래스 이름과 같아야 한다.
2. 따라서 첫 글자도 대문자로 시작한다.
3. 생성자는 반환 타입이 없다. 비워두어야 한다.

# 생성자 호출
생성자는 인스턴스를 생성하고 나서 즉시 호출된다. 

생성자를 호출하는 방법은 다음 코드와 같이 new 명령어 다음에 생성자 이름과 매개변수에 맞추어 인수를 전달하면 된다.
```
new 생성자이름(생성자에 맞는 인수 목록)
new 클래스이름(생성자에 맞는 인수 목록)
// 클래스이름 = 생성자 이름
```

# this
생성자에서 쓰이는 this인스턴스 자신의 참조값을 가리킨다.

매개변수 이름과 멤버 변수의 이름이 같은 경우

멤버 변수와 메서드의 매개변수를 구별하고 멤버 변수에 접근하기 위해 사용한다.

# 생성자의 장점
1. 중복 호출 제거

생성자가 없던 시절에는 생성 직후에 어떤 작업을 수행하기 위해 메서드를 직접 한번 더 호출해야 했다.

생성자 덕분에 객체를 생성하면서 동시에 생성 직후에 필요한 작업을 한번에 처리할 수 있게 되었다.

2. 제약 - 생성자 호출 필수
   
생성자의 진짜 장점은 객체를 생성할 때 직접 정의한 생성자가 있다면 직접 정의한 생성자를 반드시 호출해야 한다는 점이다. 

참고로 생성자를 메서드 오버로딩 처럼 여러개 정의할 수 있는데, 이 경우에는 하나만 호출하면 된다.

생성자 예제
```
package Constructor;

// MemberConstruct.java
public class MemberConstruct {
    String name;
    int age;
    int grade;

    MemberConstruct(String name, int age, int grade) {
        this.age = age;
        this.name = name;
        this.grade = grade;
        System.out.println("생성자 호출 name=" + name + ",age=" + age + ",grade=" + grade);
    }

    MemberConstruct(String name, int age) { // 생성자 오버로딩
        this.name = name;
        this.age = age;
        this.grade = 50;
        System.out.println("생성자 호출 name=" + name + ",age=" + age + ",grade=" + grade);
    }
}

// ConstructMain.java
public class ConstructMain {
    public static void main(String[] args) {
        MemberConstruct member1 = new MemberConstruct("user1", 15, 90);
        MemberConstruct member2 = new MemberConstruct("user2", 16, 80);
        MemberConstruct member3 = new MemberConstruct("user3", 17);
    }
}
```
# 기본 생성자
매개변수가 없는 생성자를 기본 생성자라 한다.

자바에서 생성자는 반드시 호출되어야 한다.

클래스에 생성자가 하나도 없으면 자바 컴파일러는 매개변수가 없고, 작동하는 코드가 없는 기본 생성자를 자동으로 만들어준다.

생성자가 하나라도 있으면 자바는 기본 생성자를 만들지 않는다.

# 문제
생성자를 이용해 제목, 저자, 페이지를 출력하는 프로그램
```
package Constructor.ex;

// Book.java
public class Book {
    String title;
    String author;
    int pages;

    Book() {
        this.title = "";
        this.author = "";
        this.pages = 0;
    }

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.pages = 0;
    }
    Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public void displayInfo(){
        System.out.println("제목: " + title + ", 저자: " + author + ", 페이지: " + pages);
    }
}

// BookMain.java
public class BookMain {
    public static void main(String[] args) {
        // 기본 생성자 사용
        Book book1 = new Book();
        book1.displayInfo();

        // title과 author만을 매개변수로 받는 생성자
        Book book2 = new Book("Hello Java", "Seo");
        book2.displayInfo();

        // 모든 필드를 매개변수로 받는 생성자
        Book book3 = new Book("JPA 프로그래밍", "kim", 700);
        book3.displayInfo();
    }
}
```
실행결과
```
제목: , 저자: , 페이지: 0
제목: Hello Java, 저자: Seo, 페이지: 0
제목: JPA 프로그래밍, 저자: kim, 페이지: 700
```
