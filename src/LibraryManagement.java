abstract class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
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