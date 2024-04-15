이 글은 인프런 김영한님의 `모든 개발자를 위한 HTTP 웹 기본 지식` 강의를 바탕으로 개인적인 정리를 위해 작성한 글입니다.

# HTTP 헤더 개요
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/170fabcd-dd58-4f3f-a42b-7d28f16fdf35)

header-field = field-name ":" OWS field-value OWS (OWS:띄어쓰기 허용)

예시
```
Host: www.google.com
```
```
Content-Type: text/html;charset=UTF-8
Content-Length: 3423
```

### 용도
HTTP 전송에 필요한 모든 부가정보
- 예) 메시지 바디의 내용, 메시지 바디의 크기, 압축, 인증, 요청 클라이언트, 서버 정보, 캐시 관리 정보...

# HTTP 분류 - RFC2616(과거)
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/02cdba46-17ce-4fa8-acc0-77e0701fd891)

엔티티 헤더
```
Content-Type: text/html;charset=UTF-8
Content-Length: 3423
```
엔티티 본문 (메시지 본문)
```
<html>
 <body>...</body>
</html>
```
- 메시지 본문(message body)은 `엔티티 본문(entity body)`을 전달하는데 사용
- `엔티티 본문`은 요청이나 응답에서 전달할 실제 데이터
- `엔티티 헤더`는 엔티티 본문의 데이터를 해석할 수 있는 정보 제공
  - 데이터 유형(html, json), 데이터 길이, 압축 정보 등등

그러나 RFC2616은 폐기되고 2014년 RFC7230~7235 등장

# HTTP 분류 - RFC723X 
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/de31877c-ab6e-4f65-bab3-6e7b469a4959)

- 엔티티(Entity) -> 표현(Representation)
- 표현 = 표현 메타데이터 + 표현 데이터

표현 헤더
```
Content-Type: text/html;charset=UTF-8
Content-Length: 3423
```
표현 데이터 (메시지 본문)
```
<html>
 <body>...</body>
</html>
```
- 메시지 본문(message body)을 통해 표현 데이터 전달
- 메시지 본문 = 페이로드(payload)
- `표현`은 요청이나 응답에서 전달할 실제 데이터
- `표현 헤더`는 표현 데이터를 해석할 수 있는 정보 제공
  - 데이터 유형(html, json), 데이터 길이, 압축 정보 등등
• 참고: 표현 헤더는 표현 메타데이터와, 페이로드 메시지를 구분해야 하지만, 여기서는 생략

# 표현
```
Content-Type: text/html;charset=UTF-8
Content-Length: 3423
```
- Content-Type: 표현 데이터의 형식
- Content-Encoding: 표현 데이터의 압축 방식
- Content-Language: 표현 데이터의 자연 언어
- Content-Length: 표현 데이터의 길이
- 표현 헤더는 전송, 응답 둘다 사용

### Content-Type
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/bff44815-25da-4325-8759-2bfa44ada878)

```
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 16

{"data":"hello"}
```
- 미디어 타입, 문자 인코딩
- 예)
  - text/html; charset=utf-8
  - application/json
  - image/png
 
### Content-Encoding
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/2262b8ea-323f-42a1-8609-f5648d1e0265)

```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
Content-Encoding: gzip
Content-Length: 521

lkj123kljoiasudlkjaweioluywlnfdo912u34lj
ko98udjkl
```
- 표현 데이터를 압축하기 위해 사용
- 데이터를 전달하는 곳에서 압축 후 인코딩 헤더 추가
- 데이터를 읽는 쪽에서 인코딩 헤더의 정보로 압축 해제
- 예)
  - gzip
  - deflate
  - identity

### Content-Language
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/8ce1a797-dae1-4210-a8b8-5da4fa6934c2)

```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
Content-Language: ko
Content-Length: 521

<html>
안녕하세요.
</html>
```
- 표현 데이터의 자연 언어를 표현
- 예)
  - ko
  - en
  - en-US
 
