//when DOM is loaded
$(document).ready(function() {
	//on hover changing call_to_action div background with h3 text color
	$("#call_to_action_link").hover(function() {
		$("#call_to_action").css('background', 'white');
		$("#call_to_action_text").css('color', '#1318c8');
	});

	//on mouseout reseting call_to_action div background with h3 text color
	$("#call_to_action_link").mouseout(function() {
		$("#call_to_action").css('background', '#1318c8');
		$("#call_to_action_text").css('color', 'white');
	});	
});

