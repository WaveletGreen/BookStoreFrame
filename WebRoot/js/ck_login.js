/**
 * 登录验证输入框是否为空
 */
$(function() {
	$("#loginForm").submit(function() {
		canSub = true;
		if ($("#loginNameId").val() == "") {
			$("#spUserName").removeClass("removeLoginRemind");
			$("#spUserName").addClass("loginRemind");
			canSub = false;
		}
		if ($("#loginPassword").val() == "") {
			$("#spPassword").removeClass("removeLoginRemind");
			$("#spPassword").addClass("loginRemind");
			canSub = false;
		}
		return canSub;
	});

	$("#loginNameId").focus(function() {
		$("#spUserName").removeClass("loginRemind");
		$("#spUserName").addClass("removeLoginRemind");
		$("#errorMsg").addClass("hideError");
	});
	$("#loginPassword").focus(function() {
		$("#spPassword").removeClass("loginRemind");
		$("#spPassword").addClass("removeLoginRemind");
		$("#errorMsg").addClass("hideError");
	});
});