// 네 값의 최댓값을 구하여 출력

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("네 정수의 최댓값을 구합니다.");
        System.out.println("a의 값: "); int a = scanner.nextInt();
        System.out.println("b의 값: "); int b = scanner.nextInt();
        System.out.println("c의 값: "); int c = scanner.nextInt();
        System.out.println("d의 값: "); int d = scanner.nextInt();

        int max = a;
        if (b>max) max = b;
        if (c>max) max = c;
        if (d>max) max = d;

        System.out.println("최댓값은 " + max + "입니다.");
    }
}
