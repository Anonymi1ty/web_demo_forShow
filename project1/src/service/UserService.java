package service;

import pojo.User;

public interface UserService {
    /**
     * 登录
     * @param user
     * @return 如果返回null则，登录失败
     */
    public User login(User user);
}
