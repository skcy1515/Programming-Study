package TamagotchiGame;

public class Work {
    private Item item;

    public Work(Item item) {
        this.item = item;
    }

    public void working() {
        System.out.println("당신을 아르바이트를 하여 돈을 얻었습니다!");
        item.setMoney(item.getMoney() + 5000);
        System.out.println("가진 돈: " + item.getMoney());
    }
}
