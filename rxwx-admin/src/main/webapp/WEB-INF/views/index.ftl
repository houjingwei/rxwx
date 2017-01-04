<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>锐讯无限－首页</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
	<@h.head />
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
        <@h.left />
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <@h.top />
            
            <div class="row J_mainContent" id="content-main" style="OVERFLOW-Y: scroll;scrollbar-face-color:#B3DDF7;scrollbar-shadow-color:#B3DDF7;" >
				
                  <div class="wrapper wrapper-content animated fadeInRight" >
                    
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-content">
                                    <table data-toggle="table" id="table" >
								            <thead>
								            </thead>
									</table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
			</div>

            <@h.fotter />
        </div>
    </div>

</body>
<script>
		
        
        $('#table').bootstrapTable({  
      method: 'post',  
      url: '${path}/role/roleList',
      dataType: "json",  
      striped: true,     //使表格带有条纹  
      pagination: true, //在表格底部显示分页工具栏  
      pageSize: 2,  
      pageNumber: 1,  
      pageList: [2, 5, 10, 20],  
      idField: "ProductId",  //标识哪个字段为id主键  
      showToggle: false,   //名片格式  
      cardView: false,//设置为True时显示名片（card）布局  
      showColumns: true, //显示隐藏列    
      showRefresh: true,  //显示刷新按钮  
      singleSelect: true,//复选框只能选择一条记录  
      search: false,//是否显示右上角的搜索框  
      clickToSelect: true,//点击行即可选中单选/复选框  
      sidePagination: "server",//表格分页的位置  
      queryParams: queryParams, //参数  
      queryParamsType: "limit", //参数格式,发送标准的RESTFul类型的参数请求  
      toolbar: "#toolbar", //设置工具栏的Id或者class  
      columns: [{
                field: 'name',
                title: '操作码'
            }, {
                field: 'description',
                title: '说明'
            } ],
      silent: true,  //刷新事件必须设置  
      formatLoadingMessage: function () {  
        return "请稍等，正在加载中...";  
      },  
      formatNoMatches: function () {  //没有匹配的结果  
        return '无符合条件的记录';  
      },  
      onLoadError: function (data) {  
        $('#reportTable').bootstrapTable('removeAll');  
      } 
    });  
        
   
        
        function queryParams(params) {  //配置参数  
		    var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的  
		      pageSize: params.limit,   //页面大小  
		      pageNumber: params.pageNumber,  //页码  
		      minSize: $("#leftLabel").val(),  
		      maxSize: $("#rightLabel").val(),  
		      minPrice: $("#priceleftLabel").val(),  
		      maxPrice: $("#pricerightLabel").val(),  
		    };  
		    return temp;  
		  } 
        
	</script>
</html>
