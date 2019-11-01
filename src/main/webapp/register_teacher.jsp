<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/11/1
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Title</title>
</head>
<body>
<h5>教师注册</h5>
    <form action="${pageContext.request.contextPath}/register_teacher" method="post">
        <li>
            <input type="text" name="username" id="user_name">
            <span id="username_check" style="display: none"></span>
        </li>
        <li>
            <label>密码:</label>
            <input type="password" name="password" id="pwd">
            <span class="error_tip" id="pwd_check">提示信息</span>
        </li>
        <li>
            <label>性别:</label>
            <input type="text" name="gender" id="gender">
            <span class="error_tip" id="email_check">提示信息</span>
        </li>
        <li class="reg_sub">
            <input type="submit" id="submit_check" value="注 册" name="">
        </li>
    </form>
</body>
</html>
