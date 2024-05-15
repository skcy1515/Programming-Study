package tamagotchiGame;

import java.util.Scanner;

public class Shopping extends usable{
    public Shopping (Item item, Tamagotchi tamagotchi) {
        super(item, tamagotchi);
    }

    @Override
    public boolean use(){
        if (tamagotchi.getTime() == 3) {
            System.out.println("쇼핑은 아침, 점심에만 할 수 있습니다.");
            return false;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("무엇을 사겠습니까? (1: 먹이, 2: 샴푸)");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return buyFood();
            case 2:
                return buyShampoo();
            default:
                System.out.println("올바른 선택이 아닙니다.");
                return false;
        }
    }

    private boolean buyFood(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("현재 돈: " + item.getMoney());
        System.out.println("먹이 가격: " + item.getFoodPrice());
        System.out.println("몇 개를 구매하시나요? ");
        int count = scanner.nextInt();

        if (item.getMoney() - item.getFoodPrice() * count < 0) {
            System.out.println("돈이 부족합니다. ");
            return false;
        } else {
            item.setMoney(item.getMoney() - item.getFoodPrice() * count);
            item.setFood(item.getFood() + count);
            System.out.print("현재 먹이 개수: " + item.getFood());
            System.out.println(", 남은 돈: " + item.getMoney());
            tamagotchi.setTime(tamagotchi.getTime() + 1);
            tamagotchi.setHunger(tamagotchi.getHunger() + 5);
            tamagotchi.setHappiness(tamagotchi.getHappiness() - 3);
            tamagotchi.setCleanLiness(tamagotchi.getCleanLiness() - 5);
            return true;
        }
    }

    private boolean buyShampoo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("현재 돈: " + item.getMoney());
        System.out.println("샴푸 가격: " + item.getShampooPrice());
        System.out.println("몇 개를 구매하시나요? ");
        int count = scanner.nextInt();

        if (item.getMoney() - item.getShampooPrice() * count < 0) {
            System.out.println("돈이 부족합니다. ");
            return false;
        } else {
            item.setMoney(item.getMoney() - item.getShampooPrice() * count);
            item.setShampoo(item.getShampoo() + count);
            System.out.print("현재 샴푸 개수: " + item.getShampoo());
            System.out.println(", 남은 돈: " + item.getMoney());
            tamagotchi.setTime(tamagotchi.getTime() + 1);
            tamagotchi.setHunger(tamagotchi.getHunger() + 5);
            tamagotchi.setHappiness(tamagotchi.getHappiness() - 3);
            tamagotchi.setCleanLiness(tamagotchi.getCleanLiness() - 5);
            return true;
        }
    }
}
