<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/11/1
  Time: 19:19
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
<h5>添加班级</h5>
<form action="${pageContext.request.contextPath}/insertclaz" method="post">
    <li>
        <label>班级名称:</label>
        <input type="text" name="clazname" id="clazname">
    </li>
    <li class="reg_sub">
        <input type="submit" value="添加" name="">
    </li>
</form>
</body>
</html>
