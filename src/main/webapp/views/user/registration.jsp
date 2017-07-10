<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<div class="sign-in-page">
        <div class="row">
        <!-- create a new account -->
        <div class="col-md-6 col-sm-6 create-new-account">
            <h4 class="checkout-subtitle">Create a new account</h4>
            <p class="text title-tag-line">Create your new account.</p>
            <form:form modelAttribute="user" class="register-form outer-top-xs"  method="post">
                <div class="form-group">
                    <label class="info-title" for="exampleInputEmail">Email Address <span>*</span></label>
                    <form:input path="email" type="email" class="form-control unicase-form-control text-input" id="exampleInputEmail" placeholder="Your Email"/>
                    <span>${emailException}</span>
                </div>
                <div class="form-group">
                    <label class="info-title" for="exampleInputName">Name <span>*</span></label>
                    <form:input path="name" type="text" class="form-control unicase-form-control text-input" id="exampleInputName" placeholder="Your Login Name"/>
                    <span>${usernameException}</span>
                </div>
                <div class="form-group">
                    <label class="info-title" for="new-password">Password (At least 6 characters) <span>*</span></label>
                    <form:input path="password"  type="password"   class="form-control unicase-form-control text-input" id="new-password"/>
                    <span>${passwordException}</span>
                </div>
                <div class="form-group">
                    <label class="info-title" for="confirm-password">Confirm Password <span>*</span></label>
                    <input type="password" name="confirmPass" class="form-control unicase-form-control text-input" id="confirm-password" onkeyup="checkPass(); return false;">
                    <span id="confirmMessage" class="confirmMessage"></span>
                </div>
                <button type="submit" id="submit-btn" class="btn-upper btn btn-primary checkout-page-button" disabled="disabled">Sign Up</button>
            </form:form>
        </div>
    </div>
</div>




<script>
    function checkPass(){
        var pass1 = document.getElementById('new-password');
        var pass2 = document.getElementById('confirm-password');
        var message = document.getElementById('confirmMessage');
        var goodColor = "#66cc66";
        var badColor = "#ff6666";
        var btn = document.getElementById('submit-btn');
        if((pass1.value == pass2.value) && (pass1.value.length > 5)){
            pass2.style.backgroundColor = goodColor;
            message.style.color = goodColor;
            message.innerHTML = "Passwords is Ok!"
            btn.disabled = false;
        }else{
            pass2.style.backgroundColor = badColor;
            message.style.color = badColor;
            message.innerHTML = "Passwords do not match or have less than 6 characters!";
            btn.disabled = true;
        }
    }
</script>