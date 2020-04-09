
package comparingstudents;

import static comparingstudents.MyComparing.print;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Michal Jiránek
 */
public class Comparing {
    public static void main(String[] args) {
        System.out.println("Array:");
        Student[] students = Datasource.loadDataAsArray();
        print(students);
        System.out.println("Sort by number");
        //sortByNumber(students);
        //sort(students);
        Arrays.sort(students);//students musí být typove kompatibilni s interface Comparable(preprogramovany)
        print(students);
        
        System.out.println("List:");
        
        List<Student> students2 = Datasource.loadDataList();
        print(students2);
        System.out.println("Sort by number");
        //sortByNumber(students);
        //sort(students);
        Collections.sort(students2);//students musí být typove kompatibilni s interface Comparable(preprogramovany)
        print(students2);
    }
    
}
