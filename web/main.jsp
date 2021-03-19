<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈明瀚
  Date: 2020/12/17
  Time: 15:50
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
    <title>学生功能页面</title>
</head>
<body>
<s:set var="name" value="#session['user']"/>
<h3><s:property value="#name"/>用户,欢迎登录学籍信息页面!
    [<a href="LoginOut.action"><button class="btn btn-info">注销用户</button></a>]</h3>
<ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="getNotice.action">首页</a></li>
    <li role="presentation"><a href="listOne.action">学生个人信息</a></li>
    <li role="presentation"><a href="getSchool.action">学生在校信息</a></li>
    <li role="presentation"><a href="stuChangepass.jsp">修改登录密码</a></li>
</ul>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;欢迎登录使用学生信息管理系统，在本系统，你可以查看和修改你的个人信息并且对你的在校信息进行查询。</h4>
<%--<s:a action="getNotice"><button class="btn btn-info">查看通知</button></s:a>--%>
<center>
    <s:form action="getNotice" method="POST" class="form-inline">
        <div class="form-group">
            <label>搜索条件：
                <input type="text" name="condition" class="form-control"/>
            </label>
            <input type="submit" value="查找" class="form-control"/>
        </div>
    </s:form>
    <h4><s:property value="msg"/></h4>
</center>
<table style="width: auto; margin:auto" class="table table-hover" text-align="center">
    <tr>
        <th align="center">通知时间</th>
        <th align="center">通知内容</th>
        <th align="center">通知文件</th>
    </tr>
    <s:set var="tmp" value="#session['notice']"/>
    <s:iterator value="tmp">
        <tr>
            <td><s:property value="date"/></td>
            <td width="300" bgcolor="#f0f8ff"><div><s:property value="info"/></div></td>
            <td><a href="download.action?id=<s:property value="date"/>"><button>下载通知文件</button></a></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
