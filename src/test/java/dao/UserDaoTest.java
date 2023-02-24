package dao;

import model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void insertUser() {
        User user1 = new User(2,"admin2","nguyen1001k@gmail.com",
                "admin","Nguyen","Nguyen Dinh",1,"Ha Noi");
        UserDao dao = new UserDao();
        assertEquals(1,dao.insertUser(user1));
    }

    @Test
    void findByUser() {
        String username = "admin";
        UserDao dao = new UserDao();
        assertEquals(true,dao.findByUsername(username));
    }

}