$('.finish').on('click',function(){
	console.log($('.write').val());
	alert($('。write').val() == null );
	if($('。write').val() == "" || $('。write').val() == null){
		alert('请添加描述');
	}
	if($('.canvas').html()==''){
		alert('还么上传照片');
	}
})
var mainTenance =[
	{
		'maintenanceName':"未修下水道",
		'maintenanceAddress':"陕西省西安市西安邮电大学B楼西北角"
	}

]
attr(mainTenance);
function attr(mainTenance){
	$('.task-title').html(mainTenance[0]['maintenanceName']);
	$('.addresss').html(mainTenance[0]['maintenanceAddress']);
}
//$(document).ready(function(){
	//$.ajax({
		//		type: "get",
   			//	url: 'http://123.206.204.163.2333/erbao/classify/goodsItem',
   				//dataType:'json',
   				//async:true,
   				//success:function(result){
   					//var data = JSON.parse(resut);
   					//$.each(data,function(){
   						//$('.task-title').html(comment['maintenanceName']);
   						//$('address').html(comment['maintenanceAddress']);
   					//})
   				//}
	//})
//})