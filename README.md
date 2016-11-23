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




#####项目问题解决#####
> 1.如果dubbo配置文件报错，提示dubbo标签找不到，请在
> `XML`下`XML Catalog` 中添加`rxwx`下`pro-file`中的`dubbo.xsd`文件


> 2.spring-data-redis 对最新版本redis的集群支持配置
>
> spring-context.xml
    <p >
    
      <?xml version="1.0" encoding="UTF-8"?>
        <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd
    http://code.alibabatech.com/schema/dubbo          
    http://code.alibabatech.com/schema/dubbo/dubbo.xsd">

    <context:property-placeholder location="classpath:config.properties" />
    <context:component-scan base-package="com.rxwx.cache" />

    <!-- redis cluster 集群配置 -->
    <import resource="classpath:spring-redis-cluster.xml" />
    
    <!-- redis 单点配置
     <import resource="classpath:spring-redis-cluster.xml" />
     -->
    <import resource="classpath:dubbo-provider.xml"/>
    </beans>

  </p>
 
  <p>
 
  > spring-redis-cluster.xml
 
      <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p" xmlns:tx="http://www.springframework.org/schema/tx"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
      http://www.springframework.org/schema/beans
      http://www.springframework.org/schema/beans/spring-beans.xsd
      http://www.springframework.org/schema/tx
      http://www.springframework.org/schema/tx/spring-tx.xsd
      http://www.springframework.org/schema/context
      http://www.springframework.org/schema/context/spring-context.xsd">
    <bean id="clusterRedisNodes1" class="org.springframework.data.redis.connection.RedisNode">
        <constructor-arg value="139.224.72.183" />
        <constructor-arg value="7111" type="int" />
    </bean>
    <bean id="clusterRedisNodes2" class="org.springframework.data.redis.connection.RedisNode">
        <constructor-arg value="139.224.72.183" />
        <constructor-arg value="7112" type="int" />
    </bean>
    <bean id="clusterRedisNodes3" class="org.springframework.data.redis.connection.RedisNode">
        <constructor-arg value="139.224.72.183" />
        <constructor-arg value="7113" type="int" />
    </bean>

    <bean id="redisClusterConfiguration" class="org.springframework.data.redis.connection.RedisClusterConfiguration">
        <property name="clusterNodes">
            <set>
                <ref bean="clusterRedisNodes1" />
                <ref bean="clusterRedisNodes2" />
                <ref bean="clusterRedisNodes3" />
            </set>
        </property>

        <property name="maxRedirects" value="5" />
    </bean>

    <bean id="jedisPoolConfig" class="redis.clients.jedis.JedisPoolConfig">
        <property name="maxIdle" value="1000" />
    </bean>

    <bean id="jedisConnFactory" class="org.springframework.data.redis.connection.jedis.JedisConnectionFactory" p:use-pool="true">

        <constructor-arg ref="redisClusterConfiguration" />

        <constructor-arg ref="jedisPoolConfig" />

    </bean>
    <bean id="stringSerializer" class="org.springframework.data.redis.serializer.StringRedisSerializer" />

    <bean id="redisTemplate" class="org.springframework.data.redis.core.RedisTemplate">
        <property name="connectionFactory" ref="jedisConnFactory" />
        <property name="hashKeySerializer" ref="stringSerializer" />
        <property name="keySerializer" ref="stringSerializer" />
        <property name="stringSerializer" ref="stringSerializer" />
        <property name="enableTransactionSupport" value="false" />
    </bean>

    </beans>

 
 
  </p>

