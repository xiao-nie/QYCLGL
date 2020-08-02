package top.lovelc.servlet;

import top.lovelc.test.USR.Insert;
import top.lovelc.test.USR.Select;
import top.lovelc.util.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servletzhuce extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Time.t());
        System.out.println("请求方式->"+req.getMethod());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************试图注册*************");
        System.out.println(Time.t());
        System.out.println("请求方式->"+req.getMethod());
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String no = req.getParameter("no");
        String type = req.getParameter("type");
        String password = req.getParameter("password");
        System.out.println("姓名："+name);
        System.out.println("工号："+no);
        System.out.println("类型："+type);
        System.out.println("密码："+password);

        Select se = new Select(no);
        boolean s = se.selects();
        if (s == false){
            System.out.println("查不到数据，允许注册！");
            Insert in = new Insert(no,name,type,password);
            int ups = in.inserts();
            if (ups == 100){
                req.setAttribute("zc","2");
            }else {
                req.setAttribute("zc","1");
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req,resp);
        }else {
            System.out.println("查到数据，不允许注册！");
            req.setAttribute("zc","0");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req,resp);
        }

    }
}
