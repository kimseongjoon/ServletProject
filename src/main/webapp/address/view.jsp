<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>이름</th>
        <th>주소</th>
        <th>우편번호</th>
        <th>전화번호</th>
    </tr>
    <tr>
        <td>${name}</td>
        <td>${addr}</td>
        <td>${zipcode}</td>
        <td>${phone}</td>
    </tr>
</table>
</body>
</html>
--%>

<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-25(025)
  Time: 오후 2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script>
        function del() {
            if (confirm("정말 삭제할까요?")) {
                location.href = "delete?num=" + ${address.num};
            }
        }
    </script>
</head>
<body>
<form action="update" method="post">
    <input type="hidden" name="num" value="${address.num}">
    <table>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name" value="${address.name}"></td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td><input type="text" name="tel" value="${address.tel}"></td>
        </tr>
        <tr>
            <th>우편번호</th>
            <td>
                <input type="text" name="zipcode" size="10" value="${address.zipcode}">
                <button type="button">검색</button>
            </td>
        </tr>
        <tr>
            <th>주소</th>
            <td><input type="text" name="addr" size="50" value="${address.addr}"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="수정">
                <input type="button" value="전체보기" onclick="location.href='list'">
                <input type="reset" value="삭제" onclick="location.href = 'delete?num=${address.num}'">
                <input type="reset" value="자바스크립트삭제" onclick="del()">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

