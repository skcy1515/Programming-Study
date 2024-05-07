package tamagotchiGame;

import java.util.Scanner;

public class Game {
    // 객체 참조 코드들
    private Tamagotchi tamagotchi;
    private Item item;
    private Activities activities;
    private Shopping shopping;


    public Game(String name) {
        this.tamagotchi = new Tamagotchi(name); // name 인자로 받는 Tamagotchi 객체 생성
        this.item = new Item(); // Item 객체 생성
        this.activities = new Activities(this.item, this.tamagotchi);
        this.shopping = new Shopping(this.item, this.tamagotchi);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            tamagotchi.printStatus(); // tamagotchi 상태 출력
            System.out.println("경과날짜: " + tamagotchi.getDays() + "일");
            // GameOver 로직
            if (tamagotchi.getTime() == 1) {
                System.out.println("현재시간: 아침");
            } else if (tamagotchi.getTime() == 2) {
                System.out.println("현재시간: 점심");
            } else {
                System.out.println("현재시간: 저녁");
            }

            System.out.println("1. 행동하기, 2. 쇼핑하기 (아침, 점심에만 가능), 3.게임 종료");
            System.out.print("무엇을 하실 건가요?: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (activities.use()){
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    if (shopping.use()) {
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    gameOver = true;
                    break;
                default:
                    System.out.println("잘못된 선택지입니다. 다시 입력하세요.");
            }
            if (tamagotchi.getTime() == 4) { // 저녁에서 다음 시간이 경과할 시 다음 날짜
                tamagotchi.setDays(tamagotchi.getDays() + 1);
                tamagotchi.setTime(1);
            }
        }
        scanner.close();
    }
}
