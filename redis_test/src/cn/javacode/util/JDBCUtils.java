package cn.javacode.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
* JDBC工具类 使用Druid连接池
* */
public class JDBCUtils {
    //定义成员变量
    private static DataSource ds;

    static{
        try {
        //加载配置文件
        Properties pro=new Properties();
        InputStream is=JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        //初始化连接池对象
        pro.load(is);
        ds=DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }
    //获取连接Connection对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
