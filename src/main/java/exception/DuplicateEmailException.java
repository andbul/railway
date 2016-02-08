package exception;

/**
 * Created by andrey on 06.02.16.
 */
public class DuplicateEmailException extends DuplicateException {

    public DuplicateEmailException(String paramname, String param) {
        super(paramname, param);
    }
}
