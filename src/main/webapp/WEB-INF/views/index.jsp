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
<%--    <script type="text/javascript">--%>
<%--        function doAjax() {--%>
<%--            var inputText = $("#input_str").val();--%>
<%--            $.ajax({--%>
<%--                url: 'validate',--%>
<%--                type: 'GET',--%>
<%--                dataType: 'json',--%>
<%--                contentType: 'application/json',--%>
<%--                mimeType: 'application/json',--%>
<%--                data: ({--%>
<%--                    inputPhone: inputText--%>
<%--                }),--%>
<%--                success: function (data) {--%>
<%--                    var result = '"' + data.inputPhone + '", ' + data.count + ' characters';--%>

<%--                    $("#result_text").text(result);--%>
<%--                }--%>
<%--            });--%>
<%--        }--%>
<%--    </script>--%>
    <script type="text/javascript">
        function doAjax() {

            var inputText = $("#input_str").val();

            $.ajax({
                url : 'validate',
                type: 'GET',
                dataType: 'json',
                contentType: 'application/json',
                mimeType: 'application/json',
                data : ({
                    text: inputText
                }),
                success: function (data) {

                    var result = '"'+data.text+'"';
                    $("#result_text").text(result);
                }
            });
        }
    </script>
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}validate" method="get">
        <div class="col-sm-6">
            <div class="form-group">
                <input type="tel"  placeholder="+8888 88888888" class="form-control"
                       pattern="[+][0-9]{2,6} [0-9]{8}" id="input_str"
                       maxlength="16" title="8 digits phone" required/>
                <label style="font-size:9px;padding-left:20px"> Country code 2 up to 6 dig.: 081 22222222 </label>
            </div>
            <button type="button" class="btn btn-primary" value="OK" onclick="doAjax()">Submit</button>
            <a href="${pageContext.request.contextPath}/makeTest"
               class="btn btn-primary" type="button" aria-pressed="true">Test Page</a>
        </div>
    </form>
    <p id="result_text"></p>
</div>

</body>
</html>
