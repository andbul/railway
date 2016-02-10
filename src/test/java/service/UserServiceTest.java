package service;

import entity.User;
import exception.DuplicateException;
import exception.UserNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrey on 10.02.16.
 */
@FixMethodOrder
public class UserServiceTest {

    UserService service = new UserService();
    Map<String,String> params;
    @Before
    public void setData(){
        params = new HashMap<>();
        params.put("login"      ,"STLogin");
        params.put("password"   ,"STPswd");
        params.put("email"      ,"STMail");
        params.put("name"       ,"STName");
        params.put("surname"    ,"STSName");
    }

    @Test
    public void TestFindByLogin(){
        User admin = service.getByLogin("admin");
        Assert.assertEquals(admin.getLogin(),"admin");
    }
    @Test
    public void TestCRUD(){
        try {
            service.create(params);
            params.put("name", "STUpdatedName");
            service.update(params);
            User user = service.getByLogin(params.get("login"));
            Assert.assertEquals(user.getName(),params.get("name"));

        } catch (DuplicateException e) {
            Assert.fail("Error while creating:Duplicate exception");
        } catch (UserNotFoundException e) {
            Assert.fail("Error while updating:User not found exception");
        } finally {
            try {
                service.delete(params.get("login"));
            } catch (UserNotFoundException e) {
                Assert.fail("Error while deleting");
            }
        }
    }

}
