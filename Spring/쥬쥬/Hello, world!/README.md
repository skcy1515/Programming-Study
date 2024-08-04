# 스프링 설치
![1](https://github.com/skcy1515/Programming-Study/assets/140364849/541fca30-6d36-4e90-b5d9-322758dca4bc)

![2](https://github.com/skcy1515/Programming-Study/assets/140364849/d616b9a4-9927-439d-946d-cbb04c8ac0c0)

SDK 버전은 아마존 corretto으로

# Hello, World!
package com.example.review.api 패키지에 TestApi 클래스 추가하고
```
@RestController
public class TestApi {

    @GetMapping("/hello/world")
    public String helloWorld() {
        return "Hello, world!";
    }

}
```
작성 후 실행시키기

![image](https://github.com/user-attachments/assets/08fda58d-34ef-4644-a225-d06a16d67a01)

 ![image](https://github.com/user-attachments/assets/83f22bab-62c8-4b07-9bb6-24ec4e7b6de0)

postman 열어서 저장 후 send 통해 정상적으로 작동되는지 테스트 하기

# HTTP Method
```
@RestController
public class TestApi {

    @GetMapping("/hello/world")
    public String helloWorld() {
        return "[Get] Hello, world!";
    }

    @PostMapping("/hello/world")
    public String postHelloWorld(){
        return "[Post] Hello, world!";
    }

    @PutMapping("/hello/world")
    public String putHelloWorld(){
        return "[Put] Hello, world!";
    }

    @DeleteMapping ("/hello/world")
    public String deleteHelloWorld(){
        return "[Delete] Hello, world!";
    }
}
```
Get, Post, Put, Delete 각각 만들어주고

![image](https://github.com/user-attachments/assets/5f217101-74fe-41ff-8303-ea3529b57265)

포스트맨 켜서 각각 테스트 해보기
