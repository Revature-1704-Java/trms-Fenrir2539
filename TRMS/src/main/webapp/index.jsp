<html>
	<head>
	<link rel="stylesheet" 
    	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
        crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/index.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <title>Tuition reimbursement system</title>
	</head>
	
	<body>
		<h2>Login Form</h2>

		<form action="/action_page.php">
  			<div class="imgcontainer">
    			<img src="img_avatar2.png" alt="Avatar" class="avatar">
  			</div>

  			<div class="container">
    			<label><b>Username</b></label>
    			<input type="text" placeholder="Enter Username" name="uname" required>

    			<label><b>Password</b></label>
    			<input type="password" placeholder="Enter Password" name="psw" required>
        
    			<button type="submit">Login</button>
    			<input type="checkbox" checked="checked"> Remember me
  			</div>

  			<div class="container" style="background-color:#f1f1f1">
    			<button type="button" class="cancelbtn">Cancel</button>
    			<span class="psw">Forgot <a href="#">password?</a></span>
  			</div>
		</form>
	</body>
</html>
