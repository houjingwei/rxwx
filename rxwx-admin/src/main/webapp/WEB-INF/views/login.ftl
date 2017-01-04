<html>
<head>
    <title>登录</title>
    <@h.head />
</head>
<body class="gray-bg">
	<div id="maxDiv" class="middle-box text-center loginscreen  animated fadeInDown">
		<div>
			<div>
				<h4 class="logo-name" style="color:#1ab394">H+</h4>

			</div>
			<h3>欢迎使用 H+</h3>

			<form class="m-t" role="form" action="${path}/login" method="post" id="loginForm">
				<div class="form-group">
					<input type="text" name="username" class="form-control"
						placeholder="用户名"  required="">
				</div>
				<div class="form-group">
					<input type="password" name="password" class="form-control"
						placeholder="密码" required="">
				</div>
				<#-- 
				<div class="form-group" style="float:left;">
					<input required="" placeholder="验证码" class="form-control" name="kaptchaCode" style="float:left;width:220px;">
					<img alt="验证码" src="${path }/img?new Date().getTime()" style="float: left; width:72px; height: 32px; margin-left: 5px;cursor:pointer;" onclick="this.src='${path }/img?'+(new Date().getTime());">
				</div>
				 -->
				<div style="float:left;" class="form-group">
					<span style="color:red;float:left;">${msg!'' }</span>
				</div>
				<button type="submit" class="btn btn-primary block full-width m-b">登
					录</button>


				<p class="text-muted text-center">
					<a href="${path}/toRegist"> <small>忘记密码了？</small>
					</a> | <a href="${path}/toRegist">注册一个新账号</a>
				</p>

			</form>
		</div>
	</div>
	
</body>
</html>
