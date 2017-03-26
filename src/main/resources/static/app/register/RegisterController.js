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

		vm.informations = [];
		vm.addNewInformation = function() {
			vm.informations.push('');
		};
		
		
		vm.removeInformation = function(z) {
			$scope.choiceSet.choices.splice(z, 1);
		};

	}
})();
