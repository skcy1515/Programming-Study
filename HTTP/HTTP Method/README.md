# HTTP 메서드
HTTP 메서드는 클라이언트가 서버에게 어떤 동작을 수행할 것인지를 나타내는 방식이다.

API URI(Uniform Resource Identifier)를 설계할 때 가장 중요한 것은 리소스 식별이다.
- 회원 목록 조회 /members
- 회원 조회 /members/{id} -> 어떻게 구분하지?
- 회원 등록 /members/{id} -> 어떻게 구분하지?
- 회원 수정 /members/{id} -> 어떻게 구분하지?
- 회원 삭제 /members/{id} -> 어떻게 구분하지?

리소스 - 회원이라는 개념 자체가 바로 리소스, 회원을 등록하고 수정하고 조회하는 것을 모두 배제하고 회원 리소스를 URI에 매핑

리소스와 행위을 분리
	- 리소스: 회원
	- 행위: 조회, 등록, 삭제, 변경
그런데 행위(메서드)는 어떻게 구분할까?

### HTTP 주요 메서드
- GET: 리소스 조회
- POST: 요청 데이터 처리, 주로 등록에 사용
- PUT: 리소스를 대체, 해당 리소스가 없으면 생성
- PATCH: 리소스 부분 변경
- DELETE: 리소스 삭제

### GET
리소스를 조회하는데 사용

요청 메시지
```
GET /members/100 HTTP/1.1
Host: localhost:8080

```
응답 메시지
```
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 34

{
 "username": "young",
 "age": 20
}
```

(HEAD: GET과 동일하지만 메시지 부분을 제외하고, 상태 줄과 헤더만 반환)

### POST
요청 데이터 처리, 리소스를 생성하거나 업데이트하는 데 사용, 메시지 바디를 통해 서버로 요청 데이터 전달

요청 메시지 (member 추가)
```
POST /members HTTP/1.1
Content-Type: application/json

{
 "username": "young",
 "age": 20
}
```
응답 메시지
```
HTTP/1.1 201 Created
Content-Type: application/json
Content-Length: 34
Location: /members/100 // 자원이 생성된 경로

{
 "username": "young",
 "age": 20
}
```

POST는 다음과 같은 기능에 사용된다.
- HTML 양식에 입력 된 필드와 같은 데이터 블록을 데이터 처리 프로세스에 제공
  - 예) HTML FORM에 입력한 정보로 회원 가입, 주문 (결제완료 -> 배달시작 -> 배달완료 처럼 단순히 값 변경을 넘어 프로세스의 상태가 변경되는 경우) 등에서 사용
- 게시판, 뉴스 그룹, 메일링 리스트, 블로그 또는 유사한 기사 그룹에 메시지 게시
  - 예) 게시판 글쓰기, 댓글 달기
- 서버가 아직 식별하지 않은 새 리소스 생성
  - 예) 신규 주문 생성
- 기존 자원에 데이터 추가
  - 예) 한 문서 끝에 내용 추가하기

### PUT
리소스를 대체, 쉽게 이야기해서 덮어버림
- 리소스가 있으면 완전 대체 
- 리소스가 없으면 생성

클라이언트가 리소스를 식별
- 클라이언트가 리소스 위치를 알고 URI 지정 (POST: /members, PUT: /members/100)
- POST와 차이점
```
PUT /members/100 HTTP/1.1
Content-Type: application/json

{
 "username": "hello",
 "age": 20
}
```

주의! 리소스를 완전히 대체함
```
PUT /members/100 HTTP/1.1
Content-Type: application/json

{
 "age": 50
}
```
```
// members/100
{
 "username": "young",
 "age": 20
}
```
실행 후
```
{
 "age": 50
}
```
### PATCH
리소스 부분을 변경함

### DELETE
리소스를 제거함

# HTTP 메시지 속성
1. 안전: 호출해도 리소스를 변경하지 않는다. (GET, HEAD)

2. 멱등: 한 번 호출하든, 두 번 호출하든 결과가 똑같다.
  - GET: 한 번 조회하든, 두 번 조회하든 같은 결과가 조회된다.
  - PUT: 결과를 대체한다. 따라서 같은 요청을 여러번 해도 최종 결과는 같다.
  - DELETE: 결과를 삭제한다. 같은 요청을 여러번 해도 삭제된 결과는 똑같다.
  - POST: 멱등이 아니다! 두 번 호출하면 같은 결제가 중복해서 발생할 수 있다.
  - 활용: 자동 복구 매커니즘 서버가 TIMEOUT 등으로 정상 응답을 못주었을 때, 클라이언트가 같은 요청을 다시 해도 되는가? 판단 근거

3. 캐시 가능
- 응답 결과 리소스를 캐시해서 사용해도 되는가?
- GET, HEAD, POST, PATCH 캐시가능
- 실제로는 GET, HEAD 정도만 캐시로 사용
