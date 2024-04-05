# URI
URI (Uniform Resource Identifier) 인터넷 상의 자원을 고유하게 식별하기 위한 문자열의 표현 방식이다. 

URI는 리소스의 위치나 이름을 나타내며, 특정 자원을 식별하기 위한 일종의 주소라고 할 수 있다.

`Uniform` : 리소스 식별하는 통일된 방식
`Resource` : 자원, URI로 식별할 수 있는 모든 것
`Identifier` : 다른 항목과 구분하는데 필요한 정보

URI는 로케이터(locator), 이름(name) 또는 둘다 추가로 분류될 수 있다.
1. `URL`(Resource Locator) : 리소스의 위치를 지정

2. `URN`(Resource Name) : 리소스에 이름 부여

위치는 변할 수 있지만 이름은 변하지 않는다.

현재까지는 URN 이름만으로 실제 리소스를 찾을 수 있는 방법이 보편화 되지 않아 현재까지는 URL이 더 널리 사용되고 있다.

따라서 URI와 URL은 같은 의미로 이야기한다.

# URL 전체 문법
예시: https://www.google.com:443/search?q=hello&hl=ko

scheme://[userinfo@]host[:port][/path][?query][#fragment]

`프로토콜` (https)

`호스트명` (www.google.com)

`포트 번호` (443)

`패스` (/search)

`쿼리 파라미터` (q=hello&hl=ko)

## Scheme
`https`://www.google.com:443/search?q=hello&hl=ko

주로 프로토콜 사용

`프로토콜` : 어떤 방식으로 자원에 접근할 것인가 하는 약속 규칙

  예) http, https, ftp 등등
  
http는 80 포트, https는 443 포트를 주로 사용, 포트는 생략 가능

https는 http에 보안을 추가 한 것 (HTTP Secure)

## Userinfo
scheme://`userinfo@`host[:port][/path][?query][#fragment]

URL에 사용자정보를 포함해서 인증

거의 사용하지 않음

## Host
https://`www.google.com`:443/search?q=hello&hl=ko

호스트 명, 도메인 명 또는 IP 주소 직접 사용 가능

## Path
https://www.google.com:443/`search`?q=hello&hl=ko

리소스가 있는 경로(path), 계층적 구조로 되어 있음

ex)

/home/file1.jpg

/members

/members/100, /items/iphone12

## Query
https://www.google.com:443/search`?q=hello&hl=ko`

주로 검색 기능, 필터링, 페이지네이션, 사용자 설정 및 매개변수 전달 등에 활용

key=value 형태

?로 시작, &로 추가 가능 ?keyA=valueA&keyB=valueB

query parameter, query string 등으로 불림, 웹서버에 제공하는 파라미터, 문자 형태

# 웹 브라우저의 요청 흐름
1. 웹 브라우저가 HTTP 메시지 생성
   
2. SOCKET 라이브러리를 통해 전달
  - A: TCP/IP 연결(IP, PORT)
  - B: 데이터 전달

3. TCP/IP 패킷 생성, HTTP 메시지 포함

4. 데이터 전송

