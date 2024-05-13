package generic.animal;

public class Animal {
    private String name;
    private int size;

    public Animal(String name, int size) {
        this.name = name;
        this.size = size;
    }
    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void sound() {
        System.out.println("동물 울음 소리");
    }

    @Override
    public String toString() { // 객체를 문자열로 반환
        return "동물{" + "이름= " + name + ", 크기= " + size + "}";
    }
}
