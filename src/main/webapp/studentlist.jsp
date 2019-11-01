<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/11/1
  Time: 17:52
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
<div id="studentlist">
    <ul id="goods_ul" class="goods_type_list clearfix">
        <c:forEach items="${studentList}" var="studentList" varStatus="sta">
            <li style="border: 1px solid lightslategray">
                <span>
                   学生ID： ${studentList.id}
                </span><br>
                <span>
                    姓名：    ${studentList.username}
                </span><br>
                <span>
                      性别：${studentList.gender}
                </span><br>
                <span>
                      入学时间：<fmt:formatDate value="${studentList.regist_time}" pattern="yyyy-MM-dd"/>
                </span><br>
                <span>
                      班级ID：${studentList.claz_id}
                </span><br>
            </li>


        </c:forEach>

    </ul>

</div>
<div class="pagenation">
    <%--<div class="pagenation">--%>
        <c:if test="${page.hasPreviousPage}">
            <a href="${pageContext.request.contextPath}/studentlist?claz_id=1&pageNum=${page.prePage}">上一页</a>
        </c:if>
        <c:if test="${! page.hasPreviousPage}">
            上一页
        </c:if>
        <a href="${pageContext.request.contextPath}/studentlist?claz_id=1&pageNum=1" class="active">1</a>
        <a href="${pageContext.request.contextPath}/studentlist?claz_id=1&pageNum=2">2</a>
        <a href="${pageContext.request.contextPath}/studentlist?claz_id=1&pageNum=3">3</a>
        <a href="${pageContext.request.contextPath}/studentlist?claz_id=1&pageNum=4">4</a>
        <a href="${pageContext.request.contextPath}/studentlist?claz_id=1&pageNum=5">5</a>

        <c:if test="${page.hasNextPage}">
            <a href="${pageContext.request.contextPath}/studentlist?claz_id=1&pageNum=${page.nextPage}">下一页></a>
        </c:if>
        <c:if test="${! page.hasNextPage}">下一页</c:if>

    <%--</div>--%>
</div>
</body>
</html>
