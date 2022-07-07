package dao.impl;

import dao.UserDao;
import pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsernameAndPsd(String username, String password) {
        String sql="select id,username,psd from user WHERE username=? and psd=?";
        return queryForOne(User.class,sql,username,password);
    }
}
