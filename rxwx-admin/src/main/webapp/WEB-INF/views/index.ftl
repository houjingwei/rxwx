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
				
                  <#include "empty_page.ftl"/>
			</div>

            <@h.fotter />
        </div>
    </div>

</body>

</html>
