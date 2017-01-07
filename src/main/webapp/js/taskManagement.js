;(function(){
	window.onload = function(){
		//字体设置
		fontSelf();
	}
	window.onresize = function () {
		fontSelf();
	};
	function fontSelf() {
		var wHtml = document.getElementById('html');
		var w = document.documentElement.clientWidth;
		w =  w > 768 ? 768 : document.documentElement.clientWidth;
		wHtml.style.fontSize = w * 0.045 + 'px';
		//页面加载
		LodeAjax();
		$("nav ul li:eq(0)").click(
			LodeAjax
		);
		function LodeAjax(){
			$(".content").empty(); 
			$('.glide').animate({left:"0"},200);
			$.ajax({
				type:"post",
				url:"http://192.168.1.162:8080/container/taskManagement",
				async:true,
				success:function(message){
					var obj = eval(message);
					for(var attr in obj){
						console.log(obj[attr]);
						var $content = $('.content');
						var $li = $("<li class='clearfix'></li>");
						$content.append($li);
						var $Img = $("<img src=''>");
						$li.append($Img);
						$Img.attr("src",obj[attr]['Pic']);
						var $introduce = $('<div class="introduce"></div>');
						$li.append($introduce);
						var $p = $('<p class="name">任务名称:</p>');
						$introduce.append($p);
						var $span = $('<span></span>');
						$p.append($span);
						var $a = $("<a href='#'></a>");
						$span.append($a);
						$a.html(obj[attr]['address']);
						var $p = $('<p class="time">时间:</p>');
						$introduce.append($p);
						var $span = $('<span></span>');
						$p.append($span);
						$span.html(obj[attr]['time']);
						var $button = $('<button class="receive"></button>');
						$li.append($button);
						//发送接受任务的id
						$button.attr('id',obj[attr]['id']);
						if(obj[attr]['state'] == 1){
							$button.html('接受任务');
							$button.addClass('receive');
							
						}else if(obj[attr]['state'] == 2){
							$button.html('已接受');
							$button.addClass('accepted');
						}else if(obj[attr]['state'] == 3){
							$button.html('未接受');
							$button.addClass('done');
						}
					}
					//接受任务按钮
					$('.receive').on('click',function(){
						console.log("11");
						$(this).html('已接受');
						$(this).addClass('accepted');
						$.ajax({
							type:"get",
							url:"url?id="+$(this).attr('id'),
							async:true,
						});
					});
					//点击a链接变色
					$('.content li .introduce p a').click(function(){
						$(this).css('color','#93cef1');
						$(this).parent().css('color','#93cef1');
					})
				}
			});
		}
		//点击巡查管理
		$("nav ul li:eq(1)").click(function(){
			$(".content").empty(); 
			$.ajax({
				type:"post",
				url:"http://192.168.1.162:8080/container/taskManagement",
				async:true,
				success:function(message){
					var obj = eval(message);
					for(var attr in obj){
						console.log(obj[attr]);
						var $content = $('.content');
						var $li = $("<li class='clearfix'></li>");
						$content.append($li);
						var $Img = $("<img src=''>");
						$li.append($Img);
						$Img.attr("src",obj[attr]['Pic']);
						var $introduce = $('<div class="introduce"></div>');
						$li.append($introduce);
						var $p = $('<p class="name">任务名称:</p>');
						$introduce.append($p);
						var $span = $('<span></span>');
						$p.append($span);
						var $a = $("<a href='#'></a>");
						$span.append($a);
						$a.html(obj[attr]['address']);
						var $p = $('<p class="time">时间:</p>');
						$introduce.append($p);
						var $span = $('<span></span>');
						$p.append($span);
						$span.html(obj[attr]['time']);
						var $button = $('<button></button>');
						$li.append($button);
						console.log(obj[attr]['state']);
						if(obj[attr]['state'] == 4){
							$button.html('已完成');
							$button.addClass('accepted');
						}else if(obj[attr]['state'] == 5){
							$button.addClass('receive');
							//这里放开始巡查链接
							var $a = $("<a href='#' style='color:#FFFFFF'></a>");
							$button.append($a);
							$a.html('开始巡查');
						}
					}
					//点击a链接变色
					$('.content li .introduce p a').click(function(){
						$(this).css('color','#93cef1');
						$(this).parent().css('color','#93cef1');
					})
				}
			});
			$('.glide').animate({left:"33.3%"},200);
		})
		//点击报警管理
		$("nav ul li:eq(2)").click(function itemOnClick(){
			$(".content").empty(); 
			$.ajax({
				type:"post",
				url:"http://192.168.1.162:8080/container/police",
				async:false,
				success:function(message){
					var obj = eval(message);
					for(var attr in obj){
						var $content = $('.content');
						var $li = $("<li class='clearfix'></li>");
						$content.append($li);
						var $Img = $("<img src=''>");
						$li.append($Img);
						$Img.attr("src",obj[attr]['Pic']);
						var $introduce = $('<div class="introduce"></div>');
						$li.append($introduce);
						var $p = $('<p class="name">任务名称:</p>');
						$introduce.append($p);
						var $span = $('<span></span>');
						$p.append($span);
						$span.html(obj[attr]['address']);
						var $p = $('<p class="time">时间:</p>');
						$introduce.append($p);
						var $span = $('<span></span>');
						$p.append($span);
						$span.html(obj[attr]['time']);
						var $button = $('<button></button>');
						$li.append($button);
						var $button = $('<button></button>');
						$li.append($button);
						$button.html('报警');
						$button.addClass('police');
						$button.attr('id',obj[attr]['id']);
					}
					//点击报警按钮
					$('.police').on('click',function(){
						console.log(this);
						var butId=$(this).attr("id");
						console.log(butId);
						$.ajax({
							type:"post",
							url:"http://192.168.1.162:8080/container/police?id="+butId,
							async:true,
							success:itemOnClick()
						});
					});

					//点击a链接变色
					$('.content li .introduce p a').click(function(){
						$(this).css('color','#93cef1');
						$(this).parent().css('color','#93cef1');
					})
				}
			});
			$('.glide').animate({left:"66.6%"},200);
		})
	};
})();
/*样例
 * var message = [{
	"Pic":"A.jpg",
	"address":"A号楼",
	"time":"2014-10-10",
	"id":1,
	"state":4},
	{
	"Pic":"B.jpg",
	"address":"B号楼",
	"time":"2014-11-10",
	"id":2,
	"state":4},
	{
	"Pic":"C.jpg",
	"address":"C号楼",
	"time":"2014-11-10",
	"id":3,
	"state":5
	}
]*/