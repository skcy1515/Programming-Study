package tamagotchiGame;

import java.util.Scanner;

public class Activities extends usable{
    public Activities(Item item, Tamagotchi tamagotchi) {
        super(item, tamagotchi);
    }

    @Override
    public boolean use() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("어떤 행동을 하시겠습니까? (1: 먹이 주기, 2: 목욕시키기. 3: 놀아주기, 4: 탐색 하기)");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return feed();
            case 2:
                return clean();
            case 3:
                tamagotchi.setTime(tamagotchi.getTime() + 1);
                return play();
            case 4:
                if (tamagotchi.getTime() != 1) {
                    System.out.println("탐색은 아침에만 할 수 있습니다.");
                    return false;
                }
                tamagotchi.setTime(tamagotchi.getTime() + 2);
                return quest();
            default:
                System.out.println("올바른 선택이 아닙니다.");
                return false;
        }
    }

    private boolean feed() {
        if (item.getFood() <= 0) {
            System.out.println("먹이가 없습니다. ");
            return false;
        } else {
            System.out.println("당신은 " + tamagotchi.getName() + "에게 먹이를 주었습니다.");
            item.setFood(item.getFood() - 1);
            System.out.println("남은 먹이 개수: " + item.getFood());

            tamagotchi.setHunger(tamagotchi.getHunger() - 30);
            if (tamagotchi.getHunger() < 0) {
                tamagotchi.setHunger(0);
            }
            tamagotchi.setHappiness(tamagotchi.getHappiness() + 1);
            tamagotchi.setCleanLiness(tamagotchi.getCleanLiness() - 5);
            tamagotchi.setTime(tamagotchi.getTime() + 1);
            return true;
        }
    }

    private boolean clean() {
        if (item.getShampoo() <= 0) {
            System.out.println("샴푸가 없습니다. ");
            return false;
        } else {
            System.out.println("당신은 " + tamagotchi.getName() + "를 목욕시켰습니다.");
            item.setShampoo(item.getShampoo() - 1);
            System.out.println("남은 샴푸 개수: " + item.getShampoo());

            tamagotchi.setHunger(tamagotchi.getHunger() + 5);
            tamagotchi.setHappiness(tamagotchi.getHappiness() + 1);
            tamagotchi.setCleanLiness(tamagotchi.getCleanLiness() + 50);
            if (tamagotchi.getCleanLiness() > 100) {
                tamagotchi.setCleanLiness(100);
            }
            tamagotchi.setTime(tamagotchi.getTime() + 1);
            return true;
        }
    }

    private boolean play() {
        System.out.println("당신은 " + tamagotchi.getName() + "를 놀아주었습니다.");
        tamagotchi.setHappiness(tamagotchi.getHappiness() + 5);
        tamagotchi.setCleanLiness(tamagotchi.getCleanLiness() - 10);
        tamagotchi.setHunger(tamagotchi.getHunger() + 10);
        return true;
    }

    private boolean quest() {
        System.out.println("당신은" + tamagotchi.getName() + "와 탐색을 하여 돈을 벌었습니다!");
        item.setMoney(item.getMoney() + (int)(Math.random()*7000+1000));
        System.out.println("가진 돈: " + item.getMoney());
        tamagotchi.setHunger(tamagotchi.getHunger() + 10);
        tamagotchi.setHappiness(tamagotchi.getHappiness() - 6);
        tamagotchi.setCleanLiness(tamagotchi.getCleanLiness() - 10);
        return true;
    }
}
