
package comparingstudents;

/**
 *
 * @author Michal Jiránek
 */
public class Student implements CompareInterface, Comparable<Student>{
    private String firstName;
    private String lastName;
    private int studentNumber;

    public Student(String firstName, String lastName, int studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
    }

    
    @Override
    public String toString() {
        return String.format("%10s %10s %10d", firstName, lastName, studentNumber);
    }

    /*public boolean isBigger(Student student) {
        return this.studentNumber > student.studentNumber
    }*/

    @Override
    public boolean isBigger(CompareInterface o) {
        return this.studentNumber > ((Student)o).studentNumber;
    }

    /*@Override //kdyby bylo jen Comparable bez <>, kdyz Coparable<Students> .. viz dole
    public int compareTo(Object o) {
        return this.studentNumber - ((Student)o).studentNumber;
    }*/

    @Override
    public int compareTo(Student o) {
        return this.studentNumber - o.studentNumber;
    }
    
    
}
