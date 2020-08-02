package top.lovelc.servlet.SJXX;

import top.lovelc.test.CLXX.Insert1;
import top.lovelc.test.Login;
import top.lovelc.test.SJXX.Insert2;
import top.lovelc.util.Time;
import top.lovelc.www.SJXX;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Servletinsert2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************试图插入或者修改信息*************");
        System.out.println(Time.t());
        System.out.println("请求方式->"+req.getMethod());
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String dno = req.getParameter("dno");
        String dname = req.getParameter("dname");
        String dsex = req.getParameter("dsex");
        String dtel = req.getParameter("dtel");
        String didno = req.getParameter("didno");
        String dln = req.getParameter("dln");
        String dlg = req.getParameter("dlg");
        String vno = req.getParameter("vno");


        System.out.println("请求ID："+id);
        System.out.println("工号（dno）："+dno);
        System.out.println("姓名（dname）："+dname);
        System.out.println("性别（dsex）："+dsex);
        System.out.println("联系电话（dtel）："+dtel);
        System.out.println("身份证号（didno）："+didno);
        System.out.println("驾驶证等级（dln）："+dln);
        System.out.println("驾驶证号（dlg）："+dlg);
        System.out.println("车牌号（vno）："+vno);
        System.out.println("管理者（id）："+id);

//判断是插入还是修改
        top.lovelc.test.SJXX.Select2 se = new top.lovelc.test.SJXX.Select2("工号",dno);
        ArrayList<SJXX> s = se.query();
        if (s.size() <1){
            System.out.println("*******查不到数据！,是插入操作*******");
            Login li = new Login();
            ArrayList<String> l = li.userloginid(id);
            if (l.size() < 1){
                System.out.println("登陆失败");
                resp.sendRedirect("http://localhost:8080/QYCLGL/error.html");
            }else {
                Insert2 inst = new Insert2(dno,dname,dsex,dtel,didno,dln,dlg,vno,id);
                int ins = inst.inserts();
                req.setAttribute("l",l);
                req.setAttribute("ins",ins);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin2.jsp");
                requestDispatcher.forward(req,resp);
                System.out.println("*******************插入成功*******************");
            }
        }else {
            System.out.println("*******查询到数据,是修改操作*******");
            Login li = new Login();
            ArrayList<String> l = li.userloginid(id);
            if (l.size() < 1){
                System.out.println("登陆失败");
                resp.sendRedirect("http://localhost:8080/QYCLGL/error.html");
            }else {
                Insert2 inst = new Insert2(dno,dname,dsex,dtel,didno,dln,dlg,vno,id);
                int ups = inst.inserts_up();
                req.setAttribute("l",l);
                req.setAttribute("ups",ups);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin2.jsp");
                requestDispatcher.forward(req,resp);
                System.out.println("*******************修改成功*******************");
            }
        }



    }
}
