<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<portlet:defineObjects />

<!-- Defining the resourceURL -->
<portlet:resourceURL var="sendData" />

<script type="text/javascript">

	/*
	 * JQuery Ajax call.
	 * On button click the serveResource is called with the submited data.
	 */
	$(document).on('ready',function(){
		jQuery('[id=send]').click(function(event) {

			$.ajax({
				url:'<%=sendData%>',
				dataType: "json",
				data:{
					firstname : 'Radouane',
					lastname : 'Roufid',
					site : 'www.roufid.com'
				}
			});
		});
	});
	
</script>

<form>
	<input type="button" id="send" value="Send">
</form>
