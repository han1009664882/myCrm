<!doctype html>
<html>
<head>
    <#include "include/common.header.ftl" >
    <script type="text/javascript" src="${ctx}/js/cus.dev.plan.detail.js" ></script>
</head>
<body style="margin: 15px">

<div id="p" class="easyui-panel" title="销售机会信息" style="width: 700px;height: 350px;padding: 10px">
    <table cellspacing="8px">
        <input type="hidden" id="saleChanceId" name="saleChanceId" value="${saleChance.id?c}"/>
        <tr>
            <td>客户名称：</td>
            <td><input type="text" id="customerName" name="customerName" readonly="readonly" value="${saleChance.customerName?if_exists}" /></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>机会来源</td>
            <td><input type="text" id="chanceSource" name="chanceSource" readonly="readonly" value="${saleChance.chanceSource?if_exists}"/></td>
        </tr>
        <tr>
            <td>联系人：</td>
            <td><input type="text" id="linkMan" name="linkMan" readonly="readonly" value="${saleChance.linkMan?if_exists}"/></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>联系电话：</td>
            <td><input type="text" id="linkPhone" name="linkPhone" readonly="readonly" value="${saleChance.linkPhone?if_exists}"/></td>
        </tr>
        <tr>
            <td>成功几率(%)：</td>
            <td><input type="text" id="cgjl" name="cgjl" readonly="readonly" value="${saleChance.cgjl?if_exists}"/></td>
            <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;</td>
        </tr>
        <tr>
            <td>概要：</td>
            <td colspan="4"><input type="text" id="overview" name="overview" style="width: 420px" readonly="readonly" value="${saleChance.overview?if_exists}"/></td>
        </tr>
        <tr>
            <td>机会描述：</td>
            <td colspan="4">
                <textarea rows="5" cols="50" id="description" name="description" readonly="readonly" >${saleChance.description?if_exists}</textarea>
            </td>
        </tr>
        <tr>
            <td>创建人：</td>
            <td><input type="text" readonly="readonly" id="createMan" name="createMan" value="${saleChance.createMan?if_exists}" /></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>创建时间：</td>
            <td><input type="text" id="createTime" name="createDate" readonly="readonly" value="${saleChance.createDate?string('yyyy-MM-dd hh:mm:ss')}" /></td>
        </tr>
        <tr>
            <td>指派给：</td>
            <td>
                <input type="text" readonly="readonly" id="assignMan" name="assignMan" value="${saleChance.assignMan?if_exists}"  />
            </td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>指派时间：</td>
            <td><input type="text" id="assignTime" name="assignTime" readonly="readonly" value="${saleChance.assignTime?string('yyyy-MM-dd hh:mm:ss')}" /></td>
        </tr>
    </table>
</div>

<br/>
<table id="dg" title="开发计划项" style="width:700px;height:250px"
       toolbar="#toolbar" idField="id" rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="id" width="50">编号</th>
        <th field="planDate" name="planDate" width="50" editor="{type:'datebox',options:{required:true,<#if show != 0 >javascript:$('#dg').edatagrid('disableEditing')</#if>}} ">日期</th>
        <th field="planItem" width="100" editor="{type:'validatebox',options:{required:true}}">计划内容</th>
        <th field="exeAffect" width="100" editor="{type:'validatebox',options:{required:true}}">执行效果</th>
    </tr>
    </thead>
</table>

<#if show == 0 >
<div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">添加计划</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">删除计划</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow');$('#dg').datagrid('acceptChanges');$('#dg').edatagrid('reload')">保存计划</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">撤销行</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-kfcg" plain="true" onclick="updateSaleChanceDevResult(2)">开发成功</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-zzkf" plain="true" onclick="updateSaleChanceDevResult(3)">终止开发</a>
</div>
</#if>
</body>
</html>