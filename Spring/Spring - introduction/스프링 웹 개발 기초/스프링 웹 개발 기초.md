# 정적 컨텐츠
정적 컨텐츠는 서버에서 동적으로 처리되지 않고, 그대로 클라이언트에게 전달되는 컨텐츠이다. 주로 HTML, CSS, JavaScript, 이미지 등이 해당된다. 스프링은 정적 컨텐츠를 처리하기 위해 특별한 설정 없이도 간단히 제공할 수 있다.

[resources/static/hello-static.html](https://github.com/skcy1515/Programming-Study/blob/main/Spring/Spring%20-%20introduction/hello-spring/src/main/resources/static/hello-static.html)
```
<!DOCTYPE HTML>
<html>
<head>
    <title>static content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
정적 컨텐츠 입니다.
</body>
</html>
```
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/cfdc39f0-b498-425a-b40c-5633d18a2ef1)

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/0e92d016-b1d5-42bf-a7d7-6bf05ce6c808)

# MVC와 템플릿 엔진
MVC는 Model-View-Controller의 약자로, 웹 애플리케이션의 구조를 설계하는 데 사용된다. 이 구조는 애플리케이션을 모델(데이터), 뷰(사용자 인터페이스), 컨트롤러(비즈니스 로직)로 나누어 관리한다.

템플릿 엔진은 서버 측에서 동적인 웹 페이지를 생성하는 데 사용되는 도구이다. (Thymeleaf)

### Controller
[controller/HelloController.java](https://github.com/skcy1515/Programming-Study/blob/main/Spring/Spring%20-%20introduction/hello-spring/src/main/java/hello/hellospring/controller/HelloController.java)
```
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
```
- @RequestParam: name이라는 이름을 가진 파라미터의 값을 받아와서 name이라는 변수에 할당 (HTTP GET 방식, URL + ? + 데이터이름=값)

### View
[templates/hello-template.html](https://github.com/skcy1515/Programming-Study/blob/main/Spring/hello-spring/src/main/resources/templates/hello-template.html)
```
<html xmlns:th="http://www.thymeleaf.org">
<body>
    <p th:text="'hello ' + ${name}">hello! empty</p>
</body>
</html>
```

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/4091a67c-593e-4e5c-929a-21b148c9a718)

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/dd423cfa-f24a-46ce-9141-e5d0ec1d8bb6)

# API
view없이 그대로 http body에 전달하는 방식

[controller/HelloController.java](https://github.com/skcy1515/Programming-Study/blob/main/Spring/Spring%20-%20introduction/hello-spring/src/main/resources/templates/hello-template.html)
```
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }
```
- @ResponseBody: http body 부분에 데이터를 직접 넣는 방식 (뷰 리졸버( viewResolver )를 사용 X)

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/327142b3-510a-4abf-81f2-8c0b556c585b)

### 객체 반환
[controller/HelloController.java](https://github.com/skcy1515/Programming-Study/blob/main/Spring/hello-spring/src/main/java/hello/hellospring/controller/HelloController.java)
```
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
```
- @ResponseBody 를 사용하고, 객체를 반환하면 객체가 JSON으로 변환됨

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/0307661a-3ba1-4b6b-b560-d264bc24cc77)

### @ResponseBody 작동 방식
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/83230e04-65c5-4b1e-bb57-93eb318d49e1)

- @ResponseBody 를 사용
  - HTTP의 BODY에 문자 내용을 직접 반환
  - viewResolver 대신에 HttpMessageConverter 가 동작
  - 기본 문자처리: StringHttpMessageConverter
  - 기본 객체처리: MappingJackson2HttpMessageConverter
  - byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
