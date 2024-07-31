package util;

public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;

    public Student(String firstName, String lastName, int pid, Grade grade) {
        // Set up the student's details
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;
    }

    public String getFirstName() {
        // Return the student's first name
        return firstName;
    }

    public String getLastName() {
        // Return the student's last name
        return lastName;
    }

    public int getPid() {
        // Return the student's PID
        return pid;
    }

    public Grade getGrade() {
        // Return the student's grade
        return grade;
    }
}

