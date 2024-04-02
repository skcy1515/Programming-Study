package Inheritance;

public class ElectricCar extends Car{

    @Override
    public void move(){
        System.out.println("전기차가 이동합니다.");
    }
    public void charge(){
        System.out.println("충전합니다.");
    }
}
