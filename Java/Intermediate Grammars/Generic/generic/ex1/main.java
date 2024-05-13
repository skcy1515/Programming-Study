package generic.ex1;

public class main {
    public static void main(String[] args) {
        //원하는 모든 타입 사용 가능
        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.set("안녕");
        String stringValue = stringBox.get();
        System.out.println("stringValue = " + stringValue);

        GenericBox<Double> doubleBox = new GenericBox<Double>();
        doubleBox.set(10.5);
        Double doubleValue = doubleBox.get();
        System.out.println("doubleValue = " + doubleValue);

        //타입 추론: 생성하는 제네릭 타입 생략 가능
        GenericBox<Integer> integerBox2 = new GenericBox<>();
    }
}
