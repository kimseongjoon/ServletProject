<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="upload.do" method="post" enctype="multipart/form-data">
    글쓴이:<input type="text" name="name"><br>
    제목:<input type="text" name="title"><br>
    파일 지정하기:<input type="file" name="uploadFile"><br>
    <input type="submit" value="전송">
</form>
</body>
</html>