package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class UserDaoTest {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        if (userDao.queryUserByUsernameAndPsd("chuanze","12457836")==null)
        System.out.println("fail");
        else
            System.out.println("success");
    }
}
