<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/11/1
  Time: 17:05
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
<div id="fenye">
    <ul id="goods_ul" class="goods_type_list clearfix">
        <c:forEach items="${clazList}" var="clazList" varStatus="sta">
            <li style="border: 1px solid lightslategray">
                <span>
                   班级ID： ${clazList.id}
                </span><br>
                <span>
                    班级名：    ${clazList.clazname}
                </span><br>
                <span>
                      班级创建时间：<fmt:formatDate value="${clazList.create_time}" pattern="yyyy-MM-dd"/>
                </span><br>
                <shiro:hasRole name="teacher">
                    <a href="${pageContext.request.contextPath}/studentlist?claz_id=${clazList.id}">查询班级学生</a>


<%--                href="${pageContext.request.contextPath}/studentlist?claz_id=${clazList.claz_id}"--%>
                <a href="${pageContext.request.contextPath}/insertclaz.jsp">添加班级</a>

                </shiro:hasRole>
            </li>



        </c:forEach>

    </ul>

</div>
<div class="pagenation">
    <c:if test="${page.hasPreviousPage}">
        <a href="${pageContext.request.contextPath}/clazlist?pageNum=${page.prePage}">上一页</a>
    </c:if>
    <c:if test="${! page.hasPreviousPage}">
        上一页
    </c:if>
    <a href="${pageContext.request.contextPath}/clazlist?pageNum=1" class="active">1</a>
    <a href="${pageContext.request.contextPath}/clazlist?pageNum=2">2</a>
    <a href="${pageContext.request.contextPath}/clazlist?pageNum=3">3</a>
    <a href="${pageContext.request.contextPath}/clazlist?pageNum=4">4</a>
    <a href="${pageContext.request.contextPath}/clazlist?pageNum=5">5</a>

    <c:if test="${page.hasNextPage}">
        <a href="${pageContext.request.contextPath}/clazlist?pageNum=${page.nextPage}">下一页></a>
    </c:if>
    <c:if test="${! page.hasNextPage}">下一页</c:if>

</div>
</body>
</html>
