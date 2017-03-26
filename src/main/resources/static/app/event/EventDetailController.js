(function() {
	'use strict';

	angular.module('app').controller('EventDetailController', EventDetailController);
	EventDetailController.$inject = ['$stateParams', 'EventServiceQuery', 'EventServiceDeleteParticipant'];

	function EventDetailController($stateParams, EventServiceQuery, EventServiceDeleteParticipant) {
		var vm = this;
		vm.event = null;

		vm.load = function() {
			EventServiceQuery.get({id: $stateParams.id}, function(data) {
				vm.event = data;
			});
		};
		
		vm.deleteParticipant = function(register) {
			EventServiceDeleteParticipant.delete({eventId: register.eventId, id: register.id}, function() {
				vm.load();
			})
		};

		vm.load();
	}
})();
