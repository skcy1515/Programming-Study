# 큐
큐는 선입선출(FIFO, Last In, First Out)의 원리를 따른다. 이것은 가장 먼저 추가된 데이터가 가장 먼저 제거되는 구조를 말한다.

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/9521f591-88b9-495d-9120-ada16812d65b)

데이터 1, 2, 3, 4를 순서대로 삽입하면 삽입 데이터는 head로, 즉 가장 앞부분으로 한다. 그리고 제거할 때는 가장 뒤에서부터 데이터를 제거하면 된다.

하지만 단방향 연결리스트로는 데이터를 뒤에서 제거하기 힘들다. (정확히는 head에서부터 가장 뒤에있는 데이터까지 이동해야 하므로 O(n)의 성능이 나와 느리다.) 

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/1ebd9dde-77b7-4e8d-a21d-20ac1ac4c13b)

성능을 위해서 tail이라는 변수를 하나 더 만들어준다. head는 가장 앞에 있는 노드를 가리키고, tail은 가장 뒤에 있는 노드를 가리킨다. 이렇게 되면 tail을 이용해서 데이터를 O(1)의 성능으로 제거할 수 있다. 

그래도 tail이 삭제되기 이전 노드를 가리킬려면 head에서부터 다시 찾아야 하는 과정은 동일하므로 결국 O(n)의 성능을 가지게 된다. 따라서 연결리스트를 이중연결리스트로 수정한다.

# 이중 연결리스트 구현
기존 연결리스트에서 모든 노드가 이전 노드를 참조해주는 기능만 추가하면 된다.

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/2f2bf01f-a195-4fc0-a592-f6aef43d0bf7)

head가 가리키는 노드의 이전 노드를 새로운 노드로 설정

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/d6b7181f-af28-40a7-8b92-4184dd28699a)

마지막 인덱스에 삽입할 시 
- 새로운 노드의 다음 노드를 null로 설정
- 새로운 노드의 이전 노드를 tail로 설정
- tail이 가리키던 노드의 다음 노드를 새로운 노드로 설정
- 만약 새로운 노드의 다음 노드가 null이라면 새로운 노드를 tail로 설정

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/27b20599-b2d5-4c1c-b45a-8382c15f0cd8)

중간에 삽입할 시
- 새로운 노드의 다음 노드를 currentNode의 다음 노드로 가리키게 설정
- 새로운 노드의 이전 노드를 currentNode로 설정
- currentNode의 다음 노드를 새로운 노드로 설정
- 새로운 노드의 다음 노드의 이전 노드를 새로운 노드로 설정

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/68496c18-129f-49e6-954e-fbb441d3a6a7)

마지막 노드 삭제할 시
- tail 노드를 삭제할 노드로 설정
- tail의 이전 노드의 다음 노드를 null로 설정 
- tail을 tail의 이전 노드로 설정

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/4f498443-aeed-415b-af59-570d2f1c7913)

중간 노드 삭제할 시
- 삭제할 노드를 현재 노드의 다음 노드로 설정
- 현재 노드의 다음 노드를 현재 노드의 다음의 다음 노드로 설정
- 현재 노드의 다음 노드의 이전 노드를 현재 노드로 설정

