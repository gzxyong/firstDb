'use strict';

(function(angular) {
	var ItemFactory = function($resource) {
		return $resource('/users/:id', {
			id : '@id'
		}, {
			update : {
				method : "PUT"
			},
			remove : {
				method : "DELETE"
			}
		});
	};

	ItemFactory.$inject = [ '$resource' ];
	angular.module("myApp.services").factory("Item", ItemFactory);
}(angular));