package exception;

/**
 * Created by andrey on 03.02.16.
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
        return "User with " +paramname + " : " + param + " already exists.";
    }
}
