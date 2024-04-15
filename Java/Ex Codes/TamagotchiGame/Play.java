package TamagotchiGame;

public class Play {
    private Tamagotchi tamagotchi;

    public Play (Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    public void playing() {
        System.out.println("당신은 " + tamagotchi.getName() + "를 놀아주었습니다.");
        tamagotchi.setHappiness(tamagotchi.getHappiness() + 3);
        tamagotchi.setHunger(tamagotchi.getHunger() + 3);
    }

}
