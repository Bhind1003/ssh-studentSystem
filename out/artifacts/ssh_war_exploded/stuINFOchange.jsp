<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈明瀚
  Date: 2020/12/19
  Time: 15:34
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
    <title>修改学生信息</title>
</head>
<body>
<s:set var="name" value="#session['user']"/>
<h3><s:property value="#name"/>用户,欢迎登录学籍信息页面!
    [<a href="LoginOut.action"><button class="btn btn-info">注销用户</button></a>]</h3>
<ul class="nav nav-tabs">
    <li role="presentation"><a href="getNotice.action">首页</a></li>
    <li role="presentation" class="active"><a href="listOne.action">学生个人信息</a></li>
    <li role="presentation"><a href="getSchool.action">学生在校信息</a></li>
    <li role="presentation"><a href="stuChangepass.jsp">修改登录密码</a></li>
</ul>
<center>
    <s:form action="updateInfo" method="post" enctype="multipart/form-data">
        <s:textfield type="text" label="学生学号" class="form-control" name="stu.sno" value="%{stu.sno}" readonly="true"/>
        <s:textfield type="text" label="学生姓名" class="form-control" name="stu.sname" value="%{stu.sname}" readonly="true"/>
        <s:textfield type="text" label="电话" class="form-control" name="stu.phone" value="%{stu.phone}" readonly="false"/>
        <s:textfield type="text" label="邮箱" class="form-control" name="stu.email" value="%{stu.email}" readonly="false"/>
        <s:file label="头像" name="img" class="form-control"/>
        <s:submit value="提交修改" class="form-control"/>
    </s:form>
    <h3><s:property value="msg"/></h3>
</center>
</body>
</html>
