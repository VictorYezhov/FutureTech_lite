<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="col-xs-12 col-sm-6 col-md-6 product-info-image">
    <a href="/${item.pathImage}" data-lightbox="roadtrip"><img src="/${item.pathImage}" > </a>
</div>
<div class="col-sm-6 col-md-6 product-info-block" >
    <div class="product-info">
        <h1 class="name">${item.name}</h1>

        <%------------ PC ------------%>
        <c:if test="${commodityType eq 'Telephone'}">
            <ul class="list-unstyled manufacturer">
                <li><span>Brand:</span>${item.getBrand().getName()}</li>
                <li><span>OS</span>${item.OS}</li>
                <li><span>Memory:</span>${item.memory} GB</li>
                <li><span>RAM:</span>${item.RAM} GB</li>
                <li><span>Battery:</span>${item.batteryCapacity} Mlh</li>
            </ul>
            <div class="price-container info-container">
                <div class="row">
                    <div class="col-sm-8">
                        <div class="price-box">
                            <span class="price">${item.price} UAH</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="quantity-container info-container">
                <div class="row">
                    <%--<div class="col-sm-2">--%>
                        <%--<span class="label">Qty :</span>--%>
                    <%--</div>--%>
                    <%--<div class="col-sm-2">--%>
                        <%--<div class="cart-quantity">--%>
                            <%--<div class="quant-input">--%>
                                <%--<input type="number" name="quantity" min="1" max="5" value="1">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <div class="col-sm-7">
                        <a href="/addtoCart/${item.id}" class="btn btn-primary"><i class="fa fa-shopping-cart inner-right-vs"></i> ADD TO CART</a>
                    </div>
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
        </c:if>

        <%------------ PC ------------%>
        <c:if test="${commodityType eq 'PC'}">
            <ul class="list-unstyled manufacturer">
                <li><span>Brand:</span>${item.getBrand().getName()}</li>
                <li><span>OS</span>${item.OS}</li>
                <li><span>Memory:</span>${item.memory} GB</li>
                <li><span>RAM:</span>${item.RAM} GB</li>
                <li><span>Videoadapter:</span>${item.videoAdapterType}</li>
                <li><span>Processor:</span>${item.processor}</li>
                <li><span>Motherboard:</span>${item.motherboard}</li>
            </ul>
            <div class="price-container info-container">
                <div class="row">
                    <div class="col-sm-8">
                        <div class="price-box">
                            <span class="price">${item.price} UAH</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="quantity-container info-container">
                <div class="row">
                    <%--<div class="col-sm-2">--%>
                        <%--<span class="label">Qty :</span>--%>
                    <%--</div>--%>
                    <%--<div class="col-sm-2">--%>
                        <%--<div class="cart-quantity">--%>
                            <%--<div class="quant-input">--%>
                                <%--<input type="number" name="quantity" min="1" max="5" value="1">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <div class="col-sm-7">
                        <a href="/addtoCart/${item.id}" class="btn btn-primary"><i class="fa fa-shopping-cart inner-right-vs"></i> ADD TO CART</a>
                    </div>
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
        </c:if>

        <%------------ MP3 ------------%>
        <c:if test="${commodityType eq 'MP3'}">
            <ul class="list-unstyled manufacturer">
                <li><span>Brand:</span>${item.getBrand().getName()}</li>
                <li><span>Memory:</span>${item.memory} GB</li>
                <li><span>Battery:</span>${item.batteryCapacity} Mlh</li>
            </ul>
            <div class="price-container info-container">
                <div class="row">
                    <div class="col-sm-8">
                        <div class="price-box">
                            <span class="price">${item.price} UAH</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="quantity-container info-container">
                <div class="row">
                    <%--<div class="col-sm-2">--%>
                        <%--<span class="label">Qty :</span>--%>
                    <%--</div>--%>
                    <%--<div class="col-sm-2">--%>
                        <%--<div class="cart-quantity">--%>
                            <%--<div class="quant-input">--%>
                                <%--<input type="number" name="quantity" min="1" max="5" value="1">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <div class="col-sm-7">
                        <a href="/addtoCart/${item.id}" class="btn btn-primary"><i class="fa fa-shopping-cart inner-right-vs"></i> ADD TO CART</a>
                    </div>
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
        </c:if>

        <%------------ TABLET ------------%>
        <c:if test="${commodityType eq 'Tablet'}">
            <ul class="list-unstyled manufacturer">
                <li><span>Brand:</span>${item.getBrand().getName()}</li>
                <li><span>OS</span>${item.OS}</li>
                <li><span>Memory:</span>${item.memory} GB</li>
                <li><span>RAM:</span>${item.RAM} GB</li>
                <li><span>Battery:</span>${item.batteryCapacity} Mlh</li>
            </ul>
            <div class="price-container info-container">
                <div class="row">
                    <div class="col-sm-8">
                        <div class="price-box">
                            <span class="price">${item.price} UAH</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="quantity-container info-container">
                <div class="row">
                    <%--<div class="col-sm-2">--%>
                        <%--<span class="label">Qty :</span>--%>
                    <%--</div>--%>
                    <%--<div class="col-sm-2">--%>
                        <%--<div class="cart-quantity">--%>
                            <%--<div class="quant-input">--%>
                                <%--<input type="number" name="quantity" min="1" max="5" value="1">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <div class="col-sm-7">
                        <a href="/addtoCart/${item.id}" class="btn btn-primary"><i class="fa fa-shopping-cart inner-right-vs"></i> ADD TO CART</a>
                    </div>
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
        </c:if>
    </div>
