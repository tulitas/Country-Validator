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

        <form action="${pageContext.request.contextPath}result" method="post">
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="inputPassport">Car technical passport number</label>
                    <input type="text" class="form-control" id="inputPassport" name="inputPassport"
                           placeholder="Car technical passport number">
                </div>
                <div class="form-group">
                    <label for="inputDate">Date of birth</label>
                    <input type="date" class="form-control" id="inputDate" name="inputDate">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

    </form>
    </div>


</body>
</html>
