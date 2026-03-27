abstract class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
      
    }

    abstract void displayDetails();
}
class Student extends Person {
    public Student(String name, int id) {
        super(name, id);
    }

        @Override
    void displayDetails() {
        System.out.println("Student ID: " + id + ", Name: " + name);
    }
}
class Book {
    int bookId;
    String title;
    String author;
    boolean isIssued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void displayBook() {
        System.out.println(bookId + " | " + title + " | " + author + " | Issued: " + isIssued);
    }
}