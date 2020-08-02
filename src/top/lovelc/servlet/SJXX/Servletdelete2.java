package top.lovelc.servlet.SJXX;

import top.lovelc.test.CLXX.Delete1;
import top.lovelc.test.CLXX.Select1;
import top.lovelc.test.Login;
import top.lovelc.test.SJXX.Delete2;
import top.lovelc.util.Time;
import top.lovelc.www.CLXX;
import top.lovelc.www.SJXX;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Servletdelete2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************试图删除信息*************");
        System.out.println(Time.t());
        System.out.println("请求方式->"+req.getMethod());
        req.setCharacterEncoding("UTF-8");
        String dno = req.getParameter("dno");
        String id = req.getParameter("id");
        System.out.println("要删除的工号："+dno);
        System.out.println("操作人ID："+id);

        Login li = new Login();
        ArrayList<String> l = li.userloginid(id);
        if (l.size() < 1){
            System.out.println("登陆失败");
            resp.sendRedirect("http://localhost:8080/QYCLGL/error.html");
            System.out.println("*************删除失败*************");
        }else {
            Delete2 de = new Delete2(dno);
            int d = de.delete2();
            req.setAttribute("d",d);
            req.setAttribute("l",l);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin2.jsp");
            requestDispatcher.forward(req,resp);
            System.out.println("*************删除成功*************");
        }
    }
}
