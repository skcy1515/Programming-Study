package TamagotchiGame;

public class Tamagotchi {
    private String name;
    private int hunger = 50;
    private int happiness = 0;
    private int cleanliness = 50;
    private int growthLevel = 1;

    public Tamagotchi(String name) { // 생성자, 이름을 인자로 받아 다마고치 객체 생성
        this.name = name;
        this.hunger = 50;
        this.happiness = 50;
        this.cleanliness = 50;
        this.growthLevel = 1;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getCleanLiness() {
        return cleanliness;
    }

    public void setCleanLiness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public void printStatus(){
        System.out.println(name + "의 상태");
        System.out.println("--------------------");
        System.out.println("배고픔: " + hunger + " 행복도: " + happiness + " 청결도: " + cleanliness + " 레벨: " + growthLevel);
    }

}
