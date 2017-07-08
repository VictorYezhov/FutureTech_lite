<div class="col-md-12 err-text text-center">
    <h2 style="color: green;">Thank for your response! We will answer your questions as soon as possible</h2>
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
