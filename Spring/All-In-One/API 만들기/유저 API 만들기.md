이번 시간에는 유저 생성 API를 개발해 볼 것이다. 이 API를 본격적으로 개발하기 전에 만들려고 하는 <도서 관리 애플리케이션>이 어떤 요구사항을 가지고 있는 살펴본다.

- 사용자
  - 도서관의 사용자를 등록할 수 있다. (이름 필수, 나이 선택)
  - 도서관 사용자의 목록을 볼 수 있다.
  - 도서관 사용자 이름을 업데이트 할 수 있다.
  - 도서관 사용자를 삭제할 수 있다.
- 책
  - 도서관에 책을 등록할 수 있다.
  - 사용자가 책을 빌릴 수 있다.
  - 다른 사람이 그 책을 진작 빌렸다면 빌릴 수 없다.
  - 사용자가 책을 반납할 수 있다.

우선 도서관의 사용자를 등록할 수 있다. (이름 필수, 나이 선택) 기능을 개발해 보겠다. API의 명세는 다음과 같다.
- HTTP Method : POST
- HTTP Path : /user
- HTTP Body (JSON)
```
{
"name": String (null 불가능),
"age": Integer
}
```
- 결과 반환 X (HTTP 상태 200 OK이면 충분하다)

### 뼈대 만들기
com.group.libraryapp.controller 패키지 안에 user 패키지를 만들고 UserController 를 만들어 주었다. 
```
package com.group.libraryapp.Controller.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/user")
    public void saveUser(@RequestBody userCreateRequest request) {

    }
}
```
또한 package com.group.libraryapp.dto.user 패키지 안에 userCreateRequest를 만들어 주었다.
```
package com.group.libraryapp.dto.user;

public class userCreateRequest {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
```

### 기능 구현
이제 뼈대를 잡았으니 실제 기능을 만들어야 한다. 원하는 것은 유저가 저장되는 것이다. 즉, 서버를 키고, API를 호출해 유저를 저장하면, 다시 불러올 수 있어야 한다. 가장 간단하게 API가 호출되면, User라는 클래스의 인스턴스를 만들고 이 데이터를 List에 저장하도록 하자. User 클래스는 새로 만들어야 한다. com.group.libraryapp 안에 domain.user 패키지를 만들어 User 클래스를 만들어준다.
```
package com.group.libraryapp.domain.user;

public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다", name));
        }
        this.name = name;
        this.age = age;
    }
}
```
name에는 null이 들어오면 안 되고, 이름이 비어 있을 수도 없으므로 생성자에서 값을 검증해주도록 했다.
```
package com.group.libraryapp.Controller.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.userCreateRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<User> users = new ArrayList<>();

    @PostMapping("/user")
    public void saveUser(@RequestBody userCreateRequest request) {
        users.add(new User(request.getName(), request.getAge()));
    }
}
```
이제 POST(저장) API에서 User 클래스를 List에 담도록 하였다. 클라이언트가 서버에 HTTP POST 요청을 보내면, 요청 본문에 JSON 형식의 사용자 데이터를 포함한다. 여기서 @RequestBody 어노테이션은 HTTP 요청 본문을 Java 객체로 변환하는 역할을 한다. 여기서는 요청 본문의 JSON 데이터를 userCreateRequest 타입의 객체로 변환한다. 마지막으로 userCreateRequest 객체의 getName()과 getAge() 메서드를 호출하여 User 객체를 생성하고, 생성된 User 객체를 users 리스트에 추가한다.

# 스프링 MVC 구조와 DTO, 도메인 모델
스프링 MVC는 애플리케이션을 세 가지 주요 구성 요소로 나눈다.

- Model: 비즈니스 로직과 데이터를 포함합니다. 도메인 모델이 이에 해당한다.
- View: 데이터를 사용자에게 표시하는 역할을 한다. JSP, Thymeleaf, 또는 HTML 페이지가 여기에 해당한다.
- Controller: 사용자 입력을 처리하고 모델과 뷰를 연결한다.

### DTO와 도메인 모델
- 도메인 모델: 애플리케이션의 핵심 비즈니스 로직과 데이터를 표현한다. 데이터베이스와 직접 상호작용하며, 비즈니스 규칙을 포함할 수 있다.
- DTO: 계층 간 데이터 전송을 위한 객체이다. 주로 컨트롤러와 서비스 간, 또는 클라이언트와 서버 간의 데이터 교환을 위해 사용된다. DTO는 단순히 데이터를 담는 역할만 하며, 비즈니스 로직을 포함하지 않는다.

### 스프링 MVC 구조와의 관계
1. 클라이언트 요청: 클라이언트는 HTTP 요청을 통해 애플리케이션에 데이터를 전송한다.
2. 컨트롤러: 컨트롤러는 클라이언트의 요청을 처리하는 역할을 한다. 요청 본문을 DTO로 매핑한다. 컨트롤러는 DTO를 서비스 계층으로 전달하여 비즈니스 로직을 수행하도록 한다.
3. 서비스:서비스 계층은 비즈니스 로직을 처리하는 곳이다. DTO를 받아 도메인 모델 객체로 변환한다.서비스 계층은 변환된 도메인 모델을 사용하여 필요한 비즈니스 로직을 수행하고, 데이터베이스에 저장한다.
4. 리포지토리: 리포지토리는 도메인 모델을 데이터베이스에 저장하거나 조회하는 역할을 한다.
5. 응답 생성: 서비스 계층에서 처리된 도메인 모델 객체를 컨트롤러로 반환한다. 컨트롤러는 이 객체를 HTTP 응답으로 변환하여 클라이언트에 반환한다.
