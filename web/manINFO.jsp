<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈明瀚
  Date: 2020/12/21
  Time: 21:38
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
<a href="manINFOchange.jsp"><button  class="btn btn-info">添加学生信息</button></a>
<a href="listINFO2.action?id=count"><button class="btn btn-info">统计数量</button></a>
<center>
<s:form action="listINFO2" method="POST" class="form-inline">
    <div class="form-group">
        <s:select name="kind" list="{'sno','sname','ssex','birth','nativePlace','politicalStatus','phone','email'}" class="form-control"/>
        <label>搜索条件：
            <input type="text" name="condition" class="form-control"/>
        </label>
        <input type="submit" value="查找" class="form-control"/>
    </div>
</s:form>
   <h4><s:property value="msg"/></h4>
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
<s:set var="tmp" value="#session['stu2']"/>
<s:iterator value="tmp">
    <tr>
        <td><s:property value="sno"/></td>
        <td><s:property value="sname"/></td>
        <td><s:property value="ssex"/></td>
        <td><s:property value="birth.toString()"/></td>
        <td><s:property value="nativePlace"/></td>
        <td><s:property value="politicalStatus"/></td>
        <td><s:property value="phone"/></td>
        <td><s:property value="email"/></td>
        <td><img src="<s:property value="pic"/>" class="img-circle" height="60" alt="头像图片损坏"></td>
        <td>
            <a href="changeInfo2.action?id=<s:property value="sno"/>"><button>修改个人信息</button></a>
            <a href="deleteInfo2.action?id=<s:property value="sno"/>"><button onclick="test()">删除个人信息</button></a><br/>
            <a href="updateSchool2.action?id=<s:property value="sno"/>"><button>编辑在校信息</button></a>
            <a href="resetPass.action?id=<s:property value="sno"/>"><button onclick="test()">重置登录密码</button></a>
        </td>
    </tr>
</s:iterator>
</table>
    <h4><s:property value="cntMsg"/></h4>
</center>
</body>
<script>
    function test() {
        const r=window.confirm("确定执行操作嘛？");
    }
</script>
</html>
