package exception;

/**
 * The class {@code DuplicateException} and its subclasses are a form of
 * {@code Exception} that indicates conditions that something in SQL request
 * has same primary key.
 */
public class DuplicateException extends Exception {
    private String paramname;
    private String param;

    public DuplicateException(String paramname, String param) {
        this.paramname = paramname;
        this.param = param;
    }

    @Override
    public String getMessage() {
        return "User with " + paramname + " : " + param + " already exists.";
    }
}
