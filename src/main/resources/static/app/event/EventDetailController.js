(function() {
	'use strict';

	angular.module('app').controller('EventDetailController', EventDetailController);
	EventDetailController.$inject = ['$stateParams', '$state', 'EventServiceQuery', '$http','EventServiceDeleteParticipant'];

	function EventDetailController($stateParams, $state, EventServiceQuery, $http, EventServiceDeleteParticipant) {
		var vm = this;
		vm.event = null;
		vm.participants = [];
		vm.promoters = [];

		vm.load = function() {
			if ($stateParams.id) {
				EventServiceQuery.get({id: $stateParams.id}, function(data) {
					vm.event = data;
				});
			}
			$http.get('api/participants').then(function(response){
				vm.promoters = response.data;
			}, function(error){
				console.error(error);
			});
		};
		
		vm.deleteParticipant = function(register) {
			EventServiceDeleteParticipant.delete({eventId: register.eventId, id: register.id}, function() {
				vm.load();
			})
		};
		
		vm.addParticipant = function(){
			$http.get('api/participants').then(function(response){
				vm.participants = response.data;
				vm.event.participants = [];
			}, function(error){
				console.error(error);
			});
		}
		
		vm.submit = function(form) {
			if (vm.event != null) {
				if (vm.participants.length > 0) {
					vm.event.participants = [];
					for (var i in vm.participants) {
						if (vm.participants[i].user.checked == true) {
							vm.event.participants.push({"participant": {"id": vm.participants[i].user.id}});
						}
					}
				}
				$http.post('api/events', vm.event).then(function(response){
					vm.participants = [];
					$state.go('event');
				}, function(error){
					console.error(error);
				});
			}
		}

		vm.load();
	}
})();
