<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="main-heading2 page-title">Mobile Phones</h2>

<div class="product-filter">
    <div class="row">
        <div class="col-md-6 text-left">
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span
                        class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <custom:sort innerHtml="Name (A-Z)" paramValue="name"/>
                    <custom:sort innerHtml="Name (Z-A)" paramValue="name,desc"/>
                    <custom:sort innerHtml="Price (Low > High)" paramValue="price"/>
                    <custom:sort innerHtml="Price (High > Low)" paramValue="price,desc"/>
                </ul>
            </div>
        </div>
        <div class="col-md-6 text-right">
            <custom:size posibleSizes="1,2,5,10" size="${telephoneList.size}"/>
        </div>
    </div>
</div>

<c:forEach var="telephone" items="${telephoneList.content}">
    <div class="col-md-4 col-sm-6">
        <div class="product-col">
            <div class="image">
                <img src="${telephone.pathImage}" alt="product" class="img-responsive">
            </div>
            <div class="caption">
                <div class="price">
                    <span class="price-new">&#8372; ${telephone.price}</span>
                </div>
                <h4><a href="/details/${telephone.id}">${telephone.name}</a></h4>
                <div class="cart-button button-group">
                    <button type="button" class="btn btn-cart" onclick="window.location.href='/addtoCart/${telephone.id}'">
                        <i class="fa fa-shopping-cart"></i>
                    </button>
                    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
                        <button type="button" class="btn btn-success" onclick="window.location.href='/updateCommodity/${telephone.id}'">
                            <i class="fa fa-refresh"></i>
                        </button>
                        <button type="button" class="btn btn-danger" onclick="window.location.href='/deleteCommodity/${telephone.id}'">
                            <i class="fa fa-trash"></i>
                        </button>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

<div class="col-md-16 text-center">
    <custom:pageable page="${telephoneList}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
</div>