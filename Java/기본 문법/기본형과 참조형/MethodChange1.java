package PrimaryReference;

public class MethodChange1 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("메서드 호출 전 a의 값: " + a); // 10
        changePrimitive(a);
        System.out.println("메서드 호출 후 a의 값: "+a); // 10
    }

    static void changePrimitive (int x) {
        x = 20;
        // 메서드가 종료되면 매개변수 x는 제거됨
    }
}
