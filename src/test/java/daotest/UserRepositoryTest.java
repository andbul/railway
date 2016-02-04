package java.daotest;

import daotest.User;
import org.junit.Test;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrey on 03.02.16.
 */
public class UserRepositoryTest {
    UserRepository repository = new UserRepositoryImpl();

    @Test
    public void TestPersistenceRecord() throws Exception {
        //Create user
        User user = repository.create();
        user.setLogin("persistTUrLogin");
        user.setPassword("persistTUPswd");
        user.setName("persistTUName");
        user.setEmail("persistTUEmail");
        //Save user in db
        repository.update(user);

        //Read user and check equals
        User user1 = repository.read(user.getId());
        assertEquals(user,user1);

        //Delete user
        repository.delete(user.getId());
    }

    @Test
    public void TestFindByLoginRecord() throws Exception {
        User user = repository.create();
        user.setLogin("loginTULogin");
        user.setPassword("loginTUPswd");
        user.setName("loginTUName");
        user.setEmail("loginTUEmail");

        repository.update(user);
        User user1 = repository.findByLogin("loginTULogin");

        assertEquals(user,user1);

        //Delete user
        repository.delete(user.getId());
    }

    @Test
    public void TestFindByLoginAndPasswordRecord() throws Exception {
        User user = repository.create();
        user.setLogin("loginPassTULogin");
        user.setPassword("loginPassTUPswd");
        user.setName("loginPassTUName");
        user.setEmail("loginPassTUEmail");

        repository.update(user);
        User user1 = repository.findByLoginAndPassword("loginPassTULogin", "loginPassTUPswd");

        assertEquals(user,user1);

        //Delete user
        repository.delete(user.getId());
    }

    @Test
    public void TestFindByEmailRecord() throws Exception {
        User user = repository.create();
        user.setLogin("emailTULogin");
        user.setPassword("emailTUPswd");
        user.setName("emailTUName");
        user.setEmail("emailTUEmail");

        repository.update(user);
        User user1 = repository.findByEmail("emailTUEmail");

        assertEquals(user,user1);

        //Delete user
        repository.delete(user.getId());
    }
}
