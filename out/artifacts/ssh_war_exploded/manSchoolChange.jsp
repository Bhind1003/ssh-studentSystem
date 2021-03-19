<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈明瀚
  Date: 2020/12/21
  Time: 20:23
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
    <title>学生在校信息修改</title>
</head>
<body>
<s:set var="name" value="#session['user']"/>
<h3><s:property value="#name"/>管理员,欢迎学籍信息管理系统!
    [<a href="LoginOut.action"><button class="btn btn-info">注销用户</button></a>]</h3>
<ul class="nav nav-tabs">
    <li role="presentation"><a href="manNotice.action">管理通知</a></li>
    <li role="presentation"><a href="listINFO2.action">学生信息管理</a></li>
    <li role="presentation" class="active"><a href="findSchool.action">学生在校信息管理</a></li>
    <li role="presentation"><a href="manChangePass.jsp">修改登录密码</a></li>
</ul>
<center>
    <s:form action="updateSchool2" method="post">
        <s:textfield type="text" label="学生学号" class="form-control" name="sch.sno" value="%{sch.sno}"/>
        <s:textfield type="text" label="所在学院" class="form-control" name="sch.deptName" value="%{sch.deptName}"/>
        <s:textfield type="text" label="专业" class="form-control" name="sch.specialty" value="%{sch.specialty}"/>
        <s:textfield type="text" label="班级" class="form-control" name="sch.clazz" value="%{sch.clazz}"/>
        <s:textfield type="text" label="宿舍" class="form-control" name="sch.dormitory" value="%{sch.dormitory}"/>
        <s:submit value="提交保存" class="form-control"/>
    </s:form>
    <h3><s:property value="msg"/></h3>
</center>
</body>
</html>
