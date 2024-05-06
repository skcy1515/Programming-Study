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
    } else {
      // 다른 곳에 삽입
      let currentNode = this.head;

      for (let i = 0; i < index - 1; i++) {
        currentNode = currentNode.next;
      }
      newNode.next = currentNode.next; // 새로운 노드의 다음 노드를 currentNode의 다음 노드로 가리키게 설정
      newNode.prev = currentNode; // 새로운 노드의 이전 노드를 currentNode로 설정
      currentNode.next = newNode; // currentNode의 다음 노드를 새로운 노드로 설정
      newNode.next.prev = newNode; // 새로운 노드의 다음 노드의 이전 노드를 새로운 노드로 설정
    }

    if (newNode.next == null) {
      // 만약 새로운 노드의 다음 노드가 null이라면 새로운 노드를 tail로 설정
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

    if (index == 0) {
      // 첫 번째 요소를 삭제할 때
      let deletedNode = this.head;
      if (this.head.next == null) {
        // 데이터 1개 요소 삭제
        this.head = null;
        this.tail = null;
      } else {
        // 데이터 2개 이상의 요소 삭제
        this.head = this.head.next;
        this.head.prev = null;
      }
      this.count--;
      return deletedNode;
    } else if (index == this.count - 1) {
      // 마지막 요소 삭제
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
