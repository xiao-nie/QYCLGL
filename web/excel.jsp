<%@ page import="java.util.List" %>
<%@ page import="top.lovelc.www.CLXX" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.omg.CORBA.Request" %>
<%@ page import="javax.xml.ws.Response" %><%--
  Created by IntelliJ IDEA.
  User: 50200
  Date: 2020/6/25
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setContentType("application/vnd.ms-excel");
    response.addHeader("Content-Disposition", "attachment;filename=" + new String(("车辆信息表").getBytes("gb2312"),"iso8859-1") + ".xls");
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
            ArrayList<CLXX> SS = (ArrayList<CLXX>) request.getAttribute("s");
    %>

    <table id="table1" style="border: 1px solid #000000; border-collapse:collapse;">
        <tr>
            <th style="border: 1px solid #000000; border-collapse:collapse;">车牌号</th>
            <th style="border: 1px solid #000000; border-collapse:collapse;">颜色</th>
            <th style="border: 1px solid #000000; border-collapse:collapse;">车型号</th>
            <th style="border: 1px solid #000000; border-collapse:collapse;">发动机号</th>
            <th style="border: 1px solid #000000; border-collapse:collapse;">载重</th>
            <th style="border: 1px solid #000000; border-collapse:collapse;">管理者</th>
        </tr>
        <%
            int xiu = 0;
            for (CLXX s : SS){
                xiu++;
        %>
        <tr>
            <td style="border: 1px solid #000000; border-collapse:collapse;"><%= s.getVno() %></td>
            <td
                    style=" border: 1px solid #000000; border-collapse:collapse;"
                                <% if("黄色".equals(s.getVcolour())){ %>
                                    background-color: rgba(255,255,0,.3);
                                <% }else if ("红色".equals(s.getVcolour())){%>
                                    background-color: rgba(255,0,0,.3);
                                <% }else if ("白色".equals(s.getVcolour())){%>
                                    background-color: rgba(255,255,255,.3);
                                <% }else if ("蓝色".equals(s.getVcolour())){%>
                                    background-color: rgba(0,0,255,.3);
                                <% }else if ("黑色".equals(s.getVcolour())){%>
                                    background-color: rgba(0,0,0,.3);
                                <% }else if ("绿色".equals(s.getVcolour())){%>
                                    background-color: rgba(0,255,0,.3);
                                <% }else if ("橙色".equals(s.getVcolour())){%>
                                    background-color: rgba(255,165,0,.3);
                                <% }else if ("紫色".equals(s.getVcolour())){%>
                                    background-color: rgba(128,0,128,.3);
                                <% }else if ("银色".equals(s.getVcolour())){%>
                                    background-color: rgba(192,192,192,.3);
                                <% }else if ("灰色".equals(s.getVcolour())){%>
                                    background-color: rgba(128,128,128,.3);
                            <% } %>
                                    "
            ><%= s.getVcolour() %></td>
            <td style="border: 1px solid #000000; border-collapse:collapse;"><%= s.getVmodel() %></td>
            <td style="border: 1px solid #000000; border-collapse:collapse;"><%= s.getVtype() %></td>
            <td style="border: 1px solid #000000; border-collapse:collapse;"><%= s.getVquality() %></td>
            <td style="border: 1px solid #000000; border-collapse:collapse;"><%= s.getId()%></td>
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