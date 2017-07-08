<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <!-- Logo -->
            <div class="logo">
                <h1><a href="/adminPage">Admin Panel</a></h1>
            </div>
        </div>
        <div class="col-md-4">
            <div class="row">
                <div class="col-lg-12">
                    <div class="input-group form">
                        <input type="text" class="form-control" placeholder="Search...">
                        <span class="input-group-btn">
	                         <button class="btn btn-primary" type="button">Search</button>
	                       </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="navbar navbar-inverse" role="banner">
                <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">My Account <b class="caret"></b></a>
                            <ul class="dropdown-menu animated fadeInUp">
                                <li><a href="/account"><i class="fa fa-user"></i> Profile</a></li>
                                <sec:authorize access="isAuthenticated()">
                                    <li><form:form action="/logout" method="post">
                                        <button class="btn btn-link"><i class="fa fa-sign-out"></i> LogOut</button>
                                    </form:form>
                                    </li>
                                </sec:authorize>
                            </ul>
                        </li>
                        <li><a href="/" target="_blank"><i class="fa fa-home"></i> My store</a> </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>