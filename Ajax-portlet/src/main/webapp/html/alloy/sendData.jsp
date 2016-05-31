<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<!-- Defining the resourceURL -->
<portlet:resourceURL var="sendData" />

<script type="text/javascript">

	/*
	 * Ajax call using AlloyUI.
	 * On button click the serveResource is called with the submited data.
	 */
	function sendDataToServer(){
		AUI().use('aui-io-request', function(A){
			A.io.request('<%=sendData%>', {
					method : 'post',
					
					// Sending tree parameters.
					data : {
						firstname : 'Radouane',
						lastname : 'Roufid',
						site : 'www.roufid.com'
					}
				});
			});
	}
</script>

<form>
	<input type="button" value="Send" onclick="sendDataToServer()">
</form>