(function() {
	'use strict';

	angular.module('app').controller('EventController', EventController);
	EventController.$inject = ['EventServiceQuery'];

	function EventController(EventServiceQuery) {
		var vm = this;
		vm.events = [];

		vm.loadAll = function() {
			EventServiceQuery.findAll(function(data) {
				vm.events = data;
			});
		};

		vm.loadAll();
	}
})();
