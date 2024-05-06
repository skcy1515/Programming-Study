import { DoublyLinkedList } from "./DoublyLinkedList.mjs";

class Queue {
  constructor() {
    this.list = new DoublyLinkedList();
  }

  enqueue(data) {
    // 데이터 앞 부분에 삽입
    this.list.insertAt(0, data);
  }

  dequeue() {
    // 가장 마지막 데이터 삭제
    try {
      return this.list.deleteLast();
    } catch (e) {
      return null;
    }
  }

  front() {
    return this.list.tail;
  }

  isEmpty() {
    return this.list.count == 0;
  }
}

export { Queue };
