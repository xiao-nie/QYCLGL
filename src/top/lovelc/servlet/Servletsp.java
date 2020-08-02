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

public class Servletsp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************试图审批*************");
        System.out.println(Time.t());
        System.out.println("请求方式->"+req.getMethod());
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String wei = req.getParameter("wei");
        String ID = req.getParameter("no");
        System.out.println("账号："+id);
        System.out.println("wei："+wei);
        System.out.println("请求ID："+ID);

        Login li = new Login();
        ArrayList<String> l = li.userloginid(ID);
        if (l.size() < 1){
            System.out.println("登陆失败");
            resp.sendRedirect("http://localhost:8080/QYCLGL/error.html");
        }else {
            System.out.println("二次验证，可以通过");
            if ("通过".equals(wei)){
                System.out.println("通过");
                Tongguo t = new Tongguo(id);
                int a = t.jia();
                System.out.println(a);
                ArrayList<Register> ru = Zcselect.selects();
                req.setAttribute("ru",ru);
                req.setAttribute("l",l);
                req.setAttribute("tg","1");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin.jsp");
                requestDispatcher.forward(req,resp);
                System.out.println("***********审批通过成功***********");
            }else {
                System.out.println("不通过");
                Tongguo t = new Tongguo(id);
                t.delete();
                ArrayList<Register> ru = Zcselect.selects();
                req.setAttribute("ru",ru);
                req.setAttribute("l",l);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin.jsp");
                requestDispatcher.forward(req,resp);
                System.out.println("***********审批不通过***********");
            }

        }


    }
}
