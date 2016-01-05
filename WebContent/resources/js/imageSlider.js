$(document).ready(function(){
	
	
	var width = 500;
	var animationSpeed = 5000;
	var pause = 10000;
	var currentSlide = 1;
	
	var $slider = $('#slider');
	var $slideContainer = $slider.find('.slides');
	var $slides = $slideContainer.find('.slide');
	
	var interval;
	
	function startSlider() {
		interval = setInterval(function() {
			$slideContainer.animate({'margin-left': '-=' + width}, animationSpeed, function(){
				currentSlide++;
				if(currentSlide == $slides.length) {
					currentSlide = 1;
					$slideContainer.css('margin-left', 0);
				}
			});
		}, pause);
	}
	
	function pauseSlider() {
		clearInterval(interval);
	}
	
	//listen for mouse enter pause
	// resume on mouse leave
	
	$slider.on('mouseenter', pauseSlider).on('mouseleave', startSlider);
	
	startSlider();
	
});