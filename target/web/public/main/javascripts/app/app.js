angular
.module('myApp', ['ngAnimate','ui.calendar','ui.bootstrap','ngDialog'])
.run(function($rootScope, mainCtrl, calendarCtrl) {
    $rootScope.mainCtrl = mainCtrl.method();
    $rootScope.calendarCtrl = calendarCtrl.method();
});