package pt.ipp.isep.dei.esoft.labproject.problem.three.version.one.todo;

public class Student {

    // Attributes
    private int number;
    private String name;
    private int grade;

    // Constructor
    public Student(int number, String name) {
        if (isValidNumber(number)){
            this.number = number;
        }else{
            throw new IllegalArgumentException("Student number need to be 7 digits");
        }
        if(isValidName(name)){
            this.name = name;
        }else {
            throw new IllegalArgumentException("Student name cannot be shorter than 5 chars");
        }
        this.grade = -1;
    }

    // Operations
    private boolean isValidNumber(int number) {
        if (number != Math.abs(number)){
            return false;
        }

        String strNumber = Integer.toString(number);
        return (strNumber.length() == 7);
    }
    private boolean isValidName(String name) {
        if (name == null){
            return false;
        }
        name = name.trim();
        return (name.length() >= 5);
    }

    private boolean isValidGrade(int grade) {
        return (grade < 20 && grade >= 0);
    }

    private boolean isEvaluated() {
        return (this.grade >= 0);
    }

    public void doEvaluation(int grade) {
        if (isValidGrade(grade) && !this.isEvaluated()){
            this.grade = grade;
        }
    }

    public boolean isApproved() {
        return (this.grade >= 10);
    }

    public int getNumber(){
        return this.number;
    }

    public int getGrade(){
        return this.grade;
    }
}