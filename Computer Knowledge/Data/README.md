# 데이터
데이터는 정적인 정보로서 컴퓨터에서 처리하는 기본적인 단위다. 이는 정보를 구성하는 최소 단위인 `비트(bit)`로 이루어져 있으며, 0과 1로 표현된다. 따라서 1비트는 2개의 데이터를 가질 수 있고, n비트는 2^n가지 정보를 표현할 수 있다.

### 바이트
데이터는 비트들이 모여서 더 큰 단위인 `바이트(Byte)`를 형성하게 된다. 1바이트는 일반적으로 8비트로 구성되며, 컴퓨터에서 데이터를 저장하고 처리하는 기본 단위로 사용된다.

바이트 또한 더 큰 단위로 묶일 수 있는데, 1000바이트가 모여 `1킬로바이트(Kilobyte)`가 되고, 1000킬로바이트가 모여 `1메가바이트(Megabyte)`, 1000메가바이트가 모여 `1기가바이트(Gigabyte)`, 1000기가바이트가 모여 `1테라바이트(Terabyte)`가 된다. 

### 워드
또한 워드(Word)라는 단위도 존재한다. 워드는 CPU가 한 번에 처리할 수 있는 데이터의 크기를 의미한다. 만약 CPU가 한 번에 16비트를 처리할 수 있으면 1워드는 16비트가 되고, 32비트를 처리할 수 있으면 1워드는 32비트가 되는 것이다.

# 2진법
이진법은 1을 넘어가는 시점에 자리 올림을 하여 0과 1, 두 개의 숫자만으로 모든 수를 표현한다. 이진법을 통해 컴퓨터는 1 이상의 숫자도 이해하고 표현할 수 있다. 

