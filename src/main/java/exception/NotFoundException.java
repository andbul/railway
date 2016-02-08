package exception;

/**
 * Created by andrey on 03.02.16.
 */
public class NotFoundException extends Exception {
    private String paramname;
    private String param;

    public NotFoundException(String paramname, String param) {
        this.paramname = paramname;
        this.param = param;
    }

    @Override
    public String getMessage() {
        return "User with " +paramname + " : " + param + " not found.";
    }
}
