(function() {
	'use strict';

	angular.module('app').controller('RegisterController', UserController);
	UserController.$inject = [ '$http' ];

	function UserController($http) {
		var vm = this;

		vm.questions = [];
		vm.answers = [];
		vm.success = false;

		$http.get('api/questions').then(function(response) {
			vm.questions = response.data;
			console.log(vm.questions);
		}, function(error) {
			console.error(error);
		});

		vm.submit = function(form) {
			if (form.$valid) {
				console.log(vm.form);
				console.log(vm.interests);
				console.log(vm.experiences);
				console.log(vm.habilities);
				console.log(vm.dificulties);

				vm.form.informations = [];

				// vm.interests.map(function(m){return {info: m.info,
				// type:'INTEREST'} })
				vm.interests.forEach(function(m) {
					vm.form.informations.push({
						"info" : {
							name : m.info,
							type : 'INTEREST'
						}
					})
				});
				vm.experiences.forEach(function(m) {
					vm.form.informations.push({
						"info" : {
							name : m.info,
							type : 'EXPERIENCE'
						}
					})
				});
				vm.habilities.forEach(function(m) {
					vm.form.informations.push({
						"info" : {
							name : m.info,
							type : 'HABILITY'
						}
					})
				});
				vm.dificulties.forEach(function(m) {
					vm.form.informations.push({
						"info" : {
							name : m.info,
							type : 'DIFICULTY'
						}
					})
				});

				vm.success = true;


				vm.form.answers = [];
				vm.answers.forEach(function(value, key) {
					vm.form.answers.push({
						"question" : {
							id : key,
							question : value.question
						}
					});
				});
				
				vm.form.user.roles = [];
				vm.form.user.roles.push({"name": "ALUNO"});
				
			}
		}

		vm.interests = [];
		vm.addNewInterest = function() {
			vm.interests.push('');
		}
		vm.removeInterest = function(z) {
			vm.interests.splice(z, 1);
		};

		vm.habilities = [];
		vm.addNewHability = function() {
			vm.habilities.push('');
		}
		vm.removeHability = function(z) {
			vm.habilities.splice(z, 1);
		};

		vm.experiences = [];
		vm.addNewExperience = function() {
			vm.experiences.push('');
		}
		vm.removeExperience = function(z) {
			vm.experiences.splice(z, 1);
		};

		vm.dificulties = [];
		vm.addNewDificulty = function() {
			vm.dificulties.push('');
		}
		vm.removeDificulty = function(z) {
			vm.dificulties.splice(z, 1);
		};

	}
})();
