'use strict';

/* App Module */
/*
 * (function(angular) { angular.module("myApp.controllers", []);
 * angular.module("myApp.services", []); angular.module("myApp", [ "ngResource",
 * "myApp.controllers", "myApp.services" ]);
 * 
 * 
 * 
 * }(angular));
 */

var myApp = angular.module('myApp', [ 'ngRoute', 'userControllers' ]);

myApp.config([ '$routeProvider', 
               function($routeProvider) {
	$routeProvider.
	when('/users', {
		templateUrl : 'app/view/user/user-list.html',
		controller : 'UserListCtrl'}).
	when('/users/:id', {
		templateUrl : 'app/view/user/user-detail.html',
		controller : 'UserDetailCtrl'	}).
	otherwise({redirectTo: '/users');
} ]);