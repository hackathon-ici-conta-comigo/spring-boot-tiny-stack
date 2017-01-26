(function() {
	'use strict';

	angular.module('app').controller('UserController', UserController);

	UserController.$inject = [ '$scope', 'UserService' ];

	function UserController($scope, UserService) {
		var vm = this;

		vm.loadAll = function() {
			UserService.findAll(function(data) {
				vm.users = data;
			});
		};
		
		vm.loadAll();
	}
})();
