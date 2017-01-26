(function() {
	'use strict';

	angular.module('app').config(stateConfig);

	stateConfig.$inject = [ '$stateProvider' ];

	function stateConfig($stateProvider) {
		$stateProvider.state('users', {
			url : "/users",
			views : {
				'content@' : {
					templateUrl : 'app/user/users.html',
					controller : 'UserController',
					controllerAs : 'vm'
				}
			}
		});
	}
})();
