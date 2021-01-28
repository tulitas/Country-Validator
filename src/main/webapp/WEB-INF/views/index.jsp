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
</head>
<body>

<div class="container">


    <form action="${pageContext.request.contextPath}validate" method="post">

        <div class="col-sm-6">
            <div class="form-group">
                <input type="tel" name="inputPhone" placeholder="+8888 8888888" class="form-control"
                       pattern="[+][0-9]{3,4} [0-9]{7,8}"
                       maxlength="13" title="Twelve digits code" required/>
                <label style="font-size:9px;padding-left:20px"> Country code 3 or 4 dig.: 081 222 2224 </label>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="${pageContext.request.contextPath}/test"
               class="btn btn-primary" type="button" aria-pressed="true">Test Page</a>
        </div>

    </form>
</div>
<a href="test.jsp">test</a>

</body>
</html>
