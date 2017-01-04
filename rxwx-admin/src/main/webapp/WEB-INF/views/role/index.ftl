<!DOCTYPE html>
<html>

<head>
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
    <script>
		$('#table').bootstrapTable({
            url: '${path}/role',
            striped: true,
            pagination: true,
            pageList: [3,5,20],
            pageSize:3,
            pageNumber:1,
            sidePagination:'server',//设置为服务器端分页
            columns: [{
                field: 'name',
                title: '操作码'
            }, {
                field: 'description',
                title: '说明'
            } ]
        });
	</script>

</body>

</html>
