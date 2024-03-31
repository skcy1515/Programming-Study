package PrimaryReference.ex;

public class Product {
    String productName;
    int price;
    int quantity;

    public Product createProduct(String productName, int price, int quantity) {
        Product products1 = new Product();
        products1.productName = productName;
        products1.price = price;
        products1.quantity = quantity;
        return products1;
    }

    public void printProduct(Product[] products) {
        for (Product product : products) {
            System.out.println("상품명: " + product.productName + ", 가격: " + product.price + ", 수량: " + product.quantity);
        }
    }

    public void getTotalAmount(Product[] products) {
        int totalAmount = 0;
        for (Product product : products) {
            totalAmount += product.price * product.quantity;
        }
        System.out.println("총 가격은 " + totalAmount + "입니다.");
    }
}
