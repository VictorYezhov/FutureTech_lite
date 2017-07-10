<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<header class="header">
    <div class="top-bar animate-dropdown">
        <div class="container">
            <div class="header-top-inner">
                <div class="cnt-account">
                    <ul class="list-unstyled">
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <li><a href="/adminPage"><i class="fa fa-user"></i> Admin Page</a></li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <li><a href="/account"><i class="icon fa fa-user"></i><spring:message code="label.account"/></a></li>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                        <li><a href="/shoppingCart"><i class="icon fa fa-shopping-cart"></i><spring:message code="label.cart"/></a></li>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
                            <li><a href="/login"><i class="icon fa fa-lock"></i><spring:message code="label.login"/></a></li>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <li><form:form action="/logout" method="post">
                                <button class="btn-log-out">LogOut</button>
                            </form:form>
                            </li>
                        </sec:authorize>
                    </ul>
                </div><!-- /.cnt-account -->

                <div class="cnt-block">
                    <ul class="list-unstyled list-inline">
                        <li class="dropdown dropdown-small">
                            <a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown"><span class="value"><spring:message code="label.language"/> </span><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/?lang=en">English</a></li>
                                <li><a href="/?lang=ua">Ukrainian</a></li>
                            </ul>
                        </li>
                    </ul><!-- /.list-unstyled -->
                </div><!-- /.cnt-cart -->
                <div class="clearfix"></div>
            </div><!-- /.header-top-inner -->
        </div><!-- /.container -->
    </div>

    <div class="main-header">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-3 logo-holder">
                    <div class="logo">
                        <a href="/"><h2>Future Tech</h2></a>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-12 col-md-7 top-search-holder">
                    <div class="search-area">
                        <form:form action="/search" method="post">
                            <div class="control-group">
                                <input type="text" class="search-field" placeholder="Search here..." name="searchName" id="search_input">
                                <button class="btn search-button"><i class="fa fa-search"></i></button>
                            </div>
                        </form:form>
                    </div>
                </div>

            </div>
        </div>
    </div>



    <!--Nav Bar-->

    <div class="header-nav animate-dropdown">
        <div class="container">
            <div class="yamm navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button data-target="#mc-horizontal-menu-collapse" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>

                <div class="nav-bg-class">
                    <div class="navbar-collapse collapse" id="mc-horizontal-menu-collapse">
                        <div class="nav-outer">
                            <ul class="nav navbar-nav">
                                <li class="active">
                                    <a href="/"><spring:message code="label.home"/></a>
                                </li>
                                <li>
                                    <a href="/contacts"><spring:message code="label.contact"/></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<script>
    $.get("/search", {term: $('#search_input').val()}, function(data) {
// do your data manipulation and transformation here
    });
</script>