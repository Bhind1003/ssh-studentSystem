<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈明瀚
  Date: 2020/12/21
  Time: 10:24
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
    <title>修改登录密码</title>
</head>
<body>
<s:set var="name" value="#session['user']"/>
<h3><s:property value="#name"/>管理员,欢迎学籍信息管理系统!
    [<a href="LoginOut.action"><button class="btn btn-info">注销用户</button></a>]</h3>
<ul class="nav nav-tabs">
    <li role="presentation"><a href="manNotice.action">管理通知</a></li>
    <li role="presentation"><a href="listINFO2.action">学生信息管理</a></li>
    <li role="presentation"><a href="findSchool.action">学生在校信息管理</a></li>
    <li role="presentation" class="active"><a href="manChangePass.jsp">修改登录密码</a></li>
</ul>
<center>
    <h3>修改登录密码</h3>
    <s:form action="changePass2" method="POST">
        <s:password name="password" label="原来密码" class="form-control"/>
        <s:password name="password2" label="新密码" class="form-control"/>
        <s:password name="password3" label="确认密码" class="form-control"/>
        <s:submit value="提交修改" class="form-control"/><s:reset value="清空" class="form-control"/>
    </s:form>
    <h3><s:property value="msg"/></h3>
</center>
</body>
</html>
