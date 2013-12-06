
var module = angular.module('FilterInControllerModule',[]);

	module.controller('FilterController', [ 'filterFilter', function(filterFilter){
		this.array = [ {name: 'Tobias'}, {name: 'Jeff'}, {name: 'Brian'}, {name: 'Igor'}, {name: 'James'}, {name: 'Brad'} ];
	
		this.filteredArray = filterFilter(this.array, 'a'); 
	}]); 

	module.controller('sample', ['$scope','filterFilter', function($scope, filterFilter){

		this.array = [ {name: 'Tobias'}, {name: 'Jeff'}, {name: 'Brian'}, {name: 'Igor'}, {name: 'James'}, {name: 'Brad'} ];
		this.filteredArray = filterFilter(this.array, 'a');
}]);

