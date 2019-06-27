var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider
  .when('user', {
    templateUrl : '/user.html',
    controller  : 'UserController'
  })
  .when('project', {
    templateUrl : '/project.html',
    controller  : 'ProjectController'
  })
  .when('task', {
    templateUrl : '/task.html',
    controller  : 'TaskController'
  })
  .otherwise({redirectTo: '/'});
});