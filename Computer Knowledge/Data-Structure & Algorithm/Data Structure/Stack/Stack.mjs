class Node {
  // 노드 생성 클래스
  constructor(data, next = null) {
    this.data = data;
    this.next = next; // 노드 생성 시 다음 위치를 null 초기화
  }
}

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

class LinkedList {
  // 연결 리스트 생성 클래스
  constructor() {
    this.head = null; // 연결리스트의 시작 노드
    this.count = 0; // 총 저장된 노드의 수
  }

  printAll() {
    // 연결 리스트의 요소 출력 함수
    let currentNode = this.head; // 현재 노드를 리스트의 헤드로 설정

    while (currentNode != null) {
      // 마지막 노드까지 반복
      console.log(currentNode.data);
      currentNode = currentNode.next;
    }
  }

  clear() {
    // 연결 리스트 요소 전부 삭제하는 함수
    this.head = null; // 연결 리스트의 모든 노드에 대한 참조 끊기
    this.count = 0; // 노드 총 개수 0으로 설정
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
    // 노드 삭제하는 함수
    if (index > this.count || index < 0) {
      throw new Error("범위를 넘어갔습니다.");
    }
    let currentNode = this.head;

    if (index == 0) {
      // 앞 부분에 삽입할 경우
      let deleteNode = this.head; // deleteNode를 헤드로 설정
      this.head = this.head.next; // 헤드를 다음 헤드가 가리키는 곳 (다음 노드)로 설정
      this.count--;
      return deleteNode; // 원래 있던 헤드는 삭제되어 deleteNode로 반환
    } else {
      for (let i = 0; i < index - 1; i++) {
        currentNode = currentNode.next; // 삭제할 인덱스 직전까지 이동
      }
      let deleteNode = currentNode.next; //deleteNode를 currentNode.next가 가리키는 곳으로 설정
      currentNode.next = currentNode.next.next; // currentNode.next를 currentNode.next.next가 가리키는 곳 (다다음 노드)로 설정
      this.count--;
      return deleteNode; // 원래 있던 currentNode.next는 삭제되어 deleteNode로 반환
    }
  }

  deleteLast() {
    // 데이터 마지막 노드 삭제하는 함수
    return this.deleteAt(this.count - 1);
  }

  getNodeAt(index) {
    // 인덱스의 데이터 조회하는 함수
    if (index > this.count || index < 0) {
      throw new Error("범위를 넘어갔습니다.");
    }

    let currentNode = this.head;
    for (let i = 0; i < index; i++) {
      // 인덱스까지 반복
      currentNode = currentNode.next;
    }
    return currentNode;
  }
}

export { Stack };
