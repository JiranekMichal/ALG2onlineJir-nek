package utils;

/**
 * Trida s vlastni vyjimkou
 *
 * @author Michal Jiránek
 */
public class IllegalFilenameException extends IllegalArgumentException {

    public IllegalFilenameException(String messege) {
        super(messege);
    }

}