### Content-Length
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/3610e284-5f31-42bd-b2fc-859f3cf30002)

- 바이트 단위
- Transfer-Encoding(전송 코딩)을 사용하면 Content-Length를 사용하면 안됨

# 협상 (content negotiation)
클라이언트가 선호하는 표현 요청
- Accept: 클라이언트가 선호하는 미디어 타입 전달
- Accept-Charset: 클라이언트가 선호하는 문자 인코딩
- Accept-Encoding: 클라이언트가 선호하는 압축 인코딩
- Accept-Language: 클라이언트가 선호하는 자연 언어
- 협상 헤더는 요청시에만 사용

### 협상과 우선 순위
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/0e950438-61aa-4c40-8c73-a98b113c7d7c)

```
GET /event
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
```
- Quality Values(q) 값 사용
- 0~1, 클수록 높은 우선순위
- 생략하면 1

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/6629c3fb-0a95-407d-8347-ceee53d3ac78)

한국어 브라우저 사용 클라이언트가 요청
```
GET /event
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
```
기본 독일어, 부가적으로 영어를 지원하는 브라우저가 응답
```
Content-Language: en

Hello (영어)
```
우선순위 덕분에 독일어가 아닌 영어가 나오게 출력할 수 있음


### 협상과 우선 순위2
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/affe16c4-5c41-4ac2-9f9b-e9fbcf45331a)

```
GET /event
Accept: text/*, text/plain, text/plain;format=flowed, */*
```
- 구체적인 것이 우선한다.
- Accept: text/*, text/plain, text/plain;format=flowed, */*
1. text/plain;format=flowed
2. text/plain
3. text/*
4. */*

# 전송방식
- 단순 전송
- 압축 전송
- 분할 전송
- 범위 전송

### 단순 전송
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/38af7e3f-6b30-4423-a9b2-adc4bc9bafee)

Content-Length
```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
Content-Length: 3423

<html>
 <body>...</body>
</html>
```

### 압축 전송
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/8772b652-f377-4114-bf0a-4f66c43db26e)

Content-Encoding

서버에서 압축을 통해 용량을 줄여서 전하는 방법이다.
```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
Content-Encoding: gzip
Content-Length: 521

lkj123kljoiasudlkjaweioluywlnfdo912u34ljko98udjkl
```

### 분할 전송

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/23bc60f7-89e3-4ee7-9c77-2ba78dd4ae1a)

Transfer-Encoding

덩어리로 나눠서 보내는 방식 하나하나씩 묶어서 보낸다. 용량이 큰것을 한번에 보내면 기다려야 하는데 분할해서 전송하면 오는대로 바로바로 볼 수 있다.
```
HTTP/1.1 200 OK
Content-Type: text/plain
Transfer-Encoding: chunked

5
Hello
5
World
0
\r\n
```

### 범위 전송
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/05c695f7-9723-4cfa-a94d-d201a8ab60fa)

Range, Content-Range

이미지를 받는데 중간에 절반정도 받았다고 쳤을때 만약에 끊기면 다시 요청해야 한다. 그러면 아까우니까 범위를 지정해서 어느정도 받고 또 받는다.

요청 메시지
```
GET /event
Range: bytes=1001-2000
```
응답 메시지
```
HTTP/1.1 200 OK
Content-Type: text/plain
Content-Range: bytes 1001-2000 / 2000

qweqwe1l2iu3019u2oehj1987askjh3q98y
```

# 일반 정보
- From: 유저 에이전트의 이메일 정보
- Referer: 이전 웹 페이지 주소
- User-Agent: 유저 에이전트 애플리케이션 정보
- Server: 요청을 처리하는 오리진 서버의 소프트웨어 정보
- Date: 메시지가 생성된 날짜

### From
유저 에이전트의 이메일 정보
- 일반적으로 잘 사용되지 않음
- 검색 엔진 같은 곳에서, 주로 사용
- 요청에서 사용

