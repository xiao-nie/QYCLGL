<%@ page import="java.util.ArrayList" %>
<%@ page import="top.lovelc.www.Register" %><%--
  Created by IntelliJ IDEA.
  User: 50200
  Date: 2020/6/25
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>admin</title>
    <link href="/images/favicon.png" rel="SHORTCUT ICON" />
    <link rel="stylesheet" href="http://wp.lovelc.top/QYCLGL/css/style.css" type="text/css"/>
    <style>
        .tab {
            padding-top: 50px;
        }
        #top .tab>table {
            width: 1200px;
            margin: 0 auto;
            margin-bottom: 20px;
        }
        #top .tab>table th {
            height: 80px;
        }
        #top .tab>table tr {
            height: 50px;
        }
        #top .tab>table caption {
            font-size: 25px;
            margin: 20px;
        }

        #top .tab>table,
        #top .tab>table td,
        #top .tab>table th {
            border: 1px solid pink;
            border-collapse: collapse;
            text-align: center;
        }
        #top .tab>table td,
        #top .tab>table th {
            width: 240px;
        }
        #top .tab>table button {
            background-color: #FFC0CB;
            border: 0;
            padding: 5px 10px;
            margin: 0 10px;
            border-radius: 5px;
        }
        #top .tab>table tr:hover {
            background-color: #dddddd;
        }
        .an {
            height: 30px;
            width: 50px;
            background-color: pink;
            border: 0px;
            border-radius: 6px;
        }
    </style>
</head>

<body>
<div id="top">
    <div class="class-1">
        <ul>
            <li>当前用户:${l.get(1)}</li>
            <li>用户权限:${l.get(2)}</li>
            <li>
                <form action="/QYCLGL/Servletselect1" method="post">
                    <input type="text" name="id" value="${l.get(0)}" hidden/>
                    <input type="submit" value="车辆管理" >
                </form>
            </li>
            <li>
                <form action="/QYCLGL/Servletselect2" method="post">
                    <input type="text" name="id" value="${l.get(0)}" hidden/>
<%--                    <input type="text" name="cx" value="查询" hidden/>--%>
                    <input type="submit" value="司机管理">
                </form>
            </li>
            <li>
                <form action="/QYCLGL/Servletselect3" method="post">
                    <input type="text" name="id" value="${l.get(0)}" hidden/>
                    <input type="submit" value="维修管理">
                </form>
            </li>
            <li><a href="http://www.lovelc.top/">退出登录</a></li>
        </ul>
    </div>
    <div class="tab">

        <% if (request.getAttribute("ru") != null){  %>
            <% if (request.getAttribute("tg") != null){%>
                <% if (request.getAttribute("tg") == "1") {%>
                    <script>
                        alert("成功通过");
                    </script>
                <% } %>
                <% if (request.getAttribute("tg") == "0") {%>
                    <script>
                        alert("成功拒绝请求");
                    </script>
                <% } %>
            <% } %>
        <table>
            <caption>待审批的注册用户</caption>
            <tr>
                <th>注册工号</th>
                <th>姓名</th>
                <th>密码</th>
                <th>注册类型</th>
                <th>审批</th>
            </tr>
           <% ArrayList<Register> ru = (ArrayList<Register>) request.getAttribute("ru");int xiu = 0;
            for ( Register r :ru ){ xiu++; %>
            <tr>
                <td class="idno"><%= r.getId() %></td>
                <td><%= r.getName() %></td>
                <td><%= r.getPassword() %></td>
                <td><%= r.getType() %></td>
                <td>
                    <form action="/QYCLGL/Servletsp" method="post" style="display: inline-block; "  >
                        <input type="text" name="id" value="<%= r.getId() %>" hidden >
                        <input type="text" name="wei" value="通过" hidden >
                        <input type="text" name="no" value="${l.get(0)}" hidden/>
                        <input class="an" type="submit" value="通过" >
                    </form>
                    <form action="/QYCLGL/Servletsp" method="post" style="display: inline-block;">
                        <input type="text" name="id" value="<%= r.getId() %>" hidden >
                        <input type="text" name="no" value="${l.get(0)}" hidden/>
                        <input type="text" name="wei" value="不通过" hidden >
                        <input class="an" type="submit" value="不通过" style="margin-left: 30px;" >
                    </form>
                </td>
            </tr>
            <% } %>
        </table>
        <% }else{ %>
            <h3>暂无待审批用户</h3>
        <% } %>
    </div>
</div>
</body>

</html>