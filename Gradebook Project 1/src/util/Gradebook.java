package util;

import java.util.*;

public class Gradebook {
    private ArrayList<Student> studentsList;

    public Gradebook() {
        // Let's create a list of students
        studentsList = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        // Add a new student to our list
        studentsList.add(student);
    }

    public void displayAllStudents() {
        // Show all students' names and scores
        for (Student s : studentsList) {
            System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
        }
    }

    public void displayAllStudentsLetter() {
        // Show all students' names and their letter grades
        for (Student s : studentsList) {
            System.out.printf("%s\t%s\t%d\t%s\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getLetterGrade());
        }
    }

    public double computeAverage() {
        // Calculate the average score
        double totalScore = 0;
        for (Student s : studentsList) {
            totalScore += s.getGrade().getScore();
        }
        return totalScore / studentsList.size();
    }

    public String computeAverageLetter() {
        // Figure out the average letter grade based on the average score
        int roundedAverage = (int) Math.round(computeAverage());
        return Grade.toLetterGrade(roundedAverage);
    }

    public float findMedianScore() {
        // Find the median score in the list of students
        int numStudents = studentsList.size();
        int[] allScores = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            allScores[i] = studentsList.get(i).getGrade().getScore();
        }
        // Sort the scores and find the median
        Arrays.sort(allScores);
        if (numStudents % 2 == 0) {
            // Median if even number of scores
            return (allScores[numStudents / 2] + allScores[numStudents / 2 - 1]) / 2.0f;
        } else {
            // Median if odd number of scores
            return allScores[numStudents / 2];
        }
    }

    public String findMedianLetter() {
        // Find the median score and convert it to a letter grade
        int numStudents = studentsList.size();
        int[] allScores = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            allScores[i] = studentsList.get(i).getGrade().getScore();
        }
        // Sort the scores
        Arrays.sort(allScores);
        float median;
        if (numStudents % 2 == 0) {
            median = (allScores[numStudents / 2] + allScores[numStudents / 2 - 1]) / 2.0f;
        } else {
            median = allScores[numStudents / 2];
        }
        // Convert median score to a letter grade
        return Grade.toLetterGrade(Math.round(median));
    }

    public int findMinScore() {
        // Find the lowest score among the students
        int minScore = studentsList.get(0).getGrade().getScore();
        for (Student s : studentsList) {
            if (s.getGrade().getScore() < minScore) {
                minScore = s.getGrade().getScore();
            }
        }
        return minScore;
    }

    public String findMinLetter() {
        // Figure out the lowest score and convert it to a letter grade
        int minScore = studentsList.get(0).getGrade().getScore();
        String minLetter = studentsList.get(0).getGrade().getLetterGrade();
        for (Student s : studentsList) {
            if (s.getGrade().getScore() < minScore) {
                minScore = s.getGrade().getScore();
                minLetter = s.getGrade().getLetterGrade();
            }
        }
        return minLetter;
    }

    public int findMaxScore() {
        // Find the highest score among the students
        int maxScore = studentsList.get(0).getGrade().getScore();
        for (Student s : studentsList) {
            if (s.getGrade().getScore() > maxScore) {
                maxScore = s.getGrade().getScore();
            }
        }
        return maxScore;
    }

    public String findMaxLetter() {
        // Figure out the highest score and convert it to a letter grade
        int maxScore = studentsList.get(0).getGrade().getScore();
        String maxLetter = studentsList.get(0).getGrade().getLetterGrade();
        for (Student s : studentsList) {
            if (s.getGrade().getScore() > maxScore) {
                maxScore = s.getGrade().getScore();
                maxLetter = s.getGrade().getLetterGrade();
            }
        }
        return maxLetter;
    }

    public String getLetterGradeByPid(int pid) {
        // Find the letter grade for a specific student by PID
        for (Student s : studentsList) {
            if (s.getPid() == pid) {
                return "The letter grade of the PID " + pid + " is: " + s.getGrade().getLetterGrade();
            }
        }
        return "PID not found.";
    }

    public String getNameByPid(int pid) {
        // Get the full name of a student by their PID
        for (Student s : studentsList) {
            if (s.getPid() == pid) {
                return "The full name of PID " + pid + " is: " + s.getFirstName() + " " + s.getLastName();
            }
        }
        return "PID not found.";
    }

    public String changeStudentGrade(int pid, int newGrade) {
        // Change a student's grade given their PID
        for (Student s : studentsList) {
            if (s.getPid() == pid) {
                s.getGrade().setScore(newGrade);
                return "Grade changed to: " + newGrade + " for PID: " + pid;
            }
        }
        return "PID not found.";
    }
}
