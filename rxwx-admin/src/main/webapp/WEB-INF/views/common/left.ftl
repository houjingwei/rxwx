<!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element" style="margin-left: 36px;">
                            <span><img alt="image" class="img-circle" src="${path}/assets/img/profile_small.jpg" /></span>
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
                    <#if (resources?? && resources?size>0)>
						<#list resources as res>
							<li>
								 <a href="#"> <span class="nav-label">${res.menuName!''}</span> <span class="fa arrow"></span> </a>
								 <#if res.resList??>
								<ul class="nav nav-second-level">
								    <#list res.resList as p>
								    	<@shiro.hasPermission  name="${p.name!''}">
								    		<li><a href="${path}${p.url!''}">${p.desc!''}</a></li>
										</@shiro.hasPermission>
									</#list>
								</ul>
								</#if>
							</li>
						</#list>
					</#if>

                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->