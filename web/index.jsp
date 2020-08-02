<%--
  Created by IntelliJ IDEA.
  User: 50200
  Date: 2020/6/24
  Time: 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>登录</title>
    <link href="./images/favicon.ico" rel="SHORTCUT ICON" />
    <link rel="stylesheet" href="./css/login.css" type="text/css"/>
    <link rel="stylesheet" href="./css/test.css" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="css/zhuce.css" />
  </head>

  <body>

<% if (request.getAttribute("zc") != null) {%>
    <% if(request.getAttribute("zc") == "1"){ %>
        <script type="text/javascript">
            alert("注册成功,管理员审核通过即可登录！");
        </script>
    <% } else { %>
        <script type="text/javascript">
            alert("注册失败！已存在该工号，请重新选择工号后注册！");
        </script>
    <% } %>
<% } %>


  <div id="ze">
    <h3>注册账号</h3>
    <form action="/QYCLGL/Servletzhuce" method="post" onsubmit="return check()">
      <table>
        <tr>
          <td><input type="text" id="zcname" name="name" placeholder="用户名/必须为中文/不超5字" maxlength="5" onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\u4E00-\u9FA5]/g,''))" /></td>
        </tr>
        <tr>
          <td><input type="text" id="zcno" name="no" placeholder="工号/必须为XG后面跟4位数字" maxlength="6" onkeyup="value=value.replace(/[\W]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" /></td>
        </tr>
        <tr>
          <td><input type="password" id="zcpassword" name="password" placeholder="密码/必须为6为数字" maxlength="6" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" /></td>
        </tr>
        <tr>
          <td><select id="xuanze" name="type">
            <option value="车辆管理">车辆管理</option>
            <option value="司机管理">司机管理</option>
            <option value="维修管理">维修管理</option>
          </select></td>
        </tr>
        <tr><td id="lianxi">注册后请联系管理员通过后方可登录</td></tr>
      </table>
      <input type="submit" id="zcan" value="立 即 注 册" />
    </form>
    <a id="fanhui" onclick="fanhui()">返回登录</a>
  </div>






    <div id="login">
      <h3>统一身份认证</h3>
      <form action="/QYCLGL/Servletlogin" method="post">
        <input type="text" name="username" id="name" placeholder="请输入工号/XG开头的6位账号" maxlength="6" />
        <input type="password" name="password" id="passwd" placeholder="请输入密码" maxlength="6" />
        <p style="display: inline-block">工号的字母要记得大写哦！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
        <p style="display: inline-block; font-size: 16px; color: red;">${m}</p>

        <input type="submit" id="denglu" value="登 录" />
        <a href="tencent://message/?Menu=yes&uin=502006690&Service=300&sigT=45a1e5847943b64c6ff3990f8a9e644d2b31356cb0b4ac6b24663a3c8dd0f8aa12a595b1714f9d45">忘记密码？</a>
        <a id="zhuce" onclick="zhuce()">注册账号</a>
      </form>
    </div>
    <div class="last">
      <div>
        <span>版权所有 @2020课程设计一组&nbsp;&nbsp;</span>
        <img src="images/login1.jpg">
        <a rel="nofollow" href="http://www.beian.miit.gov.cn" target="_blank">皖ICP备20003359号</a>
      </div>

    </div>
    <script type="text/javascript">
      function zhuce() {
        var lo = document.getElementById("login");
        lo.style.display = "none";

        var zhuce = document.getElementById("ze");
        zhuce.style.display = "block";

      }

      function fanhui() {

        var zhuce = document.getElementById("ze");
        zhuce.style.display = "none";

        var lo = document.getElementById("login");
        lo.style.display = "block";

      }

      function check(){
          var zcno=document.getElementById('zcno');
          var zcpassword=document.getElementById('zcpassword');
          var reg = /^([a-zA-Z][a-zA-Z][0-9][0-9][0-9][0-9])$/;
          if ("X,G" == zcno.value.split("",2) && reg.test(zcno.value)){
            if(zcpassword.value.length<6){
              alert("密码必须为6位，请检查！");
              zcpassword.value="";
              zcpassword.focus();
              return false;
            }
          }else {
            zcno.value = "";
            alert("检查账号格式");
            return false;
          }


      }
    </script>
  </body>

</html>
