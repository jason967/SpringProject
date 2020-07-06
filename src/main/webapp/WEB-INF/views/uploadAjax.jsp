<%--
  Created by IntelliJ IDEA.
  User: choi
  Date: 2020-07-07
  Time: 오전 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Upload Ajax</title>
</head>
<body>
<h1>Upload With Ajax</h1>
<div class="uploadDiv">
    <input type="file" name="uploadFile" multiple>
</div>
<button id="uploadBtn">Upload</button>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>

<script>
    $(document).ready(function () {
        $("#uploadBtn").on("click",function (e) {

            var formData = new FormData();

            var inpuFile = $("input[name='uploadFile']");

            var files = inpuFile[0].files;

            console.log(files);

        });

    });
</script>
</body>
</html>
