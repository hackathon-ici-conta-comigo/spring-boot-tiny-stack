(function() {
	'use strict';

	angular.module('app').controller('RegisterController', UserController);
	UserController.$inject = [];

	function UserController() {
		var vm = this;
		vm.submit = function(form) {
			if (form.$valid) {
				console.log(vm.form);
			}
		}

	}
})();
