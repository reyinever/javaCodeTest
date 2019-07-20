package cn.javacode.service.impl;

import cn.javacode.dao.ProvinceDao;
import cn.javacode.dao.impl.ProvinceDaoImpl;
import cn.javacode.domain.Province;
import cn.javacode.service.ProvinceService;
import cn.javacode.jedis.JedisPoolUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    //声明dao
    private ProvinceDao dao=new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    //使用redis缓存
    @Override
    public String findAllJson() {
        //1.先从redis中查询数据
        //1.1获取redis客户端连接
        Jedis jedis= JedisPoolUtils.getJedis();
        String provinceJson=jedis.get("province");
        //2.判断 provinceJson数据是否为null
        if(provinceJson==null||provinceJson.length()==0){
            System.out.println("redis中没数据，查询数据库...");
            //2.1从数据库中查询
            List<Province> list=dao.findAll();
            //2.2将list序列化为json
            ObjectMapper objectMapper=new ObjectMapper();
            try {
                provinceJson=objectMapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            //2.3将json数据存入redis
            jedis.set("province",provinceJson);

        }else{
            System.out.println("redis中有数据，查询缓存...");
        }
        //归还连接
        jedis.close();
        return provinceJson;
    }
}
