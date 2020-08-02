<%@ page import="java.util.List" %>
<%@ page import="top.lovelc.www.CLXX" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.omg.CORBA.Request" %>
<%@ page import="javax.xml.ws.Response" %>
<%@ page import="top.lovelc.www.SJXX" %>
<%@ page import="top.lovelc.www.WXXX" %><%--
  Created by IntelliJ IDEA.
  User: 50200
  Date: 2020/6/25
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setContentType("application/vnd.ms-excel");
    response.addHeader("Content-Disposition", "attachment;filename=" + new String(("维修信息表").getBytes("gb2312"),"iso8859-1") + ".xls");
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
            ArrayList<WXXX> SS = (ArrayList<WXXX>) request.getAttribute("s");
    %>
    <div id="kong"></div>
    <table id="table1" style="border: 1px solid #000000">
        <tr>
            <th style="border: 1px solid #000000">维修编号</th>
            <th style="border: 1px solid #000000">维修店铺</th>
            <th style="border: 1px solid #000000">维修原因</th>
            <th style="border: 1px solid #000000">维修车辆</th>
            <th style="border: 1px solid #000000">管理员</th>
        </tr>
        <%
            for (WXXX s : SS){
        %>
        <tr>
            <td style="border: 1px solid #000000"><%= s.getMno() %></td>
            <td style="border: 1px solid #000000"><%= s.getMstore() %></td>
            <td style="border: 1px solid #000000"><%= s.getMcontent() %></td>
            <td style="border: 1px solid #000000"><%= s.getVno() %></td>
            <td style="border: 1px solid #000000"><%= s.getId() %></td>
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