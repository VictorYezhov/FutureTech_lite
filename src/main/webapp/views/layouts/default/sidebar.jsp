<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="side-menu">
    <div class="head"><i class="icon fa fa-align-justify fa-fw"></i><spring:message code="label.categories"></spring:message></div>
    <nav class="megamenu-horizontal">
        <ul class="nav">
            <li>
                <a href="/telephoneList"><i class="icon fa fa-mobile" aria-hidden="true"></i><spring:message code="label.Mobile_Telepnone"/></a>
            </li>
            <li>
                <a href="/mp3List"><i class="icon fa fa-play-circle" aria-hidden="true"></i><spring:message code="label.MP3"/></a>
            </li>
            <li>
                <a href="/pcList"><i class="icon fa fa-desktop" aria-hidden="true"></i><spring:message code="label.PC"></spring:message></a>
            </li>
            <li>
                <a href="/tabletList"><i class="icon fa fa-tablet" aria-hidden="true"></i><spring:message code="label.Tablet"></spring:message></a>
            </li>
        </ul>
    </nav>
</div>
<form:form method="post" action="/filter">
<div class="sidebar-widget">
    <div class="widget-header">
        <h4 class="widget-title">Price Slider</h4>
    </div>
    <div class="sidebar-widget-body">
        <input class="form-control" name="price" id="price">
        <input class="form-control" name="price1" id="price1" type="hidden" value="0">
        <input class="form-control" name="price2" id="price2" type="hidden" value="0">
        <div id="slider-range"></div>
    </div>
    <%--<div class="widget-header">--%>
        <%--<h4 class="widget-title">Brand Filter</h4>--%>
    <%--</div>--%>
    <%--<div class="sidebar-widget-body">--%>
        <%--<select  name="brands[]" class="form-control" style="width: 200px" multiple>--%>
            <%--<option value="-1" selected="selected">Choose please</option>--%>
            <%--<c:forEach var="brand" items="${brands}">--%>
                <%--<option value="${brand.id}">${brand.name}</option>--%>
            <%--</c:forEach>--%>
        <%--</select>--%>
    <%--</div>--%>
    <%--<div class="widget-header">--%>
        <%--<h4 class="widget-title">Operation System Filter</h4>--%>
    <%--</div>--%>
    <%--<div class="sidebar-widget-body">--%>
        <%--<input class="form-control" name="os" id="os">--%>
    <%--</div>--%>
<button class="btn btn-primary">Filter</button>
</div>
</form:form>

<%-- Price Slider --%>
<script>
    $(function(){
        $( "#slider-range" ).slider({
            range: true,
            min: 0,
            max: 30000,
            values: [ 2000, 20000 ],
            slide: function( event, ui ) {
                $( "#price" ).val( "₴" + ui.values[ 0 ] + " - ₴" + ui.values[ 1 ] );
                $("#price1").val(ui.values[ 0 ]);
                $("#price2").val(ui.values[ 1 ]);

            }
        });
        $( "#price" ).val( "₴" + $( "#slider-range" ).slider( "values", 0 ) +
            " - ₴" + $( "#slider-range" ).slider( "values", 1 ) );
    });
</script>