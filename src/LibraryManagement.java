abstract class LibraryItem {
    protected int id;
    protected String title;

    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    
    public abstract void display();
}


class Book extends LibraryItem {
    private String author;

    public Book(int id, String title, String author) {
        super(id, title);
        this.author = author;
    }

 
    @Override
    public void display() {
        System.out.println("Book ID: " + id + ", Title: " + title + ", Author: " + author);
    }
}

class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(int id, String title, int issueNumber) {
        super(id, title);
        this.issueNumber = issueNumber;
    }

    @Override
    public void display() {
        System.out.println("Magazine ID: " + id + ", Title: " + title + ", Issue: " + issueNumber);
    }
}


public class LibraryManagement {
    public static void main(String[] args) {
        Book b = new Book(1, "Java Basics", "John Doe");
        Magazine m = new Magazine(2, "Tech Monthly", 5);

        b.display();
        m.display();
    }
}