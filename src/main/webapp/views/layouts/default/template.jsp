<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Future Tech</title>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/jquery-ui.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/lightbox.css">
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/jquery-ui.min.js"></script>
    <script src="/js/lightbox.js"></script>
    <script src="/js/custom.js"></script>
    <meta charset="UTF-8">
</head>
<body>
<tiles:insertAttribute name="header"/>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-3 sidebar">
                <tiles:insertAttribute name="sidebar"/>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-9 content">
                <div class="row">
                    <tiles:insertAttribute name="body"/>
                </div>
            </div>
        </div>
    </div>
</div>
<tiles:insertAttribute name="footer"/>
</body>
</html>