package pt.ipp.isep.dei.esoft.labproject.problem.three.version.two.studentListWithArray.todo;

public class StudentList {

    // Attributes
    private Student[] students;

    // Constructors
    public StudentList() {
        this.students = new Student[0];
    }

    // We create a copy of the input array instead of assigning it directly
    // (this.students = students) to protect the internal state of the class.
    //
    // If we assigned the array directly, both this.students and the external
    // students array would reference the same object in memory. That would allow
    // external code to modify our internal array after the constructor is called,
    // breaking encapsulation.
    //
    // By creating a defensive copy, we ensure that StudentList maintains control
    // over its own data and cannot be modified from outside the class.
    public StudentList(Student[] students) {
        if(students == null){
         throw new IllegalArgumentException(("Students should not be null"));
        }
        this.students = copyStudentsFromArray(students, students.length);
    }

    // Operations
    public void sortByAscendingNumber() {
        for(int i = 0 ; i < students.length; i++){
            for(int j = 0 ; j < students.length - i - 1 ; j++){
                if (students[j].getNumber() > students[j + 1 ].getNumber()) {
                    swapStudentArrayElements(students, j, j +1 );
                }
            }
        }
    }

    public void sortByDescendingGrade() {
        for(int i = 0 ; i < students.length; i++){
            for(int j = 0 ; j < students.length - i - 1 ; j++){
                if (students[j].getGrade() < students[j + 1 ].getGrade()) {
                    swapStudentArrayElements(students, j, j +1 );
                }
            }
        }
    }

    public Student[] toArray() {
        return copyStudentsFromArray(this.students, this.students.length);
    }

    public boolean add(Student student){
        if (student == null) return false;
        if (exists(student)) return false;
        this.copyStudentsFromArray(this.students,this.students.length + 1);
        this.students[this.students.length - 1] = student;
        return true;
    }

    public boolean remove(Student student){
            if (student == null) return false;
            if (exists(student)){
               int removeIndex = this.getIndexOf(student);
               if(removeIndex < 0) return false;
               Student[] firstSlice = copyStudentsFromArray(this.students, removeIndex);
               Student[] secondSlice = copyStudentsFromArray(this.students, removeIndex + 1,this.students.length-removeIndex-1);
               this.students = this.join(firstSlice,secondSlice);
               return true;
            }
            return false;

    }

    private Student[] copyStudentsFromArray(Student[] students, int size) {
      return copyStudentsFromArray(students,0,size);
    }

    private Student[] copyStudentsFromArray(Student[] students, int start, int size) {
        Student[] copyArray = new Student[size];
        for (int i = 0; i < size && (start + i) < students.length; i++) {
            copyArray[i] = students[start + i];
        }
        return copyArray;
    }

    private Student[] join(Student[] students1, Student[] students2) {
        int size = students1.length+students2.length;
        Student[] joinArray = new Student[size];

        for(int i = 0 ; i < students1.length ; i++){
            joinArray[i] = students1[i];
        }

        for(int j = 0 ; j < students2.length; j++){
            joinArray[students1.length + j] = students2[j];
        }

        return joinArray;
    }

    private void swapStudentArrayElements(Student[] array, int indexOne, int indexTwo) {
        Student temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    private boolean exists(Student student){
        for (Student value : this.students) {
            if (value != null && value.equals(student)) {
                return true;
            }
        }
        return false;
    }
    private int getIndexOf(Student student) {
         for(int i = 0 ; i< this.students.length ; i++){
             if(student.equals(this.students[i])){
                 return i;
             }
         }
        return -1;
    }
}