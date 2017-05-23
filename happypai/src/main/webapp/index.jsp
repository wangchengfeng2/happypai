<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" charset="UTF-8" href="css/jquery-ui.css">
<link rel="stylesheet" charset="UTF-8"
	href="css/jquery-ui.structure.css">
<link rel="stylesheet" charset="UTF-8" href="css/jquery-ui.theme.css">
<script type="text/javascript" src="${basePath}/js/Jquery/jquery.js"></script>
<script type="text/JavaScript"
	src="${basePath}/js/Jquery/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}/js/Jquery/jquery-ui.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	var basePath = "${basePath}";

	$(document)
			.ready(
					function() {

						$("#addBtn").button();
						$("#methodBtn").button();
						$("#addBtn")
								.click(
										function() {

											var name = $("#key").val();

											$("#jsondiv")
													.append(
															"<b class='key' >"
																	+ name
																	+ "&nbsp;:&nbsp;&nbsp;<input  name='"+name+"' /></b><input class='deleteBtn' type='button'  value='删除' /><br>");

											$(".deleteBtn")
													.bind(
															"click",
															function() {

																$(this)
																		.prev()
																		.remove();
																this.remove();

															})
										});
						$("#methodBtn").click(function() {

							var method = $("#method").val();

							/* 	$('#myform').attr("action", "${basePath}/"+method).submit(); */

						});

					});

	function ajax_submit() {

		var path = $("#method").val();
		

		$("#myform").ajaxSubmit({
			type : "post", //提交方式  
			dataType : "json", //数据类型  
			url : "/happypai/" + path, //请求url  
			success : function(data) {
				
				var jsonText = JSON.stringify(data);

				$("#result_div").text(jsonText);

			},
			error : function(request) {
				alert("网络连接失败");
			}

		})
	

		return false;
	}
</script>
</head>
<body>
	<div style="margin-left: 480px; width: 800px">
		<input id="key" type="text" style="width: 140px; height: 36px">&nbsp;&nbsp;&nbsp;&nbsp;<input
			id="addBtn" type="button" value="添加键值对" />

		<form id="myform" onsubmit="return ajax_submit()">
			<br> 
			<div id="jsondiv"></div>
			<br> 
			<input id="method" type="text" style="width: 140px; height: 36px">&nbsp;&nbsp;&nbsp;&nbsp;

			<button id="methodBtn" type="submit">添加方法并提交</button>

		</form>
		<br> <br> <br> <br>

	结果：<b id="result_div">  </b>
	</div>

</body>
</html>