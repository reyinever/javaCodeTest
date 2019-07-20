package cn.javacode.dao.impl;

import cn.javacode.dao.ProvinceDao;
import cn.javacode.domain.Province;
import cn.javacode.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    //声明一个成员变量 jdbctemplate
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        //定义sql
        String sql="select * from provice";
        //执行sql
        List<Province> list=template.query(sql,new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
