# 스프링
스프링(Spring)은 JAVA의 웹 프레임워크로 JAVA 언어를 기반으로 사용한다. JAVA로 다양한 어플리케이션을 만들기 위한 프로그래밍 틀이라 할 수 있다. 스프링은 빌드 관리를 위해 Maven과 Gradle을 주로 사용한다. (최근에는 Gradle을 사용)

### 라이브러리 VS 프레임워크
- 라이브러리(Library): 개발자가 필요할 때 라이브러리의 함수 또는 클래스를 호출하여 사용한다. 개발자가 코드의 제어 흐름을 직접 관리하며, 라이브러리는 개발자가 직접 호출하는 코드를 실행하는 데 도움을 준다.
- 프레임워크(Framework): 개발자가 정의한 규칙과 구조에 따라 애플리케이션의 제어 흐름을 프레임워크가 관리한다. 개발자는 프레임워크에서 제공하는 템플릿 메서드나 콜백 함수를 구현하여 프레임워크에 의해 호출되는 방식으로 개발한다.

### 빌드 관리 도구
Gradle은 Maven과 유사하게 빌드 자동화 도구이지만, Maven보다 더 강력하고 유연한 기능을 제공한다. 여기서 빌드 관리란 소프트웨어 개발 프로세스의 중요한 부분 중 하나이다. 빌드 관리는 소스 코드를 컴파일하고 빌드하여 실행 가능한 소프트웨어를 생성하는 프로세스를 관리하는 것을 의미한다.

일반적으로 빌드 관리는 다음과 같은 작업을 포함한다.
- 컴파일: 소스 코드를 컴파일하여 실행 가능한 코드로 변환한다.
- 의존성 관리: 프로젝트가 다른 코드나 라이브러리에 의존하는 경우, 이러한 의존성을 관리하여 필요한 라이브러리를 가져온다.
- 테스트 실행: 프로젝트의 테스트를 실행하여 코드의 정확성을 확인한다.
- 패키징: 컴파일된 코드 및 해당 의존성을 포함하여 실행 가능한 소프트웨어 패키지를 생성한다.
- 배포: 생성된 소프트웨어를 적절한 환경으로 배포하거나 배포할 수 있는 형식으로 변환한다.

빌드 관리는 소프트웨어의 개발 및 유지 관리를 단순화하고 효율화하여 개발자가 코드를 더 신속하게 배포할 수 있도록 도와줍니다.

### Web Application Server
스프링 부트에는 WAS인 톰캣이 기본적으로 내장되어 있다.

WAS는 웹 애플리케이션을 실행시켜 필요한 기능을 수행하고 그 결과를 웹 서버에게 전달하는 일종의 미들웨어를 말한다. php, jsp, asp와 같은 언어들을 사용해 동적인 페이지를 만들어낼 수 있는 서버이다.
- 프로그램 실행 환경과 데이터베이스 접속 기능을 제공한다.
- 비즈니스 로직 수행이 가능하다.
- 웹 서버 + 웹 컨테이너를 합친 형태다.
- 웹 서버와 WAS 차이
	- 웹 서버는 정적인 컨텐츠만 줄 수 있다.
 	- WAS는 어떤 애플리케이션을 돌리고, DB를 연결하고, 어떤 로직을 수행해기  (더 빠름)

# 스프링 구성
![gradle](https://github.com/skcy1515/Programming-Study/assets/140364849/bd89515f-74d8-45cb-bac0-fbd2e5b17c1c)
- .idea: 인텔리제이가 사용하는 설정 파일
- gradle/ wrapper: 미리 선언된 버전의 Gradle을 호출하고, 필요한 경우 미리 다운로드 및 설치하여 빌드 해줌
- src/ main, test - test코드와 main 코드 나누어져 있
- main/ resources - 자바 코드 파일을 제외한 html, xml, properties같은 설정 파일이 들어가 있음

### build.gradle
```
plugins {
	id 'java'
	id 'org.springframework.boot' version '3.2.4'
	id 'io.spring.dependency-management' version '1.1.4'
}

group = 'hello'
version = '0.0.1-SNAPSHOT'

java {
	sourceCompatibility = '22'
}
```
자바, 스프링 버전 명시

```
repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```
- repositories: 프로젝트가 의존성을 가져올 Maven 저장소를 지정, 여기서는 Maven Central 저장소를 사용
- dependencies: 프로젝트의 의존성을 설정 (라이브러리 가져옴)
- testImplementation: 자동으로 설치되는 테스트 라이브러리
- 의존성(dependency): 프로젝트가 다른 코드 또는 라이브러리에 의존하여 작동할 수 있도록 하는 것을 의미


