package API.Math;

public class MathMain {
    public static void main(String[] args) {
        double a = 3.5;

        System.out.println(Math.PI); // 원주율 상수 출력, 3.14159...
        System.out.println(Math.ceil(a)); // ceil(올림), 4.0
        System.out.println(Math.floor(a)); // floor(내림), 3.0
        System.out.println(Math.round(a)); // 소수점 첫째 자리 반올림 후 정수 반환, 4
        System.out.println(Math.max(3.14, 3.14159)); // 더 큰 값 반환, 3.14159
        System.out.println(Math.min(3.14, 3.14159)); // 더 작은 값 반환, 3.14
        System.out.println((int)Math.pow(5, 2)); // 5^2, 25
        System.out.println((int)Math.sqrt(25));  // 25의 제곱근, 5

        // [1, 45] 사이의 정수형 난수 5개 발생
        System.out.print("이번주 행운의 번호는 ");
        for(int i=0; i<5; i++)
            System.out.print((int)(Math.random()*45 + 1) + " ");
    }
}

