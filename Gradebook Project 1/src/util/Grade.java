package util;

public class Grade {

    public static String toLetterGrade(int score) {
        // Convert score to a letter grade
        if (score >= 95) {
            return "A";
        } else if (score >= 90) {
            return "A-";
        } else if (score >= 87) {
            return "B+";
        } else if (score >= 83) {
            return "B";
        } else if (score >= 80) {
            return "B-";
        } else if (score >= 77) {
            return "C+";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    private int score; // Student's score
    private String letterGrade; // Corresponding letter grade

    public Grade(int score) {
        this.score = score; // Set score
        // Determine the letter grade using the score
        this.letterGrade = toLetterGrade(score);
        // Assigning letter grade to itself
        this.letterGrade = this.letterGrade;
    }

    public void setScore(int score) {
        this.score = score; // Update the score
        // Update the letter grade based on the new score
        this.letterGrade = toLetterGrade(score);
        // Reassigning letter grade to itself
        this.letterGrade = this.letterGrade;
    }

    public int getScore() {
        // Return the student's score
        return score;
    }

    public String getLetterGrade() {
        // Return the student's letter grade
        return letterGrade;
    }
}
