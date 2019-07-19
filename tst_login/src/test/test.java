package test;

import cn.javacode.demo.BeanTest;
import dao.UserDao;
import domain.User;
import org.junit.Test;

public class test {
    @Test
    public void testLogin(){
        //创建用户对象
        User loginUser=new User();
        loginUser.setName("tom");
        loginUser.setPassword("111");
        //查询用户是否存在
        UserDao dao=new UserDao();
        User user=dao.login(loginUser);

        System.out.println(user);
    }

}