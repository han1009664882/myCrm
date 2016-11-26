var url;

function openTab(text, url, iconCls){
    if($("#tabs").tabs("exists",text)){
        $("#tabs").tabs("select",text);
    }else{
        var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='" + url + "'></iframe>";
        $("#tabs").tabs("add",{
            title:text,
            iconCls:iconCls,
            closable:true,
            content:content
        });
    }
}

function openPasswordModifyDialog(){
    $("#dlg").dialog("open").dialog("setTitle","修改密码");
}

function modifyPassword() {
    $("#fm").form("submit",{
        url:ctx+"/user/updatePwd",
        onSubmit:function() {
            var oldPassword = $("#oldPassword").val();
            var newPassword = $("#newPassword").val();
            var newPassword2 = $("#newPassword2").val();
            if(!$(this).form("validate")) {
                return false;
            }
            if(newPassword != newPassword2) {
                $.messager.alert("系统提示", "确认密码输入错误！");
                return false;
            }
            return true;
        },
        success:function(data) {
        	var res = JSON.parse(data);
            if(res.resultCode == 1){
                $.messager.alert("系统提示", res.result);
                $.removeCookie("userIdStr");
                $.removeCookie("userName");
                $.removeCookie("realName");
                setInterval(function() {
                    window.location.href = ctx+"/index";
                }, 1000);
            }else{
                $.messager.alert("系统提示", res.result);
                return;
            }
        }
    });
}

function closePasswordModifyDialog(){
    resetValue();
    $("#dlg").dialog("close");
}

function resetValue(){
    $("#oldPassword").val("");
    $("#newPassword").val("");
    $("#newPassword2").val("");
}

// 退出系统
function logout() {
    $.messager.confirm("系统提示","您确定要退出系统吗？",function(r) {
        if (r) {
            $.removeCookie("userIdString");
            $.removeCookie("userName");
            $.removeCookie("realName");
            window.location.href = "index";
        }
    });
}