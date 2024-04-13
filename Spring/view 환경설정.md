# Welcome page 만들기
스프링 부트가 제공하는 Welcome page 기능, static/index.html을 올려두면 Welcome page 기능을 제공한다.

`index.html`
```
<!DOCTYPE HTML>
<html>
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
Hello
<a href="/hello">hello</a>
</body>
</html>
```

# Controller 만들기
hello.hellospring/controller/HelloController.java 생성

`HelloController.java`
```
@Controller
public class HelloController {
  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data", "hello!!");
    return "hello";
  }
}
```
이 코드는 스프링 프레임워크에서 웹 애플리케이션의 요청을 처리하기 위한 컨트롤러를 정의한 것
- @Controller: 이 애노테이션은 해당 클래스가 스프링의 컨트롤러임을 나타냄
- @GetMapping("hello"): 이 애노테이션은 "/hello" 경로로 들어오는 GET 요청을 이 메서드가 처리한다는 것을 나타냄. 
- public String hello(Model model): 이 메서드는 HTTP GET 요청을 처리하는 핸들러 메서드. 메서드는 Model 객체를 매개변수로 받고, Model 객체는 컨트롤러에서 뷰로 데이터를 전달할 때 사용
- model.addAttribute("data", "hello!!"): 이 코드는 "data"라는 이름으로 "hello!!"라는 값을 모델에 추가
- return "hello": 이 요청의 응답으로 사용될 뷰의 이름,  스프링 부트는 기본적으로 resources/templates 폴더 아래에 있는 HTML 파일을 뷰로 사용하기에 return "hello"는 templates 폴더 아래에 있는 hello.html 파일과 매칭됨

즉, 이 컨트롤러는 "/hello" 경로로 들어오는 GET 요청을 처리하고, "hello"라는 이름의 뷰에 "hello!!"라는 데이터를 전달함. 이후 뷰 엔진은 해당 데이터를 이용하여 최종적으로 클라이언트에게 보여질 HTML을 생성함.

resources/templates/hello.html 생성

`hello.html`
```
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p th:text="'안녕하세요. ' + ${data}" >안녕하세요. 손님</p>
</body>
</html>
```
- xmlns:th="http://www.thymeleaf.org" : thymeleaf 문법을 사용하게끔 만듦
- ${data}로 Controller model value 값을 가져옴

### 동작 과정
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/fbec8ad8-1a2e-4712-a7f0-1a3aad646600)

컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( viewResolver )가 화면을 찾아서 처리한다.
- 스프링 부트 템플릿엔진 기본 viewName 매핑
- resources:templates/ +{ViewName}+ .html

# 빌드하고 실행하기
1. cmd창에 cd 파일경로(C:\Users\skcy1\OneDrive\Desktop\코딩\Programming-Study\Spring\hello-spring) 입력 후 gradlew.bat 입력
2. gradlew build 입

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/c291202d-de0b-4c36-8629-ad41467f49e7)





`build.gralde`
```
tasks.named('test') {
	useJUnitPlatform()
}
```
변경 후
```
test {
	useJUnitPlatform()
}
```
