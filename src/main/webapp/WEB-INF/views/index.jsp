<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Data</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script type="text/JavaScript"
            src="${pageContext.request.contextPath}/resources/js/jquery-1.9.1.min.js">
    </script>
    <script type="text/javascript">
        function doAjax() {

            var inputText = $("#input_str").val();

            $.ajax({
                url : 'testAjax',
                type: 'GET',
                dataType: 'json',
                contentType: 'application/json',
                mimeType: 'application/json',
                data : ({
                    text: inputText
                }),
                success: function (data) {

                    var result = '"'+data.text+'", '+data.count+' characters';
                    $("#result_text").text(result);
                }
            });
        }
    </script>
</head>
<body>

<div class="container">


    <form action="${pageContext.request.contextPath}validate" method="post">

        <div class="col-sm-6">
            <div class="form-group">
                <input type="tel" name="inputPhone" placeholder="+8888 88888888" class="form-control"
                       pattern="[+][0-9]{3,6} [0-9]{8}"
                       maxlength="16" title="8 digits phone" required/>
                <label style="font-size:9px;padding-left:20px"> Country code 3 up to 6 dig.: 081 2222224 </label>
            </div>

            <button type="submt" class="btn btn-primary">Submit</button>
            <a href="${pageContext.request.contextPath}/makeTest"
               class="btn btn-primary" type="button" aria-pressed="true">Test Page</a>
        </div>

    </form>
</div>
<a href="test.jsp">test</a>
<input id="input_str" type="text">
<button type="button" class="btn btn-primary" value="OK" onclick="doAjax()">Do ajax</button>
<p id="result_text"></p>
</body>
</html>
