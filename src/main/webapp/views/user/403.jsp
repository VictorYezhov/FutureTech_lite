<html>
<head>
    <title>403</title>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <meta charset="UTF-8">
</head>
<body>
<div class="col-md-12 err-text text-center">
    <h1>403</h1>
    <p>Sorry but you do not have permissions to access this page.</p>
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
