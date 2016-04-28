<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.roufid.tutorials.bean.Car"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<script>
	
	// Processing the event.
	Liferay.on('getSelectedCar', function(event) {
		
		// Getting the car.
		var car = event.car;
		
		// Building the result.
		if (car.hasOwnProperty('id')) {
			jQuery('#userInformation').empty();
			
			var htmlString = "<table class='table table-striped'>"
					+ "<tr><td><img src='"+car.imagePath+"' width='200' height='200' /></td></tr>"
					+ "<tr><td>Id</td><td>" + car.id + "</td></tr>"
					+ "<tr><td>Brand</td><td>" + car.brand + "</td></tr>"
					+ "<tr><td>Color</td><td>" + car.color + "</td></tr>"
					+ "<tr><td>Year</td><td>" + car.year + "</td></tr>"
					+ "<tr><td>Price</td><td>" + car.price + "</td></tr>"
					+ "</table>";
			jQuery('#carInformation').html(htmlString);
		}
	});
</script>

<div id="carInformation">No car is selected !</div>