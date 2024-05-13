package arrayList;

import java.util.*;

public class ArrayMain {
    public static void main(String[] args) {
        // 타입설정 Integer 객체만 적재가능
        ArrayList<String> list = new ArrayList<>();

        // 초기 용량(capacity)지정
        ArrayList<Integer> list2 = new ArrayList<>(10);

        // 배열을 넣어 생성
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1,2,3));

        // 요소 추가
        list.add("A");
        list.add("B");
        list.add("D");

        list2.addAll(list3);

        System.out.println("리스트 요소: " + list + ", 크기: " + list.size());
        System.out.println("리스트2 요소: " + list2);

        // 요소 삽입
        list.add(2, "C");
        list.add(4, "E");
        System.out.println("리스트 요소: " + list);

        // 요소 삭제
        list.remove(4);
        System.out.println(list); // [A, B, C, D]
        list2.clear(); // 요소 전부 삭제
        System.out.println(list2); // []

        // list에 A가 있는지 검색 : true
        System.out.println("list에 A가 있나? : " + list.contains("A"));

        // list에 D가 있는지 순차적으로 검색하고 index를 반환 (만일 없으면 -1)
        System.out.println("D의 인덱스 반환 : " + list.indexOf("D"));

        // list에 C가 있는지 역순으로 검색하고 index를 반환 (만일 없으면 -1)
        System.out.println("C의 인덱스 반환, 역순으로 검색 : " + list.lastIndexOf("C"));

        // 요소 얻기
        list.get(0); // "A"
        list.get(3); // "D"

        // 요소 변경
        list.set(0, "요소 변경");

        // 용량 확장
        list2.ensureCapacity(15);

        // 리스트 정렬
        list2.add(1);
        list2.add(5);
        list2.add(3);
        list2.add(2);
        list2.add(4);

        // 오름차순 정렬
        list2.sort(Comparator.naturalOrder());
        System.out.println(list2); // [1, 2, 3, 4, 5]

        // 내림차순 정렬
        list2.sort(Comparator.reverseOrder());
        System.out.println(list2); // [5, 4, 3, 2, 1]

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
    }
}
