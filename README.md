### rxwx ###



#### 项目介绍 ####

#####项目采用技术：dubbo+zookeeper+spring+springMvc+mybatis＋redis+mysql＋maven#####

#####项目结构说明#####
	rxwx-model : 数据模型
	rxwx-service: 接口组件
	
	rxwx-cache-component:缓存服务组件
	rxwx-user-component:用户服务组件
	
	rxwx-api:接口工程 <Client>
	
	rxwx-common:公共组件，包含公共异常类
	
#####项目结构图示#####
<img src="http://www.image.qupaia.com//images/memberSunsing/2016/11/11/07FCE4BD85C348DDD839CB4C35809461.png_700x700.png" width = "300" height = "200" alt="图片名称" align=center />	
#####项目运行#####
> git clone https://github.com/houjingwei/rxwx.git
> 
> 以maven方式引进eclipse
> 
> rxwx >> mvn clean install
> 
> 首先启动缓存组件
> 
>rxwx-cache-component/target/ 执行 java -jar rxwx-cache-component-1.0.0.one-jar.jar
> 
> 
> 
> 然后启动用户组件，从图示可知，用户组件依赖于缓存组件
> 
> rxwx-user-component/target/ 执行 java -jar rxwx-user-component-1.0.0.one-jar.jar
> 
> 最后将rxwx-api项目运行在tomcat中启动，访问
> ip:端口／rxwx-api/api/userList 或 ip:端口／rxwx-api/api/findOne
> 

> 
> 
> 使用默认中央仓库下载很慢，可以采用阿里云镜像
> 修改maven目录下conf/ settings.xml 

  <p>
  
  	<mirrors>
	    <mirror> 
	      <id>alimaven</id>    
	      <name>aliyun maven</name>  
	      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>  
	      <mirrorOf>central</mirrorOf>          
	    </mirror> 
    </mirrors> 
    
  </p>


