class Node {
  constructor(data, next = null) {
    this.data = data;
    this.next = next;
  }
}

class LinkedList {
  constructor() {
    this.head = null; // 연결리스트의 시작 노드
    this.count = 0; // 총 저장된 노드의 수
  }

  printAll() {
    let currentNode = this.head;

    while (currentNode != null) {
      console.log(currentNode.data);
      currentNode = currentNode.next;
    }
  }

  clear() {
    this.head = null;
    this.count = 0;
  }

  insertAt(index, data) {
    // 원하는 인덱스에 데이터 삽입
    if (index > this.count || index < 0) {
      // 연결리스트의 크기보다 큰 곳에 삽입하거나, 음수 위치에 삽입 불가
      throw new Error("범위를 넘어갔습니다.");
    }

    let newNode = new Node(data); // 새로 삽입할 노드 생성

    if (index == 0) {
      // 리스트의 가장 앞부분에 삽입할 경우
      newNode.next = this.head; // 새로운 노드의 next를 현재의 헤드 노드로 설정하여 새로운 노드가 첫 번째 노드를 가리키도록 함
      this.head = newNode; // 리스트의 헤드를 새로운 노드로 변경
    } else {
      // 인덱스가 0이 아닐 경우 삽입할 위치까지 이동해야 함
      let currentNode = this.head; // 현재 노드를 리스트의 헤드로 설정

      for (let i = 0; i < index - 1; i++) {
        // 삽입할 인덱스 직전까지 반복하여 현재 노드를 찾기
        currentNode = currentNode.next;
      }
      newNode.next = currentNode.next; // 새로운 노드의 next를 현재 노드의 next로 설정하여 새로운 노드가 현재 노드 다음을 가리키도록 함
      currentNode.next = newNode; //  현재 노드의 next를 새로운 노드로 설정하여 현재 노드가 새로운 노드를 가리키도록 함
    }
    this.count++; // 총 노드 수 증가
  }

  insertLast(data) {
    // 데이터 마지막 뒤에 노드 삽입
    this.insertAt(this.count, data);
  }

  deleteAt(index) {
    if (index > this.count || index < 0) {
      throw new Error("범위를 넘어갔습니다.");
    }
    let currentNode = this.head;

    if (index == 0) {
      let deleteNode = this.head;
      this.head = this.head.next;
      this.count--;
      return deleteNode;
    } else {
      for (let i = 0; i < index - 1; i++) {
        currentNode = currentNode.next;
      }
      let deleteNode = currentNode.next;
      currentNode.next = currentNode.next.next;
      this.count--;
      return deleteNode;
    }
  }

  deleteLast() {
    return this.deleteAt(this.count - 1);
  }

  getNodeAt(index) {
    if (index > this.count || index < 0) {
      throw new Error("범위를 넘어갔습니다.");
    }

    let currentNode = this.head;
    for (let i = 0; i < index; i++) {
      currentNode = currentNode.next;
    }
    return currentNode;
  }
}

export { Node, LinkedList };
