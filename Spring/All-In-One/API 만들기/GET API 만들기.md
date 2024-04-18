# HTTP
- (웹을 통한) 컴퓨터 간의 통신은 HTTP 라는 표준화된 방식이 있다.
- HTTP 요청은 HTTP Method (GET, POST)와 Path(/portion)가 핵심이다.
- 요청에서 데이터를 전달하기 위한 2가지 방법은 쿼리와 바디이다.
- HTTP 응답은 상태 코드가 핵심이다.
- 클라이언트와 서버는 HTTP를 주고 받으며 기능을 동작하는데 이때 정해진 규칙을 API 라고 한다.

# GET API 개발하고 테스트하기
![image](https://github.com/skcy1515/Programming-Study/assets/140364849/a1f3de8f-24cb-455b-b76c-185986f98bfa)

가장 먼저 Controller를 담을 패키지와 CalculatorController.java 파일 만들어준다. 우리가 개발할 API는 바로 덧셈 API이다. 두 수를 받아, 두 수의 덧셈 결과를 돌려줄 것이다.

API 코드를 작성하기 전에 잠시 API가 무엇이었는지, API를 이루고 있는 요소가 무엇인지 기억을 떠올려보자.

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/96592957-9eeb-4e4b-aa7a-8aefdce0d9fb)

API를 개발하기 전에는 API의 HTTP method를 어떻게 할 것인지, path는 어떻게 할 것인지, 쿼리를 사용할 것인지 바디를 사용할 것인지, 쿼리를 사용한다면 어떤 key를 이용할 것인지, 결과는 어떤 형태로 줄 것인지를 고민해서 결정해야 한다. 이러한 것을 `API Specification(명세)` 줄여서 `API 스펙` 이라고도 한다.

보통 이러한 스펙을 클라이언트 개발 담당자와 함께 정하게 된다. 현재는 연습이니 바로 정해보자.
- HTTP Method : GET
- HTTP Path : /add
- 쿼리 사용
  - int number1
  - int number2
- 결과 반환
  - int 쿼리로 들어온 두 숫자의 합

```
@RestController
public class CalculatorController {
    @GetMapping("/add")
    public int addTwoNumbers(
            @RequestParam int number1,
            @RequestParam int number2
    ) {
        return number1 + number2;
    }
}
```
- `@RestController` : 주어진 Class를 Controller로 등록한다. (Controller : API의 진입 지점)
- `@GetMapping("/add")` : 아래 함수를 HTTP Method가 GET이고 HTTP path가 /add인 API로 지정한다.
- `@RequestParam` : 주어지는 쿼리를 함수 파라미터에 넣는다.
- HTTP를 통해 `GET /add?number1=10&number2=20` 요청을 하게 되면같은 이름을 가진 쿼리의 값이 들어온다.

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/0fd27f65-a01b-44ea-b5ea-7483b32c3207)

PostMan을 통해 http://localhost:8080/add 를 입력, 키 값과 밸류값을 넣어주면 PostMan이 알아서 URL을 만들어준다.

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/3b9daa7a-d235-4af3-95a8-588abd69fe2d)

SEND를 누르면 성공했다는 상태코드인 200 OK와 함깨 값이 반환된다.

현재는 쿼리에 들어오는 값이 number1과 number2로 2개이지만, API가 복잡해지면, @RequestParam이 매우 많아질 수도 있다. 즉, Controller에 있는 함수의 파라미터가 많아져야 한다는 뜻이다.

일반적으로 함수의 파라미터가 많아지면 코드가 길어져 깔끔하지 못하고, 실수할 여지가 많아진다. 어떻게 하면 쿼리가 많아지더라도, 파라미터 개수를 줄일 수 있을까? 이럴 때 바로 쿼리를 받는 Class를 만들 수 있다.

`com.group.libraryapp` 패키지 안에 `CalculatorAddRequest.java` 를 만들어주고 number1과 number2를 가지고 있는 클래스를 만들어 보자

```
public class CalculatorAddRequest {
    private final int number1;
    private final int number2;
    
    public CalculatorAddRequest(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
    
    public int getNumber1() {
        return number1;
    }
    
    public int getNumber2() {
        return number2;
    }
}
```
이제 Controller 코드에서도 이 클래스를 사용하게 바꿔주자 @RequestParam 어노테이션은 제거해도 괜찮다.

```
@RestController
public class CalculatorController {
    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }
}
```
이번에는 CalculatorAddRequest 객체를 매개변수로 받는다.

아까 입력했던 URL로 POST MAN Send를 눌러보면, 이번에도 동일하게 30이라는 결과가 나오는 것을 확인할 수 있다.

방금사용했던 CalculatorAddRequest 는 ‘쿼리' 라는 데이터를 외부에서 서버 안 Controller로 전달하는 역할을 맡았다. 이런 객체를 `Data Transfer Object`, 줄여서 `DTO`라고 부른다.

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/426481c4-2e99-4dcc-a092-b64713fb359b)
