(function() {
	'use strict';

	angular.module('app').controller('RegisterController', UserController);
	UserController.$inject = [ '$http' ];

	function UserController($http) {
		var vm = this;

		vm.questions = [];
		vm.answers = [];
		vm.success = false;

		$http
				.get('api/questions')
				.then(function(response) {
							vm.emailExiste = false;
							vm.questions = response.data;
							console.log(vm.questions);
						},
						function(error) {
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

				vm.interests.forEach(function(m) {
					vm.form.informations.push({
						"info" : {
							name : m.info.name,
							type : 'INTEREST'
						}
					})
				});
				vm.experiences.forEach(function(m) {
					vm.form.informations.push({
						"info" : {
							name : m.info.name,
							type : 'EXPERIENCE'
						}
					})
				});
				vm.habilities.forEach(function(m) {
					vm.form.informations.push({
						"info" : {
							name : m.info.name,
							type : 'HABILITY'
						}
					})
				});
				vm.dificulties.forEach(function(m) {
					vm.form.informations.push({
						"info" : {
							name : m.info.name,
							type : 'DIFICULTY'
						}
					})
				});

				vm.form.answers = [];

				for ( var i in vm.answers) {
					vm.form.answers.push({
						"question" : {
							id : i
						},
						"answer" : vm.answers[i].question
					})
				}

				vm.form.user.roles = [];
				vm.form.user.roles.push({
					"name" : "ALUNO"
				});

				
				vm.form.birthday = new Date(vm.form.birthday);
				
				$http.post('api/profile', vm.form).then(function(response) {
					vm.success = true;
				}, function(error) {
					vm.emailExiste = false;
					if (error.data.exception === "org.springframework.dao.DataIntegrityViolationException") {
						vm.emailExiste = true;
					}
					console.error(error);
				});

				console.log(vm.form);
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
