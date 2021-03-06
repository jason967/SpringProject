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
<style>

    .uploadResult
    {
        width:100%;
        background-color: gray;
    }

    .uploadResult ul{
        display: flex;
        flex-flow: row;
        justify-content: center;
        align-content: center;
    }

    .uploadResult ul li{
        list-style: none;
        padding: 10px;
    }

    .uploadResult ul li{
        list-style: none;
        padding: 10px;
    }
    .uploadResult ul li img
    {
        width: 20px;
    }
</style>
<div class="uploadDiv">
    <input type="file" name="uploadFile" multiple>
</div>

    <div class='uploadResult'>
        <ul>

        </ul>
    </div>


<button id="uploadBtn">Upload</button>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>

<script>


        var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
        var maxSize = 5242880;

        function checkExtension(fileName,fileSize)
        {
            if(fileSize>=maxSize)
            {
                alert("파일 사이즈 초과");
                return false;
            }

            if(regex.test(fileName))
            {
                alert("해당 종류의 파일은 업로드 할 수 없습니다.");
                return false;
            }
            return true;
        }

        var cloneObj = $(".uploadDiv").clone();

        $("#uploadBtn").on("click",function (e) {

            var formData = new FormData();

            var inputFile = $("input[name='uploadFile']");

            var files = inputFile[0].files;

            console.log(files);

            for(var i =0;i<files.length;i++)
            {
                if(!checkExtension(files[i].name,files[i].size))
                {
                    return false;
                }
                formData.append("uploadFile",files[i]);
            }

            $.ajax({
                url:'/uploadAjaxAction',
                processData:false,
                contentType:false,
                data:formData,
                type:'post',
                dataType:'json',
                success:function (result) {

                    console.log("helpMe"+result);
                    showUploadedFile(result);
                    $(".uploadDiv").html(cloneObj.html());
                }
            });

        });

    var uploadResult = $(".uploadResult ul");

    function showUploadedFile(uploadResultArr) {
        var str ="";

        $(uploadResultArr).each(
            function (i,obj)
            {
                console.log(obj.image);
                if(!obj.image)
                {
                    str+="<li><img src='/resources/img/attach.jpg'>"+obj.fileName+"</li>";
                }
                else
                {
                    //str +="<li>"+obj.fileName +"</li>";
                    var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);

                    str+="<li><img src='/display?fileName="+fileCallPath+"'><li>";
                }

            });

        uploadResult.append(str);
        console.log(str);
    }
</script>
</body>
</html>
