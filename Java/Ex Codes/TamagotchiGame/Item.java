package TamagotchiGame;

public class Item {
    private int food = 0;
    private int shampoo = 0;
    private int money = 0;
    private final int foodPrice = 1;
    private final int shampooPrice = 2;

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
