<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>Employee Sign Up</h1>

<form id="signUpForm">
<label>First Name</label> <br/>
<input type="text" name="firstName" /> <br>
<label>Last Name</label><br>
<input type="text" name="lastName" /> <br>
<label>Salary</label><br>
<input type="text" name="salary" /> <br>
<button type="submit">Sign Up</button>
</form>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(function () {
	$(document).on('submit',"#signUpForm",function (e) {
		e.preventDefault();
		var data = $('#signUpForm').serialize();
		
		$.ajax({
			url: "employee/save",
			type: "post",
			dataType: 'json',
			data: data,
			//contentType: 'application/json',
			success: function (data) {
				console.log("Success: "+data);
			},
			error: function (a, b, c) {
				console.log("Error Occured: "+a+" "+b+" "+c);
			}
		});
		
		console.log(data);
	})
})
</script>
</body>
</html>
