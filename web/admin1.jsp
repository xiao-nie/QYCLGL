<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.omg.CORBA.Request" %>
<%@ page import="javax.xml.ws.Response" %>
<%@ page import="top.lovelc.www.CLXX" %><%--
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
    <title>车辆信息管理</title>
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
            <form action="/QYCLGL/Servletselect1" method="post">
                <input type="text" name="id" value="${l.get(0)}" hidden/>
                &nbsp;&nbsp;
                <label><input id="vnoup" type="radio" name="type" value="车牌号" checked="checked" />车牌号</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <label><input id="vcolourup" type="radio" name="type" value="颜色" />颜色</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <label><input id="vmodelup" type="radio" name="type" value="车型号" />车型号</label>&nbsp;&nbsp;
                <label><input id="vtypeup" type="radio" name="type" value="车类型" />车类型</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <label><input id="vqualityup" type="radio" name="type" value="载重" />载重</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <button id="charu" type="button" onclick="mymethon()">插入/修改</button><br />
                <input type="text" name="select" id="select" placeholder="请输入要搜索的内容" />
                <input class="select" type="submit" value="搜&nbsp;&nbsp;索"/>
            </form>

<%--            下载使用--%>
            <form action="/QYCLGL/Servletselect1" method="get">
                <input type="text" name="id" value="${l.get(0)}" hidden/>
                <input id="xztype" type="text" name="type" hidden>
                <input id="xzselect" type="text" name="select" hidden>
                <input id="xiazaianniu" type="submit" value="下载到本地">
            </form>

            <div id="modify">
                <div>
                    <h3>插入/修改信息</h3>
                </div>
                <form action="/QYCLGL/Servletinsert1" method="post">
                    <input type="text" name="id" value="${l.get(0)}" hidden/>
                    <table>
                        <tr>
                            <td>车&nbsp;&nbsp;牌&nbsp;&nbsp;号：</td>
                            <td><input type="text" id="vno-up" name="vno" maxlength="7"></td>
                        </tr>
                        <tr>
                            <td>颜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</td>
                            <td>
                                <select name="vcolour" id="vcolour-up" class="select-up">
                                    <option value="红色">红色</option>
                                    <option value="黄色">黄色</option>
                                    <option value="蓝色">蓝色</option>
                                    <option value="白色">白色</option>
                                    <option value="绿色">绿色</option>
                                    <option value="橙色">橙色</option>
                                    <option value="银色">银色</option>
                                    <option value="灰色">灰色</option>
                                    <option value="紫色">紫色</option>
                                    <option value="黑色">黑色</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>发动机号：</td>
                            <td><input type="text" id="vmodel-up" name="vmodel" maxlength="8"  ></td>
                        </tr>
                        <tr>
                            <td>车&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型：</td>
                            <td>
                                <select name="vtype" id="vtype-up" class="select-up">
                                    <option value="大货车">大货车/30T</option>
                                    <option value="小货车">小货车/15T</option>
                                    <option value="挂车">挂车/32T</option>
                                    <option value="客车">客车/20人</option>
                                    <option value="出租车">出租车/5人</option>
                                </select>
                            </td>
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
                if (request.getAttribute("s") != null){
                    ArrayList<CLXX> SS = (ArrayList<CLXX>) request.getAttribute("s");
            %>
            <div id="kong"></div>
            <table id="table1">
                <caption>为您查询到车辆信息:</caption>
                <tr>
                    <th>车牌号</th>
                    <th>颜色</th>
                    <th>车型号</th>
                    <th>发动机号</th>
                    <th>载重</th>
                    <th>管理者</th>
                    <th>修改</th>
                    <th>删除</th>
                </tr>
                <%
                    int xiu = 0;
                    for (CLXX s : SS){
                        xiu++;
                %>
                <tr>
                    <td><%= s.getVno() %></td>
                    <td
                            style="
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
                    <td><%= s.getVmodel() %></td>
                    <td><%= s.getVtype() %></td>
                    <td><%= s.getVquality() %></td>
                    <td><%= s.getId()%></td>
                        <td>
                            <form action="/QYCLGL/Servletdelete1" method="post">
                                <input type="text" class="vnoup1" name="vno" value=<%=s.getVno()%> hidden>
                                <input type="text" class="vcolourup1" name="vcolour" value=<%=s.getVcolour()%> hidden>
                                <input type="text" class="vmodelup1" name="vmodel" value=<%=s.getVmodel()%> hidden>
                                <input type="text" class="vtypeup1" name="vtype" value=<%=s.getVtype()%> hidden>
                                <input type="text" class="vqualityup1" name="vquality" value=<%=s.getVquality()%> hidden>
                                <input type="text" name="id" value="${l.get(0)}" hidden/>
                                <input type="button" onclick="up1(<%= xiu %>)" value="修改" class="sd">
                            </form>
                        </td>
                        <td>
                            <form action="/QYCLGL/Servletdelete1" method="post">
                                <input type="text" name="vno" value=<%=s.getVno()%> hidden>
                                <input type="text" name="id" value=${l.get(0)} hidden/>
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
            <p id="selectnumber">查不到数据！</p>
            <%
                }
            %>
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
                if ("车牌号".equals(s)){
                    s1 = "vnoup";
                }else if ("颜色".equals(s)){
                    s1 = "vcolourup";
                }else if ("车型号".equals(s)){
                    s1 = "vmodelup";
                }else if ("车类型".equals(s)){
                    s1 = "vtypeup";
                }else if ("载重".equals(s)){
                    s1 = "vqualityup";
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
        var ele=document.getElementById("modify");
        ele.style.display = "block";

        // var vno_up = document.getElementById("vno-up");
        // vno_up.readOnly=false;
        // vno_up.value = null;
        //
        // vmodel_up.value = null;
    }

    function cancel() {
        var ele=document.getElementById("modify");
        ele.style.display = "none";
    }

    function up1(xiu) {

        var ele=document.getElementById("modify");
        ele.style.display = "block";

        var vno = document.getElementsByClassName("vnoup1");
        var vcolour = document.getElementsByClassName("vcolourup1");
        var vmodel = document.getElementsByClassName("vmodelup1");
        var vtype = document.getElementsByClassName("vtypeup1");

        var vno_up = document.getElementById("vno-up");
        var vcolour_up = document.getElementById("vcolour-up");
        var vmodel_up = document.getElementById("vmodel-up");
        var vtype_up = document.getElementById("vtype-up");

        vno_up.value = vno[xiu-1].value;
        vcolour_up.value = vcolour[xiu-1].value;
        vmodel_up.value = vmodel[xiu-1].value;
        vtype_up.value = vtype[xiu-1].value;

        vno_up.readOnly=true;
    }

</script>
</body>

</html>