package TamagotchiGame;

import java.util.Scanner;

public class Game {
    // 객체 참조 코드들
    private Tamagotchi tamagotchi;
    private Item item;
    private Feed feed;
    private Play play;
    private Clean clean;
    private Work work;
    private Shopping shopping;
    private int days = 0; // 날짜
    private int time = 1; // 시간

    public Game(String name) {
        this.tamagotchi = new Tamagotchi(name); // name 인자로 받는 Tamagotchi 객체 생성
        this.item = new Item(); // Item 객체 생성
        this.feed = new Feed(this.item, this.tamagotchi);
        this.play = new Play(this.tamagotchi);
        this.clean = new Clean(this.item, this.tamagotchi);
        this.work = new Work(this.item);
        this.shopping = new Shopping(this.item);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            tamagotchi.printStatus(); // tamagotchi 상태 출력
            System.out.println("경과날짜: " + days + "일");
            // GameOver 로직
            if (time == 1) {
                System.out.println("현재시간: 아침");
            } else if (time == 2) {
                System.out.println("현재시간: 점심");
            } else {
                System.out.println("현재시간: 저녁");
            }

            System.out.println("무엇을 하실 건가요?:");
            System.out.println("1. 먹이주기 ");
            System.out.println("2. 놀아주기 ");
            System.out.println("3. 목욕 시키기 ");
            System.out.println("4. 아르바이트 (아침에만 가능) ");
            System.out.println("5. 쇼핑하기 (아침, 점심에만 가능)");
            System.out.println("6. 게임 종료");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (feed.giveFood()){
                        time++;
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    play.playing();
                    time++;
                    break;
                case 3:
                    if (clean.takeShower()) {
                        time++;
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    if (time == 1) {
                        work.working();
                        time = time + 2;
                        break;
                    } else {
                        System.out.println("지금 시간에는 아르바이트를 갈 수 없습니다.");
                        continue;
                    }
                case 5:
                    System.out.println("상품을 고르세요 1. 먹이 2. 샴푸 3. 뒤로가기");
                    // 현재 돈 출력
                    int count = scanner.nextInt();
                    if (count == 1) {
                        shopping.buyFood();
                        time++;
                    } else if (count == 2) {
                        shopping.buyShampoo();
                        time++;
                    } else if (count == 3){
                        continue; // 뒤로가기
                    } else {
                        System.out.println("다시 입력하세요.");
                    }
                    break;
                case 6: // 6 입력시 게임 퇴장
                    gameOver = true;
                    break;
                default:
                    System.out.println("잘못된 선택지입니다. 다시 입력하세요.");
            }
            if (time == 4) { // 저녁에서 다음 시간이 경과할 시 다음 날짜
                days++;
                time = 1;
            }
        }

        scanner.close();
    }
}
