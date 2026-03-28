abstract class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id=id;
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

class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();


    void addBook(Book b) {
        books.add(b);
        System.out.println("Book added successfully!");
    }

    
    void deleteBook(int id) {
        books.removeIf(b -> b.bookId == id);
        System.out.println("Book deleted!");
    }

    
    void searchBook(String keyword) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(keyword) || b.author.equalsIgnoreCase(keyword)) {
                b.displayBook();
            }
        }
    }

    
    void issueBook(int bookId) {
        try {
            for (Book b : books) {
                if (b.bookId == bookId) {
                    if (!b.isIssued) {
                        b.isIssued = true;
                        System.out.println("Book issued successfully!");
                        return;
                    } else {
                        throw new Exception("Book already issued!");
                    }
                }
            }
            throw new Exception("Book not found!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    void returnBook(int bookId) {
        try {
            for (Book b : books) {
                if (b.bookId == bookId) {
                    if (b.isIssued) {
                        b.isIssued = false;
                        System.out.println("Book returned successfully!");
                        return;
                    } else {
                        throw new Exception("Book was not issued!");
                    }
                }
            }
            throw new Exception("Book not found!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    void showBooks() {
        for (Book b : books) {
            b.displayBook();
        }
    }
}