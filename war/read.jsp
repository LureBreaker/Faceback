<%@page import="java.util.*"%>
<%@page import="com.FaceBack.*"%>
<%
	ArrayList<Message> msgList =(ArrayList<Message>)request.getAttribute("msgList");
	ArrayList<Member> memberList =(ArrayList<Member>)request.getAttribute("memberList");
%>


<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="utf-8">
<title>Face Back</title>

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
			<div id="content" style="width: 800px;">
				<%
					if (msgList != null && msgList.size() > 0) {
						for (Message msg : msgList) {
				%>
				<div style="text-align: left;">
					<div style="float: left;">
						<img src="./images/ppl.png" />
					</div>
					<div style="">
						Letter from <a href="/readmessage?email=<%=msg.getFrom()%>">
							<%
								Member member = new MemberDAO().retrieve(msg.getFrom());
										if (member != null)
											out.println(member.getName());
										else
											out.println("your friend");
							%>
						</a> (<%=msg.getYear()%>):

						<h3>
							Dear
							<%=msg.getName()%></h3>
						<p>
							<%=msg.getMessage()%>
						</p>
					</div>
				</div>
				<div style="width: 100%; margin-top: 100px; text-align: center;">

				</div>

				<%
					}
					} else {
				%>
				<div style="text-align: center; margin-top: 20px;">
					<img src="./images/faceback.png" style="width: 200px;" /> <br />
					<span>Sorry you did not make any message inside!</span>
					<hr />
				</div>
				<%
					}
				%>
				<div style="clear:both; float:left;border-top:1px solid red; width:100%;">
					
					<h3>You sent message to:</h3>
					<div style="text-align:left;">
					<ul >
					<% for (Member m : memberList){ %>
						<li><a href="/readmessage?email=<%=m.getEmail()%>"><%= m.getName() %></a></li>
					<% } %>
					</ul>
					</div>
				</div>
			</div>
			<div id="sidebar" align="center">
				<h3>Write Memory to Friends</h3>
				<div style="margin-top: 30px;">
					<a href="./play.jsp"> <img src="./images/write.png" /><br />
						<span></span>
					</a>
				</div>
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