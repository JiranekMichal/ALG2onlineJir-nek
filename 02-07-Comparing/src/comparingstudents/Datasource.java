
package comparingstudents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Michal Jiránek
 */
public class Datasource {
    public static double[]gradesAlice = {5,2.5,3,5,1.5};
    public static double[]gradesBob = {1,1.5,2,2,1.5};
    public static double[]gradesCyril = {3,2.5,3,2,1.5};
    
    public static Student[] data = {
        new Student("Alice", "Mala", 345),
        new Student("Bob", "Velky", 123),
        new Student("Cyril", "Stredny", 567)
    };
    
    public static Student[] loadDataAsArray(){
        return Arrays.copyOf(data, data.length);
    }
    
    public static List <Student> loadDataList(){
        return Arrays.asList(data);
        //ArrayList<Student> students = new ArrayList<>();
        //students.addAll(Arrays.asList(data));
    }
}
