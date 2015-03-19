
angular
.module('myApp')
.service('calendarCtrl',  ['$scope','$compile','$http','$modal','ngDialog',function($scope,$compile,$http,$modal,ngDialog) {
 

	 this.method = function() {
        return 'hoge service';
    };

 });