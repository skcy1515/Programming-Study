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
```
package com.group.libraryapp.dto;

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

이제 뼈대를 잡았으니 실제 기능을 만들어야 한다. 원하는 것은 유저가 저장되는 것이다. 즉, 서버를 키고, API를 호출해 유저를 저장하면, 다시 불러올 수 있어야 한다. 가장 간단하게 API가 호출되면, User라는 클래스의 인스턴스를 만들고 이 데이터를 List에
저장하도록 하자. User 클래스는 새로 만들어야 한다. com.group.libraryapp 안에 domain.user 패키지를 만들어 User 클래스를 만들어준다.

```


