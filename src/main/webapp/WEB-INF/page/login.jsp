<%--
  Created by IntelliJ IDEA.
  User: lp
  Date: 2020/6/28
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="login" method="post" action="/login" style="text-align: center">
    <input type="text" placeholder="用户名" required="required" name="username">
    </br>
    <input type="password" placeholder="密码" required="required" name="password">
    </br>
    <input type="submit"></form>
</br>
<input type="checkbox" name="rememberme" style="text-align: center" placeholder="记住我">

</form>

</body>
</html>
