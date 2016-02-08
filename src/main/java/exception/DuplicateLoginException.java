package exception;

/**
 * Created by andrey on 03.02.16.
 */
public class DuplicateLoginException extends DuplicateException {
    public DuplicateLoginException(String paramname, String param) {
        super(paramname, param);
    }
}
