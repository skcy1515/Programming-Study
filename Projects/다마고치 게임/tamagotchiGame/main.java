package tamagotchiGame;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String name; // 다마고치 이름 변수
        Scanner scanner = new Scanner(System.in);
        System.out.println("다마고치 게임 실행");
        System.out.print("다마고치의 이름을 입력해주세요: ");
        name = scanner.nextLine();

        Game game = new Game(name); // 다마고치 이름을 인자로 받는 game 객체 생성
        System.out.println("게임 시작!");
        game.start(); // 게임 시작 함수
    }
}
