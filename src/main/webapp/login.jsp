<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/11/1
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(
            function () {
                var captcha = false;
                $("#captcha_input").blur(
                    function () {
                        var captchainput = $("#captcha_input").val();
                        $.ajax({
                            url:"${pageContext.request.contextPath}/checkcode",
                            type:"post",
                            data:"captchainput="+captchainput,
                            dataType:"json",
                            success:function (data) {
                                console.log(data);
                                if (data.captcha_check==1){
                                    $("#captcha_span").text("验证码正确");
                                    $("#captcha_span").css({"color":"green"});
                                    $("#captcha_span").show();
                                    captcha = true;
                                } else {
                                    $("#captcha_span").text("验证码错误");
                                    $("#captcha_span").css({"color":"red"});
                                    $("#captcha_span").show();
                                }
                            }
                        })

                    }
                )
                $("#check_submit").click(
                    function () {
                        <%--var checkboxr = $("#checkbox_r").val();--%>
                        <%--$.ajax({--%>
                        <%--    url:"${pageContext.request.contextPath}/login",--%>
                        <%--    type:"post",--%>
                        <%--    data:"checkboxr="+checkboxr,--%>
                        <%--    dataType:"json",--%>
                        <%--})--%>
                        if (captcha){
                            $("#form_check").submit();

                        } else {
                            return false;
                        }
                    }
                )
            }
        )
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    username: <input type="text" name="username"> <br>
    password: <input name="password" type="password"> <br>
        <img src="${pageContext.request.contextPath}/captcha" style="width:85px;height: 25px" id="cap"> <input id="captcha_input" style="background: #fdfdfd;height: 25px;width: 100px;vertical-align: middle;">
        <span id="captcha_span" style="display:none;" >提示信息</span>
    <input id="check_submit" type="submit" name="" value="登录" class="input_submit">
</form>
<script>
    $(function(){
        $("#cap").click(function(){
            //刷新验证码
            path = $(this).attr("src")+"?"+new Date().getTime();
            $(this).attr("src",path);
        });
    });
</script>
</body>
</html>
