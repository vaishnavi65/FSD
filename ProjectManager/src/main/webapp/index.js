var app = angular.module('mainApp',['ngRoute', 'ngAnimate']);
 
app.config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when('/project',{
            templateUrl: 'project.html'
        })
        .when('/task',{
            templateUrl: 'task.html',
            controller:'TaskController'
        })
        .when('/user',{
            templateUrl: 'user.html',
            controller:'UserController'
        })
        .when('vTask',{
            templateUrl: 'vTask.html',
            controller:'vTaskController'
            	
        })
        .otherwise({
            redirectTo: '/project'
        });
 
    $locationProvider.hashPrefix('');
 
});
//Controller Part
app.controller("UserController", function($scope, $http) {
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
app.controller("ProjectController", function($scope, $http) {
	//Added to load the project details dynamically
	$scope.in_value="    Add    ";
	_refreshUserData();
	  	$scope.searchManager = function() {
		$http({
                method : 'GET',
                url : 'http://localhost:8090/ProjectManager/user/searchManagers'
            }).then(function successCallback(response) {
                $scope.users = response.data;
            }, function errorCallback(response) {
                console.log(response.statusText);
            });
        };
        $scope.doSuspend = function(project) {
        	 var pName=project.project;
        	 var pStartDate=project.start_date;
        	 var pEndDate=project.end_date;
        	 var pPriority=project.priority;
        	 var method = "PUT";
                var url = 'http://localhost:8090/ProjectManager/project/suspend';
            	   var data = {
            			   project:pName,
            		       start_date:pStartDate,
            		       end_date:pEndDate,
            		       priority:pPriority,
            		       status: 'Suspended'
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
          
          $scope.doUpdate = function(project) {
        	  $scope.project_name=project.project;
 		       $scope.startDate=new Date(project.start_date);
 		       $scope.endDate=new Date(project.end_date);
 		      $scope.priority_value=project.priority;
 		       $scope.manager=project.manager_first_name+' '+project.manager_last_name;
            	$scope.in_value="  Update  ";
              };
  	$scope.doSortBySDate= function() 
       {
    	  $http({
            method : 'GET',
            url : 'http://localhost:8090/ProjectManager/project/sortBySDate'
        }).then(function successCallback(response) {
            $scope.projects = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
       };
       
       $scope.checkboxEnabled=function()
       {
    	   $scope.startDate=new Date();
    	   var today = new Date();
    	   var newdate = new Date();
    	    newdate.setDate(today.getDate()+1);
    	   $scope.endDate=newdate;
       };
      
       $scope.doSortByEDate = function() 
          {
        	 $http({
                method : 'GET',
                url : 'http://localhost:8090/ProjectManager/project/sortByEDate'
            }).then(function successCallback(response) {
                $scope.projects = response.data;
            }, function errorCallback(response) {
                console.log(response.statusText);
            });
          };
         $scope.doSortByPriority = function() 
          {
        	 $http({
                method : 'GET',
                url : 'http://localhost:8090/ProjectManager/project/sortByPriority'
            }).then(function successCallback(response) {
                $scope.projects = response.data;
            }, function errorCallback(response) {
                console.log(response.statusText);
            });
          };
         $scope.doSortByCompletion= function() 
         {
        	 $http({
                method : 'GET',
                url : 'http://localhost:8090/ProjectManager/project/sortByCompletion'
            }).then(function successCallback(response) {
                $scope.projects = response.data;
            }, function errorCallback(response) {
                console.log(response.statusText);
            });
         };
	function _clearFormData() {
		 $scope.project_name="";
	       $scope.startDate="";
	       $scope.endDate="";
	      $scope.priority_value=0;
	    $scope.manager="";
      $scope.in_value="    Add    ";
        };
     function _refreshUserData() {
                $http({
                    method : 'GET',
                    url : 'http://localhost:8090/ProjectManager/project/details'
                }).then(function successCallback(response) {
                    $scope.projects = response.data;
                }, function errorCallback(response) {
                    console.log(response.statusText);
                });
            };
        function _success(response) {
                    _refreshUserData();
                    _clearFormData()
                };
         
         function _error(response) {
                	 _refreshUserData();
                    console.log(response.statusText);
                };
                $scope.submitUser = function() {
                	if($scope.startDate>$scope.endDate)
                		{
                		alert("select an end date greater than start date")
                		}
                	else
                		{
                		var method = "POST";
	                    var url = 'http://localhost:8090/ProjectManager/project/add';
	                    var name=$scope.manager;
	                    var res=name.split(' ');
	                    var fname=res[0];
	                    var lname=res[1];
	                    var data = {
	                			   project:$scope.project_name,
	                		       start_date: $scope.startDate,
	                		       end_date:$scope.endDate,
	                		       priority: $scope.priority_value,
	                		       status: 'In Progress',
	                		       manager_first_name: fname,
	                		       manager_last_name: lname
	                		      };
	                	 $http({
	                        method : method,
	                        url : url,
	                        data :  JSON.stringify(data),
	                        headers : {
	                            'Content-Type' : 'application/json'
	                        }
	                    }).then( _success, _error );
	                	_clearFormData();
                		}
	                	
	                };

				                });

app.controller("TaskController", function($scope, $http) {
	//Added to load the project details dynamically
	$scope.in_value="    Add    ";
	 	$scope.searchManager = function() {
		$http({
                method : 'GET',
                url : 'http://localhost:8090/ProjectManager/user/searchManagers'
            }).then(function successCallback(response) {
                $scope.users = response.data;
            }, function errorCallback(response) {
                console.log(response.statusText);
            });
        };
        $scope.searchprojectNameL= function() {
    		$http({
                    method : 'GET',
                    url : 'http://localhost:8090/ProjectManager/project/details'
                }).then(function successCallback(response) {
                    $scope.projectNameList = response.data;
                }, function errorCallback(response) {
                    console.log(response.statusText);
                });
            };
            $scope.searchpt= function() {
        		$http({
                        method : 'GET',
                        url : 'http://localhost:8090/ProjectManager/parentTask/details'
                    }).then(function successCallback(response) {
                        $scope.ptList = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                };
      	                            
     	function _clearFormData() {
		 $scope.projectNameL="";
		 $scope.task_name="";
	       $scope.startDate="";
	       $scope.endDate="";
	      $scope.ptName="";
	    $scope.manager="";
      $scope.in_value="    Add    ";
      $scope.checkboxModel.flag=false;
        };
        $scope.checkboxEnabled=function()
           {
        	$scope.checkboxModel.flag=true;
        	   var enabled=true;
           };

     function _error(response) {
                	  console.log(response.statusText);
                };
                $scope.submitUser = function() {
                	if($scope.checkboxModel.flag)
                		{
                		var method = "POST";
	                    var url = 'http://localhost:8090/ProjectManager/parentTask/add';
	                    var data = {
	                    		parentTaskName: $scope.task_name
	                		      };
	                	 $http({
	                        method : method,
	                        url : url,
	                        data :  JSON.stringify(data),
	                        headers : {
	                            'Content-Type' : 'application/json'
	                        }
	                    }).then( _success, _error );
	                	_clearFormData();
                		}
                	else{
                		if($scope.startDate>$scope.endDate)
                		{
                		alert("select an end date greater than start date")
                		}
                	else
                		{
                		var method = "POST";
	                    var url = 'http://localhost:8090/ProjectManager/task/add';
	                    var data = {
	                    		task:$scope.task_name ,
	                	        start_date:$scope.startDate,
	                	        end_date:$scope.endDate,
	                	        priority:$scope.priority_value,
	                	        projName:$scope.projectNameL,
	                	        userName:$scope.manager,
	                	        parentTaskName:$scope.ptName,
	                	        taskStatus:"In Progress",
	                	         };
	                	 $http({
	                        method : method,
	                        url : url,
	                        data :  JSON.stringify(data),
	                        headers : {
	                            'Content-Type' : 'application/json'
	                        }
	                    }).then( _success, _error );
	                	_clearFormData();
	                	$scope.checkboxModel.flag=false;
                		}
                	}
                	
	                	
	                };
	                function _success(response) {
	                    _clearFormData()
	                    $scope.checkboxModel.flag=false;
	                };

				                });