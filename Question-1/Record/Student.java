package Record;

public class Student {
    private int studentID;
    private String name;
    private int age;
    private String department;

    // Constructor
    public Student(int id, String name, int age, String department) {
        this.studentID = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Getters
    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    // toString method
    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Department: " + department;
    }
}
