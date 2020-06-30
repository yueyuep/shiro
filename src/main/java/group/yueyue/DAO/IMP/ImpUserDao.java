package group.yueyue.DAO.IMP;

import group.yueyue.DAO.IUserDao;
import group.yueyue.Unity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * Create by lp on 2020/6/24
 */
@Repository
public class ImpUserDao implements IUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findUser(String username) {


        User user = jdbcTemplate.queryForObject(
                "select * from user where name=?",
                new Object[]{username},
                new BeanPropertyRowMapper<User>(User.class));
        return user;
    }
}
