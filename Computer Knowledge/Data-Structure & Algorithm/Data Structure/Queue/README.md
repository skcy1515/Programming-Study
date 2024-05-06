# 큐
큐는 선입선출(FIFO, Last In, First Out)의 원리를 따른다. 이것은 가장 먼저 추가된 데이터가 가장 먼저 제거되는 구조를 말한다.

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/9521f591-88b9-495d-9120-ada16812d65b)

데이터 1, 2, 3, 4를 순서대로 삽입하면 삽입 데이터는 head로, 즉 가장 앞부분으로 한다. 그리고 제거할 때는 가장 뒤에서부터 데이터를 제거하면 된다.

하지만 단방향 연결리스트로는 데이터를 뒤에서 제거하기 힘들다. (정확히는 head에서부터 가장 뒤에있는 데이터까지 이동해야 하므로 O(n)의 성능이 나와 느리다.) 

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/1ebd9dde-77b7-4e8d-a21d-20ac1ac4c13b)

성능을 위해서 tail이라는 변수를 하나 더 만들어준다. head는 가장 앞에 있는 노드를 가리키고, tail은 가장 뒤에 있는 노드를 가리킨다. 이렇게 되면 tail을 이용해서 데이터를 O(1)의 성능으로 제거할 수 있다. 

그래도 tail이 삭제되기 이전 노드를 가리킬려면 head에서부터 다시 찾아야 하는 과정은 동일하므로 결국 O(n)의 성능을 가지게 된다. 따라서 연결리스트를 이중연결리스트로 수정한다.

### 이중 연결리스트