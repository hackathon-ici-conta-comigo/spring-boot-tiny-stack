(function() {
    'use strict';

    angular.module('app').controller('SearchController', SearchController);

    SearchController.$inject = [ '$scope', 'SearchService', '$http', '$uibModal'];

    function SearchController($scope, SearchService, $http, $uibModal) {
        var vm = this;

        vm.map = { center: {
                      latitude:-30.42132699317399,
                      longitude:-51.96892992127687},
                   zoom:6};

        vm.markers = [];
        vm.profiles = [];

        vm.search = function() {
            vm.markers.splice(0, vm.markers.length);
            SearchService.search({name : vm.name, initialAgeGroup: vm.initialAgeGroup, endAgeGroup : vm.endAgeGroup, city: vm.city}, function(data) {
                vm.profiles = data;
                angular.forEach(data, function(value, index) {
                    (function(profile) {
                        $http.get("http://nominatim.openstreetmap.org/search?format=json&q=" + profile.address.city + " " + profile.address.country)
                        .then(function(result) {
                            if(result.data.length > 0) {
                                for(var ind = 0; ind < result.data.length; ind++) {
                                    if( ((result.data.length <= 2 && "administrative" == result.data[ind].type) || "city" == result.data[ind].type)
                                        && result.data[ind].display_name.toLowerCase().indexOf(profile.address.city.toLowerCase()) == 0) {
                                        vm.markers.push({ id: index,
                                                  latitude: result.data[ind].lat,
                                                  longitude: result.data[ind].lon,
                                                  title: profile.user.firstName,
                                                  city: profile.address.city});
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
        vm.select = function(googleMarker, eventName, modelMarker) {
            vm.profilesFiltered = vm.profiles.filter(function(profile) {
                return profile.address.city == modelMarker.city;
            });
            var modalInstance = $uibModal.open({
              templateUrl: 'myModalContent.html',
              controller: 'ModalInstanceCtrl',
              controllerAs: '$ctrl',
              controller: function($uibModalInstance, profilesFiltered, city) {
                   var $ctrl = this;
                   $ctrl.profilesFiltered = profilesFiltered;
                   $ctrl.city = city;
                   $ctrl.cancel = function () {
                       $uibModalInstance.dismiss('cancel');
                   };
              },
              resolve: {
                profilesFiltered: function () {
                    return vm.profilesFiltered;
                },
                city : function() {
                    return modelMarker.city;
                }
              }
            });
            modalInstance.result.then(function (selectedItem) {
              $ctrl.selected = selectedItem;
            }, function () {
            });
        };
    }
})();
