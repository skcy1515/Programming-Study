package Constructor.ex;

public class Book {
    String title;
    String author;
    int pages;

    Book() {
        this.title = "";
        this.author = "";
        this.pages = 0;
    }

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.pages = 0;
    }
    Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public void displayInfo(){
        System.out.println("제목: " + title + ", 저자: " + author + ", 페이지: " + pages);
    }
}
