# 연결 리스트
각 `노드` 가 데이터와 포인터를 가지고 한 줄로 연결되어 있는 방식으로 데이터를 저장하는 자료 구조

`노드` : 데이터를 담는 변수 + 다음 노드를 가리키는 변수

데이터가 필요하다면 필요한 데이터만큼 노드를 만들어 데이터를 저장하고 다음 노드를 가리켜 연결한다. 연결 리스트는 첫 번째 노드의 주소만 알면 다른 모든 노드에 접근할 수 있다.
- 장점: 크기가 동적으로 조절 가능하며, 요소의 삽입 및 삭제가 효율적이다.
- 단점: 특정 위치의 요소에 직접적으로 액세스할 수 없으며, 탐색 시간이 더 걸릴 수 있다. 또한 메모리 공간을 더 차지한다.

### 배열과 비교
- 배열: 크기가 고정, 연속된 공간에 할당, O(1)
- 연결 리스트: 크기가 동적, 불연속적, O(n)
- 삽입과 삭제는 둘 다 O(n)의 성능을 가짐

### 연결 리스트 구현
`추상 자료형 (Abstract Data Types)` : 기능의 구현 부분을 나타내지 않고 순수한 기능이 무엇인지 나열한 것, 대표적인 예시로 제품 설명서 (기능과 사용 방법만 정의되어 있고, 내부 구현은 설명하지 않음)가 있다.

연결리스트의 추상자료형
1. 모든 데이터 출력
2. 모든 데이터 제거
3. 원하는 인덱스에 데이터 삽입
4. 마지막 데이터 뒤에 데이터 삽입
5. 원하는 인덱스의 데이터 삭제
6. 마지막 데이터 삭제
7. 원하는 인덱스 데이터 읽기

### 원하는 인덱스에 데이터 삽입 

```
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
```
1. newNode를 통해 새로운 노드의 데이터를 설정한다.
2. 리스트의 가장 앞 부분에 삽입할 때: 이럴 때는 새로 삽입하는 노드가 head가 되어야 하므로
![1](https://github.com/skcy1515/Programming-Study/assets/140364849/6e82f85d-2797-4060-8489-87973eb0d5bc)

새로 생성한 노드의 next가 head (처음 노드)를 가리키게 하고,
   
```
newNode.next = this.head;
```
   
![2](https://github.com/skcy1515/Programming-Study/assets/140364849/5eee67b7-2f99-4017-a0a8-541f2c377563)

새로 생성한 노드를 head로 변경하면 된다.
      
```
this.head = newNode;
```
        
3. 리스트의 원하는 인덱스에 삽입할 때: 만약 인덱스 3에 삽입할 경우

![3](https://github.com/skcy1515/Programming-Study/assets/140364849/fc827e90-b73c-4287-a4ad-321101cadb7f)

currentNode를 head (처음 노드)로 설정하고 세 번째 떨어진 노드 전까지 이동한다.
```
let currentNode = this.head; // 현재 노드를 리스트의 헤드로 설정

for (let i = 0; i < index - 1; i++) {
// 삽입할 인덱스 직전까지 반복하여 현재 노드를 찾기
    currentNode = currentNode.next;
}
```
![4](https://github.com/skcy1515/Programming-Study/assets/140364849/af2f9a20-912f-4b25-9905-1cc03d823591)

그리고 newNode가 currentNode가 가리키던 노드, 즉 세 번째 노드를 가리키게 하고, currentNode가 newNode를 가리키게 하면 끝난다
```
newNode.next = currentNode.next; // 새로운 노드의 next를 현재 노드의 next로 설정하여 새로운 노드가 현재 노드 다음을 가리키도록 함
currentNode.next = newNode; //  현재 노드의 next를 새로운 노드로 설정하여 현재 노드가 새로운 노드를 가리키도록 함
```

### 원하는 인덱스 데이터 삭제
```
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
```
1. currentNode를 헤드 (시작 노드)로 설정한다.
2. 인덱스가 0인 경우:

![5](https://github.com/skcy1515/Programming-Study/assets/140364849/23c6ae80-9ea9-4b3a-925e-8c9f6be64f8d)

deleteNode를 헤드로 설정한 후 헤드를 헤드가 가리키는 곳 (다음 노드)로 설정한다. 즉, 원래 있던 헤드는 삭제되어 deleteNode로 반환된다.
```
let deleteNode = this.head;
this.head = this.head.next;
this.count--;
return deleteNode;
```

3. 원하는 인덱스 제거 시:

![6](https://github.com/skcy1515/Programming-Study/assets/140364849/02724ba0-ac32-459b-95e6-a977f0e7c937)

currentNode를 제거할 인덱스 직전까지 이동한 후 deleteNode를 currentNode.next로 currentNode가 가리키는 곳으로 설정한다. 그리고 currentNode를 제거할 노드의 next 노드를 가리키게 한다.
```
for (let i = 0; i < index - 1; i++) {
    currentNode = currentNode.next;
}
let deleteNode = currentNode.next;
currentNode.next = currentNode.next.next;
this.count--;
return deleteNode;
```
