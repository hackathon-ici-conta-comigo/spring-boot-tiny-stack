(function() {
	'use strict';

	angular.module('app', [ 'ui.router', 'ngResource', 'ui.bootstrap', 'uiGmapgoogle-maps' ])
	.config(['uiGmapGoogleMapApiProvider', function(GoogleMapApiProviders) {
        GoogleMapApiProviders.configure({
            china: true,
            key: 'AIzaSyDXbYuqw915GA8Roxx8riLFV8Da3hY5s8o',
            libraries: 'visualization'
        });
    }])
    .run(run);

	function run() {
	}

})();