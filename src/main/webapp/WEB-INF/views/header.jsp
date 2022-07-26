<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Screen</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery-3.4.1.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>
<div class="jumbotron p-3 bg-danger text-white text-center mb-0 rounded-0 border-bottom">
	<h6 class="float-right m-2">Welcome ! ${sessionScope.uname }</h6>
	<h5>Welcome to Contract Management Portal</h5>
</div>
<div class="container-fluid">
<div class="row">
	<div class="col-sm-2 p-0">
		<div class="list-group">
		<c:if test="${sessionScope.role eq 'Admin' }">
		  <a href="/createreq" class="list-group-item list-group-item-action">Create Requirement</a>
		  <a href="/viewreq" class="list-group-item list-group-item-action">View Requirement</a>
		  <a href="/logout" class="list-group-item list-group-item-action">Logout</a>
		</div>
		</c:if>
		<c:if test="${sessionScope.role eq 'Supplier' }">
		  <a href="/viewreq" class="list-group-item list-group-item-action">View Requirement</a>
		  <a href="/logout" class="list-group-item list-group-item-action">Logout</a>
		</div>
		</c:if>
	</div>
	<div class="col-sm-10">