# HTTP 헤더 개요
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
```
GET /event
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
```
- Quality Values(q) 값 사용
- 0~1, 클수록 높은 우선순위
- 생략하면 1

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


