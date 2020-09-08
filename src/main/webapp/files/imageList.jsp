<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:useBean id="arr" type="com.file.FileDTO"/>--%>
<%--<jsp:setProperty name="arr" property="*"/>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${arr}" var="item">
    <img src=../upload/${item.image} width=100 height=100>
    작성자:${item.name}
    제목:${item.title}
</c:forEach>
</body>
</html>
