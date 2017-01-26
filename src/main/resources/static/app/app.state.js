(function() {
	'use strict';

	angular.module('app').config(routeConfig);

	routeConfig.$inject = [ '$stateProvider', '$urlRouterProvider' ];

	function routeConfig($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise("")
		
		$stateProvider.state('users', {
			url : "/users",
			views: {
                'main@': {
                    templateUrl: 'views/users.html',
                    controller: 'UsersController',
                    controllerAs: 'vm'
                }
            }
		})
	}
})();
