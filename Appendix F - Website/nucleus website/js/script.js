//when DOM is loaded
$(document).ready(function() {
	//on hover changing call_to_action div background with h3 text color
	$("#call_to_action_link").hover(function() {
		$("#call_to_action").css('background', 'white');
		$("#call_to_action_text").css('color', 'black');
	});

	//on mouseout reseting call_to_action div background with h3 text color
	$("#call_to_action_link").mouseout(function() {
		$("#call_to_action").css('background', 'black');
		$("#call_to_action_text").css('color', 'white');
	});	
});

