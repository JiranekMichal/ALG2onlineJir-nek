
package comparingstudents;

import static comparingstudents.mycomparing.MyComparing.print;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Michal Jiránek
 */
public class Comparing {
    public static void main(String[] args) {
        Student[] students = Datasource.loadDataAsArray();
        students[0].getGrades(5,2.5,3,5,1.5);
        students[1].getGrades(1,1.5,2,2,1.5);
        students[2].getGrades(3,2.5,3,2,1.5);
        //test shodnosti objektu - nemusí být stejný objekt, staci, kdyz ma stejna data
        System.out.println(students[0].equals(students[1]));
        System.out.println("Array:");
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
        
        
        System.out.println("Sort by firstname");
        Arrays.sort(students, new ComparatorByFirstName());
        print(students);
        
        System.out.println("Sort by lastname");
        Arrays.sort(students, new Comparator<Student>(){ //anonymni trida implemetujici Comparator interface
            @Override
            public int compare(Student o1, Student o2) {
                Collator col = Collator.getInstance(new Locale("cs","CZ")); //tovarni metoda
                return col.compare(o1.getLastName(), o2.getLastName()); //trida na trideni cesky
                //return (o1.getLastName()).compareTo(o2.getLastName()); //ASCII trideni..nejdriv velka pak mala pismena
            }
        });
        print(students);
        
        Arrays.sort(students, (Student o1, Student o2) -> (o1.getLastName()).compareTo(o2.getLastName()) //lambda výraz
        );
        
        //setridit podle prumeru
        System.out.println("Sort by average");
        Arrays.sort(students, new ComparatorByGrades());
        print(students);
    }
    
}
