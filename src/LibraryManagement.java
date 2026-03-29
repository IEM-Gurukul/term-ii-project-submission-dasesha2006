import java.util.*;
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
        System.out.println("Book added successfully");
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
public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n--- LIBRARY MENU ---");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Show Books");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    lib.addBook(new Book(id, title, author));
                    break;

                case 2:
                    System.out.print("Enter Book ID to delete: ");
                    lib.deleteBook(sc.nextInt());
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Title/Author: ");
                    lib.searchBook(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter Book ID to issue: ");
                    lib.issueBook(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Book ID to return: ");
                    lib.returnBook(sc.nextInt());
                    break;

                case 6:
                    lib.showBooks();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}