package exception;

/**
 * Created by andrey on 03.02.16.
 */
public class UserNotFoundException extends NotFoundException{

    public UserNotFoundException(String paramname, String param) {
        super(paramname, param);
    }
}
