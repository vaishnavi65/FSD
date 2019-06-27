var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider

  .when('/user', {
    templateUrl : 'ProjectManager/user.html',
    controller  : 'UserController'
  })

  .when('/project', {
    templateUrl : 'ProjectManager/project.html',
    controller  : 'ProjectController'
  })

  .when('/task', {
    templateUrl : 'ProjectManager/task.html',
    controller  : 'TaskController'
  })

  .otherwise({redirectTo: '/'});
});

app.controller('UserController', function($scope) {
	_refreshUserData();
	 $scope.in_value="    Add    ";
	$scope.resetUser = function() {
		_clearFormData();
    };
	$scope.doEdit = function(user) {
		$scope.first_name=user.first_name;
		$scope.last_name=user.last_name;
		$scope.employee_id=user.employee_id;
		$scope.in_value="  Update  ";
		
    };
    $scope.doDelete = function(user) {
   	 var fname=user.first_name;
   	 var lname=user.last_name;
   	 var id=user.employee_id;
   	 console.log(fname);
   	 var method = "DELETE";
           var url = 'http://localhost:8090/ProjectManager/user/delete';
       	   var data = {
       		  first_name: fname,
       		 last_name: lname,
       		employee_id:id,
       		project_id: 0,
       	    task_id: 0
          };
       	 $http({
               method : method,
               url : url,
               data :  JSON.stringify(data),
               headers : {
                   'Content-Type' : 'application/json'
               }
           }).then( _success, _error );
     };
				                $scope.submitUser = function() {
				                	var method = "POST";
				                    var url = 'http://localhost:8090/ProjectManager/user/add';
				                	   var data = {
				                		  first_name: $scope.first_name,
				                		 last_name: $scope.last_name,
				                		employee_id:$scope.employee_id,
				                		project_id: 0,
				                	    task_id: 0
				                   };
				                	 $http({
				                        method : method,
				                        url : url,
				                        data :  JSON.stringify(data),
				                        headers : {
				                            'Content-Type' : 'application/json'
				                        }
				                    }).then( _success, _error );
				                	_clearFormData()
				                };
				               $scope.doSortByFName= function() 
				               {
				            	  $http({
			                        method : 'GET',
			                        url : 'http://localhost:8090/ProjectManager/user/serachByFName'
			                    }).then(function successCallback(response) {
			                        $scope.users = response.data;
			                    }, function errorCallback(response) {
			                        console.log(response.statusText);
			                    });
				               };
				              $scope.doSortByLName = function() 
				              {
				            	 $http({
			                        method : 'GET',
			                        url : 'http://localhost:8090/ProjectManager/user/serachByLName'
			                    }).then(function successCallback(response) {
			                        $scope.users = response.data;
			                    }, function errorCallback(response) {
			                        console.log(response.statusText);
			                    });
				              };
				             $scope.doSortById= function() 
				             {
				            	 $http({
			                        method : 'GET',
			                        url : 'http://localhost:8090/ProjectManager/user/serachById'
			                    }).then(function successCallback(response) {
			                        $scope.users = response.data;
			                    }, function errorCallback(response) {
			                        console.log(response.statusText);
			                    });
				             };
				               function _refreshUserData() {
				                    $http({
				                        method : 'GET',
				                        url : 'http://localhost:8090/ProjectManager/user/searchManagers'
				                    }).then(function successCallback(response) {
				                        $scope.users = response.data;
				                    }, function errorCallback(response) {
				                        console.log(response.statusText);
				                    });
				                }
				               function _success(response) {
				                    _refreshUserData();
				                    _clearFormData()
				                }
				         
				                function _error(response) {
				                	 _refreshUserData();
				                    console.log(response.statusText);
				                }
				         
				                //Clear the form
				                function _clearFormData() {
				                    $scope.first_name="";
				                    $scope.last_name = "";
				                    $scope.employee_id = "";
				                   $scope.in_value="    Add    ";
				                };

});

app.controller('ProjectController', function($scope) {
  $scope.message = 'Hello from BlogController';
});

app.controller('TaskController', function($scope) {
  $scope.message = 'Hello from AboutController';
});