(function() {
    'use strict';

    angular.module('app').controller('SearchController', SearchController);

    SearchController.$inject = [ '$scope', 'SearchService', '$http'];

    function SearchController($scope, SearchService, $http) {
        var vm = this;

        vm.map = { center: {
                      latitude:-30.42132699317399,
                      longitude:-51.96892992127687},
                   zoom:6};

        vm.markers = [];

        vm.search = function() {
            vm.markers.splice(0, vm.markers.length);
            SearchService.search({name : vm.name, initialAgeGroup: vm.initialAgeGroup, endAgeGroup : vm.endAgeGroup, city: vm.city}, function(data) {
                angular.forEach(data, function(value, index) {
                    (function(profile) {
                        $http.get("http://nominatim.openstreetmap.org/search?format=json&q=" + profile.address.city + " " + profile.address.country)
                        .then(function(result) {
                            if(result.data.length > 0) {
                                for(var ind = 0; ind < result.data.length; ind++) {
                                    if( ((result.data.length <= 2 && "administrative" == result.data[ind].type) || "city" == result.data[ind].type)
                                        && result.data[ind].display_name.indexOf(profile.address.city) == 0) {
                                        vm.markers.push({ id: index,
                                                  latitude: result.data[ind].lat,
                                                  longitude: result.data[ind].lon,
                                                  title: profile.user.firstName });
                                        vm.map = { center: {
                                              latitude: result.data[ind].lat,
                                              longitude: result.data[ind].lon
                                              },zoom:5
                                         };
                                         return;
                                     }
                                 }
                             }
                        });
                    })(value);
                    
                });
            });
        };
    }
})();
