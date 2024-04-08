package day;

public class Day {
    private String work;

    public void set(String work) {
        this.work = work;
    }

    public void show() {
        if (this.work == null) {
            System.out.println("없습니다.");
        }
        else {
            System.out.println(this.work + "입니다.");
        }
    }
}
