<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin Panel | Future Tech</title>
    <link rel="stylesheet" href="/css/styles.css">
    <%--<link rel="stylesheet" href="/css/responsive.css">--%>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
</head>
<body>
<sec:authorize access="hasAuthority('ROLE_ADMIN')">
    <div class="header">
        <tiles:insertAttribute name="header"/>
    </div>
    <div class="page-content">
        <div class="row">
            <div class="col-md-3">
                <tiles:insertAttribute name="sidebar" />
            </div>
            <div class="col-md-9">
                <tiles:insertAttribute name="body" />
            </div>
        </div>
    </div>
    <tiles:insertAttribute name="footer" />

</sec:authorize>
</body>
</html>
