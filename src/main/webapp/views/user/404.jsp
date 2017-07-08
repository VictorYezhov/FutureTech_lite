<%--
  Created by IntelliJ IDEA.
  User: terty
  Date: 26.06.2017
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <meta charset="UTF-8">
</head>
<body>
<div class="col-md-12 err-text text-center">
    <h1>404</h1>
    <p>We are sorry, the page you've requested is not available.</p>
    <a href="/"><i class="fa fa-home"></i> Go To Homepage</a>
    <p class="redirect-home">you should be automatically redirected in <span id="seconds">7</span> seconds.</p>
</div>
<script>
    var seconds = 7;
    var foo;

    function redirect() {
        document.location.href = '/';
    }

    function updateSecs() {
        document.getElementById("seconds").innerHTML = seconds;
        seconds--;
        if (seconds == -1) {
            clearInterval(foo);
            redirect();
        }
    }

    function countdownTimer() {
        foo = setInterval(function () {
            updateSecs()
        }, 1000);
    }

    countdownTimer();
</script>
</body>
</html>

