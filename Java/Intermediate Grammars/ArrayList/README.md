# 배열 리스트
배열의 경우 다음 2가지 불편함이 있다.
- 배열의 길이를 동적으로 변경할 수 없다.
- 데이터를 추가하기 불편하다, 데이터를 추가하는 경우 직접 오른쪽으로 한 칸씩 데이터를 밀어야 한다. (이런 코드를 직접 작성해야 한다.)

배열의 이런 불편함을 해소하고 동적으로 데이터를 추가할 수 있는 자료 구조를 ArrayList(배열 리스트)라 한다.

# 배열 리스트 사용법
### 객체 생성
```
// 타입설정 Integer 객체만 적재가능
ArrayList<Integer> list = new ArrayList<>();

// 초기 용량(capacity)지정
ArrayList<Integer> list2 = new ArrayList<>(10);

// 배열을 넣어 생성
ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1,2,3));
```

### 요소 추가
```
// 요소 추가
list.add("A");
list.add("B");
list.add("D");

list2.addAll(list3); // 컬렉션 자체를 가져와서 추가

System.out.println("리스트 요소: " + list + ", 크기: " + list.size()); // 리스트 요소: [A, B, D], 크기: 3
System.out.println("리스트2 요소: " + list2); // 리스트2 요소: [1, 2, 3]
```

### 요소 삽입
```
// 요소 삽입
list.add(2, "C");
list.add(4, "E");
System.out.println("리스트 요소: " + list); // 리스트 요소: [A, B, C, D, E]
```
지정된 위치에 요소를 넣을수 있게 기존의 요소들이 한칸씩 뒤로 이동되면서 빈공간을 만들어준다. 유의할점은 한칸씩 데이터들을 뒤로 밀어내는 동작은 꽤나 비용이 크기 때문에 ArrayList의 사이즈가 커질 수록 비효율적이 된다. (이는 ArrayList 컬렉션의 단점이기도 하다.)

위치를 지정하여 삽입할때 인덱스가 리스트의 capacity를 넘지 않도록 조절이 필요하다. 만일 용량에 맞지 않는 인덱스 위치에 요소를 넣으려고 한다면 IndexOutOfBoundsException 예외가 발생하게 된다.

### 요소 삭제
```
// 요소 삭제
list.remove(4);
System.out.println(list); // [A, B, C, D]

list2.clear(); // 요소 전부 삭제
System.out.println(list2); // []
```

### 요소 검색
```
// list에 A가 있는지 검색 : true
System.out.println("list에 A가 있나? : " + list.contains("A"));

// list에 D가 있는지 순차적으로 검색하고 index를 반환 (만일 없으면 -1)
System.out.println("D의 인덱스 반환 : " + list.indexOf("D"));

// list에 C가 있는지 역순으로 검색하고 index를 반환 (만일 없으면 -1)
System.out.println("C의 인덱스 반환, 역순으로 검색 : " + list.lastIndexOf("C"));
```

### 요소 얻기
```
// 요소 얻기
list.get(0); // "A"
list.get(3); // "D"
```

### 요소 변경
```
// 요소 변경
list.set(0, "요소 변경");
```

### 용량 확장
가변적인 동작은 리스트를 다루는데에는 편하지만, 배열 복사 동작 자체가 성능이 그리 좋지않아 오버헤드(Overhead)를 발생 시키게 된다. 따라서 사용될 데이터의 개수를 미리 알고 있는 경우라면 애초에 ArrayList를 만들 때부터 큰 값으로 만들어주면 된다. 그러면 배열이 복사하면서 발생하는 오버헤드를 피할 수 있어 성능저하를 방지할 수 있게 된다. 혹은 ensureCapacity() 메서드를 이용해 리스트의 최소 용량을 재지정함으로써 실행 중간에 리스트의 용량을 늘릴수도 있다.
```
// 용량 확장
list2.ensureCapacity(15);
```

### 리스트 정렬
```
// 오름차순 정렬
list2.sort(Comparator.naturalOrder());
System.out.println(list2); // [1, 2, 3, 4, 5]

// 내림차순 정렬
list2.sort(Comparator.reverseOrder());
System.out.println(list2); // [5, 4, 3, 2, 1]
```

원본 리스트 자체를 바꾼다.

### 리스트 순회
```
// 이터레이터 객체 반환
ListIterator<Integer> iter = list2.listIterator();

// 만일 다음 요소가 있다면 반복
while (iter.hasNext()) {
  System.out.println(iter.next()); // 요소를 출력하고 반복 위치를 뒤로 이동
}

// 만일 이전 요소가 있다면 반복
while (iter.hasPrevious()) {
  System.out.println(iter.previous()); // 요소를 출력하고 반복 위치를 앞으로 이동
}
```
실행 결과
```
5
4
3
2
1
1
2
3
4
5
```
몇몇 컬렉션에서는 저장된 요소를 Iterator 인터페이스로 읽어오도록 하는 순회 패턴을 지향한다. Collection 인터페이스에서는 Iterator 인터페이스를 구현한 클래스의 인스턴스를 반환하는 iterator() 메소드를 정의하여 각 요소에 접근하도록 정의 하고 있다. 따라서 Collection 인터페이스를 상속받는 List나 Set 인터페이스에서도 iterator() 메소드를 사용할 수 있다. (Map은 X)

ArrayList에는 Iterator 뿐만 아니라 리스트 전용 이터레이터 객체인 ListIterator도 지원한다. ListIterator 인터페이스는 Iterator 인터페이스를 상속받아 여러 기능을 추가한 인터페이스로서, Iterator는 컬렉션의 요소에 접근할 때 단 방향으로만 이동할 수 있는 반면, ListIterator 인터페이스는 컬렉션 요소의 대체, 추가 그리고 인덱스 검색 등을 위한 작업에서 양방향으로 이동하는 것을 지원하여 더욱 쓰임새가 넓다.