### Referer
이전 웹 페이지 주소
- 현재 요청된 페이지의 이전 웹 페이지 주소
- A -> B로 이동하는 경우 B를 요청할 때 Referer: A 를 포함해서 요청
- Referer를 사용해서 유입 경로 분석 가능
- 요청에서 사용

### User-Agent
유저 에이전트 애플리케이션 정보
```
user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/
537.36 (KHTML, like Gecko) Chrome/86.0.4240.183 Safari/537.36
```
- 클라이언트의 애플리케이션 정보(웹 브라우저 정보, 등등)
- 통계 정보
- 어떤 종류의 브라우저에서 장애가 발생하는지 파악 가능
- 요청에서 사용

### Server
요청을 처리하는 ORIGIN 서버의 소프트웨어 정보
- Server: Apache/2.2.22 (Debian)
- server: nginx
- 응답에서 사용

### Date
메시지가 발생한 날짜와 시간
- Date: Tue, 15 Nov 1994 08:12:31 GMT
- 응답에서 사용

# 특별한 정보
- Host: 요청한 호스트 정보(도메인)
- Location: 페이지 리다이렉션
- Allow: 허용 가능한 HTTP 메서드
- Retry-After: 유저 에이전트가 다음 요청을 하기까지 기다려야 하는 시간

### Host
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/8ef7a7d1-d5fb-46af-900e-627dd0b685c6)

요청한 호스트 정보(도메인)
```
GET /search?q=hello&hl=ko HTTP/1.1
Host: www.google.com
```
- 요청에서 사용
- 필수
- 하나의 서버가 여러 도메인을 처리해야 할 때
- 하나의 IP 주소에 여러 도메인이 적용되어 있을 때
- 예) 가상 호스트를 통해 여러 도메인을 한번에 처리할 수 있는 서버가 있을 때 (aaa.com, bbb.com, ccc.com) 클라이언트가 Host 헤더를 넣어서 어느 도메인에 전달할지 정해줄 수 있다.

### Location
페이지 리다이렉션
- 웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면, Location 위치로 자동 이동 (리다이렉트)
- 응답코드 3xx에서 설명
- 201 (Created): Location 값은 요청에 의해 생성된 리소스 URI
- 3xx (Redirection): Location 값은 요청을 자동으로 리디렉션하기 위한 대상 리소스를 가리킴

### Allow
허용 가능한 HTTP 메서드
- 405 (Method Not Allowed) 에서 응답에 포함해야함
- Allow: GET, HEAD, PUT

### Retry-After
유저 에이전트가 다음 요청을 하기까지 기다려야 하는 시간
- 503 (Service Unavailable): 서비스가 언제까지 불능인지 알려줄 수 있음
- Retry-After: Fri, 31 Dec 1999 23:59:59 GMT (날짜 표기)
- Retry-After: 120 (초단위 표기)

# 인증
- Authorization: 클라이언트 인증 정보를 서버에 전달
- WWW-Authenticate: 리소스 접근시 필요한 인증 방법 정의

### Authorization
클라이언트 인증 정보를 서버에 전달
- Authorization: Basic xxxxxxxxxxxxxxxx

### WWW-Authenticate
리소스 접근시 필요한 인증 방법 정의
- 401 Unauthorized 응답과 함께 사용
```
WWW-Authenticate: Newauth realm="apps", type=1,
title="Login to \"apps\"", Basic realm="simple"
```

### 쿠키
인터넷에서 정보를 저장하고 전송하는 데 사용되는 작은 데이터 조각, 웹 서버가 클라이언트의 웹 브라우저에 쿠키를 보내면, 그것은 브라우저에 저장되고 나중에 동일한 서버에 요청을 할 때마다 서버에 해당 정보를 제공한다.

- Set-Cookie: 서버에서 클라이언트로 쿠키 전달(응답)
- Cookie: 클라이언트가 서버에서 받은 쿠키를 저장하고, HTTP 요청시 서버로 전달

