
var sampleApp = angular.module("sampleApp",['ngRoute']);

sampleApp.config(['$routeProvider',
		function($routeProvider){
			$routeProvider.
				when('/AddNewOrder', {
					templateUrl: 'templates/add_new_order.html',
					controller: 'AddOrderController'
				}).
				when('/ShowOrders', {
					templateUrl: 'templates/show_orders.html',
					controller: 'ShowOrdersController'
				}).
				otherwise({
					templateUrl: 'templates/add_new_order.html',
					controller: 'AddOrderController'
				});
		}]);

sampleApp.controller('AddOrderController', function($scope){
		$scope.message = "This is Add new order screen";
});

sampleApp.controller('ShowOrdersController', function($scope){
		$scope.message = "This is Show Orders screen";
});