</div>

<script>
    lightbox.option({
        'resizeDuration': 800,
        'wrapAround': 	false,
        'disableScrolling':	true
    })
</script>










<%--<div class="col-sm-6">--%>
            <%--<h2>${item.getBrand().getName()} ${item.name}</h2>--%>
            <%--<a href="/${item.pathImage}" data-lightbox="roadtrip"><img src="/${item.pathImage}" style="width: 300px; height: auto;" > </a>--%>

        <%--</div>--%>
        <%--<div class="col-sm-6" >--%>
            <%--<div class="product-information">--%>
                <%--<h3>Product Information</h3>--%>
                <%--<c:if test="${commodityType eq 'Telephone'}">--%>
                    <%--<p><b>Name: </b>${item.name}</p>--%>
                    <%--<p><b>Brand: </b>${item.getBrand().getName()}</p>--%>
                    <%--<p><b>Operational System: </b>${item.OS}</p>--%>
                    <%--<p><b>Memory: </b>${item.memory} GB</p>--%>
                    <%--<p><b>RAM: </b>${item.RAM} GB</p>--%>
                    <%--<p><b>Battery: </b>${item.batteryCapacity} Mlh</p>--%>
                    <%--<span>--%>
                        <%--<span>${item.price} UAH</span>--%>
                        <%--<label>Quantity:</label>--%>
                        <%--<input type="number" name="quantity" min="1" max="5" value="1">--%>
                    <%--</span>--%>
                    <%--<a href="/addtoCart/${item.id}">  <i class="fa fa-shopping-bag"></i> Add to cart</a>--%>
                <%--</c:if>--%>
                <%--<c:if test="${commodityType eq 'PC'}">--%>
                    <%--<p><b>Name: </b>${item.name}</p>--%>
                    <%--<p><b>Brand: </b>${item.getBrand().getName()}</p>--%>
                    <%--<p><b>Operational System: </b>${item.OS}</p>--%>
                    <%--<p><b>Memory: </b>${item.memory} GB</p>--%>
                    <%--<p><b>RAM: </b>${item.RAM} GB</p>--%>
                    <%--<p><b>Videoadapter: </b>${item.videoAdapterType}</p>--%>
                    <%--<p><b>Processor: </b>${item.processor}</p>--%>
                    <%--<p><b>Motherboard: </b>${item.motherboard}</p>--%>

                    <%--<span>--%>
                            <%--<span>${item.price} UAH</span>--%>
                            <%--<label>Quantity:</label>--%>
                            <%--<input type="number" name="quantity" min="1" max="5" value="1">--%>
                        <%--</span>--%>
                    <%--<a href="/addtoCart/${item.id}">  <i class="fa fa-shopping-bag"></i> Add to cart</a>--%>
                <%--</c:if>--%>
                <%--<c:if test="${commodityType eq 'MP3'}">--%>
                    <%--<p><b>Name: </b>${item.name}</p>--%>
                    <%--<p><b>Brand: </b>${item.getBrand().getName()}</p>--%>
                    <%--<p><b>Memory: </b>${item.memory} GB</p>--%>
                    <%--<p><b>Battery: </b>${item.batteryCapacity} Mlh</p>--%>

                    <%--<span>--%>
                            <%--<span>${item.price} UAH</span>--%>
                            <%--<label>Quantity:</label>--%>
                            <%--<input type="number" name="quantity" min="1" max="5" value="1">--%>
                        <%--</span>--%>
                    <%--<a href="/addtoCart/${item.id}">  <i class="fa fa-shopping-bag"></i> Add to cart</a>--%>
                <%--</c:if>--%>
                <%--<c:if test="${commodityType eq 'Tablet'}">--%>
                    <%--<p><b>Name: </b>${item.name}</p>--%>
                    <%--<p><b>Brand: </b>${item.getBrand().getName()}</p>--%>
                    <%--<p><b>Operational System: </b>${item.OS}</p>--%>
                    <%--<p><b>Memory: </b>${item.memory} GB</p>--%>
                    <%--<p><b>RAM: </b>${item.RAM} GB</p>--%>
                    <%--<p><b>Battery: </b>${item.batteryCapacity} Mlh</p>--%>

                    <%--<span>--%>
                            <%--<span>${item.price} UAH</span>--%>
                            <%--<label>Quantity:</label>--%>
                            <%--<input type="number" name="quantity" min="1" max="5" value="1">--%>
                        <%--</span>--%>

                      <%--<a href="/addtoCart/${item.id}">  <i class="fa fa-shopping-bag"></i> Add to cart</a>--%>


                <%--</c:if>--%>
            <%--</div>--%>
        <%--</div>--%>

<%--<script>--%>
    <%--lightbox.option({--%>
        <%--'resizeDuration': 800,--%>
        <%--'wrapAround': 	false,--%>
        <%--'disableScrolling':	true--%>
    <%--})--%>
<%--</script>--%>
