# 데드락 (교착 상태)
여러 프로세스가 서로 다른 프로세스의 작업이 끝나기를 기다리다가 아무도 작업을 진행하지 못하는 상태를 교착상태라고 한다. 교착상태가 발생하는 이유는 공유자원 때문이다. 만약 어떤 자원을 여러 개의 프로세스가 공유하지 않는다면 교착상태는 발생하지 않는다.

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/102ed67c-8f41-4c4b-b726-a06cf413982e)

교착상태를 설명하는 가장 유명한 예시 식사하는 철학자이다. 원형으로 된 탁자에 맛있는 음식이 준비되어 있고 의자가 세 개 놓여져 있다. 철학자 3명은 각자 자리에 앉아서 음식을 먹으려 하는데 포크가 세 개 밖에 없다. 음식을 먹으려면 포크를 2개 사용해야 한다.

음식을 먹으려는 철학자는 좌우에 있는 포크를 집어서 음식을 먹는다. 그 동안 다른 철학자는 음식을 먹지 않고 깊은 생각을 한다. 이렇게만 식사가 이루어지면 아무 문제가 없을 것 같지만

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/388fe5dc-6299-47f8-84f6-d850415aedb4)

우연히 철학자 3명이 동시에 자기 오른쪽에 있는 포크를 집었다. 모든 철학자가 포크 하나가 더 필요한 상황이고 아무도 양보를 하지 않아 더 이상 식사가 불가능한 교착상태에 빠진다. 

### 교착상태의 필요조건
필요조건에는 4가지가 있는데 이 중 하나라도 충족하지 않는다면 교착상태는 발생하지 않는다.

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/a5ed97d7-956c-4983-97bf-89232efb230c)

- 상호배제: 어떤 프로세스가 한 리소스를 점유했다면 그 리소스는 다른 프로세스에게 공유가 되면 안 된다. (리소스는 포크)
- 비선점: 프로세스 A가 리소스를 점유하고 있는데 프로세스 B가 리소스를 빼앗을 수 없어야 한다. 
- 점유와 대기: 어떤 프로세스가 리소스 A를 가지고 있는 상태에서 리소스 B를 원하는 상태여야 한다. (포크를 원함)
- 원형대기: 점유와 대기를 하는 프로세스들의 관계가 원형을 이루고 있음 (원형 탁자)

# 교착상태 회피
교착상태 해결법으로 교착상태 회피라는 방법이 있다. 프로세스들에게 자원을 할당할 때 어느정도 자원을 할당해야 교착상태가 발생하는지 파악해서 교착상태가 발생하지 않는 수준의 자원 할당을 한다.

교착상태 회피는 전체 자원의 수와 할당된 자원의 수를 기준으로 `안정 상태`와 `불안정 상태`로 나눈다. 운영체제는 안정 상태를 최대한 유지하려고 자원 할당을 하고 불안정 상태에 있다고 해서 꼭 데드락이 일어나는 건 아니고 확률이 높아진다.

교착상태 회피를 표현한 알고리즘에는 은행원 알고리즘이 있다.

1. 은행이 돈이 1000만원이 있다고 가정, 사업가 A는 은행에서 500만원을 빌림. 사업가 B는 은행에서 400만원을 빌림.
2. 시간이 지나서 은행은 사업가 A에게 돈을 갚으라고 말하는데 사업가A는 지금은 갚지 못하고 200만원만 더 빌려주면 그걸로 돈을 벌어서 갚는다고 말함. 그러나 은행은 100만원밖에 없기 때문에 사업가 B에게 돈을 받아서 사업가 A에게 200만원을 빌려주려고 함. 그래서 사업가 B에게 돈을 갚으라고 말했는데 사업가 B도 지금은 갚을 수 없고 200만원만 더 빌려주면 그걸로 돈을 벌어서 갚는다고 함.
3. 은행은 누구에게도 돈을 빌려줄 수 없고, 빌려준 돈도 받지도 못 하는 교착상태에 빠짐. 은행은 이러한 상황을 피하기 위해서 사업가들에게 돈을 빌려줄 때 은행의 여윳돈과 사업가들에게 빌려준 돈들을 보고 대출 가능한 상황(안정상태)인지 확인하고 빌려주는데 이것을 은행원 알고리즘이라고 함.

