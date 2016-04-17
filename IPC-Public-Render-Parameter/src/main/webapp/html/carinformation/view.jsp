<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.roufid.tutorials.bean.Car"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	Car car = (Car) renderRequest.getAttribute("car");

	if (car != null) {
%>
<table class="table table-striped">
	<tr>
		<td><img src="${car.imagePath}" width="200" height="200" /></td>
	</tr>

	<tr>
		<td>Id :</td>
		<td><c:out value="${car.id}" /></td>
	</tr>

	<tr>
		<td>Brand :</td>
		<td><c:out value="${car.brand}" /></td>
	</tr>


	<tr>
		<td>Color :</td>
		<td><c:out value="${car.color}" /></td>
	</tr>

	<tr>
		<td>Year :</td>
		<td><c:out value="${car.year}" /></td>
	</tr>

	<tr>
		<td>Price :</td>
		<td><c:out value="${car.price}" /></td>
	</tr>
</table>


<%
	} else {
%>
No car is selected !
<%
	}
%>
