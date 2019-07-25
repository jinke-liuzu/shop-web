var url;

function ResetValues(){
	$("#mname").val('');
	$("#typeid").val('');
	$("#timeid").val('');
	$("#publishTime").val('');
	$("#sorce").val('');
	$("#clickCount").val('');
	$("#movieIntro").val('');
	$("#fileid").val('');
	
}
 




//添加
function Add(){
	$("#AddDialog").dialog('open').dialog('setTitle',"添加数据");
	url = "user/add.do";
}

function SaveDialog(){
	
	$("#ModiyDialogForm").form('submit',{
		url:url,
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function(result){
			if( result.errorMsg ){
				$.messager.alert("系统提示",result.errorMsg);
				return;
			}
			else{
				//setTimeout();
				$.messager.alert("系统提示","保存成功");
				ResetValues();
				//关闭当前的添加对话框
				$("#AddDialog").dialog('close');
				
				//刷新  表格数据
				$("#data").datagrid('reload');
			}
		}
	});
	
	ResetValues();
}

//取消按钮
function CloseDialog(){
	ResetValues();
	
	//关闭添加 的对话框
	$("#AddDialog").dialog('close');
}
 



function aa(){
	//现在关闭消息窗口
	$.messager.progress('close');
	$("#data").datagrid('reload');
	
 }



 
//修改
function ModifyBySelect(){
	//获取要修改的数据 返回的是一个
	var rows = $("#data").datagrid('getSelections');
	//alert(rows);
	if(1 !=rows.length){
		$.messager.alert("系统提示","请选择一条数据进行编辑！");
		return ;
	}
	//打开窗口
	$("#AddDialog").dialog('open').dialog('setTitle','修改数据');
	//获取数据
	var selData = $("#data").datagrid('getSelected');
	$("#ModiyDialogForm").form('load',selData);
	alert(selData.mid);
	url="user/add.do?mid="+selData.mid;
}

//修改
/*function ModifyBySelect(){
	
	//返回所有选定的行,当没有记录被选中,我将返回空数组。
	//对选中的进行判断  是否是一条
	var SelectRows = $("#data").datagrid('getSelections');
	if( 1 != SelectRows.length ){
		$.messager.alert("系统提示", "请选择一行要编辑的数据");
		return;
	}
	
	//获取到选中的是一条
	var aa = SelectRows[0];
	alert(SelectRow);
	//打开选中页面
	$("#AddDialog").dialog('open').dialog('setTitle',"编辑数据");
	//显示选中的数据
	$("#ModiyDialogForm").form('load',aa);
	//把
	url ="user/add.do?mid="+aa.mid;
}
 */

//批删 $.messager.confirm("系统提示", "你确定要作废<font color=red> " + rows.length + " </font>条数据吗?",


function DeleteByFruitName(){
	
	//获取数据
	var rows=$("#data").datagrid('getSelections');
	if(0 ==rows.length){
		$.messager.alert("系统提示","请选择要删除的数据！");
		return ;
	}
	//选中数据
	//得到id值
	var arr=[];
	for(var i=0;i<rows.length;i++){
		arr.push(rows[i].mid);
	}
	//对id进行拼接
	var ids=arr.join(",");
	
	$.messager.confirm("系统提示", "你确定要刪除<font color=red> " + rows.length + " </font>条数据吗?",
			function(xo){
			if(xo){
				$("#data").datagrid('reload');
			$.post("user/deleteAll.do",{ids:ids},
				function(result){
				//alert("result:"+result);
				if( result.success ){
					$.messager.alert("系统提示", "你已成功删除 <font color=green> " + result.DeleteCounts + " </font>条数据!~");
					$("#data").datagrid('reload');
				}
				else{
					$.messager.alert("系统提示", "<font color=red>删除失败</font>");
				}
				},"json");
				
			}
		
			});
}

 
 
 
 
function OpenTab(Text,URL){
	if( $("#MenusTabs").tabs('exists', Text) ){
		$("#MenusTabs").tabs('select', Text);
	}
	else{
		var Content = "<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src=" + URL + "></iframe>";
		$("#MenusTabs").tabs('add',{
			title:Text,
			closable:true,
			content:Content
		});	
	}
}
 
(function(){
	var TreeMenusDatas=[{
		text:"图书馆图书系统",
		children:[{
			text:"小说图书信息",
			attributes:{
				url:"data.jsp"
			}
		}]
	}];
	
	$("#TreeMenus").tree({
		data:TreeMenusDatas,
		lines:true,
		onClick:function(node){
			if( node.attributes ){
				OpenTab( node.text, node.attributes.url );
			}
		}
	});
})();
