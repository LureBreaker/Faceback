<!DOCTYPE html>
<head lang="en">
<meta charset="utf-8">
<title>FaceBack Send to your friend!</title>

<link rel="stylesheet" href="style/default.css">
<link rel="stylesheet" href="style/red.css" />
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
	$(function() {
		$('input[name=email]').change(function() {
			$.ajax({
				type : "POST",
				url : "/memberws",
				data : {
					'type' : 'retrieveName', 
					'email' : $(this).val()
				},
				success : function(data) {
					$('input[name=name]').val(data);
				},
				error : function() {

				}
			});
		});
	});
</script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="/">Face Back</a>
				</h1>
			</div>
			<div style="float: right;">
				<img src="./images/faceback.png"
					style="margin-top: 20px; height: 70px;" />
				<div align="center">
					<a href="/login?type=logout">[log out]</a>
				</div>
			</div>
		</div>
		<div id="page">
			<div id="content">
				<form action="sendMsg" method="POST">
					<p>
						<label for="email">Your friend's email:</label> <input type="text"
							name="email" />
					</p>
					<p>
						<label for="name">Your friend's Name:</label> <input type="text"
							name="name" />
					</p>
					<p>
						<label for="year">Year of the happening:</label> <input
							type="text" name="year" />
					</p>
					<p>
						<label for="happening">What's going on:</label>
						<textarea name="happening"></textarea>
					</p>
					<p>
						<input type="submit" style="width: 100px;" name="submit"
							value="submit" />
					</p>
				</form>
			</div>
		</div>

		<div id="footer">
			<p>Copyright (c) 2013 FaceBack All rights reserved.</p>
			<ul style="display: none;">
				<li>Other Projects:</li>
				<li><a
					href="http://alvinkwang.github.com/plantatree/PlantATree.html">Plant
						A Tree</a></li>
				<li><a href="http://dl.dropbox.com/u/11625785/public/web/">Analytics
						Test</a></li>
				<li><a href="http://bencees.github.com/cloud/splash.html">Feeling
						Ugly</a></li>
				<li><a href="http://rosannechoo2011.github.com/fivepages/">Five
						Pages</a></li>
				<li><a
					href="http://keemin.github.com/bootstrap-1/indexas3.html">storyon</a></li>
				<li><a href="http://kwgoh.github.com/code-express/index.html">CodeExpress</a></li>
				<li><a href="http://kenwjj.github.com/Metro-UI-CSS/public">BoxandButton</a></li>
			</ul>

		</div>
	</div>


</body>

</html>