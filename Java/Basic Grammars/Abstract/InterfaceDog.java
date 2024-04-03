package Abstract;

public class InterfaceDog implements InterfaceAnimal{
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
    @Override
    public void move() {
        System.out.println("개 이동");
    }
}
