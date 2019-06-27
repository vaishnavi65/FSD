var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) 
{
	$scope.index=false;
	$scope.project=true;
	$scope.addTask=true;
	$scope.addUser=true;
	$scope.viewTask=true;
	
	$scope.showProj = function() 
	{
		$scope.project=false;
		$scope.addTask=true;
		$scope.addUser=true;
		$scope.viewTask=true;
		$scope.color=tab1;
		$scope.myStyle={"color" : "red"};
    };
	$scope.showAddTask = function() 
	{
		$scope.project=true;
		$scope.addTask=false;
		$scope.addUser=true;
		$scope.viewTask=true;
	};
	$scope.showAddUser = function() 
	{
		$scope.project=true;
		$scope.addTask=true;
		$scope.addUser=false;
		$scope.viewTask=true;
    };
	$scope.showViewTask = function() 
	{
		$scope.project=true;
		$scope.addTask=true;
		$scope.addUser=true;
		$scope.viewTask=false;
    };

});