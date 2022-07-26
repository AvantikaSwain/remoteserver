<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="jumbotron text-center p-3 mb-2 bg-danger text-white">
	<h4>Welcome to Contract Management</h4>
</div>
<div class="container-fluid">
	<div class="row">
			<div class="col-sm-4 mx-auto mt-2">
				<div class="card shadow">
					<div class="card-header text-center bg-danger text-white">
						<h5>Admin Login Screen</h5>
					</div>
					<div class="card-body">
						<form method="post">
						<div class="form-group">
						<label>User ID</label>
						<input type="text" name="userid" required class="form-control">
						</div>
						<div class="form-group">
						<label>Password</label>
						<input type="password" name="pwd" required class="form-control">
						</div>
						<input type="submit" value="Log In" class="btn btn-primary float-right px-4">
					</form>
					<c:if test="${error ne null }">
					<div class="alert text-danger font-weight-bold">${error }</div>
					</c:if>
					</div>
				</div>
			</div>
		</div>
</div>
</body>
</html>