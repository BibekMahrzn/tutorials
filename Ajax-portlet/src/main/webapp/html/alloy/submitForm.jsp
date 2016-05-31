<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<!-- Defining the resourceURL -->
<portlet:resourceURL var="submitForm" />

<script type="text/javascript">

	function submitFormToServer(){
	
		AUI().use('aui-io-request', function(A){
			A.io.request('<%=submitForm%>', {
					method : 'post',
					dataType: 'json',
					
					// Sending the form to the server.
					form : {
						id: 'calculator'
					},
					
					// Receiving data from the server. Data is contained in this.get('responseData').
					on: {
						success: function() {
							var response = this.get('responseData');
							document.getElementById('result').innerHTML = response.result;
						}
					}
				});
			});
	}
</script>

<form id="calculator">
	
	<div>Super calculator !</div>
	<br/>
	<table>
		<tr>
			<td><input type="text" name="firstInput"/></td>
			<td>+</td>
			<td><input type="text" name="secondInput"/></td>
			<td>=</td>
			<td><div id="result"></div></td>
		</tr>
	</table>

	<br />
	<input type="button" value="Submit" onclick="submitFormToServer()">
</form>