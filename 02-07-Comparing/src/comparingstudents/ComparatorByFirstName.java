
package comparingstudents;

import java.util.Comparator;

/**
 *
 * @author Michal Jiránek
 */
public class ComparatorByFirstName implements Comparator <Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.getFirstName()).compareTo(o2.getFirstName());
    }

    
}
