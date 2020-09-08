<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-28(028)
  Time: 오전 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    var sendIt = function () {
        if ($("#dong").val() == "") {
            alert("동이름을 입력하세요")
            $("#dong").focus();
            return false;
        }
        $.ajax({
            type:"post",
            url:"zipCheck",
            data:{"dong" : $("#dong").val()},
            success:function (result) {
                data = JSON.parse(result);
                var htmlStr="<table>"
                for (var i = 0; i < data.length; i++) {
                    htmlStr += "<tr>";
                    htmlStr += "<td>" + data[i].zipcode + "</td>";
                    htmlStr += "<td>" + data[i].sido + "</td>";
                    htmlStr += "<td>" + data[i].gugun + "</td>";
                    htmlStr += "<td>" + data[i].dong + "</td>";
                    htmlStr += "<td>" + data[i].bunji + "</td>";
                    htmlStr += "<tr>";
                }
                htmlStr += "</table>";
                $("#area").html(htmlStr);
            }
        });
    };
    $(function () {
        $("#area").on("click", "tr", function () {
            var address = $("td:eq(1)", this).text() + " " + $("td:eq(2)", this).text() + " " + $("td:eq(3)", this).text() + " " + $("td:eq(4)", this).text();
            $(opener.document).find("#zipcode").val($("td:eq(0)", this).text())
            $(opener.document).find("#addr").val(address);
            self.close();
        })
        $("#send").on("click", function () {
            sendIt();
        });
        $("#dong").keydown(function (e) {
            if (e.keyCode == 13) {
                sendIt();
                return;
            }
        })
    })
</script>
<body>
<table>
    <tr>
        <td>
            동이름입력:<input type="text" name="dong" id="dong">
            <input type="button" value="검색" id="send">
        </td>
    </tr>
    <%--        <%--%>
    <%--            if (zipArr.isEmpty()) {--%>
    <%--        %>--%>
    <tr>
        <td>
            검색된 결과가 없습니다
        </td>
    </tr>

    <%--        <%--%>
    <%--        } else {--%>
    <%--        %>--%>

    <tr>
        <td>*검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.</td>
    </tr>

    <%-- <%
         for (ZipCodeVO z : zipArr) {
             String zip = z.getZipcode();
             String sido = z.getSido();
             String bunji = z.getBunji();
             String gugun = z.getGugun();
             String d = z.getDong();
     %>
     <tr>
         <td>
             <a href="javascript:send('<%=zip%>', '<%=sido%>', '<%=gugun%>', '<%=d%>', '<%=bunji%>')">
                 <%=zip%> <%=sido%> <%=gugun%> <%=d%> <%=bunji%>
             </a>
         </td>
     </tr>
     <%

             }
         }
     %>--%>
</table>
<div id="area"></div>
</body>
</html>
