package top.lovelc.servlet.WXXX;

import top.lovelc.test.CLXX.Select1;
import top.lovelc.test.WXXX.Insert3;
import top.lovelc.test.WXXX.Select3;
import top.lovelc.test.Login;
import top.lovelc.www.CLXX;
import top.lovelc.www.WXXX;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Servletinsert3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求方式->"+req.getMethod());
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String mno = req.getParameter("mno");
        String vno = req.getParameter("vno");
        String mstore = req.getParameter("mstore");
        String mcontent = req.getParameter("mcontent");

        System.out.println("ID："+id);
        System.out.println("维修编号："+mno);
        System.out.println("车牌号："+vno);
        System.out.println("维修店铺："+mstore);
        System.out.println("维修原因："+mcontent);

//判断是插入还是修改
        Select3 se = new Select3("维修编号",mno);
        ArrayList<WXXX> s = se.querys();
        System.out.println(s);
        if (s.size() <1){
            System.out.println("查不到数据！,是插入操作");
            Login li = new Login();
            ArrayList<String> l = li.userloginid(id);
            if (l.size() < 1){
                System.out.println("登陆失败");
                resp.sendRedirect("http://localhost:8080/QYCLGL/error.html");
            }else {
                Insert3 inst = null;
                try {
                    inst = new Insert3(mstore,mcontent,vno,id);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                int ins = inst.inserts();

                req.setAttribute("gm",inst.getMno());
                req.setAttribute("l",l);
                req.setAttribute("ins",ins);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin3.jsp");
                requestDispatcher.forward(req,resp);
            }
        }else {
            System.out.println("查询到数据,是修改操作");
            Login li = new Login();
            ArrayList<String> l = li.userloginid(id);
            if (l.size() < 1){
                System.out.println("登陆失败");
                resp.sendRedirect("http://localhost:8080/QYCLGL/error.html");
            }else {
                Insert3 inst = new Insert3(mno,mstore,mcontent,vno,id);
                int ups = inst.inserts_up();
                req.setAttribute("l",l);
                req.setAttribute("ups",ups);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin3.jsp");
                requestDispatcher.forward(req,resp);
            }
        }



    }
}
