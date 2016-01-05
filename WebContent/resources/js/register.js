$(document).ready(function(){
	
	$.validator.setDefaults({
		errorClass: 'help-block',
		highlight: function(element) {
			$(element)
				.closest('.form-group')
				.addClass('has-error');
		},
		unhighlight: function(element) {
			$(element)
				.closest('.form-group')
				.removeClass('has-error');
		}
	});
	
	
	$('#registerForm').validate({
				onfocusout: function(element) {
					this.element(element);
				},
				rules : {
					username: {
						required: true,
						minlength: 5
					},
					password: {
						required: true,
						minlength: 8
					},
					confirmPassword : {
						required: true,
						minlength: 8,
						equalTo: '#password_id'
					}
				},
				onkeyup : false,
				messages : {
					username : {
						required: 'Username required',
						minlength: 'Username must be at least 8 characters long'
					},
					password: {
						required: 'Password required',
						minlength: 'Password must be at least 8 charactes long'
					},
					confirmPassword : {
						required: 'Confirmation of the password is required',
						minlength: 'Confirmation must be at least 8 characters long',
						equalTo: 'Confirma password must amatch password'
					}
				}
		});
	
	$('#username').blur(function(event){
		var ID = event.target.id;
		
		var username = $('#username').val();
		
		if(username.length > 4) {
			
			$.ajax({
				url: 'checkIfUserExists',
				method: 'GET',
				data: {ID: ID,
					username: username}
			}).done(function(response){
				if(response == 'true'){
					$('#usernameAvailable').css('color', 'green').text('Username available');
				} else {
					$('#usernameAvailable').css('color', 'red').text('Username is not available');
				}
			});
			
		}
	});
});