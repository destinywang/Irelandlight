$('.finish').on('click',function(){
	for(var i=0;i<$('.checkbox').length;i++){
		if($('.checkbox')[i].checked){
			window.location.href ="maintenanceFinish.html"
		}else{
			alert('还有未维修的项目');
		}
		
	}
})
var Index =[
	{
		"taskTitle":"灭火器",
		"describeContent":"喷灌处有磨损，此处灭火器存储量不足",
		"fireImg":"../img/fireHydrant.jpg"
	}
];
A(Index);
function A(Index){
						$('.task-title').html(Index[0]['taskTitle']);
 						$('.content').html(Index[0]['describeContent']);
 						$('.fireHydrant').attr("src",Index[0]['fireImg']);
}
//$('document').ready(function(){
//	$ajax({
//				type: "get",
// 				url: 'http://123.206.204.163.2333/erbao/classify/goodsItem',
// 				dataType:'json',
// 				async:true,
// 				success:function(result){
// 					var data = JSON.parse(resut);
// 					$.each(data,function(commentIndex, comment){
// 						$('.task-title').html(comment['taskTitle']);
// 						$('。content').html(comment['describeContent']);
// 						$('.fireHydrant').html(comment['fireImg']);
// 					})
// 				}
// 				
//	})	
//})
