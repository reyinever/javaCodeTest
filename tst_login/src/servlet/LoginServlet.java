package servlet;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        /*
        //获取请求参数
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        //创建User对象
        User loginUser = new User();
        loginUser.setName(name);
        loginUser.setPassword(password);

         */
        //使用BeanUtils封装对象
        User loginUser=new User();
        Map<String,String[]> map=request.getParameterMap();
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用UserDao的login方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        if (user == null) {
            System.out.println("登录失败");
            //登录失败
            request.getRequestDispatcher("/failServlet").forward(request, response);
        } else {
            System.out.println("登录成功");
            //登录成功
            //存储数据
            request.setAttribute("user", user);
            //转发
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
