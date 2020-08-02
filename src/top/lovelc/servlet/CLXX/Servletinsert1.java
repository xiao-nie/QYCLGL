package top.lovelc.servlet.CLXX;

import top.lovelc.test.CLXX.Insert1;
import top.lovelc.test.CLXX.Select1;
import top.lovelc.test.Login;
import top.lovelc.www.CLXX;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Servletinsert1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求方式->"+req.getMethod());
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String vno = req.getParameter("vno");
        String vcolour = req.getParameter("vcolour");
        String vmodel = req.getParameter("vmodel");
        String vtype = req.getParameter("vtype");
        String vquality = null;
        if ("大货车".equals(vtype)){
            vquality = "30T";
        }else if ("小货车".equals(vtype)){
            vquality = "15T";
        }else if ("挂车".equals(vtype)){
            vquality = "32T";
        }else if ("客车".equals(vtype)){
            vquality = "20人";
        }else if ("出租车".equals(vtype)){
            vquality = "5人";
        }

        System.out.println("id："+id);
        System.out.println("vno："+vno);
        System.out.println("vcolour："+vcolour);
        System.out.println("vmodel："+vmodel);
        System.out.println("vtype："+vtype);
        System.out.println("vquality："+vquality);

//判断是插入还是修改
        Select1 se = new Select1("车牌号",vno);
        ArrayList<CLXX> s = se.query();
        System.out.println(s);
        if (s.size() <1){
            System.out.println("查不到数据！,是插入操作");
            Login li = new Login();
            ArrayList<String> l = li.userloginid(id);
            if (l.size() < 1){
                System.out.println("登陆失败");
                resp.sendRedirect("http://localhost:8080/QYCLGL/error.html");
            }else {
                Insert1 inst = new Insert1(vno,vcolour,vmodel,vtype,vquality,id);
                int ins = inst.inserts();
                req.setAttribute("l",l);
                req.setAttribute("ins",ins);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin1.jsp");
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
                Insert1 inst = new Insert1(vno,vcolour,vmodel,vtype,vquality,id);
                int ups = inst.inserts_up();
                req.setAttribute("l",l);
                req.setAttribute("ups",ups);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin1.jsp");
                requestDispatcher.forward(req,resp);
            }
        }



    }
}
