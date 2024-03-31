package PrimaryReference.ex;

import java.util.Scanner;

public class ProductOrderMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // 엔터키를 통해 입력 버퍼 없앰
        Product[] products = new Product[n];
        Product product = new Product();

        for (int i=0; i<n; i++) {
            System.out.println((i + 1) + "번째 주문 정보를 입력하세요.");

            System.out.print("상품명: ");
            String productName = scanner.nextLine();

            System.out.print("가격: ");
            int price = scanner.nextInt();

            System.out.print("수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            products[i] = product.createProduct(productName, price, quantity);
        }
        product.printProduct(products);
        product.getTotalAmount(products);
        scanner.close();
    }
}
