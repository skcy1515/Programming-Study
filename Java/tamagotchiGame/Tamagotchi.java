package tamagotchiGame;

public class Tamagotchi {
    private String name;
    private int hunger;
    private int happiness;
    private int cleanLiness;
    private int growthLevel;
    private int days; // 날짜
    private int time; // 시간

    public Tamagotchi(String name) { // 생성자, 이름을 인자로 받아 다마고치 객체 생성
        this.name = name;
        this.hunger = 50;
        this.happiness = 50;
        this.cleanLiness = 50;
        this.growthLevel = 1;
        this.days = 0;
        this.time = 1;
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
        return cleanLiness;
    }

    public void setCleanLiness(int cleanliness) {
        this.cleanLiness = cleanliness;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void printStatus(){
        System.out.println(name + "의 상태");
        System.out.println("--------------------");
        System.out.println("배고픔: " + hunger + " 행복도: " + happiness + " 청결도: " + cleanLiness + " 레벨: " + growthLevel);
    }

}
