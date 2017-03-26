(function() {
	'use strict';

	angular.module('app').controller('EventController', EventController);
	EventController.$inject = [];

	function EventController() {
		var vm = this;
		vm.events = [];

		vm.loadAll = function() {
			EventService.findAll(function(data) {
				vm.events = data;
			});
		};

		vm.loadAll();
	}
})();
