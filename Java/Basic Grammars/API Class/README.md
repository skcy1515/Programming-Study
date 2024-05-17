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

# Wrapper 클래스
프로그램에 따라 기본 타입의 데이터를 객체로 취급해야 하는 경우가 있다. 예를 들어, 메소드의 인수로 객체 타입만이 요구되면, 기본 타입의 데이터를 그대로 사용할 수는 없다. 이때에는 기본 타입의 데이터를 먼저 객체로 변환한 후 작업을 수행해야 한다.

 이렇게 8개의 기본 타입에 해당하는 데이터를 객체로 포장해 주는 클래스를 래퍼 클래스(Wrapper class)라고 한다. 래퍼 클래스는 각각의 타입에 해당하는 데이터를 인수로 전달받아, 해당 값을 가지는 객체로 만들어 준다.

 ### 박싱(Boxing)과 언박싱(UnBoxing)
- 박싱(boxing): 기본 타입의 값을 Wrapper 객체로 변환
- 언박싱(unboxing): Wrapper 객체에 들어 있는 기본 타입의 값을 빼내는 것

```
        Integer num1 = new Integer(7); // 박싱
        Integer num2 = new Integer(3); // 박싱

        int int1 = num1.intValue();    // 언박싱
        int int2 = num2.intValue();    // 언박싱
```

### 오토 박싱(AutoBoxing)과 오토 언박싱(AutoUnBoxing)
JDK 1.5부터는 박싱과 언박싱이 필요한 상황에서 자바 컴파일러가 이를 자동으로 처리해 준다. 이렇게 자동화된 박싱과 언박싱을 오토 박싱(AutoBoxing)과 오토 언박싱(AutoUnBoxing)이라고 부른다.

```
        Character ch = 'X'; // Character ch = new Character('X'); : 오토박싱
        char c = ch;        // char c = ch.charValue();           : 오토언박싱
        System.out.println(c); // X
```

# StringBuffer 클래스
String 클래스의 인스턴스는 한 번 생성되면 그 값을 읽기만 할 수 있고, 변경할 수는 없다. 하지만 StringBuffer 클래스의 인스턴스는 그 값을 변경할 수도 있고, 추가할 수도 있다.

이를 위해 StringBuffer 클래스는 내부적으로 버퍼(buffer)라고 하는 독립적인 공간을 가진다. 버퍼 크기의 기본값은 16개의 문자를 저장할 수 있는 크기이며, 생성자를 통해 그 크기를 별도로 설정할 수도 있다.

주요 메서드들
- append
- insert
- replace
- delete
- setLength

```
        StringBuffer sb = new StringBuffer("This");
        sb.append(" is pencil"); // 문자열 덧붙이기
        System.out.println(sb); // This is pencil

        sb.insert(7, " my"); // "my" 문자열 삽입
        System.out.println(sb); // This is my pencil

        sb.replace(8, 10, "your"); // "my"를 "your"로 변경
        System.out.println(sb); // This is your pencil

        sb.delete(8, 13); // "your " 삭제
        System.out.println(sb); // This is pencil

        sb.setLength(4); // 스트링 버퍼 내 문자열 길이 수정
        System.out.println(sb); // This
```

# Math 클래스
```
        double a = 3.5;

        System.out.println(Math.PI); // 원주율 상수 출력, 3.14159...
        System.out.println(Math.ceil(a)); // ceil(올림), 4.0
        System.out.println(Math.floor(a)); // floor(내림), 3.0
        System.out.println(Math.round(a)); // 소수점 첫째 자리 반올림 후 정수 반환, 4
        System.out.println(Math.max(3.14, 3.14159)); // 더 큰 값 반환, 3.14159
        System.out.println(Math.min(3.14, 3.14159)); // 더 작은 값 반환, 3.14
        System.out.println((int)Math.pow(5, 2)); // 5^2, 25
        System.out.println((int)Math.sqrt(25));  // 25의 제곱근, 5

        // [1, 45] 사이의 정수형 난수 5개 발생
        System.out.print("이번주 행운의 번호는 ");
        for(int i=0; i<5; i++)
            System.out.print((int)(Math.random()*45 + 1) + " ");
```
