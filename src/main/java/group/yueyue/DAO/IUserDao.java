package group.yueyue.DAO;

import group.yueyue.Unity.User;

/**
 * Create by lp on 2020/6/24
 * 用户相关的接口
 */
public interface IUserDao {
    public User findUser(String username);
}
