(function() {
	'use strict';

	angular.module('app').factory('UserService', UserService);

	UserService.$inject = [ '$resource' ];

	function UserService($resource) {
		var service = $resource('api/users', {}, {
			'findAll' : {
				method : 'GET',
				isArray : true
			}
		});

		return service;
	}
})();
