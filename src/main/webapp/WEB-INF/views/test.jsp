<%--@elvariable id="link" type="validator"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2 align="center">Test Page</h2>
<div class="container" >
    <div class="col-sm-2" >
        In list ${count} countries <br>
        Your table source is:  ${link}<br>
        Your table name is:  ${tableName}
    </div>
    <a href="${pageContext.request.contextPath}/"
       class="btn btn-primary" type="button" aria-pressed="true">Home</a>
</div>
</body>

</html>