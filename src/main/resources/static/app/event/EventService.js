(function() {
	'use strict';

	angular.module('app').factory('EventServiceQuery', EventServiceQuery);
	angular.module('app').factory('EventServiceDeleteParticipant', EventServiceDeleteParticipant);

	EventServiceQuery.$inject = [ '$resource' ];
	EventServiceDeleteParticipant.$inject = [ '$resource' ];

	function EventServiceQuery($resource) {
		var service = $resource('api/events/:id', {}, {
			'findAll' : {
				method : 'GET',
				isArray : true
			},
			'get': {
                method: 'GET'
            }
		});

		return service;
	}
	
	function EventServiceDeleteParticipant($resource) {
		var service = $resource('api/eventparticipant/:eventId/:id', {}, {});

		return service;		
	}
})();
