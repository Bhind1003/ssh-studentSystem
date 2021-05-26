<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈明瀚
  Date: 2020/12/17
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link href="css/main.css" rel="stylesheet">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body><a href="index.jsp"><button class="btn btn-success">学生登录</button></a>
<center>
<h2 style="-webkit-text-fill-color: blue">学信帮</h2>
<h3>管理员登录</h3>
<s:form action="Login2" method="post" enctype = "multipart/form-data">
    <s:textfield name="checkNum" label="验证码" class="form-control"/>
    <label for="checkImg">&nbsp;&nbsp;&nbsp;&nbsp;</label><img id="checkImg" src="<s:url action="checkImg"/>" onclick="change()" alt="验证码" title="点击更换验证码" aria-label="验证码"/>
    <s:textfield name="user.sno" label="用户名" class="form-control"/>
    <s:password name="user.password" maxlength="16" label="密码" class="form-control"/>
    <s:submit value="登录" class="form-control"/><s:reset value="重置" class="form-control"/>
</s:form>
    <h3><s:property value="msg"/> </h3>
</center>
</body>
<script>
    function change(){    //切换验证码
        const img1 = document.getElementById("checkImg");
        img1.src="<s:url action="checkImg"/>?"+new Date().getTime(); //加时间戳防止缓存
    }
</script>
</html>
