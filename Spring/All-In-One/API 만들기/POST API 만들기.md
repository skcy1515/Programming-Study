# JSON
POST 를 통해 곱셈 기능을 가진 API를 만들어볼 것이다. 원래 POST API의 의미는 어떤 값을 저장한다는 의미이기 때문에 곱셈 기능을 하는 경우는 POST API를 작성하면 안 된다! 하지만 현재는 ‘HTTP 바디' 사용 방법을 연습하기
위해 POST로 만들어 볼 것이다. 

POST API 경우 쿼리를 사용하지 않고 바디(body)를 사용한다. 그렇다면 이 body에는 데이터를 어떻게 담아주는 걸까? 바로 JSON 을 사용한다.

JSON은 JavaScript Object Notation의 약자로, 웹 통신에서 객체를 표기하는 기법이다. 예를 들어 사람이 있다고 가정했을 때, 사람에게는 이름도 있고 나이도 있다. 이런 사람을 JSON 으로 표현하면 다음과 같다.
```
{
   "name": "최태현",
   "age": 99
}
```
또 예를 들어, 어떤 사람이 강아지들을 키운다고 해보자! 그렇다면 JSON은 다음과 같이 바뀌게 될 것이다.
```
{
  "name": "최태현",
  "age": 99,
  "dogs": ["코코", "초코"]
}
```
key가 dogs 이고 value에는 List<String> 이라 할 수 있는 ["코코", "초코"] 가 들어가 있다. 만약 집 정보를 추가하고 싶다면?
```
{
  "name": "최태현",
  "age": 99,
  "house": {
    "address": "대한민국 서울",
    "hasDoor": true
  }
}
```
다음과 같이 다시 한번 JSON 형식이 들어갈 수도 있다.

# POST API
POST API의 스펙
- HTTP Method : POST
- HTTP Path : /multiply
- HTTP Body (JSON)
```
{
  "number1": 숫자,
  "number2": 숫자
}
```
- 결과 반환
  - 곱셈 결과, 숫자 타입

코드 추가
```
@PostMapping("/multiply")
public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request){
  return request.getNumber1() * request.getNumber2();
}
```
Controller는 API의 진입 지점으로 한 Controller Class에 여러 API를 만들어 줄 수 있다.
- `@PostMapping(”/multiply”)` : 아래 함수를 HTTP Method가 POST이고 Path가 /multiply인 API로 지정한다.
- `@RequestBody` : HTTP Body로 들어오는 JSON을 CalculatorMultiplyRequest 로 바꿔준다.
- `CalculatorMultiplyRequest` : HTTP body를 객체로 바꾸는 @RequestBody 를 사용하는 경우는, 생성자를 만들지 않아도 괜찮다.

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/c3cbeb43-1b32-4a7e-b867-85c3ae1749d4)

PostMan에 JSON을 입력하면  테스트 결과 10 * 20 = 200 이라는 결과가 정상적으로 나온다. HTTP Body에 있던 JSON이 @RequestBody 를 통해 CalculatorMultiplyRequest 에 매핑되고, Controller로 들어가 최종 결과를 반환해준 것이다.

![image](https://github.com/skcy1515/Programming-Study/assets/140364849/0343083d-351f-4eba-bce8-e4d39f64ed01)


