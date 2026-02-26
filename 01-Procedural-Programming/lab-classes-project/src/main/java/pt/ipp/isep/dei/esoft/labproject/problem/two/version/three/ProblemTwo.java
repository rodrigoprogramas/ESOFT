package pt.ipp.isep.dei.esoft.labproject.problem.two.version.three;

public class ProblemTwo {
    public static boolean sortStudentsByAscendingNumber(Student[] students) {
        if (students == null){
            return false;
        }
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].number > students[j + 1].number) {
                    swapStudentArrayPositions(students, j, j + 1);
                }
            }
        }
        return true;
    }

    public static boolean sortStudentsByDescendingGrade(Student[] students) {
        if (students == null){
            return false;
        }
        for (int i = 0 ; i < students.length; i++){
            for(int j = 0 ; j < students.length - i - 1; j++){
                if (students[j].grade < students[j + 1 ].grade) {
                    swapStudentArrayPositions(students,j,j+1);
                }
            }

        }
        return true;
    }

    public static void swapStudentArrayPositions(Student[] array, int indexOne, int indexTwo){
        Student temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}