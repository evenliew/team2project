
/**
 * 审批详情(加班管理)
 * @param path
 * @param id
 */
function detailOvertime(path,id) {
	overtimeHTML(path, 'upd');
	$.ajax({
		url: path + "/examine/examine/detail.action",
		type: "POST",
		data:{id :id},
		dataType: "JSON",
		success: function(data) {
			var examine = data.examine;
			var overtime = data.overtime;
			var stratTime = new Date(overtime.startTime)
			var endTime = new Date(overtime.endTime)
			$("#overtimeDivModel #examine").val(examine.id);
			$("#overtimeDivModel #startTime").val(stratTime.format('yyyy-MM-dd h:mm:ss'));
			$("#overtimeDivModel #endTime").val(endTime.format('yyyy-MM-dd h:mm:ss'));
			$("#overtimeDivModel #des").val(overtime.des);
		}, error: function(data) {
			
		}
	});
}


/**
 * 验证日期格式
 */
function validate(){
	
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var st = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01]) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
	if (startTime != '' && !st.test(startTime)){
		alert("请输入正确的开始日期格式");
		return false;
	}
	var et = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01]) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
	if (endTime != '' && !et.test(endTime)){
		alert("请输入正确的结束日期格式");
		return false;
	}
	var d1 = Date.parse(startTime);
	var d2 = Date.parse(endTime);
	var date = d2 - d1;
	var time = 60*60*1000;
	if(date<0||date<time){
		alert("开始时间应小于结束时间并且间隔小于一小时,请检查!");
		return false;
	}
	return true;
}

/**
 * 加班审批
 * @param path
 */
function examineStatus(path,status) {
	var id = $("#examine").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var des = $("#des").val();
	var st= document.getElementById("a");
	if(st=="同意"){var status = "1"}
	var st1= document.getElementById("b");
	if(st1=="拒绝"){var status = "2"}
	var res =  validate();
	if (!res) return; 
	$.ajax({
		url: path + "/examine/updateStatus.action",
		type: "POST",
		data:{id:id,status:status},
		dataType: "JSON",
		success: function(data) {
			location.href = path + "/examine/list.action";
		}, error: function(data) {
		}
	});
}
	
/**
 * 加班HTML
 * @param path
 */
function overtimeHTML(path, method) {
	// 检查当前页面是否弹层，如果有则删除
	if($('#overtimeDivModel') != null && $('#overtimeDivModel') != undefined)
		$('#overtimeDivModel').remove();
	
	var style_ = 'width: 500px; height: 300px; z-index: 1000; position: fixed; top: 50%;margin-top:-150px; left: 50%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
	var overtimeHtml = '<div id="overtimeDivModel" style="' + style_ + '">';
	overtimeHtml += '<div class="form-horizontal" role="form">';
	overtimeHtml += '<input type="hidden" id="overtimeId" value=""/>';
	overtimeHtml += '<input type="hidden" id="examine" value=""/>';
	overtimeHtml += '<input type="hidden" id="status" value=""/>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="startTime" class="col-sm-3 control-label">开始时间</label>';
	overtimeHtml += '<div class="col-sm-9">';
	overtimeHtml += '<input type="text" class="form-control" id="startTime" value="2017-06-16 18:00:00" readonly="readonly">';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="endTime" class="col-sm-3 control-label">结束时间</label>';
	overtimeHtml += '<div class="col-sm-9">';
	overtimeHtml += '<input type="text" class="form-control" id="endTime" value="2017-06-16 22:00:00" readonly="readonly">';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="des" class="col-sm-3 control-label">加班描述</label>';
	overtimeHtml += '<div class="col-sm-9">';
	overtimeHtml += '<input type="text" class="form-control" id="des" value="工作未完成" readonly="readonly">';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<div class="col-sm-12" style="text-align: center;">';
	overtimeHtml += '<input type="button" class="btn btn-primary btn" id="a" value="同意" onclick="examineStatus(\'' + path + '\', 1);" style="margin-left: 30px;"></input>';
	overtimeHtml += '<input type="button" class="btn btn-primary btn" id="b" value="拒绝" onclick="examineStatus(\'' + path + '\', 2);" style="margin-left: 30px;"/>';
	overtimeHtml += '<input type="button" class="btn btn-primary btn" value="关闭" onclick="javascript:$(\'#overtimeDivModel\').remove();" style="margin-left: 30px;"/>';
	overtimeHtml += '</div></div>';
	overtimeHtml += '</div></div>';
	$("body").append(overtimeHtml);
}
/**
 * 
 * 日期格式转换
 */
Date.prototype.format = function(format) {
    var date = {
           "M+": this.getMonth() + 1,
           "d+": this.getDate(),
           "h+": this.getHours(),
           "m+": this.getMinutes(),
           "s+": this.getSeconds(),
           "q+": Math.floor((this.getMonth() + 3) / 3),
           "S+": this.getMilliseconds()
    };
    if (/(y+)/i.test(format)) {
           format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    for (var k in date) {
           if (new RegExp("(" + k + ")").test(format)) {
                  format = format.replace(RegExp.$1, RegExp.$1.length == 1
                         ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
           }
    }
    return format;
}