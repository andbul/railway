package daotest;

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
        User user = new User();
        user.setLogin("persistTUrLogin");
        user.setPassword("persistTUPswd");
        user.setName("persistTUName");
        user.setEmail("persistTUEmail");

        //Save user in db
        repository.create(user);

        //Change
        user.setName("persistNewName");

        //Update
        repository.update(user);

        //Read user and check equals
        User user1 = repository.read(user.getLogin());
        assertEquals(user,user1);

        //Delete user
        repository.delete(user.getLogin());
    }

    @Test
    public void TestFindByLoginRecord() throws Exception {
        User user = new User();
        user.setLogin("loginTULogin");
        user.setPassword("loginTUPswd");
        user.setName("loginTUName");
        user.setEmail("loginTUEmail");

        repository.create(user);
        User user1 = repository.findByLogin("loginTULogin");

        assertEquals(user,user1);

        //Delete user
        repository.delete(user.getLogin());
    }

    @Test
    public void TestFindByLoginAndPasswordRecord() throws Exception {
        User user = new User();
        user.setLogin("loginPassTULogin");
        user.setPassword("loginPassTUPswd");
        user.setName("loginPassTUName");
        user.setEmail("loginPassTUEmail");

        repository.create(user);
        User user1 = repository.findByLoginAndPassword("loginPassTULogin", "loginPassTUPswd");

        assertEquals(user,user1);

        //Delete user
        repository.delete(user.getLogin());
    }

    @Test
    public void TestFindByEmailRecord() throws Exception {
        User user = new User();
        user.setLogin("emailTULogin");
        user.setPassword("emailTUPswd");
        user.setName("emailTUName");
        user.setEmail("emailTUEmail");

        repository.create(user);
        User user1 = repository.findByEmail("emailTUEmail");

        assertEquals(user,user1);

        //Delete user
        repository.delete(user.getLogin());
    }
}
