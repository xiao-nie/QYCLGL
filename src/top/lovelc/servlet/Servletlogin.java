package top.lovelc.servlet;

import top.lovelc.test.Login;
import top.lovelc.test.Zcselect;
import top.lovelc.util.Time;
import top.lovelc.www.Register;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Servletlogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Time.t());
        System.out.println("请求方式->"+req.getMethod());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************试图登录*************");
        System.out.println(Time.t());
        System.out.println("请求方式->"+req.getMethod());
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("账号："+username);
        System.out.println("密码："+password);
        Login li = new Login();
        ArrayList<String> l = li.userlogin(username,password);
        if (l.size() < 1){
            System.out.println("登陆失败");
            req.setAttribute("m","账号或密码错误!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req,resp);
            System.out.println("*************登陆失败*************");
        }else {
            System.out.println("登陆成功");
            System.out.println("ID:"+l.get(0));
            System.out.println("姓名:"+l.get(1));
            System.out.println("用户权限:"+l.get(2));
            if ("admin     ".equals(l.get(2))){
                req.setAttribute("l",l);
                ArrayList<Register> ru = Zcselect.selects();
                req.setAttribute("ru",ru);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin.jsp");
                requestDispatcher.forward(req,resp);
            }else if ("车辆管理  ".equals(l.get(2))){
                req.setAttribute("l",l);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin1.jsp");
                requestDispatcher.forward(req,resp);
            }else if ("司机管理  ".equals(l.get(2))){
                req.setAttribute("l",l);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin2.jsp");
                requestDispatcher.forward(req,resp);
            }else if ("维修管理  ".equals(l.get(2))){
                req.setAttribute("l",l);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin3.jsp");
                requestDispatcher.forward(req,resp);
            }
            System.out.println("*************成功登录*************");
        }
    }
}
