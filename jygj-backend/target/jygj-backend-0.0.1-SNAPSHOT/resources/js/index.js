$(".addJinliBtn").click(function() {
	addJinli();
});

$(".deleteResume").click(function() {
	var resumeId = $(this).attr("data-resumeId");
	deleteResume(resumeId);
});

$(".editJinli").click(function() {
	var resumeId = $(this).attr("data-resumeId");
	document.location.href = "/jinli/customer/addJinli.html?id=" + resumeId;
});

function addJinli() {
	document.location.href="/jinli/customer/addJinli.html";
}

function deleteResume(id) {
	if (confirm("您确认删除吗？")) {
		document.location.href="/jinli/customer/deleteResume.html?id=" + id;		
	} 
}

