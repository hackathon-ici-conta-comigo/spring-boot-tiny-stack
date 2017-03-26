(function() {
	'use strict';

	angular.module('app').controller('EventDetailController', EventDetailController);
	EventDetailController.$inject = ['$stateParams', 'EventServiceQuery', '$http','EventServiceDeleteParticipant'];

	function EventDetailController($stateParams, EventServiceQuery, $http, EventServiceDeleteParticipant) {
		var vm = this;
		vm.event = null;
		vm.participants = [];

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
		
		vm.addParticipant = function(){
			$http.get('').then(function(response){
				vm.participants = respose.data;
			}, function(error){
				console.error(error);
			});
		}

		vm.load();
	}
})();