HTTP는 무상태(Stateless) 프로토콜이다.
- 클라이언트와 서버가 요청과 응답을 주고 받으면 연결이 끊어진다.
- 클라이언트가 다시 요청하면 서버는 이전 요청을 기억하지 못한다.
- 클라이언트와 서버는 서로 상태를 유지하지 않는다.

### 쿠키 미사용
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/6c249f99-d990-4570-b4ce-5dc644aac793)

모든 요청에 사용자 정보 포함
```
GET /welcome?user=홍길동 HTTP/1.1
GET /board?user=홍길동 HTTP/1.1
GET /order?user=홍길동 HTTP/1.1
GET /xxx...?user=홍길동 HTTP/1.1
```

### 쿠키 사용
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/b67468fd-a1e6-470d-9e46-238638d9af24)

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/a83b6c04-25d4-45f9-87bb-928ce08e4600)

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/b3e0a597-516a-45d8-831e-e2f043033204)

로그인
```
POST /login HTTP/1.1
user=홍길동
```
응답 메시지, (쿠키 저장소에 user=홍길동 저장)
```
HTTP/1.1 200 OK
Set-Cookie: user=홍길동

홍길동님이 로그인했습니다.
```

로그인 이후 welcome 페이지 접근 (쿠키 저장소에서 조회)
```
GET /welcome HTTP/1.1
Cookie: user=홍길동
```
응답 메시지
```
HTTP/1.1 200 OK

안녕하세요. 홍길동님
```

### 쿠키 예시
 ```
 set-cookie: sessionId=abcde1234; expires=Sat, 26-Dec-2020 00:00:00 GMT; path=/; domain=.google.com; Secure
 ```
- 쿠키 사용처
 - 사용자 로그인 세션 관리
 - 광고 정보 트래킹
- 쿠키 정보는 항상 서버에 전송됨
 - 네트워크 트래픽 추가 유발
 - 최소한의 정보만 사용(세션 id, 인증 토큰)
- 서버에 전송하지 않고, 웹 브라우저 내부에 데이터를 저장하고 싶으면 웹 스토리지 (localStorage, sessionStorage) 참고
- 주의! 보안에 민감한 데이터는 저장하면 안됨(주민번호, 신용카드 번호 등등)

### 쿠키 - 생명 주기
Expires, max-age
- Set-Cookie: expires=Sat, 26-Dec-2020 04:39:21 GMT
 - 만료일이 되면 쿠키 삭제
- Set-Cookie: max-age=3600 (3600초)
 - 0이나 음수를 지정하면 쿠키 삭제
- 세션 쿠키: 만료 날짜를 생략하면 브라우저 종료시 까지만 유지
- 영속 쿠키: 만료 날짜를 입력하면 해당 날짜까지 유지

### 쿠키 - 도메인
Domain
- 예) domain=example.org
- 명시: 명시한 문서 기준 도메인 + 서브 도메인 포함
 - domain=example.org를 지정해서 쿠키 생성
 - xample.org는 물론이고
 - dev.example.org도 쿠키 접근
- 생략: 현재 문서 기준 도메인만 적용
 - example.org 에서 쿠키를 생성하고 domain 지정을 생략
 - example.org 에서만 쿠키 접근
 - dev.example.org는 쿠키 미접근

### 쿠키 - 경로
Path
- 예) path=/home
- 이 경로를 포함한 하위 경로 페이지만 쿠키 접근
- 일반적으로 path=/ 루트로 지정

### 쿠키 - 보안
Secure, HttpOnly, SameSite
- Secure
 - 쿠키는 http, https를 구분하지 않고 전송
 - Secure를 적용하면 https인 경우에만 전송
- HttpOnly
 - XSS 공격 방지
 - 자바스크립트에서 접근 불가(document.cookie)
 - HTTP 전송에만 사용
- SameSite
 - XSRF 공격 방지
 - 요청 도메인과 쿠키에 설정된 도메인이 같은 경우만 쿠키 전송
