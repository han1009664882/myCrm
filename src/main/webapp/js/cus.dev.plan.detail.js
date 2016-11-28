$(function() {
	var saleChanceId = $("#saleChanceId").val();

	$('#dg').edatagrid(
		{
			url : ctx + '/cus_dev_plan/list?saleChanceId=' + saleChanceId,
			saveUrl : ctx + '/cus_dev_plan/add_update?saleChanceId='
					+ saleChanceId,
			updateUrl : ctx + '/cus_dev_plan/add_update?saleChanceId='
					+ saleChanceId,
			destroyUrl : ctx + '/cus_dev_plan/delete'
		});

	//$("#dg").edatagrid("disableEditing");

})

function updateSaleChanceDevResult(devResult) {
	var saleChanceId = $("#saleChanceId").val();
	$.getJSON(ctx + "/sale_chance/update_devResult", {
		"saleChanceId" : saleChanceId,
		"devResult" : devResult
	}, function(data) {
		if (data.resultCode == 1) {
			$.messager.alert("系统提示", data.result);
		} else {
			$.messager.alert("系统提示", data.result);
		}
	})
}