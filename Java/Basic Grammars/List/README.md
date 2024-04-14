# 리스트
리스트(List)는 배열과 비슷하지만 편리한 기능이 더 많은 자료형이다. 리스트와 배열의 가장 큰 차이점은, 배열은 크기가 정해져 있지만 리스트는 변한다는 데 있다.

### ArrayList
리스트 자료형에서 가장 일반적으로 사용하는 ArrayList를 알아보자.
list 선언
```
List list = new ArrayList();
```
실행 코드
```
package list;

import java.util.ArrayList;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add(2, "3");
        list.add(3, "4");

        list.remove(2);
        list.remove("4");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println(list.contains("4"));

    }
}
```
실행 결과
```
1 2 false
```
- add: ArrayList의 add 메서드를 사용하면 요솟값을 추가할 수 있다.
- get: ArrayList의 get 메서드를 사용하면 특정 인덱스의 값을 추출할 수 있다.
- remove: 특정 인덱스나 특정 객체 값을 넣어 원하는 데이터를 삭제할 수 있디.
- size: 리스트의 요소 개수 반환
- contains: 리스트 안에 해당 항목이 있는지 판별해 그 결과를 boolean으로 리턴

### 제네릭스
제네릭스(generics)는 자바 J2SE 5.0 버전 이후에 도입된 개념으로, 자료형을 안전하게 사용할 수 있도록 만들어 주는 기능이다. 제네릭스를 사용하면 자료형을 강제로 바꿀 때 생길 수 있는 캐스팅 오류를 줄일 수 있다.

제네릭스의 이점을 좀 더 살펴보자. 다음은 제네릭스를 사용하지 않은 예이다.
```
ArrayList pitches = new ArrayList();
pitches.add("138");
pitches.add("129");

String one = (String) pitches.get(0);
String two = (String) pitches.get(1);
```
제네릭스를 사용하지 않으면 ArrayList에 추가하는 객체는 Object 자료형으로 인식된다. Object 자료형은 모든 객체가 상속하고 있는 가장 기본적인 자료형이다. 따라서 ArrayList 객체인 pitches에 값을 넣을 때는 문제가 없지만 값을 가져올 때는 매번 Object 자료형에서 String 자료형으로 형 변환(casting) 을 해야 한다.

```
ArrayList<String> pitches = new ArrayList<>();
pitches.add("138");
pitches.add("129");

String one = pitches.get(0);  // 형 변환이 필요없다.
String two = pitches.get(1);  // 형 변환이 필요없다.
```
반대로 제네릭스를 사용하면 형변환이 필요 없다.

### 다양한 방법으로 ArrayList 만들기

```
package list;

import java.util.*;

public class ListGenericsMain {
    public static void main(String[] args) {
        ArrayList<String> pitches = new ArrayList<>();  // 제네릭스를 사용한 표현

        pitches.add("138");
        pitches.add("129");
        pitches.add("142");

        System.out.println(pitches);  // [138, 129, 142] 출력

        String[] data = {"1381", "1291", "1421"};  // 이미 투구수 데이터 배열이 있다.

        ArrayList<String> pitches2 = new ArrayList<>(Arrays.asList(data)); // java.util.Arrays 클래스의 asList 메서드를 사용하면 이미 존재하는 문자열 배열로 ArrayList를 만들 수 있다.

        System.out.println(pitches2);  // [138, 129, 142] 출력

        Map<String, Integer> map = new HashMap<>(); // map 사용

        map.put("apple", 10);
        map.put("banana", 5);
        map.put("orange", 7);

        List<Integer> list = new ArrayList<>(map.values());
        System.out.println(list);
    }
}
```
실행 결과
```
[138, 129, 142]
[1381, 1291, 1421]
[5, 7, 10]
```

