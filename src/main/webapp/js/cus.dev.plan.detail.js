
$(function(){
	var saleChanceId = $("#saleChanceId").val();

	$('#dg').edatagrid({    
		url: '../cus_dev_plan/list?saleChanceId='+saleChanceId,    
		saveUrl: '../cus_dev_plan/add_update?saleChanceId=' + saleChanceId,    
		updateUrl:'../cus_dev_plan/add_update?saleChanceId=' + saleChanceId,
        destroyUrl:'../cus_dev_plan/delete'   
	}); 
	
})