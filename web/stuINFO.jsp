<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈明瀚
  Date: 2020/12/17
  Time: 21:09
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
    <title>学生个人信息</title>
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
<table style="width: auto; margin:auto" class="table table-hover" text-align="center">
    <tr>
        <th align="center">学生学号</th>
        <th align="center">学生姓名</th>
        <th align="center">性别</th>
        <th align="center">生日</th>
        <th align="center">籍贯</th>
        <th align="center">政治面貌</th>
        <th align="center">电话</th>
        <th align="center">邮箱</th>
        <th align="center">照片</th>
        <th align="center">操作</th>
    </tr>
    <tr>
        <td><s:property value="stu.sno"/></td>
        <td><s:property value="stu.sname"/></td>
        <td><s:property value="stu.ssex"/></td>
        <td><s:property value="stu.birth.toString()"/></td>
        <td><s:property value="stu.nativePlace"/></td>
        <td><s:property value="stu.politicalStatus"/></td>
        <td><s:property value="stu.phone"/></td>
        <td><s:property value="stu.email"/></td>
        <td><img src="<s:property value="stu.pic"/>" class="img-circle" width="50" height="60" alt="头像图片损坏"></td>
        <td><a href="updateInfo.action?id=<s:property value="stu.sno"/>"><button class="btn btn-default">修改</button></a></td>
    </tr>
</table>
</body>
</html>
