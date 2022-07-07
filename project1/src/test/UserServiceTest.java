package test;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class UserServiceTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        System.out.println(userService.login(new User(null,"chuanze","124578369")));
    }
}
