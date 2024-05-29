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

            System.out.println("1. 행동하기, 2. 쇼핑하기 (아침, 점심에만 가능), 3.게임 설명, 4. 게임 종료");
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
                    System.out.println("다마고치 게임에 오신 것을 환영합니다! 이 게임은 플레이어가 여러 행동을 통해 다마고치를 최종 성장 (레벨 5까지)시키는 것이 목표입니다.");
                    System.out.println("다마고치는 5일에 1번씩 성장을 합니다. 다마고치는 행복도, 청결도 수치가 하나라도 0이 되거나 배고픔 수치가 100이 넘으면 죽습니다. ");
                    System.out.println("1번 선택지로 다마고치에게 먹이를 주거나, 목욕을 시키거나, 놀아주거나, 탐색을 할 수 있습니다. ");
                    System.out.println("탐색은 다마고치와 밖을 다니면서 얻은 물건들을 팔아 1000~8000원 랜덤하게 돈을 얻을 수 있습니다. 탐색은 아침에만 할 수 있습니다. ");
                    System.out.println("2번 선택지로 먹이나 다마고치 샴푸를 살 수 있습니다. 처음에 먹이는 5개, 샴푸는 1개를 가지고 있습니다. ");
                    break;
                case 4:
                    gameOver = true;
                    break;
                default:
                    System.out.println("잘못된 선택지입니다. 다시 입력하세요.");
            }
            if (tamagotchi.getTime() == 4) { // 저녁에서 다음 시간이 경과할 시 다음 날짜
                tamagotchi.setDays(tamagotchi.getDays() + 1);
                tamagotchi.setTime(1);
            }
            if (tamagotchi.getCleanLiness() <= 0 || tamagotchi.getHunger() >= 100 || tamagotchi.getHappiness() <= 0){
                System.out.println(tamagotchi.getName() + "가 죽었습니다.");
                gameOver = true;
            }
            switch (tamagotchi.getDays()){
                case 5:
                    if (tamagotchi.getGrowthLevel() == 2)
                        break;
                    tamagotchi.setGrowthLevel(tamagotchi.getGrowthLevel() + 1);
                    System.out.println(tamagotchi.getName() + "가 성장하였습니다!");
                    break;
                case 10:
                    if (tamagotchi.getGrowthLevel() == 3)
                        break;
                    tamagotchi.setGrowthLevel(tamagotchi.getGrowthLevel() + 1);
                    System.out.println(tamagotchi.getName() + "가 성장하였습니다!");
                    break;
                case 15:
                    if (tamagotchi.getGrowthLevel() == 4)
                        break;
                    tamagotchi.setGrowthLevel(tamagotchi.getGrowthLevel() + 1);
                    System.out.println(tamagotchi.getName() + "가 성장하였습니다!");
                    break;
                case 20:
                    tamagotchi.setGrowthLevel(tamagotchi.getGrowthLevel() + 1);
                    System.out.println(tamagotchi.getName() + "가 최종 성장을 하였습니다! 축하합니다!");
                    gameOver = true;
                    break;
            }
        }
        scanner.close();
    }
}