```
class Node {
  constructor(data, next = null, prev = null) {
    this.data = data;
    this.next = next;
    this.prev = prev; // 이전 노드를 가리키는 prev 프로퍼티 추가
  }
}

class DoublyLinkedList {
  constructor() {
    this.head = null;
    this.tail = null; // 리스트의 끝을 가리키는 tail 프로퍼티 추가
    this.count = 0;
  }

  printAll() {
    let currentNode = this.head;
    let text = "[";

    while (currentNode != null) {
      text += currentNode.data;
      currentNode = currentNode.next;

      if (currentNode != null) {
        text += ", ";
      }
    }

    text += "]";
    console.log(text);
  }

  clear() {
    this.head = null;
    this.count = 0;
  }

  insertAt(index, data) {
    if (index > this.count || index < 0) {
      throw new Error("범위를 넘어갔습니다.");
    }

    let newNode = new Node(data);

    if (index == 0) {
      newNode.next = this.head;
      if (this.head != null) {
        // 데이터가 0개일 때 에러가 나지 않도록 추가
        this.head.prev = newNode; // head가 가리키는 노드의 이전 노드를 새로운 노드로 설정
      }
      this.head = newNode;
    } else if (index == this.count) {
      // 마지막 인덱스에 삽입
      newNode.next = null; // 새로운 노드의 다음 노드를 null로 설정
      newNode.prev = this.tail; // 새로운 노드의 이전 노드를 tail로 설정
      this.tail.next = newNode; // tail이 가리키던 노드의 다음 노드를 새로운 노드로 설정
    } else { // 다른 곳에 삽입
      let currentNode = this.head;

      for (let i = 0; i < index - 1; i++) {
        currentNode = currentNode.next;
      }
      newNode.next = currentNode.next; // 새로운 노드의 다음 노드를 currentNode의 다음 노드로 가리키게 설정
      newNode.prev = currentNode; // 새로운 노드의 이전 노드를 currentNode로 설정
      currentNode.next = newNode; // currentNode의 다음 노드를 새로운 노드로 설정
      newNode.next.prev = newNode; // 새로운 노드의 다음 노드의 이전 노드를 새로운 노드로 설정
    }

    if (newNode.next == null) { // 만약 새로운 노드의 다음 노드가 null이라면 새로운 노드를 tail로 설정
      this.tail = newNode;
    }
    this.count++;
  }

  insertLast(data) {
    this.insertAt(this.count, data);
  }

  deleteAt(index) {
    if (index >= this.count || index < 0) {
      throw new Error("제거할 수 없습니다.");
    }

    let currentNode = this.head;

    if (index == 0) { // 첫 번째 요소를 삭제할 때
      let deletedNode = this.head; 
      if (this.head.next == null) { // 데이터 1개 요소 삭제
        this.head = null;
        this.tail = null;
      } else { // 데이터 2개 이상의 요소 삭제
        this.head = this.head.next;
        this.head.prev = null;
      }
      this.count--;
      return deletedNode;
    } else if (index == this.count - 1) { // 마지막 요소 삭제
      let deletedNode = this.tail; // tail 노드를 삭제할 노드로 설정
      this.tail.prev.next = null; // tail의 이전 노드의 다음 노드를 null로 설정 
      this.tail = this.tail.prev; // tail을 tail의 이전 노드로 설정
      this.count--;
      return deletedNode; // 삭제할 노드 리턴
    } else {
      for (let i = 0; i < index - 1; i++) {
        currentNode = currentNode.next;
      }

      let deletedNode = currentNode.next; // 삭제할 노드를 현재 노드의 다음 노드로 설정
      currentNode.next = currentNode.next.next; // 현재 노드의 다음 노드를 현재 노드의 다음의 다음 노드로 설정
      currentNode.next.prev = currentNode; // 현재 노드의 다음 노드의 이전 노드를 현재 노드로 설정
      this.count--;
      return deletedNode;
    }
  }

  deleteLast() {
    return this.deleteAt(this.count - 1);
  }

  getNodeAt(index) {
    if (index >= this.count || index < 0) {
      throw new Error("범위를 넘어갔습니다.");
    }

    let currentNode = this.head;
    for (let i = 0; i < index; i++) {
      currentNode = currentNode.next;
    }

    return currentNode;
  }
}

export { Node, DoublyLinkedList };
```

# 큐 구현 예제
이중 연결리스트를 기반으로 큐 구현, 구현 전에 에 필요한 추상 자료형 정의

enqueue - 큐에 삽입
dequeue - 큐 요소 삭제
front - 가장 먼저 들어간 데이터 참조 (tail)
isEmpty - 비었는지 확인

