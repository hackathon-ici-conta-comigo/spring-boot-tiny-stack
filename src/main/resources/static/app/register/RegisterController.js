(function() {
	'use strict';

	angular.module('app').controller('RegisterController', UserController);
	UserController.$inject = [];

	function UserController() {
		var vm = this;

		vm.loadAll = function() {
			UserService.findAll(function(data) {
				vm.users = data;
			});
		};

		vm.loadAll();
	}
})();
