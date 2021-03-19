<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈明瀚
  Date: 2020/12/17
  Time: 21:53
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
    <title>学生在校信息</title>
</head>
<body>
<s:set var="name" value="#session['user']"/>
<h3><s:property value="#name"/>用户,欢迎登录学籍信息页面!
    [<a href="LoginOut.action"><button class="btn btn-info">注销用户</button></a>]</h3>
<ul class="nav nav-tabs">
    <li role="presentation"><a href="getNotice.action">首页</a></li>
    <li role="presentation"><a href="listOne.action">学生个人信息</a></li>
    <li role="presentation" class="active"><a href="getSchool.action">学生在校信息</a></li>
    <li role="presentation"><a href="stuChangepass.jsp">修改登录密码</a></li>
</ul>
<table style="width: auto; margin:auto" class="table table-hover" text-align="center">
    <tr>
        <th align="center">学生学号</th>
        <th align="center">所在学院</th>
        <th align="center">专业</th>
        <th align="center">班级</th>
        <th align="center">宿舍</th>
        <th align="center">操作</th>
    </tr>
    <tr>
        <td><s:property value="sch.sno"/></td>
        <td><s:property value="sch.deptName"/></td>
        <td><s:property value="sch.specialty"/></td>
        <td><s:property value="sch.clazz"/></td>
        <td><s:property value="sch.dormitory"/></td>
        <td><a href="updateSchool.action?id=<s:property value="sch.sno"/>"><button class="btn btn-default">修改</button> </a></td>
    </tr>
</table>
</body>
</html>
