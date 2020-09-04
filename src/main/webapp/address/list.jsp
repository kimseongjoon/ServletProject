<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <a href="insert">글쓰기</a>
    <thead>
    <tr>
        <th>이름</th>
        <th>주소</th>
        <th>우편번호</th>
        <th>전화번호</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lists}" var="ad">
        <tr>
            <td>${ad.name}</td>
            <td>${ad.addr}</td>
            <td>${ad.zipcode}</td>
            <td>${ad.tel}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
