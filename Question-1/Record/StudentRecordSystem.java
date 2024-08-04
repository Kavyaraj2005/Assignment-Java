package Record;

public class StudentRecordSystem {
    private Student[] students = new Student[20];
    private int count = 0;

    // Add a student
    public void addStudent(Student student) {
        if (count < students.length) {
            students[count] = student;
            count++;
        } else {
            System.out.println("Student array is full.");
        }
    }

    // Get a student by ID
    public Student getStudent(int studentID) {
        for (int i = 0; i < count; i++) {
            if (studentID == students[i].getStudentID()) {
                return students[i];
            }
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        for (int i = 0; i < count; i++) {
            System.out.println(students[i].toString());
        }
    }
}
