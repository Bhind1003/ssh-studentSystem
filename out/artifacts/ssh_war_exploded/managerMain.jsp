<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈明瀚
  Date: 2020/12/17
  Time: 16:44
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
    <title>管理员功能界面</title>
</head>
<body>
<s:set var="name" value="#session['user']"/>
<h3><s:property value="#name"/>管理员,欢迎学籍信息管理系统!
    [<a href="LoginOut.action"><button class="btn btn-info">注销用户</button></a>]
</h3>
<ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="manNotice.action">管理通知</a></li>
    <li role="presentation"><a href="listINFO2.action">学生信息管理</a></li>
    <li role="presentation"><a href="findSchool.action">学生在校信息管理</a></li>
<%--    <li role="presentation"><a href="#">学生登录密码管理</a></li>--%>
    <li role="presentation"><a href="manChangePass.jsp">修改登录密码</a></li>
</ul>
<h3>欢迎进入学生信息管理系统，在本系统，你可以查看和修改管理所以学生的信息。</h3>
<a href="changeNotice.action?id=add">
    <button class="btn btn-info">添加通知</button>
</a>
<center>
    <s:form action="findNotice" method="POST" class="form-inline">
        <div class="form-group">
            <label>搜索条件：
                <input type="text" name="condition" class="form-control"/>
            </label>
            <input type="submit" value="查找" class="form-control"/>
        </div>
    </s:form>
    <h3><s:property value="msg"/></h3>
    <table style="width: auto; margin:10px auto" class="table table-hover">
        <tr>
            <th align="center">通知时间</th>
            <th align="center">通知内容</th>
            <th align="center">操作</th>
        </tr>
        <s:set var="tmp" value="#session['notice2']"/>
        <s:iterator value="tmp">
            <tr>
                <td><s:property value="date"/></td>
                <td width="300" bgcolor="#f0f8ff"><div><s:property value="info"/></div></td>
                <td>
                    <a href="changeNotice.action?id=<s:property value="date"/>">
                        <button>修改</button>
                    </a>
                    <a href="deleteNotice.action?id=<s:property value="date"/>">
                        <button onclick="test()">删除</button>
                    </a>
                </td>
            </tr>
        </s:iterator>
    </table>
</center>
</body>
<script>
    function test() {
        const r = confirm("确定删除嘛？");
        if (r===true) {
            window.location.href("deleteNotice.action?id=<s:property value="date"/>");
        }
        else {
            history.go(-2);
        }
    }
</script>
</html>
