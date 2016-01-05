$(document).ready(function() {
	$('.editMovie').click(function() {
		$(this).closest('tr').next().toggle();
	});

	$.validator.setDefaults({
		errorClass : 'help-block',
		highlight : function(element) {
			$(element).closest('.form-group')
			.addClass('has-error');
		},
		unhighlight : function(element) {
			$(element).closest('.form-group').removeClass(
			'has-error');
		}
	});

	$('.editMovie').each(function() {
		$(this).validate({
			rules : {
				name : 'required',
				year : {
					required : true,
					digits : true,
					range : [ 1896, 2015 ]
						},
					genre : 'required',
					director : 'required',
					runtime : {
					required : true,
					digits : true
								}
						},
				messages : {
					name : {
						required : 'Morate upisati naziv filma'
							},
					year : {
						required : 'Morate upisati godinu snimanja',
						digits : 'Moraju biti brojevi',
						range : 'Godina koju ste upisali je izvan dozvoljenih granica'
							},
						genre : {
						required : 'Morate upisati zanr'
							},
						director : {
							required : 'Morate upisati direktora'
							},
						runtime : {
							required : 'Morate upisati trajanje filma',
							digits : 'Moraju biti brojevi'
						}
					}
				});
		});
});