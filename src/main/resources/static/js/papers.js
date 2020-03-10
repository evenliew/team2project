/*alert("aaa");*/
$(document).ready(function() {
	showPapers();
});
function showPapers(){
	/*alert("aaa");*/
	$.ajax({
		url:"../PapersController/papers/showpapers",
		type:"POST",
		dataType:"json",
		success:function(data){
			alert(data);
			var content = "";
//			for (var i = 0; i < data.length; i++) {
//				var papers=data[i];
				content+="<div id='f2_a3_a1'>"+文件名+"</div>"
				+"<div id='f2_a3_a2'>"+张三+"</div>"
				+"<div id='f2_a3_a3'>"+时间+"</div>"
				+"<div id='f2_a3_a4'>"
				+"	<div id='f2_a3_a4_a1'>相关事项</div>"
				+"</div>"
				+"<div id='f2_a3_a5'>"
				+"	<div id='f2_a3_a5_a1'>删除</div>"
				+"	<div id='f2_a3_a5_a2'>下载</div>"
				+"</div>";
			$("#f2_a3").append(content);
			$("#f2_a3").html(content);
			$("#pay").html("支付$"+totalprice);
//		}
	}
	});
}