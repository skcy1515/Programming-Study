# HTTP
HTTP (Hyper Text Transfer Protocol) 인터넷에서 데이터를 주고받는 데 사용되는 프로토콜이다.

주로 웹 브라우저와 웹 서버 간에 데이터를 전송하는 데 사용되며, 웹 페이지를 요청하고 전송하는 데 사용된다.

HTTP가 전송하는 것들에는 다음과 같은 것들이 있다.
- HTML, TEXT
- IMAGE, 음성, 영상, 파일
- JSON, XML (API)

거의 모든 형태의 데이터가 전송이 가능하고, 서버간에 데이터를 주고 받을 때도 대부분 HTTP 사용된다.

### HTTP 역사
- `HTTP/0.9` 1991년: GET 메서드만 지원, HTTP 헤더X
- `HTTP/1.0` 1996년: 메서드, 헤더 추가
- `HTTP/1.1` 1997년: 가장 많이 사용, 우리에게 가장 중요한 버전 (TCP 사용)
- `HTTP/2` 2015년: 성능 개선 (TCP 사용)
- `HTTP/3` 진행중: TCP 대신에 UDP 사용, 성능 개선

### HTTP 특징
1. `클라이언트-서버 구조` : 클라이언트는 HTTP 요청을 보내고 서버는 요청을 받아들여 적절한 응답을 반환한다.
2. `무상태 (Stateless) 프로토콜` : 서버가 클라이언트의 상태를 보존하지 않는다. 서버의 확장성에 용이하다는 장점이 있지만, 클라이언트가 추가 데이터를 전송해야 하는 단점이 있다.
   - `상태 유지(Stateful)` : 클라이언트의 요청1에 대한 상태를 해당 요청을 받은 서버A가 기억하고 있는 것. 만약 서버A에서 장애가 난다면 유지되던 상태 정보가 없어져 버리므로 처음부터 다시 요청을 해야한다.
   - 무상태 프로토콜이라면 클라이언트 요청1을 보낼 때, 데이터를 다 담아서 보내기 때문에 아무 서버나 호출할 수 있다. 무상태는 응답 서버를 쉽게 바꿀 수 있기 때문에 무한한 서버 증설이 가능하다.
   - 상태 유지는 로그인같은 곳에 쓰이고, 무상태는 로그인이 필요 없는 단순한 서비스 소개 화면같은 곳에 쓰인다.
3. `비 연결성(connectionless)` : 서버와 클라이언트 사이의 연결을 계속 유지하지 않는다. 서버는 클라이언트 요청에 응답하고 나면 연결을 끊어버린다. 이렇게 함으로써 서버의 자원을 최적화 하고, 많은 클라이언트의 요청을 동시에 처리할 수 있다.
   - 한계 : TCP/IP 연결 (3 way handshaking 시간 추가)을 새로 맺어야 하고, 웹 브라우저로 사이트를 요청하면 HTML 뿐만 아니라 자바스크립트, css, 추가 이미지 등 수 많은 자원들을 다운로드 해야한다.
   - HTTP 초기 : 연결, HTML 응답, 종료, 연결, 자바스크립트 응답, 종료, 연결, 이미지 응답, 종료 총 0.9초)
   - 지금은 `HTTP 지속 연결` (클라이언트와 서버 간의 여러 HTTP 요청과 응답을 하나의 TCP 연결을 통해 처리하는 기술)로 문제 해결 -> 연결, HTML 응답, 자바스크립트 응답, 이미지 응답, 종료 총 0.5초, 또한 HTML 2, 3으로 발전하면서 더 많은 최적화가 이루어지고 있음
  
# HTTP 메시지
HTTP 메시지 구조는 다음과 같이 이루어져 있다.
- start-line 시작 라인
- header 헤더
- empty line 공백 라인 (CRLF)
- message body

ex) 요청 메시지
```
GET /search?q=hello&hl=ko HTTP/1.1
Host: www.google.com

 ```

ex) 응답 메시지
```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
Content-Length: 3423 message body

<html>
   <body>...</body>
</html>
```

### 시작 라인
시작 라인은 요청 메시지(Request-Line)와 응답 메시지(Status-Line)으로 나누어져 있다.

`요청 메시지 (Request-Line)` = method SP(공백) request-target SP HTTP-version CRLF(엔터)
```
GET /search?q=hello&hl=ko HTTP/1.1
```
- HTTP 메서드 (GET: 조회, POST: 요청 내역 처리)
- 요청 대상 (/search?q=hello&hl=ko), 절대경로 "/"로 시작
- HTTP Version

`응답 메시지 (Status-Line)` = HTTP-version SP status-code SP reason-phrase CRLF
```
HTTP/1.1 200 OK
```
- HTTP 버전
- HTTP 상태 코드: 요청 성공, 실패를 나타냄
   - 200: 성공
   - 400: 클라이언트 요청 오류
   - 500: 서버 내부 오류
- 이유 문구: 사람이 이해할 수 있는 짧은 상태 코드 설명 글

### 헤더
HTTP 전송에 필요한 모든 부가정보
- ex) 메시지 바디의 내용, 메시지 바디의 크기, 압축, 인증, 요청 클라이언트(브라우저) 정보, 서버 애플리케이션 정보, 캐시 관리 정보...
```
// 요청 메시지 헤더
Host: www.google.com

// 응답 메시지 헤더
Content-Type: text/html;charset=UTF-8
Content-Length: 3423 message body
```

### 메시지 바디
용도
- 실제 전송할 데이터
- HTML 문서, 이미지, 영상, JSON 등등 byte로 표현할 수 있는 모든 데이터 전송 가능
```
<html>
   <body>...</body>
</html>
```
