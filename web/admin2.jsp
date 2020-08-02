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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>司机信息管理</title>
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
            <form action="/QYCLGL/Servletselect2" method="post">
                <input type="text" name="id" value="${l.get(0)}" hidden/>
                &nbsp;&nbsp;
                <label><input id="dnoup" type="radio" name="type" value="工号" checked="checked" />工号</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <label><input id="dnameup" type="radio" name="type" value="姓名" />姓名</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <label><input id="dsexup" type="radio" name="type" value="性别" />性别</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <label><input id="dtelup" type="radio" name="type" value="联系电话" />联系电话</label>&nbsp;&nbsp;
                <label><input id="didnoup" type="radio" name="type" value="身份证号" />身份证号</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <label><input id="dlnup" type="radio" name="type" value="驾驶证等级" />驾驶证等级</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <label><input id="dlgup" type="radio" name="type" value="驾驶证号" />驾驶证号</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <label><input id="dvnoup" type="radio" name="type" value="车牌号" />车牌号</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <button id="charu" type="button" onclick="mymethon()">插入/修改</button><br />
                <input type="text" name="select" id="select" placeholder="请输入要搜索的内容" />
                <input class="select" type="submit" value="搜&nbsp;&nbsp;索"/>
            </form>

            <%--            下载使用--%>
            <form action="/QYCLGL/Servletselect2" method="get">
                <input type="text" name="id" value="${l.get(0)}" hidden/>
                <input id="xztype" type="text" name="type" hidden>
                <input id="xzselect" type="text" name="select" hidden>
                <input id="xiazaianniu" type="submit" value="下载到本地" style="left: 830px;">
            </form>

            <div id="modify1">
                <div>
                    <h3>插入/修改信息</h3>
                </div>
                <form action="/QYCLGL/Servletinsert2" method="post">
                    <input type="text" name="id" value="${l.get(0)}" hidden/>
                    <table>
                        <tr>
                            <td>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
                            <td><input type="text" id="dno-up" name="dno" maxlength="6" placeholder=" 请输入工号"></td>
                        </tr>
                        <tr>
                            <td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
                            <td><input type="text" id="dname-up" name="dname" maxlength="10" placeholder=" 请输入姓名"></td>
                        </tr>
                        <tr>
                            <td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                            <td>
                                <select id="dsex-up" name="dsex">
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>手&nbsp;&nbsp;&nbsp;机&nbsp;&nbsp;&nbsp;号：</td>
                            <td><input type="text" id="dtel-up" name="dtel" maxlength="11" placeholder=" 请输入手机号" ></td>
                        </tr>
                        <tr>
                            <td>身&nbsp;份&nbsp;证&nbsp;号：</td>
                            <td><input type="text" id="didno-up" name="didno" maxlength="18" placeholder=" 请输入身份证号" ></td>
                        </tr>
                        <tr>
                            <td>驾驶证等级：</td>
                            <td>
                                <select id="dln-up" name="dln">
                                    <option value="A1">A1</option>
                                    <option value="A2">A2</option>
                                    <option value="A3">A3</option>
                                    <option value="B1">B1</option>
                                    <option value="B2">B2</option>
                                    <option value="C1">C1</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>驾&nbsp;驶&nbsp;证&nbsp;号：</td>
                            <td><input type="text" id="dlg-up" name="dlg" maxlength="12" placeholder=" 请输入驾驶证号" ></td>
                        </tr>
                        <tr>
                            <td>驾驶车牌号：</td>
                            <td><input type="text" id="vno-up" name="vno" maxlength="7" placeholder=" 请输入驾驶车牌号" ></td>
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

            <%
                if (request.getAttribute("cx") != null){
            %>

            <%
                if (request.getAttribute("s") != null){
                    ArrayList<SJXX> SS = (ArrayList<SJXX>) request.getAttribute("s");
            %>
            <div id="kong"></div>
            <table id="table1">
                <caption>为您查询到车辆信息:</caption>
                <tr>
                    <th>工号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>手机号</th>
                    <th>身份证号</th>
                    <th>驾驶证等级</th>
                    <th>驾驶证号</th>
                    <th>车牌号</th>
                    <th>管理者</th>
                    <th>修改</th>
                    <th>删除</th>
                </tr>
                <%
                    int xiu = 0;
                    for (SJXX s : SS){
                        xiu++;
                %>
                <tr>
                    <td><%= s.getDno() %></td>
                    <td><%= s.getDname() %></td>
                    <td><%= s.getDsex() %></td>
                    <td><%= s.getDtel() %></td>
                    <td><%= s.getDidno() %></td>
                    <td><%= s.getDln() %></td>
                    <td><%= s.getDlg() %></td>
                    <td><%= s.getVno()%></td>
                    <td><%= s.getId()%></td>
                    <td>
                        <form action="/QYCLGL/Servletdelete2" method="post">
                            <input type="text" class="dnoup2" name="dno" value=<%= s.getDno() %> hidden>
                            <input type="text" class="dnameup2" name="dname" value=<%=s.getDname()%> hidden>
                            <input type="text" class="dsexup2" name="dsex" value=<%=s.getDsex()%> hidden>
                            <input type="text" class="dtelup2" name="dtel" value=<%=s.getDtel()%> hidden>
                            <input type="text" class="didnoup2" name="didno" value=<%=s.getDidno()%> hidden>
                            <input type="text" class="dlnup2" name="dln" value=<%=s.getDln()%> hidden>
                            <input type="text" class="dlgup2" name="dlg" value=<%=s.getDlg()%> hidden>
                            <input type="text" class="vnoup2" name="id" value=<%=s.getVno()%> hidden>
                            <input type="text" name="id" value="${l.get(0)}" hidden/>
                            <input type="button" onclick="up2(<%= xiu %>)" value="修改" class="sd">
                        </form>
                    </td>
                    <td>
                        <form action="/QYCLGL/Servletdelete2" method="post">
                            <input type="text" name="dno" value=<%=s.getDno()%> hidden>
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
                alert("插入成功！");
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
                #modify1,
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
                if ("工号".equals(s)){
                    s1 = "dnoup";
                }else if ("姓名".equals(s)){
                    s1 = "dnameup";
                }else if ("联系电话".equals(s)){
                    s1 = "dtelup";
                }else if ("身份证号".equals(s)){
                    s1 = "didnoup";
                }else if ("驾驶证等级".equals(s)){
                    s1 = "dlnup";
                }else if ("驾驶证号".equals(s)){
                    s1 = "dlgup";
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
        var ele=document.getElementById("modify1");
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
        var ele=document.getElementById("modify1");
        ele.style.display = "none";
    }

    function up2(xiu) {

        var ele=document.getElementById("modify1");
        ele.style.display = "block";

        var dno = document.getElementsByClassName("dnoup2");
        var dname = document.getElementsByClassName("dnameup2");
        var dsex = document.getElementsByClassName("dsexup2");
        var dtel = document.getElementsByClassName("dtelup2");
        var didno = document.getElementsByClassName("didnoup2");
        var dln = document.getElementsByClassName("dlnup2");
        var dlg = document.getElementsByClassName("dlgup2");
        var vno = document.getElementsByClassName("vnoup2");

        var dno_up = document.getElementById("dno-up");
        var dname_up = document.getElementById("dname-up");
        var dsex_up = document.getElementById("dsex-up");
        var dtel_up = document.getElementById("dtel-up");
        var didno_up = document.getElementById("didno-up");
        var dln_up = document.getElementById("dln-up");
        var dlg_up = document.getElementById("dlg-up");
        var vno_up = document.getElementById("vno-up");


        dno_up.value = dno[xiu-1].value;
        dname_up.value = dname[xiu-1].value;
        dsex_up.value = dsex[xiu-1].value;
        dtel_up.value = dtel[xiu-1].value;
        didno_up.value = didno[xiu-1].value;
        dln_up.value = dln[xiu-1].value;
        dlg_up.value = dlg[xiu-1].value;
        vno_up.value = vno[xiu-1].value;

        dno_up.readOnly=true;
    }

</script>
</body>

</html>