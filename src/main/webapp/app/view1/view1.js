'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'app/view1/view1.html',
    controller: 'View1Ctrl',
    controllerAs : 'ctrl'
  });
}])

.controller('View1Ctrl', ["InfoFactory","InfoService", "$http", "$scope", function(InfoFactory,InfoService,$http, $scope) {
  this.msgFromFactory = InfoFactory.getInfo();
  this.msgFromService = InfoService.getInfo();
  
  $http.get("api/footballclubs").then(function(response) {
      $scope.fbClubs = response.data;
  })
}]);