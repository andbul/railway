package exception;

/**
 * The class {@code NotFoundException} and its subclasses are a form of
 * {@code Exception} that indicates conditions that entity with
 * that primary key does not exist.
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
        return "User with " + paramname + " : " + param + " not found.";
    }
}
