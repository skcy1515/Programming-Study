// 세 값의 최솟값을 구하여 출력

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("세 정수의 최솟값을 구합니다.");
        System.out.println("a의 값: "); int a = scanner.nextInt();
        System.out.println("b의 값: "); int b = scanner.nextInt();
        System.out.println("c의 값: "); int c = scanner.nextInt();

        int min = a;
        if (b<min) min = b;
        if (c<min) min = c;

        System.out.println("최솟값은 " + min + "입니다.");
    }
}
