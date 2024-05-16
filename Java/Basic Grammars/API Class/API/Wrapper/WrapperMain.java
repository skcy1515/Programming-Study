package API.Wrapper;

public class WrapperMain {
    public static void main(String[] args) {
        Integer num1 = new Integer(7); // 박싱
        Integer num2 = new Integer(3); // 박싱

        int int1 = num1.intValue();    // 언박싱
        int int2 = num2.intValue();    // 언박싱

        Character ch = 'X'; // Character ch = new Character('X'); : 오토박싱
        char c = ch;        // char c = ch.charValue();           : 오토언박싱
        System.out.println(c);
    }
}
