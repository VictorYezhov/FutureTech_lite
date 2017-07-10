<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="sign-in-page">
    <div class="row">
        <!-- Sign-in -->
        <div class="col-md-6 col-sm-6 sign-in">
            <h4 class="">Sign in</h4>
            <p class="">Hello, Welcome to your account.</p>
            <form:form class="register-form" action="/login" method="post">
                <h3 class="text-center" style="color: red;">${exception}</h3>
                <div class="form-group">
                    <label class="info-title" for="login-name">Login Name <span>*</span></label>
                    <input name="username" type="text" class="form-control unicase-form-control text-input" id="login-name" onkeyup="check();">
                </div>
                <div class="form-group">
                    <label class="info-title" for="login-password">Password <span>*</span></label>
                    <input name="password" type="password" class="form-control unicase-form-control text-input" id="login-password" onkeyup="check();">
                </div>
                <button type="submit" class="btn-upper btn btn-primary checkout-page-button" disabled="disabled" id="login-btn">Login</button>
            </form:form>
        </div>

        <!-- Sign-in -->
    </div>
    <div>
        <p><spring:message code="label.prorosal_of_register"/> <a href="/signUp"><spring:message code="label.signUp"/></a></p>
    </div>
</div>

<script>
    function check() {
        var login = document.getElementById('login-name'),
            password = document.getElementById('login-password');
        document.getElementById('login-btn').disabled = login.value && password.value ? false : "disabled";
    }
</script>
