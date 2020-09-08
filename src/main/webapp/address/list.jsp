<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#btn").click(
                function () {
                    if ($("#word").val() == "") {
                        alert("검색어를 입력하세요.");
                        $("#word").focus();
                        return false;
                    }
                    $.getJSON("searchList",
                        {"field": $("#field").val(), "word": $("#word").val()},
                        function (data) {
                            // alert(data.jarr.length);
                            var htmlStr = "";
                            $.each(data.jarr, function (key, val) {
                                htmlStr += "<tr>";
                                <%--htmlStr +=     "<td><a href='view?num=${ad.num}'>${ad.name}</a></td>";--%>
                                htmlStr += "<td>" + val.name + "</td>";
                                htmlStr += "<td>" + val.addr + "</td>";
                                htmlStr += "<td>" + val.zipcode + "</td>";
                                htmlStr += "<td>" + val.tel + "</td>";
                                htmlStr += "<tr>";
                            });
                            $("table tbody").html(htmlStr);
                            $("span").text(data.countObj.count);
                        }
                    );
                });
        });
    </script>
</head>
<body>
<table>
    <a href="insert">글쓰기</a> / <a href="list">전체보기</a><br>
    <h3>전체회원(<span>${count}</span>)</h3>
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
            <td><a href="view?num=${ad.num}">${ad.name}</a></td>
            <td>${ad.addr}</td>
            <td>${ad.zipcode}</td>
            <td>${ad.tel}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--버튼을 클릭했을 경우 form action을 실행, 연결된 함수를 실행 두가지를 모두 할 수 있기 때문에 한가지는 설정 했는지 확인 필요--%>
<%--<form action="searchList">--%>
<form>
    <select name="field" id="field">
        <option value="name">이름</option>
        <option value="tel">전화번호</option>
    </select>
    <input type="text" name="word" id="word">
    <input type="button" id="btn" value="찾기">

<%--    버튼의 타입이 정의되어있지 않으면 submit동작을 하기 때문에 type을 지정해줘야함--%>
<%--    <button id="btn" value="찾기">--%>

</form>
</body>
</html>
