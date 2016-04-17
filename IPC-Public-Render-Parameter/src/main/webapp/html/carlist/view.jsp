<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<!-- Defining the action URL -->
<portlet:actionURL var="selectCar" windowState="normal"	name="selectCarAction" />

<table class="table table-striped">
	<thead>
		<tr>
			<th></th>
			<th>Id</th>
			<th>Year</th>
			<th>Brand</th>
			<th>Color</th>
			<th>Action</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="car" items="${cars}">
		
			<!-- Defining a form for each car. -->
			<aui:form action="<%=selectCar%>" method="post" name="carList">
				<input name="carId" value="${car.id}" style="visibility: hidden;" />
				<tr>
					<td><img src="${car.imagePath}" width="50" height="50" /></td>
					<td><c:out value="${car.id}" /></td>
					<td><c:out value="${car.year}" /></td>
					<td><c:out value="${car.brand}" /></td>
					<td><c:out value="${car.color}" /></td>
					<td><input type="submit" name="selectButton" value="Select">
					</td>
				</tr>
			</aui:form>
			
		</c:forEach>
	</tbody>
</table>