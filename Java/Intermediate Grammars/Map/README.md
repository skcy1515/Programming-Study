# 맵
맵(Map) 은 대응 관계를 쉽게 표현할 수 있게 해주는 자료형이다. 맵은 키(key)와 값(value)을 한 쌍으로 갖는다. 

Map은 저장 순서를 유지할 필요가 없고, Key를 통해 Value를 얻어내기 때문에 Key는 중복을 허용하지 않는다.

const Map형식 예시
```
[
    {
        id: 1,
        role: 'admin',
        theme: "#64C59A",
    },
    {
        id: 2,
        role: 'developer',
        theme: "#FF5C00",
    },
    {
        id: 3,
        role: 'designer',
        theme: "#7B3FEF",
    },
    {
        id: 4,
        role: 'pm',
        theme: "#5262F5",
    }
]
```

### map 선언
```
Map<String, Integer> map = new HashMap<>();
```
- map 변수의 타입을 인터페이스인 Map<Integer, String>으로 지정
- 해시맵 클래스는 맵 인터페이스를 구현한 클래스 중의 하나이므로, HashMap의 인스턴스를 Map 타입으로 참조
- Map이 인터 페이스이기 때문에 자식인 HashMap으로 객체를 생성
- 해시맵은 키-값 쌍의 데이터를 저장하는 자료구조로, 특정 키를 사용하여 해당 키에 대응하는 값을 빠르게 검색할 수 있다.

# 맵 사용법
### put
데이터를 맵에 추가한다.
```
map.put("apple", 10);
map.put("banana", 5);
map.put("orange", 7);
```
- key 매개변수는 저장하고자 하는 데이터의 키(Key)이다.
- value 매개변수는 해당 키와 연관된 값을 나타낸다.
- put 함수는 주어진 키-값 쌍을 맵에 추가하거나, 이미 존재하는 키의 값을 업데이트한다.

### get
get 메서드는 key에 해당하는 value를 얻을 때 사용한다.
```
int appleCount = map.get("apple");
System.out.println(appleCount); // 10
```
- key 매개변수는 검색하고자 하는 데이터의 키를 나타낸다
- get 함수는 주어진 키에 해당하는 값(value)을 반환한다. 키가 존재하지 않으면 null을 반환한다.

### remove
remove 메서드는 맵의 항목을 삭제하는 메서드로, 해당 key의 항목을 삭제한 후 value 값을 리턴한다.
```
map.remove("orange");
```

### size
맵의 요소의 개수를 리턴한다.
```
System.out.println(map.size()); // 요소 개수 출력, 2
```

### containsKey
맵에 해당 key가 있는지를 참(true) 또는 거짓(false)으로 리턴한다.
```
System.out.println(map.containsKey("orange")); // false 출력
```

### keySet
keySet은 맵의 모든 key를 모아서 리턴한다.
```
System.out.println(map.keySet()); // [banana, apple]
```
