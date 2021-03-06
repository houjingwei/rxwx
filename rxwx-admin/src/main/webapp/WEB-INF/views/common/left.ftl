<!--左侧导航开始-->
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close"><i class="fa fa-times-circle"></i>
    </div>
    <div class="sidebar-collapse">
        <ul class="nav" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element" style="margin-left: 36px;">
                    <span><img alt="image" class="img-circle"  style="width: 62px; height: 62px;"
                    	src="<#if admin??>${admin.photo!''}<#else>${path}/assets/img/profile_small.jpg</#if>" /></span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="clear">
                       <span class="block m-t-xs"><strong class="font-bold"><#if admin??>${admin.name!''}</#if></strong></span>
                        <span class="text-xs block">
                        	<#if (roles?? && roles?size>0)>
                        		<#list roles as role>
                        			${role}
                        		</#list>
                        	</#if>
                        <b class="caret"></b></span>
                        </span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a class="J_menuItem" href="form_avatar.html">修改头像</a>
                        </li>
                        <li><a class="J_menuItem" href="profile.html">个人资料</a>
                        </li>
                        <li><a class="J_menuItem" href="contacts.html">联系我们</a>
                        </li>
                        <li><a class="J_menuItem" href="mailbox.html">信箱</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="${path }/logout">安全退出</a>
                        </li>
                    </ul>
                </div>
                <div class="logo-element">H+
                </div>
            </li>
            <#if (menus?? && menus?size>0)>
				<#list menus as menu>
					<li>
						<@shiro.hasPermission  name="${menu.code!''}">
							<a href="#"> <span class="nav-label">${menu.name!''}</span> <span class="fa arrow"></span> </a>
							<#if (menu.resMenuVoList?? && menu.resMenuVoList?size>0)>
							<ul class="nav nav-second-level">
							    <#list menu.resMenuVoList as resMenu>
							    	<@shiro.hasPermission  name="${resMenu.code!''}">
							    		<li><a href="javascript:goto('${path}${resMenu.url!''}')">${resMenu.name!''}</a></li>
									</@shiro.hasPermission>
								</#list>
							</ul>
							</#if>
						</@shiro.hasPermission>
					</li>
				</#list>
			</#if>

        </ul>
    </div>
</nav>
<!--左侧导航结束-->

<script>
	function goto(path){
		$(".J_iframe").attr("src",path); 
	}
</script>