그렇다면 음수는 어떻게 표현할까? 0과 1만으로 음수를 표현하는 방법 중 가장 널리 사용되는 방법은 2의 보수(two's complement)를 구해 이 값을 음수로 간주하는 방법이다. 2의 보수의 사전적 의미는 어떤 수를 그보다 큰 2^n에서 뺀 값을 의미한다. 예를 들어 11(2)의 2의 보수는 11(2)보다 큰 2^n, 즉, 100(2)에서 11(2)를 뺀 01(2)이 되는 것이다. 

이를 쉽게 생각하면 모든 0과 1을 뒤집고, 거기에 1을 더한 값으로 이해하면 쉽다. 숫자만으로는 이 수가 어떤 진법으로 표현된 수인지 알 수 없기 때문에 아래첨자(2)를 붙이거나, 이진수 앞에 0b를 붙인다.

하지만 1(2)과 10(2)과 같이 보수와 양수의 값이 같은 경우가 존재한다. 즉, 이진수만 봐서는 이게 음수인지 양수인지 구분하기가 어렵다. 그래서 컴퓨터는 내부에서 어떤 수를 다룰 때는 이 수가 양수인지 음수인지를 구분하기 위해 CPU 내부에 있는 플래그 레지스터의 `플래그(flag)`를 사용한다.

# 16진법
십육진법(Hexadecimal)은 수가 15를 넘어가는 시점에서 자리 올림을 하는 숫자 표현 방식이다. 컴퓨터 데이터를 표현할 때 이진법으로는 숫자의 길이가 너무 길어지기 때문에 십육진법도 많이 사용한다. (0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F, 10, 11...) 십육진수도 이진수와 마찬가지로 숫자 뒤에 아래첨자(16)를 붙이거나, 숫자 앞에 0x를 붙여 구분한다.

그렇다면 왜 십육진법이 필요한 것일까? 십육진법은 왜 만들어졌고, 그 용도는 무엇일까? 주요한 이유 중 하나는 십육진법이 이진수와의 변환 과정이 간편하기 때문이다. 이를 통해 복잡한 이진 데이터를 사람이 이해하기 쉬운 형태로 나타낼 수 있으며, 이는 디버깅 과정 등에서 매우 유용하게 사용된다. 

다음은 십육진수를 이진수로 바꾸는 과정이다. 십육진수를 이루고 있는 각 글자를 따로따로 이진수로 변환하고, 그것들을 그대로 이어 붙이면 십육진수가 이진수로 변환된다. 즉 A12B(16) = 1010000100101011(2)가 되는 것이다. 

이진수를 십육진수로 바꾸는 과정이다. 이진수 숫자를 네 개씩 끊고, 끊어 준 네 개의 숫자를 하나의 십육진수로 변환한 뒤 그대로 이어 붙이면 된다. 즉, 01011101(2) = 5D(16)이 되는 것이다.

# 문자 집합 
문자 집합(character set)은 컴퓨터가 인식하고 표현할 수 있는 문자의 집합체를 의미한다. 컴퓨터는 이러한 문자 집합에 포함된 문자들만 인식 가능하다.

하지만 문자 집합에 속한 문자라 하더라도 컴퓨터가 바로 이해하는 것은 아니다. 사람이 이해하는 문자를 컴퓨터가 이해할 수 있는 이진 코드, 즉 0과 1로 변환해야만 컴퓨터가 인식하고 처리할 수 있다. 이처럼 인간이 이해하는 정보를 컴퓨터가 처리할 수 있는 형태로 변환하는 과정을 `인코딩(encoding)`이라고 한다. 반대로 컴퓨터가 처리하는 정보를 인간이 이해할 수 있는 형태로 해석하는 과정을 `디코딩(decoding)`이라고 한다.

### ASCII 코드
아스키(ASCII: American Standard Code for Information Interchange)코드는 초창기 문자 집합 중 하나로, 영어 알파벳과 아라비아 숫자, 그리고 일부 특수 문자를 포함한다. 아스키 코드의 각 문자들은 총 8비트로 구성되어 있다. 이 중 7비트는 문자를 나타내기 위해 사용되고, 1비트는 오류를 검출하는 패리티 비트(parity bit)로 사용된다.

예를 들어 'A'는 10진수 65로 인코딩 되고, 'a'는 10진수 97로 인코딩 된다. 이때 각 글자에 부여된 고유한 값을 코드 포인트(code point)라고 한다. 여기서 A의 코드 포인트는 65고, a의 코드 포인트는 97이 된다.

아스키 코드는 매우 간단하게 인코딩 된다는 장점이 있지만, 한글 같은 문자를 표현할 수 없고, 128개보다 많은 문자를 표현하지 못한다는 단점이 있다.

### EUC-KR
한글 인코딩을 이해하려면 한글의 특수성부터 이해해야 한다. 알파벳을 쭉 이어 쓰면 단어가 되는 영어와는 달리, 한글은 각 음절 하나하나가 초성, 중성, 종성의 조합으로 이루어져 있다. 따라서 한글 인코딩에는 완성된 하나의 글자에 고유한 코드를 부여하는 완성형 인코딩 방식과, 각각의 비트열을 할당하여 그것들의 조합으로 하나의 글자 코드를 완성하는 조합형 인코딩 방식이 있다.

이러한 EUC-KR은 KS X 1001, KS X 1003이라는 문자 집합을 기반으로 하는 대표적인 완성형 인코딩 방식이다. 즉, EUC-KR 방식은 한글 단어에 2바이트 크기의 코드를 부여한다. 이러한 방식으로 총 2350개 한글 단어를 표현할 수 있지만, 이는 모든 한글 조합을 표현할 수 있을 정도로 많은 양은 아니다. 

### 유니코드
앞선 EUC-KR 인코딩 방식을 채용하면 한국어를 코드를 표현할 수 있다. 하지만 언어별로 인코딩을 나라마다 해야 한다면 다국어를 지원하는 프로그램을 만들 때 각 나라 언어의 인코딩을 모두 알아야 하는 번거로움이 있다. 다시 말해, 모든 언어를 아우르는 문자 집합과 통일된 표준 인코딩 방식이 있다면 언어별로 인코딩하는 수고로움을 덜 수 있다. 이러한 접근에서 나온 것이 유니코드(Unicode) 문자 집합이다. 현대 문자를 표현할 때 가장 많이 사용되는 표준 문자 집합인 유니코드 문자 집합은 EUC-KR보다 훨씬 많은 한글을 포함하며, 대부분 나라의 문자, 특수문자, 화살표, 이모티콘 등을 코드로 표현할 수 있게 구현해 놓았다.

유니코드는 UTF(Unicode Transformation Format)라는 여러 인코딩 방식을 사용하여 문자를 이진 데이터로 변환한다. 이러한 UTF 인코딩 방식들은 다양한 용도에 따라 설계되었으며, 다음과 같은 주요 종류가 있다.
1. UTF-8: UTF-8은 가변 길이 인코딩 방식으로, 1바이트에서 4바이트까지의 가변 길이로 문자를 표현한다. 아스키 문자는 1바이트로 표현되고, 다국어 문자들은 다양한 바이트 수로 표현된다. 인터넷에서 가장 널리 사용되는 인코딩 방식 중 하나이며, 호환성이 뛰어나고 경제적이다.
2. UTF-16: UTF-16은 16비트(2바이트) 고정 길이 인코딩 방식으로, 모든 문자를 2바이트로 표현한다. 기본적으로 유니코드 코드 포인트를 2바이트로 표현하며, Supplementary Plane의 문자들은 4바이트로 표현된다. 주로 윈도우 시스템에서 사용된다.
3. UTF-32: UTF-32는 32비트(4바이트) 고정 길이 인코딩 방식으로, 모든 문자를 4바이트로 표현한다. 이 방식은 각 문자를 일관되게 크기의 데이터로 저장하기 때문에 편리하지만, 저장 공간을 많이 차지하고 일부 시스템에서는 비효율적일 수 있다.