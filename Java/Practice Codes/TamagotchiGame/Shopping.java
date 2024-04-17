package TamagotchiGame;

import java.util.Scanner;

public class Shopping {
    private Item item;

    public Shopping (Item item) {
        this.item = item;
    }

    public boolean buyFood(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("현재 돈: " + item.getMoney());
        System.out.println("몇 개를 구매하시나요? ");
        int count = scanner.nextInt();

        if (item.getMoney() - item.getFoodPrice() * count < 0) {
            System.out.println("돈이 부족합니다. ");
            return false;
        } else {
            item.setMoney(item.getMoney() - item.getFoodPrice() * count);
            item.setFood(item.getFood() + count);
            return true;
        }
    }

    public boolean buyShampoo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("현재 돈: " + item.getMoney());
        System.out.println("몇 개를 구매하시나요? ");
        int count = scanner.nextInt();

        if (item.getMoney() - item.getShampooPrice() * count < 0) {
            System.out.println("돈이 부족합니다. ");
            return false;
        } else {
            item.setMoney(item.getMoney() - item.getShampooPrice() * count);
            item.setShampoo(item.getShampoo() + count);
            return true;
        }
    }
}
