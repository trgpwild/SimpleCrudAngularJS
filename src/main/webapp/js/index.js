'use strict';

angular.module('app', [ 'ngResource' ])

.factory('ContactService', [ '$resource', function($resource) {
	return $resource('rest/contacts/:id', {
		id : '@id'
	});
}]);

var ContactController = function($scope, ContactService) {

	$scope.text = 'Hello World!';
	
	$scope.contacts = ContactService.query();

	$scope.contact = new ContactService();

	$scope.edit = function(contact) {
		$scope.contact = contact;
	};

	$scope.newOne = function() {
		$scope.contact = new ContactService();
	};

	$scope.add = function() {
		$scope.contact.$save(function() {
			$scope.contacts = ContactService.query();
		});
	};

	$scope.remove = function(contact) {
		$scope.contact.$delete({
			id : contact.id
		}, function(res) {
			$scope.contacts = ContactService.query();
			$scope.contact = new ContactService();
		});
	};

};