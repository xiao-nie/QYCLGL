package top.lovelc.servlet.WXXX;

import top.lovelc.test.Login;
import top.lovelc.test.SJXX.Delete2;
import top.lovelc.test.WXXX.Delete3;
import top.lovelc.util.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Servletdelete3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************试图删除信息*************");
        System.out.println(Time.t());
        System.out.println("请求方式->"+req.getMethod());
        req.setCharacterEncoding("UTF-8");
        String mno = req.getParameter("mno");
        String id = req.getParameter("id");
        System.out.println("要删除的维修编号："+mno);
        System.out.println("操作人ID："+id);

        Login li = new Login();
        ArrayList<String> l = li.userloginid(id);
        if (l.size() < 1){
            System.out.println("登陆失败");
            resp.sendRedirect("http://localhost:8080/QYCLGL/error.html");
            System.out.println("*************删除失败*************");
        }else {
            Delete3 de = new Delete3(mno);
            int d = de.delete3();
            req.setAttribute("d",d);
            req.setAttribute("l",l);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin3.jsp");
            requestDispatcher.forward(req,resp);
            System.out.println("*************删除成功*************");
        }
    }
}
