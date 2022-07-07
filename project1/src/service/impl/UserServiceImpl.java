package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    //需要操作数据库，所以导入UserDao
    private UserDao userDao=new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPsd(user.getUsername(),user.getPassword());
    }
}
