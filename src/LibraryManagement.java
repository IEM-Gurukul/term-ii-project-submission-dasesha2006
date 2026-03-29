import java.util.*;

abstract class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    
    abstract void display();
}


class Student extends Person {
    int studentId;

    Student(int studentId, String name) {
        super(name);
        this.studentId = studentId;
    }

    
    void display() {
        System.out.println("Student ID: " + studentId + ", Name: " + name);
    }
}

class Book {
    int id;
    String name;
    String author;
    boolean isIssued;
    String issuedTo;

    Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isIssued = false;
        this.issuedTo = "";
    }

    void display() {
        System.out.println(id + " | " + name + " | " + author +
                " | Issued: " + isIssued +
                (isIssued ? " to " + issuedTo : ""));
    }
}

public class LibraryManagement {

    static Book[] books = new Book[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    
    static void addBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Book Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Author Name: ");
            String author = sc.nextLine();

            books[count++] = new Book(id, name, author);
            System.out.println("Book Added!\n");

        } catch (Exception e) {
            System.out.println("Invalid Input! Please try again.\n");
            sc.nextLine(); // clear buffer
        }
    }

    
    static void viewBooks() {
        if (count == 0) {
            System.out.println("No books available.\n");
            return;
        }

        for (int i = 0; i < count; i++) {
            books[i].display();
        }
        System.out.println();
    }

    
    static void issueBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student ID: ");
            int sid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String sname = sc.nextLine();

            Student s = new Student(sid, sname); // inheritance + abstraction

            for (int i = 0; i < count; i++) {
                if (books[i].id == id) {
                    if (!books[i].isIssued) {
                        books[i].isIssued = true;
                        books[i].issuedTo = s.name;
                        System.out.println("Book Issued to:");
                        s.display(); // polymorphism (method override)
                    } else {
                        System.out.println("Already Issued!");
                    }
                    return;
                }
            }
            System.out.println("Book Not Found!");

        } catch (Exception e) {
            System.out.println("Invalid Input!\n");
            sc.nextLine();
        }
    }

    
    static void returnBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            for (int i = 0; i < count; i++) {
                if (books[i].id == id) {
                    if (books[i].isIssued) {
                        books[i].isIssued = false;
                        books[i].issuedTo = "";
                        System.out.println("Book Returned!");
                    } else {
                        System.out.println("Book was not issued!");
                    }
                    return;
                }
            }
            System.out.println("Book Not Found!");

        } catch (Exception e) {
            System.out.println("Invalid Input!\n");
            sc.nextLine();
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            
            try {
                choice = sc.nextInt();

                switch (choice) {
                    case 1: addBook(); break;
                    case 2: viewBooks(); break;
                    case 3: issueBook(); break;
                    case 4: returnBook(); break;
                    case 5: System.out.println("Thank you!"); break;
                    default: System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 5);
    }
}