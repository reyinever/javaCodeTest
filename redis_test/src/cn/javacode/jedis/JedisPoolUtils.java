package cn.javacode.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {
    public static JedisPool jedisPool;

    static{
        //读取配置文件
        InputStream inputStream =JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties=new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取配置文件中的参数值
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));

        //创建连接池
        jedisPool=new JedisPool(jedisPoolConfig, properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
    }
    public static Jedis getJedis(){
        //获取连接
        return jedisPool.getResource();
    }

}