### 운영체제가 은행원 알고리즘을 구현하는 방법
운영체제는 프로세스들에게 자원을 할당하기 전에 자기가 가지고 있는 전체 자원의 수를 알아야 함 (시스템의 총 자원) 그리고 프로세스들은 각자 자기가 필요한 자원의 최대 숫자를 운영체제에게 알려줘야 함 (최대 요구 자원)

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/1d9ac9ba-a1cf-4e57-90a4-0c5a62e0fb27)

### 안정상태
- 시스템의 총 자원은 14개
- P1의 최대 요구 자원은 9개, 현재 5개가 할당, P2의 최대 요구 자원은 6개, 현재 4개가 할당. P3의 최대 요구 자원은 4개, 현재 3개가 할당
- 프로세스들에게 할당된 자원을 모두 합치면 12개이고 현재 사용 가능한 자원이 2개가 남음
- 여기서 은행원 알고리즘은 각 프로세스가 현재 요구할 수 있는 요청이 예상되는 자원을 구함 (P1 -> 4개, P2 -> 2개, P3 -> 1개)
- 만약 P1이 4개를 요청하면 현재 사용 가능한 자원은 2개이기 때문에 P1의 요청을 거부하고 P2의 요청을 받음
- P2가 2개를 요청했기 때문에 사용 가능한 자원 2개를 전부 P2에게 할당하고 P2는 할당된 자원을 가지고 작업을 마치고 6개를 반납함
- 그럼 사용 가능한 자원이 6개로 늘어났기 때문에 P1, P3이 요청한 자원을 전부 할당할 수 있음

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/bf709360-b3bc-411f-a1a2-3eda67d9b038)

### 불안정상태
- 사용 가능한 자원으로는 P1, P2, P3이 요청할 수 있는 최대 요청인 2개를 충족하지 못 함

은행원 알고리즘을 교착상태를 피하는 좋은 방법이지만 비용이 비싸고 비효율적이다. 그래서 교착상태의 발생은 허용하지만 교착상태가 발생했을 때 이를 해결하는 방식을 연구했다.

# 교착 상태 검출 방법
- 가벼운 교착상태 검출: 타이머를 이용하는 방식으로, 프로세스가 일정시간 동안 작업을 진행하지 않는다면 교착상태가 발생했다고 간주하고 이를 해결함.
  - 교착상태를 해결하는 방법은 일정 시점마다 체크포인트를 만들어 작업을 저장하고 타임아웃으로 교착상태가 발생했다면 마지막으로 저장했던 체크포인트로 롤백
- 무거운 교착상태 검출: 자원 할당 그래프를 이용하는 방식으로, 현재 운영체제에서 프로세스가 어떤 자원을 사용하는지 지켜보고 교착상태가 발생하면 이를 해결함

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/4bcf3ef8-5432-411d-b5b1-6deb7e980085)

왼쪽 그래프는 순환구조가 아니기 때문에 교착상태가 일어나지 않고, 오른쪽 그래프는 순환구조이기 때문에 교착상태가 발생

이렇게 교착상태를 검출했다면 교착상태를 일으킨 프로세스를 강제종료시킴. 그리고 다시 실행시킬 때 체크포인트로 롤백시킴.

이 무거운 교착상태 검출 방식은 운영체제가 지속적으로 자원 할당 그래프를 유지하고 검사해야 하기 때문에 오버헤드가 발생하지만 가벼운 교착상태 검출 방식에서 일어날 수 있는 억울하게 종료되는 프로세스는 발생하지 않음