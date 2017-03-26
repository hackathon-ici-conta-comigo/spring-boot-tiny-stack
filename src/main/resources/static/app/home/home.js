<!doctype html>
<html class="no-js" lang="en" ng-app="app">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <title>sprint-boot-tiny-stack</title>
	    <meta name="description" content="">
	    <meta name="viewport" content="width=device-width">
	</head>
	<body>
		<h2>Painel</h2>
		<div class="home-section">
		    <ul class="menu-list">
		        <li><a ui-sref="users">Users</a></li>
		    </ul>
		</div>
		<div ui-view="content"></div>
		<script src="/webjars/angularjs/angular.js"></script>
		<script src="/webjars/angular-ui-router/angular-ui-router.js"></script>
		<script src="/webjars/angular-resource/angular-resource.js"></script>
		<script src="/app/app.js"></script>
		<script src="/app/app.state.js"></script>
		<script src="/app/user/UserService.js"></script>
		<script src="/app/user/UserController.js"></script>
		<link rel="stylesheet" href="/webjars/bootstrap/3.3.6/css/bootstrap.css">
	</body>
</html>