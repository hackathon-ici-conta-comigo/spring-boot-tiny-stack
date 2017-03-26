(function() {
    'use strict';

    angular.module('app').controller('SearchController', SearchController);

    SearchController.$inject = [ '$scope', 'SearchService' ];

    function SearchController($scope, SearchService) {
        var vm = this;

        vm.map = { center: {
                      latitude:-30.42132699317399,
                      longitude:-51.96892992127687},
                   zoom:6};

        vm.markers = [];

        vm.search = function() {
            SearchService.search({name : vm.name, initialAgeGroup: vm.initialAgeGroup, endAgeGroup : vm.endAgeGroup, city: vm.city}, function(data) {
                angular.forEach(data, function() {
                    vm.markers.push({ id: data.user.id,
                                      latitude: data.address.location.latitude,
                                      longitude: data.address.location.longitude,
                                      title: data.user.firstName });
                    vm.map = { center: {
                                  latitude: data.address.location.latitude,
                                  longitude: data.address.location.longitude
                                  }
                             };
                });
            });
        };
    }
})();
