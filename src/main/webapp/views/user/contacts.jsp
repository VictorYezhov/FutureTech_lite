<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: terty
  Date: 21.06.2017
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="contact-page">
    <div class="row">
        <div class="col-md-12 contact-map">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d82352.671015165!2d23.94219555815365!3d49.8326679491113!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x473add7c09109a57%3A0x4223c517012378e2!2z0JvRjNCy0ZbQsiwg0JvRjNCy0ZbQstGB0YzQutCwINC-0LHQu9Cw0YHRgtGM!5e0!3m2!1suk!2sua!4v1498035683179" width="600" height="450" style="border:0"></iframe>
        </div>
        <div class="col-md-8 contact-form">
            <div class="col-md-12 contact-title">
                <h4>Contact Form</h4>
            </div>

            <form:form  action="/sendMessage" id="main-contact-form" class="register-form" name="contact-form" method="post">
            <div class="col-md-4 ">
                <div class="form-group">
                    <label class="info-title" for="exampleInputName">Your Name <span>*</span></label>
                    <input type="text" name="name" class="form-control unicase-form-control text-input" id="exampleInputName" placeholder="Name" required>
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group">
                    <label class="info-title" for="exampleInputEmail1">Email Address <span>*</span></label>
                    <input type="email" name="email" class="form-control unicase-form-control text-input" id="exampleInputEmail1" placeholder="email" required>
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group">
                    <label class="info-title" for="exampleInputTitle">Title <span>*</span></label>
                    <input type="text" name="subject" class="form-control unicase-form-control text-input" id="exampleInputTitle" placeholder="Title">
                </div>
            </div>
            <div class="col-md-12">
                <div class="form-group">
                    <label class="info-title" for="exampleInputComments">Your Comments <span>*</span></label>
                    <textarea name="message" class="form-control unicase-form-control" id="exampleInputComments" required></textarea>
                </div>
            </div>
            <div class="col-md-12 outer-bottom-small m-t-20">
                <button type="submit" name="submit" class="btn-upper btn btn-primary checkout-page-button" id="send">Send Message</button>
            </div>
            </form:form>
        </div>
        <div class="col-md-4 contact-info">
            <div class="contact-title">
                <h4>Information</h4>
            </div>
            <div class="clearfix address">
                <span class="contact-i"><i class="fa fa-map-marker"></i></span>
                <span class="contact-span">Lviv, Ukraine</span>
            </div>
            <div class="clearfix phone-no">
                <span class="contact-i"><i class="fa fa-mobile"></i></span>
                <span class="contact-span">+3 8(000) 123-4567<br>+3 8(000) 123-4567</span>
            </div>
            <div class="clearfix email">
                <span class="contact-i"><i class="fa fa-envelope"></i></span>
                <span class="contact-span"><a href="#">no-reply@futuretech.com</a></span>
            </div>
        </div>
    </div>
</div>