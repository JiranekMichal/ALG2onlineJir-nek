
package comparingstudents;

import comparingstudents.mycomparing.CompareInterface;
import java.util.Objects;

/**
 *
 * @author Michal Jiránek
 */
public class Student implements CompareInterface, Comparable<Student>{
    private String firstName;
    private String lastName;
    private int studentNumber;
    private double [] grades = {0};
    
    
    public Student(String firstName, String lastName, int studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
    }

    public void getGrades(double...grades){
        this.grades = grades;
    }
    
    @Override
    public String toString() {
        return String.format("%10s %10s %10d", firstName, lastName, studentNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }
    
    //TODO calculateAverage
    public double calculateAverage(){
        double average = 0;
        for (int i = 0; i < grades.length; i++) {
            average += grades[i];
        }
        average = average / grades.length;
        return average;
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

    //pri zmene equals zmenit i hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.firstName);
        hash = 89 * hash + Objects.hashCode(this.lastName);
        hash = 89 * hash + this.studentNumber;
        return hash;
    }

    //default in Object
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.studentNumber != other.studentNumber) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }
    
    
    
}
