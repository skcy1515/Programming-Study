이 글은 인프런 김영한님의 `모든 개발자를 위한 HTTP 웹 기본 지식` 강의를 바탕으로 개인적인 정리를 위해 작성한 글입니다.

# HTTP 상태 코드
클라이언트가 보낸 요청의 처리 상태를 응답에서 알려주는 기능

### 1xx (Informational)
요청이 수신되어 처리중
### 2xx (Successful)
클라이언트의 요청을 성공적으로 처리
- 200 OK
- 201 Created 요청 성공해서 새로운 리소스가 생성됨
- 202 Accepted 요청이 접수되었으나 처리가 완료되지 않았음
  - 배치 처리 같은 곳에서 사용
  - 예) 요청 접수 후 1시간 뒤에 배치 프로세스가 요청을 처리함
- 204 No Content 서버가 요청을 성공적으로 수행했지만, 응답 페이로드 본문에 보낼 데이터가 없음
  - 예) 웹 문서 편집기에서 save 버튼
  - save 버튼의 결과로 아무 내용이 없어도 된다.
  - save 버튼을 눌러도 같은 화면을 유지해야 한다.
  - 결과 내용이 없어도 204 메시지(2xx)만으로 성공을 인식할 수 있다.

### 3xx (Redirection)
요청을 완료하기 위해 유저 에이전트의 추가 조치 필요

웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면, Location 위치로 자동 이동 (리다이렉트)

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/fad679dc-cd12-4e59-8f8f-b3554f9485b5)

### 리다이렉션 종류
- 영구 리다이렉션: 특정 리소스의 URI가 영구적으로 이동
  - 예: /members -> /users
- 일시 리다이렉션: 일시적인 변경
  - 주문 완료 후 주문 내역 화면으로 이동
  - PRG: Post/Redirect/Get
- 특수 리다이렉션: 결과 대신 캐시 사용

### 영구 리다이렉션
301, 308
- 리소스의 URI가 영구적으로 이동
- 원래의 URL를 사용X, 검색 엔진 등에서도 변경 인지
- **301 Moved Permanently**
  - 리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음(MAY)
- **308 Permanent Redirect**
  - 301과 기능은 같음
  - 리다이렉트시 요청 메서드와 본문 유지(처음 POST를 보내면 리다이렉트도 POST 유지)

### 리다이렉션 301
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/b56fe064-a687-4853-8f37-cb0a22059bac)

1. 요청
```
POST /event HTTP/1.1
Host: localhost:8080
name=hello&age=20
```
2. 응답
```
HTTP/1.1 301 Moved Permanently
Location: /new-event 
```
3. 리다이렉션, 요청 (메시지 바디 삭제)
```
GET /new-event HTTP/1.1
Host: localhost:8080
```

### 리다이렉션 308
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/87aee8c8-da17-4c42-86d9-a7adf2fb3d65)

1.요청
```
POST /event HTTP/1.1
Host: localhost:8080
name=hello&age=20
```
2.응답
```
HTTP/1.1 308 Permanent Redirect
Location: /new-event 
```
3.리다이렉션, POST와 메시지 바디 유지
```
POST /new-event HTTP/1.1
Host: localhost:8080
name=hello&age=20
```

### 일시 리다이렉션
302, 307, 303
- 리소스의 URI가 일시적으로 변경
- 따라서 검색 엔진 등에서 URL을 변경하면 안됨
- **302 Found**
  - 리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음(MAY)
- **307 Temporary Redirect**
  - 302와 기능은 같음
  - 리다이렉트시 요청 메서드와 본문 유지(요청 메서드를 변경하면 안된다. MUST NOT)
- **303 See Other**
  - 302와 기능은 같음
  - 리다이렉트시 요청 메서드가 GET으로 변경

**PRG: Post/Redirect/Get**
- POST로 주문후에 웹 브라우저를 새로고침하면?
- 새로고침은 다시 요청
- 중복 주문이 될 수 있다.

### RPG - 예시
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/40461238-812e-4142-b6fd-0ce3b9e57e25)

보통 302, 303 상태 코드를 사용

1. 요청
```
POST /order HTTP/1.1
Host: localhost:8080

itemId=mouse&count=1
```
2. DB에 주문 데이터 저장

3. 응답
```
HTTP/1.1 302 Found
Location: /order-result/19 
```
4. 자동 리다이렉트

5. 요청 (PRG로 인해 POST가 GET 메서드로 바뀜)
```
GET /order-result/19 HTTP/1.1
Host: localhost:8080
```
6. 주문 데이터 조회 19번 주문

7. 응답
```
HTTP/1.1 200 OK
<html>주문완료</html>
```
8. 결과 화면에서 새로고침하면 GET /order-result/19, 결과 화면만 다시 요청(5번으로 이동)

**PRG 이후 리다이렉트**
- URL이 이미 POST -> GET으로 리다이렉트 됨
- 새로 고침 해도 GET으로 결과 화면만 조회

정리하자면
- 302 Found -> GET으로 변할 수 있음
- 307 Temporary Redirect -> 메서드가 변하면 안됨
- 303 See Other -> 메서드가 GET으로 변경
- 307, 303을 권장하지만 현실적으로 이미 많은 애플리케이션 라이브러리들이 302를 기본값으로 사용
- 자동 리다이렉션시에 GET으로 변해도 되면 그냥 302를 사용해도 큰 문제 없음

**304 Not Modified**
- 캐시를 목적으로 사용
- 클라이언트에게 리소스가 수정되지 않았음을 알려준다. 따라서 클라이언트는 로컬PC에 저장된 캐시를 재사용한다. (캐시로 리다이렉트 한다.)
- 304 응답은 응답에 메시지 바디를 포함하면 안된다. (로컬 캐시를 사용해야 하므로)
- 조건부 GET, HEAD 요청시 사용

### 4xx (Client Error)
클라이언트 오류, 잘못된 문법등으로 서버가 요청을 수행할 수 없음
- 400 Bad Request
  - 클라이언트가 잘못된 요청을 해서 서버가 요청을 처리할 수 없음
  - 예) 요청 파라미터가 잘못되거나, API 스펙이 맞지 않을 때
- 401 Unauthorized
  - 클라이언트가 해당 리소스에 대한 인증이 필요함

- 403 Forbidden
  - 서버가 요청을 이해했지만 승인을 거부함
  - 주로 인증 자격 증명은 있지만, 접근 권한이 불충분한 경우
    - 예) 어드민 등급이 아닌 사용자가 로그인은 했지만, 어드민 등급의 리소스에 접근하는 경우
- 404 Not Found
  - 요청 리소스를 찾을 수 없음, 요청 리소스가 서버에 없음
  - 또는 클라이언트가 권한이 부족한 리소스에 접근할 때 해당 리소스를 숨기고 싶을 때

### 5xx (Server Error)
서버 오류, 서버가 정상 요청을 처리하지 못함
- 500 Internal Server Error
  - 서버 문제로 오류 발생, 애매하면 500 오류
- 503 Service Unavailable
  - 서비스 이용 불가
  - 서버가 일시적인 과부하 또는 예정된 작업으로 잠시 요청을 처리할 수 없음

