# 접근 제어자
자바는 `public` , `private` 같은 접근 제어자(access modifier)를 제공한다. 

접근 제어자를 사용하면 해당 클래스 외부에서 특정 필드나 메서드에 접근하는 것을 허용하거나 제한할 수 있다.

# 접근 제어자의 종류
`private` : 모든 외부 호출을 막는다.

`default` : 같은 패키지안에서 호출은 허용한다.

`protected` : 같은 패키지안에서 호출은 허용한다. 패키지가 달라도 상속 관계의 호출은 허용한다.

`public` : 모든 외부 호출을 허용한다.

# 캡슐화
캡슐화(Encapsulation)는 객체 지향 프로그래밍의 중요한 개념 중 하나다. 

캡슐화는 데이터와 해당 데이터를 처리하는 메서드를 하나로 묶어서 외부에서의 접근을 제한하는 것을 말한다. 

캡슐화를 통해 데이터의 직접적인 변경을 방지하거나 제한할 수 있다.

캡슐화를 안전하게 완성할 수 있게 해주는 장치가 바로 접근 제어자다.

1. 데이터를 숨겨라

객체에는 속성(데이터)과 기능(메서드)이 있다. 캡슐화에서 가장 필수로 숨겨야 하는 것은 속성(데이터)이다.

객체의 데이터는 객체가 제공하는 기능인 메서드를 통해서 접근해야 한다.

2. 기능을 숨겨라

객체의 기능 중에서 외부에서 사용하지 않고 내부에서만 사용하는 기능들이 있다. 이런 기능도 모두 감추는 것이 좋다.

잘 캡슐화 된 예제
```
// BankAccount.java
package access;

public class BankAccount {

    private int balance;

    public BankAccount() {
        balance = 0;
    }

    // public 메서드: deposit
    public void deposit(int amount) {
        if (isAmountValid(amount)) {
            balance += amount;
        } else {
            System.out.println("유효하지 않은 금액입니다.");
        }
    }

    // public 메서드: withdraw
    public void withdraw(int amount) {
        if (isAmountValid(amount) && balance - amount >= 0) {
            balance -= amount;
        } else {
            System.out.println("유효하지 않은 금액이거나 잔액이 부족합니다.");
        }
    }

    // public 메서드: getBalance
    public int getBalance() {
        return balance;
    }

    // private 메서드: isAmountValid
    private boolean isAmountValid(int amount) {
        return amount > 0;
    }
}

// BankAccountMain
package access;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(10000);
        account.withdraw(3000);
        System.out.println("balance = " + account.getBalance());
    }
}
```
`private`

`balance` : 데이터 필드는 외부에 직접 노출하지 않는다. BankAccount 가 제공하는 메서드를 통해서만 접근할 수 있다.

`isAmountValid()` : 입력 금액을 검증하는 기능은 내부에서만 필요한 기능이다. 따라서 private 을 사용했다.

`public`
   
`deposit()` : 입금
`withdraw ()` : 출금
`getBalance()` : 잔고 출력

# 문제
쇼핑카트에 아이템을 담아서 출력하는 프로그램
```
package access.ex;

// Item.java
public class Item {
    private String name;
    private int price;
    private int quantity;

    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int gerPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

// ShoppingCart.java
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

// ShoppingCartMain.java
public class ShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("마늘", 2000, 2);
        Item item2 = new Item("상추", 3000, 4);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.displayItems();
    }
}
```
실행결과
```
장바구니를 출력합니다.
상품명 : 마늘, 가격 : 2000, 수량 : 2
상품명 : 상추, 가격 : 3000, 수량 : 4
총 가격: 16000
```
