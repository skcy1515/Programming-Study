package access.ex;

public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount = 0;

    public void addItem(Item item) {
        if (itemCount >= 10) {
            System.out.println("장바구니가 가득 찼습니다.");
            return;
        } else {
            items[itemCount] = item;
            itemCount++;
        }
    }

    public void displayItems() {
        int total = 0;
        System.out.println("장바구니를 출력합니다.");
        for (int i=0; i<itemCount; i++) {
            Item item = items[i];
            System.out.println("상품명 : " + item.getName() + ", 가격 : " + item.gerPrice() + ", 수량 : " + item.getQuantity());
            total += item.gerPrice() * item.getQuantity();
        }
        System.out.println("총 가격: " + total);
    }
}
