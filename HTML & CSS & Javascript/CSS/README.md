# CSS
CSS(Cascading Style Sheets)는 웹 페이지의 스타일을 정의하기 위한 스타일 시트 언어이다. 

HTML이 웹 페이지의 구조를 정의하는 데 사용되는 반면, CSS는 HTML 요소의 디자인, 레이아웃 및 스타일을 지정한다.

# 선택자
CSS에서 요소를 선택하는 패턴을 말한다. 선택자는 HTML 요소의 이름, 클래스, ID, 속성 등을 기반으로 할 수 있다.
```
* {} (전체 선택자)
tag {} (태그 선택자)
.class {} (클래스 선택자 <div class = "class">)
#id {} (id 선택자 <div id = "id">)
```
# 속성
선택한 요소에 적용할 스타일 속성을 지정한다. (예, 텍스트 색상, 배경색, 폰트 크기, 여백 등)

# 스타일 시트
CSS 코드의 모음을 말한다. 스타일 시트는 HTML 문서에 직접 포함될 수도 있고, 별도의 .css 파일로 분리하여 링크할 수도 있다.

# 박스 모델
HTML 요소가 차지하는 공간을 설명하는 모델로, 콘텐츠, 패딩, 테두리, 여백 등의 구성 요소로 이루어진다. 

`margin` : 박스 바깥의 여백

`border` : 박스의 기준이 되는 바깥 테두리

`padding`: 박스의 안쪽 여백

`contents`: 박스의 내용

`border-box` : 크기 중심이 바깥 테두리

padding을 조절하면 border은 그대로, content의 크기는 줄어든다.

`content-box` : 크기 중심이 내용

padding을 조절하면 content의 크기는 그대로, border의 크기가 늘어난다.

![스크린샷 2024-03-31 131135](https://github.com/skcy1515/Programming-Study/assets/140364849/129542fa-27d0-4613-8c0d-a929f6045224)

기본 박스 모델은 content 박스이다.

그런데 여백이 바뀐다고 해서 박스 자체의 크기가 변하게 되면 

나중에 여기저기 서로 사이즈가 맞지 않아서 레이아웃이 틀어져 보이게 될 것이다.

따라서 CSS 시작 시, 
```
* {
  box-sizing: border-box
}
```
를 추가하여 모든 박스를 border-box로 지정해둔다.

![화면 캡처 2024-03-31 131218](https://github.com/skcy1515/Programming-Study/assets/140364849/b34d720c-ed5e-4ff8-a2be-50130a33b40f)

[박스 모델 CSS 예제](https://github.com/skcy1515/Programming-Study/blob/main/HTML%20%26%20CSS%20%26%20Javascript/CSS/01-boxmodel.html)

[회원가입 페이지 예제](![회원가입 예제 꾸미기](https://github.com/skcy1515/Programming-Study/assets/140364849/002e1f73-8256-4796-9354-5954d41acef5))
 
