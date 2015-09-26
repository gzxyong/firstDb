'use strict';

var userControllers = angular.module('userControllers', []);

userControllers.controller('UserListCtrl', ['$scope', '$http',
  function($scope, $http) {
    $http.get('phones/phones.json').success(function(data) {
      $scope.phones = data;
    });

    $scope.orderProp = 'age';
  }]);

userControllers.controller('UserDetailCtrl', ['$scope', '$routeParams', '$http',
  function($scope, $routeParams, $http) {
    $http.get('phones/' + $routeParams.phoneId + '.json').success(function(data) {
      $scope.phone = data;
    });
  }]);


/*(function(angular) {
	var AppController = function($scope, Item) {
		Item.query(function(response) {
			$scope.items = response ? response : [];
		});

		$scope.addItem = function(name, password, email, mobile, birthday, sex) {
			new Item({
				name : name,
				password : password,
				email : email,
				mobile : mobile,
				birthday : birthday,
				sex : false
			}).$save(function(item) {
				$scope.items.push(item);
			});
			$scope.newItem = "";
		};

		$scope.updateItem = function(item) {
			item.$update();
		};

		$scope.deleteItem = function(item) {
			item.$remove(function() {
				$scope.items.splice($scope.items.indexOf(item), 1);
			});
		};
	};

	AppController.$inject = [ '$scope', 'Item' ];
	angular.module("myApp.controllers").controller("AppController",
			AppController);
}(angular));*/