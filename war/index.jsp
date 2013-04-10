<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="utf-8">
<title>Face Back</title>

<link rel="stylesheet" href="style/default.css">
<link rel="stylesheet" href="style/red.css">
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-39497749-1']);
  _gaq.push(['_setDomainName', 'afaceback.appspot.com']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
<script src="./js/jquery-1.9.1.js"></script>
<script>
	$(function(){
		$("#spanRegister").click(function(){
			$("#divRegName").show();
			$('input[name="submit"]').val("Register");
			$("#hidReg").val('true');
			$(this).hide();
		});
	});
</script>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">Face Back</a>
				</h1>
			</div>
			<div style="float:left;margin:20px;color:#eaeaea;width:300px;">
			<p>
			<b>Face Back</b> is a platform for you to sharing your treasure memories to your friends and also to the public. 
			</p>
			</div>
			<div style="float: right;">
				<img src="./images/faceback.png"
					style="margin-top: 20px; height: 70px;" />
			</div>
		</div>
		<div id="page">
			<div id="content" sityle="text-align: center;">
			
			<%
				String useremail = (String)session.getAttribute("useremail");
				if (useremail==null || "".equals(useremail)){
			%>
				<div id="login" >
					<form action="login" method="POST"
						style="width: 100%; text-align: center; ">
						<div align="center" style="margin-left:120px;">
							<div align="center" style="width: 600px;float:left">
								<div style="width: 600px;">
									<label for="email">Email:</label> <input type="text"
										name="email" />
								</div>

								<div style="width: 600px;">
									<label for="password">Password:</label> <input type="password"
										name="password" />

								</div>
								
								<div id='divRegName' style="display:none;width: 600px;">
									<label for="name">Name:</label> <input type="text"
										name="name" />
									<input type="hidden" id="hidReg" name="hidReg" value="false"  />
									
								</div>
							</div>
							<div style="width:100px;float:left;margin-top:20px;">
								<input type="submit" name="submit" value="Login" />
								<span id='spanRegister'><a href="#">Registration</a></span>
							</div>
							<br />
							<div style="clear:both;margin-right:550px;padding-top:20px;">
								
							</div>
						</div>
					</form>
					<% } else { 
						response.sendRedirect("/readmessage");
					}%>
				</div>
			</div>
		</div>

		<div id="footer">
			<p>Copyright (c) 2013 FaceBack All rights reserved.</p>
		</div>
	</div>

</body>

</html>
