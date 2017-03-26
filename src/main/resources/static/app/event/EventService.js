(function() {
	'use strict';

	angular.module('app').factory('EventServiceQuery', EventServiceQuery);
	angular.module('app').factory('EventService', EventService);

	EventServiceQuery.$inject = [ '$resource' ];
	EventService.$inject = [ '$resource' ];

	function EventServiceQuery($resource) {
		var service = $resource('api/events', {}, {
			'findAll' : {
				method : 'GET',
				isArray : true
			}
		});

		return service;
	}
	
	function EventService($resource) {
		var service = $resource('api/events/:id', {id: '@id'}, {
			'findOne' : {
				method : 'GET',
				params: {id: id}
			},
			'delete' : {
				method : 'DELETE',
				params: {id: id}
			}
		});

		return service;
	}
})();
