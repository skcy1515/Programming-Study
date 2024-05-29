package tamagotchiGame;

public class Item {
    private int food = 5;
    private int shampoo = 1;
    private int money = 0;
    private final int foodPrice = 1000;
    private final int shampooPrice = 2000;

    public int getShampoo() {
        return shampoo;
    }

    public int getFood() {
        return food;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public int getShampooPrice() {
        return shampooPrice;
    }

    public void setShampoo(int shampoo) {
        this.shampoo = shampoo;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
