<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/11/1
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/updateuser" method="post">
    <span>
                   学生ID： ${User.id}<input name="id" style="display:none;" value="${User.id}">
                </span><br>
    <span>
                    姓名：    <input name="username" value="${User.username}">
                </span><br>
    <span>
                      性别：<input name="gender" value="${User.gender}">
                </span><br>
    <span>
                      班级ID：<input name="claz_id" value="${User.claz_id}">
                </span><br>
    <input type="submit" value="提交修改">

</form>


</body>
</html>
