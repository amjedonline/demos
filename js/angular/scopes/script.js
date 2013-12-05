var myApp = angular.module('scopeInheritance', []);
myApp.controller('MainCtrl', ['$scope', function($scope){
	$scope.timeOfDay = 'Morning';
	$scope.name = 'Nikki';
}]);

myApp.controller('ChildCtrl', ['$scope', function($scope){
	$scope.name = 'Mattie';
}]);

myApp.controller('GrandChildCtrl', ['$scope', function($scope){
	$scope.timeOfDay = 'Evening';
	$scope.name = 'Gingerbreak Baby';
}]);
