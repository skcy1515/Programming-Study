package TamagotchiGame;

public class Clean {
    private Tamagotchi tamagotchi;
    private Item item;

    public Clean(Item item, Tamagotchi tamagotchi) {
        this.item = item;
        this.tamagotchi = tamagotchi;
    }


    public boolean takeShower() {
        if (item.getShampoo() <= 0) {
            System.out.println("샴푸가 없습니다. ");
            return false;
        } else {
            System.out.println("당신은 " + tamagotchi.getName() + "를 목욕시켰습니다.");
            tamagotchi.setCleanLiness(tamagotchi.getCleanLiness() + 50);
            item.setShampoo(item.getShampoo() - 1);
            return true;
        }
    }
}
