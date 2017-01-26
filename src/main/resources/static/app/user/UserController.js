//app.controller('UsersController', function($scope) {
//	$scope.headingTitle = "User List";
//});

(function() {
	'use strict';

	angular.module('app').controller('UsersController', UsersController);

	UsersController.$inject = [ '$scope' ];

	function UsersController($scope) {
		var vm = this;
	}
})();
