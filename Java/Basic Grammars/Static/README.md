# 자바 메모리구조
자바의 메모리 구조는 크게 `메서드 영역`, `스택 영역`, `힙 영역` 3개로 나눌 수 있다.

`메서드 영역` : 클래스 정보(클래스의 실행 코드, 필드, 메서드 등 모든 실행 코드)를 보관한다.

`스택 영역` : 실제 프로그램이 실행되는 영역이다. 메서드를 실행할 때 마다 하나씩 쌓인다.

`힙 영역` : 객체(인스턴스)가 생성되는 영역이다. new 명령어를 사용하면 이 영역을 사용한다

`static 영역` : static 변수들을 보관한다. 

자바에서 특정 클래스로 100개의 인스턴스를 생성하면, 힙 메모리에 100개의 인스턴스가 생긴다. 

각각의 인스턴스는 내부에 변수와 메서드를 가진다. 같은 클래스로 부터 생성된 객체라도, 인스턴스 내부의 변수 값은 서로 다를 수 있지만,

메서드는 공통된 코드를 공유한다. 따라서 객체가 생성될 때, 인스턴스 변수에는 메모리가 할당되지만, 

메서드에 대한 새로운 메모리 할당은 없다. 메서드는 메서드 영역에서 공통으로 관리되고 실행된다.

# 스택
나중에 넣은 것이 가장 먼저 나오는 것을 후입 선출(LIFO, Last In First Out)이라 하고, 이런 자료 구조를 스택이라 한다.

프로그램 실행과 메서드 호출에는 스택 구조가 적합하다.

# static
static 키워드를 사용하면 공용으로 함께 사용하는 변수, 메서드를 만들 수 있다.

`인스턴스 변수` : static 이 붙지 않은 멤버 변수

static 이 붙지 않은 멤버 변수는 인스턴스를 생성해야 사용할 수 있고, 인스턴스에 소속되어 있다.

인스턴스 변수는 인스턴스를 만들 때 마다 새로 만들어진다.

`클래스 변수` : static 이 붙은 멤버 변수

클래스 변수, 정적 변수, static 변수등으로 부른다.

static 이 붙은 멤버 변수는 인스턴스와 무관하게 클래스에 바로 접근해서 사용할 수 있고, 클래스 자체에 소속되어 있다.

클래스 변수는 자바 프로그램을 시작할 때 딱 1개가 만들어진다. 인스턴스와는 다르게 보통 여러곳에서 공유하는 목적으로 사용된다.

static 메서드는 static이 붙은 정적 메서드나 정적 변수만 사용할 수 있다.

또한 인스턴스 변수나, 인스턴스 메서드를 사용할 수 없지만, 클래스를 통해 모든 곳에서 static을 호출할 수 있다.

# 변수와 생명주기
`지역 변수(매개변수 포함)` : 지역 변수는 스택 영역에 있는 스택 프레임 안에 보관된다. 

메서드가 종료되면 스택 프레임도 제거 되는데 이때 해당 스택 프레임에 포함된 지역 변수도 함께 제거된다. 

따라서 지역 변수는 생존 주기가 짧다.

`인스턴스 변수` : 인스턴스에 있는 멤버 변수를 인스턴스 변수라 한다. 인스턴스 변수는 힙 영역을 사용한다. 

힙 영역은 GC(가비지 컬렉션)가 발생하기 전까지는 생존하기 때문에 보통 지역 변수보다 생존 주기가 길다.

`클래스 변수` : 클래스 변수는 메서드 영역의 static 영역에 보관되는 변수이다. 

메서드 영역은 프로그램 전체에서 사용하는 공용 공간이다. 

클래스 변수는 해당 클래스가 JVM에 로딩 되는 순간 생성된다. 그리고 JVM이 종료될때 까지 생명주기가 어어진다. 

따라서 가장 긴 생명주기를 가진다

# 문제
수학 계산을 static 메서드로 구현한 예제
```
package Static;

// Math.java
public class Math {

    public static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum = sum + value;
        }
        return sum;
    }

    public static int average(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum = sum + value;
        }
        return (sum / values.length);
    }

    public static int min(int[] values) {
        int min = values[0];
        for (int value : values) {
            if (min > value) {
                min = value;
            }
        }
        return min;
    }

    public static int max(int[] values) {
        int max = values[0];
        for (int value : values) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }
}

// MathMain.java
public class MathMain {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        System.out.println("sum=" + Math.sum(values));
        System.out.println("average=" + Math.average(values));
        System.out.println("min=" + Math.min(values));
        System.out.println("max=" + Math.max(values));
    }
}
```
// 실행 결과
```
sum=15
average=3
min=1
max=5
```

