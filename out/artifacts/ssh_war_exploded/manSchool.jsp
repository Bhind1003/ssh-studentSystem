<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈明瀚
  Date: 2020/12/21
  Time: 19:52
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
    <title>管理学生在校信息</title>
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
<a href="manSchoolChange.jsp"><button  class="btn btn-info">添加学生在校信息</button></a>
<a href="findSchool.action?id=count"><button class="btn btn-info">统计数量</button></a>
<center>
    <s:form action="findSchool" method="POST" class="form-inline">
        <div class="form-group">
            <s:select name="kind" list="{'sno','deptName','specialty','clazz','dormitory'}" class="form-control"/>
            <label>搜索条件：
                <input type="text" name="condition" class="form-control"/>
            </label>
            <input type="submit"  value="查找" class="form-control"/>
        </div>
    </s:form>
    <h3><s:property value="msg"/></h3>
    <table style="width: auto; margin:10px auto" class="table table-hover" text-align="center">
        <tr>
            <th align="center">学生学号</th>
            <th align="center">所在学院</th>
            <th align="center">专业</th>
            <th align="center">班级</th>
            <th align="center">宿舍</th>
            <th align="center">操作</th>
        </tr>
        <s:set var="tmp" value="#session['school2']"/>
        <s:iterator value="tmp">
            <tr>
                <td><s:property value="sno"/></td>
                <td><s:property value="deptName"/></td>
                <td><s:property value="specialty"/></td>
                <td><s:property value="clazz"/></td>
                <td><s:property value="dormitory"/></td>
                <td>
                    <a href="updateSchool2.action?id=<s:property value="sno"/>"><button>修改</button></a>
                    <a href="deleteSchool2.action?id=<s:property value="sno"/>"><button onclick="">删除</button></a>
                </td>
            </tr>
        </s:iterator>
    </table>
</center>
</body>
<script>
    function test() {
        const r=window.confirm("确定删除嘛？");
    }
</script>
</html>
