package exception;


public class DuplicateEmailException extends DuplicateException {

    public DuplicateEmailException(String paramname, String param) {
        super(paramname, param);
    }
}
