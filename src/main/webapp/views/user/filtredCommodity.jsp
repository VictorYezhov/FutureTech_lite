<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<c:forEach var="item" items="${items}">
    <div class="col-md-4 col-sm-6">
        <div class="product-col">
            <div class="image">
                <img src="${item.pathImage}" alt="product" class="img-responsive">
            </div>
            <div class="caption">
                <div class="price">
                    <span class="price-new">&#8372; ${item.price}</span>
                </div>
                <h4><a href="/details/${item.id}">${item.getBrand().getName()} ${item.name}</a></h4>
                <div class="cart-button button-group">
                    <button type="button" class="btn btn-cart" onclick="window.location.href='/addtoCart/${item.id}'">
                        <i class="fa fa-shopping-cart"></i>
                    </button>
                    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
                        <button type="button" class="btn btn-success" onclick="window.location.href='/updateCommodity/${item.id}'">
                            <i class="fa fa-refresh"></i>
                        </button>
                        <button type="button" class="btn btn-danger" onclick="window.location.href='/deleteCommodity/${item.id}'">
                            <i class="fa fa-trash"></i>
                        </button>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

