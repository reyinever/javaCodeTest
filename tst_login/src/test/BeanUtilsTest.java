package test;

import cn.javacode.demo.BeanTest;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    @Test
    public void test(){
        User user=new User();
        try {
            BeanUtils.setProperty(user,"name","zs");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }

    @Test
    public void testProperty(){
        /*
        *测试javabean的属性和成员变量的区别
        * */
        BeanTest bt=new BeanTest();
        try {
            //BeanUtils.setProperty(bt,"age",22);
            // 执行结果：BeanTest{name='null', age=0}
            BeanUtils.setProperty(bt,"hehe",22);
            //执行结果：BeanTest{name='null', age=22}
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(bt);
    }
}
