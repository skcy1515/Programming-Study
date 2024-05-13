package generic.ex2;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class main {
    public static void main(String[] args) {
        Animal animal = new Animal("동물", 0);
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 60);

        Box<Dog> dogBox = new Box<>();
        dogBox.set(dog);
        System.out.println("findDog = " + dogBox.get());

        Box<Cat> catBox = new Box<>();
        catBox.set(cat);
        System.out.println("findCat = " + catBox.get());
    }
}
