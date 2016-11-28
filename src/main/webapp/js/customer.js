var url;

function searchCustomer(){
	$("dg").datagrid("load",{
		"khno":$("#s_khno").val(),
		"name":$("#s_name").val()
	})
}

function openCustomerAddDialog(){
	$("#dlg").dialog("open").dialog("setTitle", "添加客户信息");
}

function openCustomerModifyDialog(){
	var rows = $("#dg").datagrid("getSelections");
	if(rows.length==0){
		$.messager.alert("系统提示","请选择一条要编辑的数据");
		return;
	}
	if(rows.length>1){
		$.messager.alert("系统提示","最多选择一条数据");
	}
	$("#dlg").dialog("open").dialog("setTitle", "修改客户信息");
	$("#fm").form("load",row);
	$("#customerId").val(rows[0].id);
}

function deleteCustomer(){
	var rows = $("#dg").datagrid("getSelections");
}