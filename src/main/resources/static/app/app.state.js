(function() {
	'use strict';

	angular.module('app').config(stateConfig);

	stateConfig.$inject = [ '$stateProvider'];

	function stateConfig($stateProvider) {
		$stateProvider
		.state('index', {
			url : "/#",
			views : {
				'content@' : {
					templateUrl : 'app/home/home.html'
				},
				'header@' : {
					templateUrl : 'app/carousel/carousel.html'						
				}
			}
		})
		.state('home', {
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
		}).state('search', {
            url : "/search",
            views : {
                'content@' : {
                    templateUrl : 'app/search/search.html',
                    controller : 'SearchController',
                    controllerAs : 'vm'
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
				},
				'header@' : {
					templateUrl : 'app/carousel/carousel.html'						
				}
			}
		})
		.state('event-detail', {
			parent: 'event',
			url : "/{id}/edit",
			views : {
				'content@' : {
					templateUrl : 'app/event/event-detail.html',
					controller : 'EventDetailController',
					controllerAs : 'vm'
				},
				'header@' : {
					templateUrl : 'app/carousel/carousel.html'						
				}
			}
        })
        .state('event-new', {
			parent: 'event',
			url : "/new",
			views : {
				'content@' : {
					templateUrl : 'app/event/event-detail.html',
					controller : 'EventDetailController',
					controllerAs : 'vm'
				},
				'header@' : {
					templateUrl : 'app/carousel/carousel.html'						
				}
			}
        });
	}
})();
