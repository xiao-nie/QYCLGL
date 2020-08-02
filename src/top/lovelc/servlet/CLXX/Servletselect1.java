package top.lovelc.servlet.CLXX;

import top.lovelc.test.Login;
import top.lovelc.test.CLXX.Select1;
import top.lovelc.util.Time;
import top.lovelc.www.CLXX;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Servletselect1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************试图下载表格*************");
        System.out.println(Time.t());
        System.out.println("请求方式->"+req.getMethod());
        req.setCharacterEncoding("UTF-8");
        String type = req.getParameter("type");
        String select = req.getParameter("select");
        String ID = req.getParameter("id");
        System.out.println("请求ID："+ID);
        System.out.println("查询类型："+type);
        System.out.println("查询内容："+select);

        Login li = new Login();
        ArrayList<String> l = li.userloginid(ID);
        if (l.size() < 1){
            System.out.println("登陆失败");
            resp.sendRedirect("http://localhost:8080/QYCLGL/error.html");
        }else {
            Select1 se = new Select1(type,select);
            ArrayList<CLXX> s = se.query();
            System.out.println(s);
            if (s.size() <1){
                System.out.println("查不到数据！");
                req.setAttribute("l",l);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin1.jsp");
                requestDispatcher.forward(req,resp);
            }else {
                System.out.println("查询到数据");
                req.setAttribute("type",type);
                req.setAttribute("select",select);
                req.setAttribute("l",l);
                req.setAttribute("s",s);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/excel.jsp");
                requestDispatcher.forward(req,resp);
                System.out.println("*************下载表格成功*************");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************试图查询数据*************");
        System.out.println(Time.t());
        System.out.println("请求方式->"+req.getMethod());
        req.setCharacterEncoding("UTF-8");
        String type = req.getParameter("type");
        String select = req.getParameter("select");
        String ID = req.getParameter("id");
        System.out.println("请求ID："+ID);
        System.out.println("查询类型："+type);
        System.out.println("查询内容："+select);

        Login li = new Login();
        ArrayList<String> l = li.userloginid(ID);
        if (l.size() < 1){
            System.out.println("登陆失败");
            resp.sendRedirect("http://localhost:8080/QYCLGL/error.html");
        }else {
            Select1 se = new Select1(type,select);
            ArrayList<CLXX> s = se.query();
            System.out.println(s);
            if (s.size() <1){
                System.out.println("查不到数据！");
                req.setAttribute("l",l);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin1.jsp");
                requestDispatcher.forward(req,resp);
            }else {
                System.out.println("查询到数据");
                req.setAttribute("type",type);
                req.setAttribute("select",select);
                req.setAttribute("l",l);
                req.setAttribute("s",s);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin1.jsp");
                requestDispatcher.forward(req,resp);
                System.out.println("*************数据查询成功*************");
            }
        }

    }
}
