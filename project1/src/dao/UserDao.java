package dao;

import pojo.User;

public interface UserDao {
    /**
     * 根据用户名和密码查询这个用户
     * @param username
     * @param password
     * @return 如果返回null说明没有这个用户
     */
    public User queryUserByUsernameAndPsd(String username,String password);
}
