<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈明瀚
  Date: 2020/12/22
  Time: 16:31
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
    <title>管理学生信息</title>
</head>
<body>
<s:set var="name" value="#session['user']"/>
<h3><s:property value="#name"/>管理员,欢迎学籍信息管理系统!
    [<a href="LoginOut.action"><button class="btn btn-info">注销用户</button></a>]</h3>
<ul class="nav nav-tabs">
    <li role="presentation"><a href="manNotice.action">管理通知</a></li>
    <li role="presentation" class="active"><a href="listINFO2.action">学生信息管理</a></li>
    <li role="presentation"><a href="findSchool.action">学生在校信息管理</a></li>
    <li role="presentation"><a href="manChangePass.jsp">修改登录密码</a></li>
</ul>
<center>
    <s:form action="changeInfo2" method="post" enctype="multipart/form-data">
        <s:textfield type="text" label="学生学号" class="form-control" name="stu.sno" value="%{stu.sno}"/>
        <s:textfield type="text" label="学生姓名" class="form-control" name="stu.sname" value="%{stu.sname}"/>
<%--        <s:textfield type="text" label="性别" class="form-control" name="stu.ssex" value="%{stu.ssex}"/>--%>
        <s:radio name="stu.ssex" label="性别" list="{'男','女'}" value="%{stu.ssex}" class="form-inline"/>
        <s:textfield type="text" label="生日" class="form-control" name="stu.birth" value="%{stu.birth.toString()}"/>
        <s:textfield type="text" label="籍贯" class="form-control" name="stu.nativePlace" value="%{stu.nativePlace}"/>
        <s:textfield type="text" label="政治面貌" class="form-control" name="stu.politicalStatus" value="%{stu.politicalStatus}"/>
        <s:textfield type="text" label="电话" class="form-control" name="stu.phone" value="%{stu.phone}" readonly="false"/>
        <s:textfield type="text" label="邮箱" class="form-control" name="stu.email" value="%{stu.email}" readonly="false"/>
        <s:file label="头像" name="img" class="form-control"/>
        <s:submit value="提交保存" class="form-control"/>
    </s:form>
    <h3><s:property value="msg"/></h3>
</center>
</body>
</html>
