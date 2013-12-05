var spicyApp = angular.module("SpicyApp", []);


spicyApp.controller("SpicyCtrl", function($scope){
	$scope.spice="very";

	$scope.chiliSpicy = function(){
		$scope.spice="chili";
	};

	$scope.jalapenoSpicy = function(){
		$scope.spice="jalapeno";
	};

	$scope.customSpice = function(spice){
		$scope.spice=spice;
	};
});
