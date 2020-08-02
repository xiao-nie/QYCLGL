<%@ page import="java.util.List" %>
<%@ page import="top.lovelc.www.CLXX" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.omg.CORBA.Request" %>
<%@ page import="javax.xml.ws.Response" %>
<%@ page import="top.lovelc.www.SJXX" %><%--
  Created by IntelliJ IDEA.
  User: 50200
  Date: 2020/6/25
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setContentType("application/vnd.ms-excel");
    response.addHeader("Content-Disposition", "attachment;filename=" + new String(("司机信息表").getBytes("gb2312"),"iso8859-1") + ".xls");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Excel下载</title>
</head>
    <body>


    <%
        if (request.getAttribute("s") != null){
            ArrayList<SJXX> SS = (ArrayList<SJXX>) request.getAttribute("s");
    %>
    <div id="kong"></div>
    <table id="table1" style="border: 1px solid #000000">
        <tr>
            <th style="border: 1px solid #000000">工号</th>
            <th style="border: 1px solid #000000">姓名</th>
            <th style="border: 1px solid #000000">性别</th>
            <th style="border: 1px solid #000000">手机号</th>
            <th style="border: 1px solid #000000">身份证号</th>
            <th style="border: 1px solid #000000">驾驶证等级</th>
            <th style="border: 1px solid #000000">驾驶证号</th>
            <th style="border: 1px solid #000000">车牌号</th>
            <th style="border: 1px solid #000000">管理者</th>
        </tr>
        <%
            for (SJXX s : SS){
        %>
        <tr>
            <td style="border: 1px solid #000000"><%= s.getDno() %></td>
            <td style="border: 1px solid #000000"><%= s.getDname() %></td>
            <td style="border: 1px solid #000000"><%= s.getDsex() %></td>
            <td style="border: 1px solid #000000"><%= s.getDtel() %></td>
            <td style="border: 1px solid #000000"><%= "’"+s.getDidno() %></td>
            <td style="border: 1px solid #000000"><%= s.getDln() %></td>
            <td style="border: 1px solid #000000"><%= "‘"+s.getDlg() %></td>
            <td style="border: 1px solid #000000"><%= s.getVno()%></td>
            <td style="border: 1px solid #000000"><%= s.getId()%></td>
        </tr>
        <%
            }
        %>
    </table>
<%
    }
%>

</body>
</html>