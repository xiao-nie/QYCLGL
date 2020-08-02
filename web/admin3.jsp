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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>维修信息管理</title>
    <link href="images/favicon.ico" rel="SHORTCUT ICON" />
    <link rel="stylesheet" href="http://wp.lovelc.top/QYCLGL/css/style.css" type="text/css"/>
    <link rel="stylesheet" href="http://wp.lovelc.top/QYCLGL/css/test.css" type="text/css"/>
</head>

<body>
<div id="top">
    <div class="class-1">
        <ul>
            <li>当前用户:${l.get(1)}</li>
            <li>用户权限:${l.get(2)}</li>
            <li><a href="http://www.lovelc.top/">退出登录</a></li>
        </ul>
    </div>

    <%
        if (request.getAttribute("l") != null){
    %>
    <div id="body">
        <div id="sousuo">
            <form action="/QYCLGL/Servletselect3" method="post">
                <input type="text" name="id" value="${l.get(0)}" hidden/>
                &nbsp;&nbsp;
                <label><input id="mnoup" type="radio" name="type" value="维修编号" checked="checked" />维修编号</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <label><input id="mstoreup" type="radio" name="type" value="维修店铺" />维修店铺</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <label><input id="mcontentup" type="radio" name="type" value="维修原因" />维修原因</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <label><input id="vnoup" type="radio" name="type" value="车牌号" />车牌号</label>&nbsp;&nbsp;
                <button id="charu" type="button" onclick="mymethon()">插入/修改</button><br />
                <input type="text" name="select" id="select" placeholder="请输入要搜索的内容" />
                <input class="select" type="submit" value="搜&nbsp;&nbsp;索"/>
            </form>

            <%--            下载使用--%>
            <form action="/QYCLGL/Servletselect3" method="get">
                <input type="text" name="id" value="${l.get(0)}" hidden/>
                <input id="xztype" type="text" name="type" hidden>
                <input id="xzselect" type="text" name="select" hidden>
                <input id="xiazaianniu" type="submit" value="下载到本地" style="left: 520px;">
            </form>

            <div id="modify2" >
                <div>
                    <h3>插入/修改信息</h3>
                </div>
                <form action="/QYCLGL/Servletinsert3" method="post">
                    <input type="text" name="id" value="${l.get(0)}" hidden/>
                    <table>
                        <tr>
                            <td>车&nbsp;&nbsp;&nbsp;牌&nbsp;&nbsp;&nbsp;号：</td>
                            <td><input type="text" id="vno-up" name="vno" maxlength="7" placeholder=" 请输入车牌号"></td>
                            <input type="text" id="mno-up" name="mno" hidden>
                            <input type="text" id="id-up" name="id" hidden >
                        </tr>
                        <tr>
                            <td>维&nbsp;修&nbsp;店&nbsp;铺：</td>
                            <td><input type="text" id="mstoreup-up" name="mstore" placeholder=" 请输入店铺名"></td>
                        </tr>
                        <tr>
                            <td>维&nbsp;修&nbsp;原&nbsp;因：</td>
                            <td><textarea id="mcontent-up" name="mcontent" placeholder=" 请输入维修原因" cols="23" rows="4" style=" resize: none; font-size: 18px; overflow-y:visible; outline:none; border : none;"></textarea></td>
                        </tr>
                    </table>
                    <div>
                        <input type="button" value="取消" onclick="cancel()">
                        <input type="submit"  value="提交" >
                    </div>
                </form>
            </div>
        </div>

        <div class="tab">
            <%
                }
            %>
            <%
                if (request.getAttribute("l") == null){
            %>
            <h1>非法进入,本系统仅供企业内部员工使用</h1>
            <%
                }
            %>

            <% if (request.getAttribute("cx") != null){ %>
            <%
                if (request.getAttribute("s") != null){
                    ArrayList<WXXX> SS = (ArrayList<WXXX>) request.getAttribute("s");
            %>
            <div id="kong"></div>
            <table id="table1">
                <caption>为您查询到车辆信息:</caption>
                <tr>
                    <th>维修编号</th>
                    <th>维修店铺</th>
                    <th>维修原因</th>
                    <th>维修车辆</th>
                    <th>管理员</th>
                    <th>修改</th>
                    <th>删除</th>
                </tr>
                <%
                    int xiu = 0;
                    for (WXXX s : SS){
                        xiu++;
                %>
                <tr>
                    <td><%= s.getMno() %></td>
                    <td><%= s.getMstore() %></td>
                    <td><%= s.getMcontent() %></td>
                    <td><%= s.getVno() %></td>
                    <td><%= s.getId() %></td>
                    <td>
                        <form action="/QYCLGL/Servletdelete3" method="post">
                            <input type="text" class="mnoup3" name="mno" value=<%= s.getMno() %> hidden>
                            <input type="text" class="mstoreup3" name="mstore" value=<%=s.getMstore()%> hidden>
                            <input type="text" class="mcontentup3" name="mcontent" value=<%=s.getMcontent()%> hidden>
                            <input type="text" class="vnoup3" name="vno" value=<%=s.getVno()%> hidden>
                            <input type="text" class="idup3" name="id" value=<%=s.getId()%> hidden>
                            <input type="text" name="id" value="${l.get(0)}" hidden/>
                            <input type="button" onclick="up3(<%= xiu %>)" value="修改" class="sd">
                        </form>
                    </td>
                    <td>
                        <form action="/QYCLGL/Servletdelete3" method="post">
                            <input type="text" name="mno" value=<%=s.getMno()%> hidden>
                            <input type="text" name="id" value="${l.get(0)}" hidden/>
                            <input type="submit" value="删除" class="sd">
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <%
            }else{
            %>
            <script>
                alert("查不到数据！，请检查后重新查询");
            </script>

            <%
                }
            %>
            <% } %>

            <% if (request.getAttribute("ins") != null){
                int ins = (int) request.getAttribute("ins"); %>
            <% if (ins == 1){ %>
            <script>
                alert("插入成功！维修编号为：<%= request.getAttribute("gm") %>");
            </script>
            <style>
                #modify,
                .tab p {
                    display: none;
                }
            </style>
            <% }else{ %>
            <script>
                alert("插入失败！");
            </script>
            <style>
                #modify,
                .tab p  {
                    display: none;
                }
            </style>
            <% } %>
            <% } %>

            <% if (request.getAttribute("ups") != null){
                int ups = (int) request.getAttribute("ups"); %>
            <% if (ups == 1){ %>
            <script>
                alert("修改成功！");
            </script>
            <% }else{ %>
            <script>
                alert("修改失败！");
            </script>
            <% } %>
            <% } %>

            <% if (request.getAttribute("d") != null){
                int d = (int) request.getAttribute("d"); %>
            <% if (d == 1){ %>
            <script>
                alert("删除成功！");
            </script>
            <style>
                #modify,
                .tab p {
                    display: none;
                }
            </style>
            <% }else{ %>
            <script>
                alert("删除失败！");
            </script>
            <style>
                #modify,
                .tab p  {
                    display: none;
                }
            </style>
            <% } %>
            <% } %>
        </div>
    </div>
</div>
<script type="text/javascript">

    (function () {
        <% String s = (String) request.getAttribute("type");
            String s1 = null;
                if ("维修编号".equals(s)){
                    s1 = "mnoup";
                }else if ("维修店铺".equals(s)){
                    s1 = "mstoreup";
                }else if ("维修原因".equals(s)){
                    s1 = "mcontentup";
                }else if ("车牌号".equals(s)){
                    s1 = "vnoup";
                }else {
                }
            %>
        <% String ss = (String) request.getAttribute("select"); %>
        var typeup = document.getElementById("<%= s1 %>");
        var select = document.getElementById("select");
        var xztype = document.getElementById("xztype");
        var xzselect = document.getElementById("xzselect");
        typeup.checked = true;
        select.value = "<%= ss %>";
        xztype.value = typeup.value;
        xzselect.value = "<%= ss %>";
    })()

    function  mymethon(){
        var ele=document.getElementById("modify2");
        ele.style.display = "block";

        var dno_up = document.getElementById("dno-up");
        var dname_up = document.getElementById("dname-up");
        var dsex_up = document.getElementById("dsex-up");
        var dtel_up = document.getElementById("dtel-up");
        var didno_up = document.getElementById("didno-up");
        var dln_up = document.getElementById("dln-up");
        var dlg_up = document.getElementById("dlg-up");
        var vno_up = document.getElementById("vno-up");

        dno_up.value = null;
        dname_up.value = null;
        dsex_up.value = null;
        dtel_up.value = null;
        didno_up.value = null;
        dln_up.value = null;
        dlg_up.value = null;
        vno_up.value = null;

        dno_up.readOnly=false;
    }

    function cancel() {
        var ele=document.getElementById("modify2");
        ele.style.display = "none";
    }

    function up3(xiu) {

        var ele=document.getElementById("modify2");
        ele.style.display = "block";

        var mno = document.getElementsByClassName("mnoup3");
        var mstore = document.getElementsByClassName("mstoreup3");
        var mcontent = document.getElementsByClassName("mcontentup3");
        var vno = document.getElementsByClassName("vnoup3");
        var id = document.getElementsByClassName("idup3");

        var mno_up = document.getElementById("mno-up")
        var mstore_up = document.getElementById("mstoreup-up");
        var mcontent_up = document.getElementById("mcontent-up");
        var vno_up = document.getElementById("vno-up");
        var id_up = document.getElementById("id-up");

        mstore_up.value = mstore[xiu-1].value;
        mcontent_up.value = mcontent[xiu-1].value;
        vno_up.value = vno[xiu-1].value;
        mno_up.value = mno[xiu-1].value;
        id_up.value = id[xiu-1].value;

        dno_up.readOnly=true;
    }

</script>
</body>

</html>