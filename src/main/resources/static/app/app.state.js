(function() {
	'use strict';

	angular.module('app').config(stateConfig);

	stateConfig.$inject = [ '$stateProvider'];

	function stateConfig($stateProvider, $urlRouterProvider) {
		$stateProvider.state('home', {
			url : "/home",
			views : {
				'content@' : {
					templateUrl : 'app/home/home.html'
				},
				'header@' : {
					templateUrl : 'app/carousel/carousel.html'						
				}
			}
		})
		.state('register', {
			url : "/register",
			views : {
				'content@' : {
					templateUrl : 'app/register/register.html',
					controller: 'RegisterController',
					controllerAs: 'vm'
				},
				'header@' : {
					templateUrl : 'app/carousel/carousel.html'
				}
			}
		})
		.state('users', {
			url : "/users",
			views : {
				'content@' : {
					templateUrl : 'app/user/users.html',
					controller : 'UserController',
					controllerAs : 'vm'
				}
			}
		})
		.state('admin', {
			url : "/admin",
			views : {
				'content@' : {
					templateUrl : 'app/admin/admin.html'
				}
			}
		})
		.state('event', {
			url : "/event",
			views : {
				'content@' : {
					templateUrl : 'app/event/event.html',
					controller : 'EventController',
					controllerAs : 'vm'
				}
			}
		});
	}
})();
