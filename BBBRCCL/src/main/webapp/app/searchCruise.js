var app = angular.module('searchCruise', []);

app
		.controller(
				'searchCruiseController',
				function($scope, $http, $window) {

					$scope.cruises = {
						_id : "",
						shipcode : "",
						shipname : "",
						sailingdate : "",
						state : "",
						destination : ""
					}

					$scope.searchCruise = function() {

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
								})
								.then(
										function(response) {
											console.log("success data");

											$scope.curPage = 1,
													$scope.itemsPerPage = 3,
													$scope.maxSize = 5;

											this.items = itemsDetails;

											$scope.numOfPages = function() {
												return Math
														.ceil(itemsDetails.length
																/ $scope.itemsPerPage);

											};

											$scope
													.$watch(
															'curPage + numPerPage',
															function() {
																var begin = (($scope.curPage - 1) * $scope.itemsPerPage), end = begin
																		+ $scope.itemsPerPage;

																$scope.cru = response.data
																		.slice(
																				begin,
																				end);
															});

											console.log(response.data);
											$scope.cruises = null;
											// $scope.cru = response.data;
											$scope.cru.sailingdate = new Date(
													$scope.cru.sailingdate);
											console.log($scope.cru);
										});
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