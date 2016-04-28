<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="getSelectedCar" />

<script>
	/*
	 * On button click. A resourceURL is called to retreive the selected car and fire the event on success.
	 */
	$(document).on('ready',function(){
		jQuery('[id*=selectButton]').click(function(event) {
			
			var carId = this.id.split("|")[1];
			
			$.ajax({
				url:'<%=getSelectedCar%>',
				dataType: "json",
				data:{
					carId: carId
				},
				type: "get",
				success: function(data){
					
					//Firing the event.
					Liferay.fire('getSelectedCar', {car:data});
				}
			});
		});
	});
</script>


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
			<aui:form action="<%=getSelectedCar%>" method="post" name="carList">
				<tr>
					<td><img src="${car.imagePath}" width="50" height="50" /></td>
					<td><c:out value="${car.id}" /></td>
					<td><c:out value="${car.year}" /></td>
					<td><c:out value="${car.brand}" /></td>
					<td><c:out value="${car.color}" /></td>
					<td><aui:button type="button" name="selectButton|${car.id}" value="Select" id="${car.id}"/></td>
				</tr>
			</aui:form>
		</c:forEach>
	</tbody>
</table>