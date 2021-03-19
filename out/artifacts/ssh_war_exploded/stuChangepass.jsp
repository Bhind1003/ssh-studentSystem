<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈明瀚
  Date: 2020/12/18
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link href="css/main.css" rel="stylesheet">
<html>
<head>
    <title>修改学生密码</title>
</head>
<body>
<s:set var="name" value="#session['user']"/>
<h3><s:property value="#name"/>用户,欢迎登录学籍信息页面!
    [<a href="LoginOut.action"><button class="btn btn-info">注销用户</button></a>]</h3>
<ul class="nav nav-tabs">
    <li role="presentation"><a href="getNotice.action">首页</a></li>
    <li role="presentation"><a href="listOne.action">学生个人信息</a></li>
    <li role="presentation"><a href="getSchool.action">学生在校信息</a></li>
    <li role="presentation" class="active"><a href="stuChangepass.jsp">修改登录密码</a></li>
</ul>
<center>
    <h3>修改登录密码</h3>
    <s:form action="changePass" method="POST">
        <s:password name="password" label="原来密码" class="form-control"/>
        <s:password name="password2" label="新密码" class="form-control"/>
        <s:password name="password3" label="确认密码" class="form-control"/>
        <s:submit value="提交修改" class="form-control"/><s:reset value="清空" class="form-control"/>
    </s:form>
    <h3><s:property value="msg"/></h3>
</center>
</body>
</html>
