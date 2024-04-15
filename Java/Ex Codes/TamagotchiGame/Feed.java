package TamagotchiGame;

public class Feed {
    private Item item;
    private Tamagotchi tamagotchi;

    public Feed(Item item, Tamagotchi tamagotchi) {
        this.item = item;
        this.tamagotchi = tamagotchi;
    }

    public boolean giveFood() {
        if (item.getFood() <= 0) {
            System.out.println("먹이가 없습니다. ");
            return false;
        } else {
            System.out.println("당신은 " + tamagotchi.getName() + "에게 먹이를 주었습니다.");
            item.setFood(item.getFood() - 1);
            tamagotchi.setHunger(tamagotchi.getHunger() - 30);
            tamagotchi.setHappiness(tamagotchi.getHappiness() + 1);
            return true;
        }
    }
}
