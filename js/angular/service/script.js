var module = angular.module('myServiceModule', []).
		controller('myController', ['$scope', 'notify', function($scope, notify){
			$scope.callNotify = function(msg){
				notify(msg);
			};
		}]).
		factory('notify',['$window', function(win){
			var msgs = [];
			return function(msg){
				msgs.push(msg);
				if (msgs.length == 3) {
					win.alert(msgs.join("\n"));
					msgs = [];
				}
			};
		}]).
		controller('uglyController', ['$scope', '$window', function($scope, win){
			var msgs = [];
			$scope.callNotify= function(msg) {
				msgs.push(msg);
				if(msgs.length==3) {
					win.alert(msgs.join(" | "));
					msgs = [];
				}
			};
		}]);
	


