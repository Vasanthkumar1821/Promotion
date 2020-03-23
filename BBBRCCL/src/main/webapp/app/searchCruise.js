var app = angular.module('searchCruise', []);

app.controller('searchCruiseController', function($scope, $http, $window) {

	$scope.cruises = {
		_id : "",
		shipcode : "",
		shipname : "",
		sailingdate : "",
		state : "",
		destination : ""
	}
	$scope.searchCruise = function() {

		// console.log("Submition Started");
		// console.log($scope.cruises);
		$http(
				{
					method : 'GET',
					url : 'http://localhost:8062/api/cruises/'
							+ $scope.cruises.state + '/'
							+ $scope.cruises.destination + '/'
							+ $scope.cruises.sailingdate,
					data : angular.toJson($scope.cruises),
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(function(response) {
			console.log("success data");
			console.log(response.data);

			$scope.cru = response.data;
			$scope.cru.sailingdate = new Date($scope.cru.sailingdate);
			console.log($scope.cru);
			// console.log("state==" + $scope.cruises.state);
		});
		/*
		 * $http( { method : 'GET', url : 'http://localhost:8062/api/cruises/' +
		 * $scope.cruises.state + '/' + $scope.cruises.destination + '/' +
		 * $scope.cruises.sailingdate, data : angular.toJson($scope.cruises),
		 * headers : { 'Content-Type' : 'application/json' } }).then(function
		 * success(response) { console.log(response.data); // controller:
		 * 'viewCruises'; $scope.cru = response.data; //
		 * console.log($scope.cru); $scope.cruises = null; //
		 * $window.location.reload(); }, function error(response) {
		 * console.log("error found"); console.log(response.data); })
		 */
	}
});

app.controller('viewCruises', function($scope, $http) {
	$scope.cruises = {
		_id : "",
		shipcode : "",
		shipname : "",
		sailingdate : "",
		state : "",
		destination : ""
	}
	$http({
		method : 'GET',
		url : 'http://localhost:8064/api/cruises',
		data : angular.toJson($scope.cruises),
		headers : {
			'Content-Type' : 'application/json'
		}
	}).then(function(response) {
		// $scope.cruises.sailingdate = new Date($scope.cruises.sailingdate);
		$scope.cru = response.data;
	});
});