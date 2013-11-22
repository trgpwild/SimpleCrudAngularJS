'use strict';

describe('ContactController', function() {

	// we'll use this in our tests
	var scope, controller, $httpBackend;

	// mock Application to allow us to inject our own dependencies
	beforeEach(angular.mock.module('app'));

	// mock the controller for the same reason and include $rootScope and
	// $controller
	beforeEach(angular.mock.inject(function($rootScope, $controller, _$httpBackend_) {

		$httpBackend = _$httpBackend_;
		$httpBackend.when('GET', 'rest/contacts').respond([ {
			"id" : 1,
			"name" : "Thiago Pinto",
			"phone" : "015-11111111"
		}, {
			"id" : 2,
			"name" : "Jose Ribeiro",
			"phone" : "015-11111111"
		}, {
			"id" : 3,
			"name" : "Camilo Lopes",
			"phone" : "015-11111111"
		} ]);

		// create an empty scope
		scope = $rootScope.$new();

		// declare the controller and inject our empty scope
		controller = $controller('ContactController', {
			$scope : scope
		});		
		

	}));

	// tests start here
	it('should have variable text = "Hello World!"', function() {
		expect(scope.text).toBe('Hello World!');
	});
	
	it('should fetch list of contacts', function(){
        $httpBackend.flush();
        expect(scope.contacts.length).toBe(3);
        expect(scope.contacts[0].name).toBe('Thiago Pinto');
    });
	
	it('should prepare the addition of contacts', inject(function(ContactService){
		scope.newOne();
		expect(scope.contact).toEqual(new ContactService());
    }));

});