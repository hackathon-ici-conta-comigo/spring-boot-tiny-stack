(function() {
	'use strict';

	angular.module('app').factory('SearchService', SearchService);

	SearchService.$inject = [ '$resource' ];

	function SearchService($resource) {
		var service = $resource('api/search?name=:name&initialAgeGroup=:initialAgeGroup&endAgeGroup=:endAgeGroup&city=:city', 
		      {name : '@name', initialAgeGroup:'@initialAgeGroup', endAgeGroup:'@endAgeGroup', city : '@city'}, {
			'search' : {
				method : 'GET',
				isArray : true
			}
		});

		return service;
	}
})();
