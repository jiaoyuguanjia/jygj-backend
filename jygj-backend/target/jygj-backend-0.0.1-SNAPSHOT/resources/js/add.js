function back() {
	document.location.href="/jinli/index.html";
}

function appendYear() {
	var optionHtmls = "<option>请选择年份</option>";
	var year = "${resume.year}";
	for(var i = 1977; i < 1996; i++) {
		if (i == year) {
			optionHtmls += '<option selected="selected" value="'+ i +'">'+ i +'</option>';
		} else {
			optionHtmls += '<option value="'+ i +'">'+ i +'</option>';
		}
	}
	$("select[name='year']").html(optionHtmls);
}

function appendMonth() {
	var optionHtmls = "<option>请选择月份</option>";
	var month = "${resume.month}";
	for(var i = 1; i < 13; i++) {
		if (i == month) {
			optionHtmls += '<option selected="selected" value="'+ i +'">'+ i +'</option>';
		} else {
			optionHtmls += '<option value="'+ i +'">'+ i +'</option>';
		}
	}
	$("select[name='month']").html(optionHtmls);
}

function appendProvince(datas) {
	var optionHtmls = "<option>请选择省</option>";
	var provinceCode = "${resume.provinceCode}";
	for(var key in datas) {
		if (provinceCode == datas[key].code) {
			optionHtmls += '<option selected="selected" value="'+ datas[key].code +'">'+ datas[key].name +'</option>';
		} else {
			optionHtmls += '<option value="'+ datas[key].code +'">'+ datas[key].name +'</option>';
		}
    }
	$("select[name='provinceCode']").html(optionHtmls);
}

function appendCity(datas) {
	var optionHtmls = "<option>请选择市</option>";
	var cityCode = "${resume.cityCode}";
	for(var key in datas) {
		if (cityCode == datas[key].code) {
			optionHtmls += '<option selected="selected" value="'+ datas[key].code +'">'+ datas[key].name +'</option>';
		} else {
			optionHtmls += '<option value="'+ datas[key].code +'">'+ datas[key].name +'</option>';
		}
    }
	$("select[name='cityCode']").html(optionHtmls);
}

function appendArea(datas) {
	var optionHtmls = "<option>请选择区</option>";
	var areaCode = "${resume.areaCode}";
	for(var key in datas) {
		if (areaCode == datas[key].code) {
			optionHtmls += '<option selected="selected" value="'+ datas[key].code +'">'+ datas[key].name +'</option>';
		} else {
			optionHtmls += '<option value="'+ datas[key].code +'">'+ datas[key].name +'</option>';
		}
    }
	$("select[name='areaCode']").html(optionHtmls);
}


function ajaxProvince() {
	$.ajax({
	   type: "POST",
	   url: "/jinli/ajaxGetProvinceList.json",
	   success: function(datas){
	     appendProvince(eval(datas));
	   }
	});
}

function ajaxCity(code) {
	var param = {
		provinceCode: code
	};
	$.ajax({
	   type: "POST",
	   dataType: "JSON",
	   url: "/jinli/ajaxGetCityList.json",
	   data: param,
	   cache: false,
	   async: false,
	   success: function(datas){
		   appendCity(eval(datas));//eval()--将java中Json对象转换成js中的Json对象
	   }
	});
}

function ajaxArea(code) {
	var param = {
		cityCode: code
	};
	$.ajax({
	   type: "POST",
	   url: "/jinli/ajaxGetAreaList.json",
	   data: param,
	   success: function(datas){
	     appendArea(eval(datas));
	   }
	});
}

function fillPlace() {
	ajaxProvince();
	var provinceCode = "${resume.provinceCode}";
	var cityCode = "${resume.cityCode}";
	if (provinceCode && cityCode) {
		ajaxCity(provinceCode);
		ajaxArea(cityCode);
	}
}

$(function() {
	appendYear();
	appendMonth();
	fillPlace();
	
	
	$("select[name='provinceCode']").change(function() {
		var code = $(this).find("option:selected").val();
		ajaxCity(code);
	});
	
	$("select[name='cityCode']").change(function() {
		var code = $(this).find("option:selected").val();
		ajaxArea(code);
	});
});