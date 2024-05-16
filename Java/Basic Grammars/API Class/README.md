# Object 클래스
java.lang 패키지는 자바에서 가장 기본적인 동작을 수행하는 클래스들의 집합이다. java.lang 패키지 중에서도 가장 많이 사용되는 클래스는 바로 Object 클래스이다. Object 클래스는 모든 자바 클래스의 최고 조상 클래스가 된다. 따라서 자바의 모든 클래스는 Object 클래스의 모든 메소드를 바로 사용할 수 있다.

### toString 
객체를 문자열로 반환한다.

```
@Override
public String toString() {
  return "직원{이름='" + name + "', 나이=" + age + ", 이메일='" + email + "'}";
}

ObjectMain person1 = new ObjectMain("John Doe", 30, "john.doe@example.com");
System.out.println(person1); // 직원{이름='John Doe', 나이=30, 이메일='john.doe@example.com'}
```

### equals
객체 내용이 같은지 비교한다.

```
@Override
public boolean equals(Object obj) {
  ObjectMain person = (ObjectMain) obj;
  return age == person.age && name.equals(person.name) && email.equals(person.email);
  }

ObjectMain person1 = new ObjectMain("John Doe", 30, "john.doe@example.com");
ObjectMain person2 = new ObjectMain("John Doe", 30, "john.doe@example.com");
ObjectMain person3 = new ObjectMain("Chan Young", 23, "skcy151515@example.com");

System.out.println(person1.equals(person2)); // true
System.out.println(person1.equals(person3)); // false
```

# String 클래스
C언어에서는 문자열을 char형 배열로 표현하지만, 자바에서는 문자열을 위한 String이라는 클래스를 별도로 제공한다. String 클래스에는 문자열과 관련된 작업을 할 때 유용하게 사용할 수 있는 다양한 메소드가 포함되어 있다.

String 인스턴스는 한 번 생성되면 그 값을 읽기만 할 수 있고, 변경할 수는 없다. 이러한 객체를 자바에서는 불변 객체(immutable object)라고 한다. 즉, 자바에서 덧셈(+) 연산자를 이용하여 문자열 결합을 수행하면, 기존 문자열의 내용이 변경되는 것이 아니라 내용이 합쳐진 새로운 String 인스턴스가 생성되는 것이다.

주요 메서드들
- concat
- length
- contains
- trim
- replace
- charAt
- indexOf
- toUpperCase, toLowerCase

```
        String a = " C#";
        String b = " C++";

        System.out.println(a + "의 길이는 " + a.length()); // 문자열의 길이(문자 개수), 3
        System.out.println(a.contains("#")); // 문자열의 포함 관계, true

        a = a.concat(b); // 문자열 연결
        System.out.println(a); //  C# C++

        a = a.trim(); // 문자열 앞 뒤의 공백 제거
        System.out.println(a); // C#C++

        a = a.replace("C#", "Java"); // 문자열 대치
        System.out.println(a); // Java C++

        char c = a.charAt(2); // 인덱스 2의 문자 리턴
        System.out.println(c); // v

        System.out.println(a.indexOf("Java")); // 문자열이 처음 등장하는 인덱스 반환, 0

        System.out.println(a.toUpperCase()); // 대문자로 변환하여 출력 (원본 문자열 변경 X), JAVA C++
        System.out.println(a.toLowerCase()); // 소문자로 변환하여 출력 (원본 문자열 변경 X), java c++
```
