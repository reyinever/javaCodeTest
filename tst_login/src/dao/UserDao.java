package dao;

import domain.User;
import util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /*
     * 登录方法
     * @param:*/
    public User login(User loginUser) {
        try {
            //sql语句
            String sql = "select * from t3 where name=? and password=?";
            //查询数据库并将查询结果转换为对象返回
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getName(),
                    loginUser.getPassword());
            return user;
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
