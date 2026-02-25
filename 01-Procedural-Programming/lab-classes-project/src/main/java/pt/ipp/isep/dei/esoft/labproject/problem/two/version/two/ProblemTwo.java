package pt.ipp.isep.dei.esoft.labproject.problem.two.version.two;



public class ProblemTwo {
    public static boolean sortStudentsByAscendingNumber(int[] studentNumbers, String[] studentNames, int[] studentGrades) {
        if( studentNumbers != null && studentNames != null && studentGrades != null){
            int studentNumbersSize = studentNumbers.length;
            int studentNamesSize = studentNames.length;
            int studentGradesSize = studentGrades.length;
            if (studentNumbersSize == studentNamesSize && studentNamesSize == studentGradesSize){
                for (int i = 0; i < studentNumbersSize ; i++){
                    for(int j = 0; j < studentNumbersSize - i - 1; j++){
                        if (studentNumbers[j] > studentNumbers[j + 1]) {
                            int tempNumber = studentNumbers[j];
                            String tempName = studentNames[j];
                            int tempGrade = studentGrades[j];

                            studentNumbers[j] = studentNumbers[j + 1];
                            studentNumbers[j + 1] = tempNumber;

                            studentNames[j] = studentNames[j + 1];
                            studentNames[j + 1] = tempName;

                            studentGrades[j] = studentGrades[j + 1];
                            studentGrades[j + 1] = tempGrade;

                        }
                    }
                }
                return true;
            }
        }
        return false;

    }

}