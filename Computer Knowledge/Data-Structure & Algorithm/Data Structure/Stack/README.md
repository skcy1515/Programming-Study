# 스택
스택은 후입선출(LIFO, Last In, First Out)의 원리를 따른다. 이것은 가장 마지막에 추가된 데이터가 가장 먼저 제거되는 구조를 말한다.

- 일상생활에서 볼 수 있는 스택의 예시: 엘레베이터 (늦게 탄 사람이 먼저 내리고, 일찍 탄 사람이 늦게 내림)

스택을 연결리스트로 구현: 데이터 삽입을 무조건 첫 번째 인덱스에 하기, 제거도 가장 앞부분, 즉 head에 있는 노드만 삭제

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/c9dc7367-3609-4532-a58f-0096097da816)

한쪽으로만 데이터를 삽입, 삭제하면 간단하게 스택이 된다.

스택은 컴퓨터 프로그래밍에서 다양한 용도로 활용된다. 
- Ctrl + Z (실행취소를 누르면 스택에 쌓인 데이터가 제거됨)
- 문법 검사 (코드를 검사하면서 스택에 코드를 넣고 정상이면 다시 내보냄, 만약 스택에 데이터가 남아있으면 문법 오류)

# 스택 구현 예제
기존에 있던 연결리스트를 기반으로 스택 구현, 구현 전에 스택에 필요한 추상 자료형 정의
- push - 데이터 삽입
- pop - 데이터 제거
- peek - Top에 있는 데이터 참조
- isEmpty - 스택이 비었는지 체크

```
class Stack {
  // 스택 생성 클래스
  constructor() {
    this.list = new LinkedList(); // LinkedList 인스턴스를 생성하여 변수 list에 저장
  }

  push(data) {
    this.list.insertAt(0, data); // 인덱스에 노드 삽입
  }

  pop() {
    try {
      return this.list.deleteAt(0); // 인덱스의 노드 삭제
    } catch (e) {
      return null; // 예외가 발생하면 null 반환
    }
  }

  peek() {
    return this.list.getNodeAt(0); // 인덱스의 노드 참조
  }

  isEmpty() {
    return this.list.count == 0; // 만약 count가 0이면 true, 아니면 false 반환
  }
}
```
