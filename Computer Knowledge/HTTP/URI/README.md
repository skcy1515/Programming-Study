이 글은 인프런 김영한님의 `모든 개발자를 위한 HTTP 웹 기본 지식` 강의를 바탕으로 개인적인 정리를 위해 작성한 글입니다.

# URI
URI (Uniform Resource Identifier) 인터넷 상의 자원을 고유하게 식별하기 위한 문자열의 표현 방식이다. 

URI는 리소스의 위치나 이름을 나타내며, 특정 자원을 식별하기 위한 일종의 주소라고 할 수 있다.

- `Uniform` : 리소스 식별하는 통일된 방식
- `Resource` : 자원, URI로 식별할 수 있는 모든 것
- `Identifier` : 다른 항목과 구분하는데 필요한 정보

URI는 로케이터(locator), 이름(name) 또는 둘다 추가로 분류될 수 있다.
1. `URL`(Resource Locator) : 리소스의 위치를 지정
2. `URN`(Resource Name) : 리소스에 이름 부여

위치는 변할 수 있지만 이름은 변하지 않는다.

현재까지는 URN 이름만으로 실제 리소스를 찾을 수 있는 방법이 보편화 되지 않아 현재까지는 URL이 더 널리 사용되고 있다.

따라서 URI와 URL은 같은 의미로 이야기한다.

# URL 전체 문법
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/5a316755-476d-4ce6-96d8-a934f50f85a9)

- scheme://[userinfo@]host[:port][/path][?query][#fragment]
- https://www.google.com:443/search?q=hello&hl=ko

- `프로토콜` (https)
- `호스트명` (www.google.com)
- `포트 번호` (443)
- `패스` (/search)
- `쿼리 파라미터` (q=hello&hl=ko)

### Scheme
- `scheme`://[userinfo@]host[:port][/path][?query][#fragment]
- `https`://www.google.com:443/search?q=hello&hl=ko

- 주로 프로토콜 사용
- `프로토콜` : 어떤 방식으로 자원에 접근할 것인가 하는 약속 규칙
  - 예) http, https, ftp 등등
- http는 80 포트, https는 443 포트를 주로 사용, 포트는 생략 가능
- https는 http에 보안을 추가 한 것 (HTTP Secure)

### Userinfo
- scheme://`[userinfo@]`host[:port][/path][?query][#fragment]
- https://www.google.com:443/search?q=hello&hl=ko
- URL에 사용자정보를 포함해서 인증
- 거의 사용하지 않음

### Host
- scheme://[userinfo@]`host`[:port][/path][?query][#fragment]
- https://`www.google.com`:443/search?q=hello&hl=ko
- 호스트 명, 도메인 명 또는 IP 주소 직접 사용 가능

### Port
- scheme://[userinfo@]host`[:port]`[/path][?query][#fragment]
- https://www.google.com`:443`/search?q=hello&hl=ko
- 포트(PORT)
- 접속 포트
- 일반적으로 생략, 생략시 http는 80, https는 443

### Path
- scheme://[userinfo@]host[:port]`[/path]`[?query][#fragment]
- https://www.google.com:443/`search`?q=hello&hl=ko
- 리소스가 있는 경로(path), 계층적 구조로 되어 있음
- ex)
  - /home/file1.jpg
  - /members
  - /members/100, /items/iphone12

### Query
- scheme://[userinfo@]host[:port][/path]`[?query]`[#fragment]
- https://www.google.com:443/search`?q=hello&hl=ko`
- 주로 검색 기능, 필터링, 페이지네이션, 사용자 설정 및 매개변수 전달 등에 활용
- key=value 형태
- ?로 시작, &로 추가 가능 ?keyA=valueA&keyB=valueB
- query parameter, query string 등으로 불림, 웹서버에 제공하는 파라미터, 문자 형태

### fragment
- scheme://[userinfo@]host[:port][/path][?query]`[#fragment]`
- https://docs.spring.io/spring-boot/docs/current/reference/html/gettingstarted.html`#getting-started-introducing-spring-boot`
- html 내부 북마크 등에 사용
- 서버에 전송하는 정보 아님

# 웹 브라우저의 요청 흐름
- 웹 브라우저가 HTTP 메시지 생성

  ![image](https://github.com/skcy1515/Programming-Study/assets/140364849/b6a83d6e-02f1-4c33-853c-44d50c7bee19)

  ![image](https://github.com/skcy1515/Programming-Study/assets/140364849/0038f2ab-0a4e-4fe1-939e-92ac05857a03)

- SOCKET 라이브러리를 통해 전달
  
  ![image](https://github.com/skcy1515/Programming-Study/assets/140364849/91853d5d-50d8-4a08-963d-3627d7fbbc2b)

  - A: TCP/IP 연결(IP, PORT)
  - B: 데이터 전달
- TCP/IP 패킷 생성, HTTP 메시지 포함
  
  ![image](https://github.com/skcy1515/Programming-Study/assets/140364849/e252559c-f889-4073-8de1-1691ebb385d8)

  ![image](https://github.com/skcy1515/Programming-Study/assets/140364849/7391bf0b-dd95-4228-8952-001d0e1f477d)

- 서버 응답

  ![image](https://github.com/skcy1515/Programming-Study/assets/140364849/2ec999c7-d60b-4b8b-93fc-89612382383f)

  ![image](https://github.com/skcy1515/Programming-Study/assets/140364849/864a9882-96ac-4a36-8cd3-f2b402acc340)

  ![image](https://github.com/skcy1515/Programming-Study/assets/140364849/b5cf67af-cc54-411e-902b-8cf25cfd873c)




