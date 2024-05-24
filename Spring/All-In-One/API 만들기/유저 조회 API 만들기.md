필요한 API 스펙 
- HTTP Method : GET
- HTTP Path : /user
- 쿼리 : 없음
- 결과 반환
```
[{
"id": Long,
"name": String (null 불가능),
"age": Integer
}, ...]
```

### HTTP 결과를 JSON으로 반환하는 방법
Controller에서 그냥 객체를 반환하면, JSON으로 응답이 가게 된다. 이때 객체에는 getter가 있어야 한다.

예시
```
public class Fruit {
  private String name;
  private long price;

  public Fruit(String name, long price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public long getPrice() {
    return price;
  }
}
```
```
@GetMapping("/fruit")
public Fruit getFruit() {
  return new Fruit("사과", 1000L);
}
```
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/41437d6e-e523-4326-b0d3-3ffbf59440d5)

이는 우리가 @RestController 어노테이션을 클래스에 붙여준 덕분에 가능한 일이다.

### id란 무엇인가?
id 라는 필드가 존재한다. 일반적으로 id란 데이터별로 겹치지 않는 유일한 번호를 의미한다. 때문에 API 스펙에 id가 있다는 의미는, User별로 고유한 번호를 API 응답 결과로 반환해주어야 한다는 점이다. List에 담겨 있는 유저의 순서를 id로 해주면, User별로 고유한 번호라고 생각할 수 있을 것이다.

# 구현
API의 응답이 될 DTO부터 만들어주자. com.group.libraryapp.dto.user 패키지에 response 패키지를 추가로 만들어 UserResponse 클래스를 다음과 같이 만들어 주었다.

```
package com.group.libraryapp.dto.user.response;

import com.group.libraryapp.domain.user.User;

public class UserResponse {
    private long id;
    private String name;
    private Integer age;

    public UserResponse(long id, User user) {
        this.id = id;
        this.name = user.getName();
        this.age = user.getAge();
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
}
```
이 클래스를 만들기 위해서 User 쪽에서 2개의 getter를 추가해주었다.

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

    // 추가한 부분
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
```
또한 userController 클래스에 다음 코드를 추가하였다.
```
    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        List<UserResponse> responses = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            responses.add(new UserResponse(i + 1, users.get(i)));
        }
        return responses;
    }
```
- List<UserResponse> : 여러명 있는 유저의 정보를 반환하기 때문에 List를 사용했다. 실제 API 스펙에서도 리스트임이 표기되어 있다.
- for문 : id를 주기 위해 forEach 대신 for문을 사용하였다.
- i + 1 : id는 일반적으로 1부터 시작하기 때문에 0부터 시작하는 index i에 1을 더해주었다.

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/23540f1b-f3d1-4d12-9d6f-1876e5654cbe)

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/d9dff4c8-07bb-480b-8937-54861ab6a030)
