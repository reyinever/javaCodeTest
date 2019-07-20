package cn.javacode.web;

import cn.javacode.domain.Province;
import cn.javacode.service.ProvinceService;
import cn.javacode.service.impl.ProvinceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        //1.调用service查询
        ProvinceService service=new ProvinceServiceImpl();
        List<Province> list=service.findAll();
        //2.序列化list为json
        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(list);
        System.out.println(json);

         */
         ProvinceService Service=new ProvinceServiceImpl();
         String json=Service.findAllJson();
        //3.响应结果
        response.setHeader("content-type","application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
