
var app = angular.module('form-example', []);

var INTEGER_REGEXP = /^\-?d*$/;
app.directive('integer', function(){
	return {
		require: 'ngModel',
		link: function(scope, elm, attrs, ctrl){
			ctrl.$parsers.unshift(function(viewValue){
				if(INTEGER_REGEXP.test(viewValue)){
					// it is valid
					ctrl.$setValidity('integer', true);
					return viewValue;
				} else {
					// it is invalid, return undefined (no model update)
					ctrl.$setValidity('integer', false);
					return undefined;
				}
			});
		}
	};
});

var FLOAT_EXP = /^\-?\d+((\.|\,)\d+)?$/;
app.directive('smartFloat', function(){
	return {
		require: 'ngModel',
		link: function(scope, elm, attrs, ctrl) {
			ctrl.$parsers.unshift(function(viewValue){
				if (FLOAT_EXPR.test(viewValue)){
					//valid smart float
					ctrl.setValidity('smartFloat', true);
					return parseFloat(viewValue.replace(',', '.'));
				} else {
					ctrl.setValidity('smartFloat', false);
					return undefined;
				}
			});
		}
	};
});


				

