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
