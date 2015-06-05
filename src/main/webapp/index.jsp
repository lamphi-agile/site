<%@page import="fr.lamphi.api.LessonRessource"%>
<%@page import="fr.lamphi.api.Lesson"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<meta charset="utf-8">
<title>L'amphi</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="icon" type="image/png" href="img/favicon/favicon-32x32.png" />
<link rel="icon" href="img/favicon/favico.ico" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../bower_components/html5shiv/dist/html5shiv.js"></script>
      <script src="../bower_components/respond/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="../" class="navbar-brand"><img
					src="img/logo_lamphi.png" width="70px" /></a>
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-main">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#" id="themes">Themes <span
							class="caret"></span></a>
						<ul class="dropdown-menu" aria-labelledby="themes">
							<li><a href="../default/">Default</a></li>
							<li class="divider"></li>
							<li><a href="../cerulean/">Cerulean</a></li>
							<li><a href="../cosmo/">Cosmo</a></li>
							<li><a href="../cyborg/">Cyborg</a></li>
							<li><a href="../darkly/">Darkly</a></li>
							<li><a href="../flatly/">Flatly</a></li>
							<li><a href="../journal/">Journal</a></li>
							<li><a href="../lumen/">Lumen</a></li>
							<li><a href="../paper/">Paper</a></li>
							<li><a href="../readable/">Readable</a></li>
							<li><a href="../sandstone/">Sandstone</a></li>
							<li><a href="../simplex/">Simplex</a></li>
							<li><a href="../slate/">Slate</a></li>
							<li><a href="../spacelab/">Spacelab</a></li>
							<li><a href="../superhero/">Superhero</a></li>
							<li><a href="../united/">United</a></li>
							<li><a href="../yeti/">Yeti</a></li>
						</ul></li>
					<li><a href="../help/">Help</a></li>
					<li><a href="http://news.bootswatch.com">Blog</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#" id="download">Download <span
							class="caret"></span></a>
						<ul class="dropdown-menu" aria-labelledby="download">
							<li><a href="./bootstrap.min.css">bootstrap.min.css</a></li>
							<li><a href="./bootstrap.css">bootstrap.css</a></li>
							<li class="divider"></li>
							<li><a href="./variables.less">variables.less</a></li>
							<li><a href="./bootswatch.less">bootswatch.less</a></li>
							<li class="divider"></li>
							<li><a href="./_variables.scss">_variables.scss</a></li>
							<li><a href="./_bootswatch.scss">_bootswatch.scss</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="Register.jsp" target="_blank">Inscription</a></li>
					<li><a href="https://wrapbootstrap.com/?ref=bsw"
						target="_blank">Connexion</a></li>
				</ul>

			</div>
		</div>
	</div>


	<div class="container">

		<div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<h1>Cerulean</h1>
					<p class="lead">A calm blue sky</p>
				</div>
			</div>
		</div>

		<!-- Tables
      ================================================== -->
		<div class="bs-docs-section">

			<div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<h1 id="tables">Les cours</h1>
					</div>

					<div class="bs-component">
						<table class="table table-striped table-hover ">
							<thead>
								<tr>
									<th>#</th>
									<th>Titre</th>
									<th>Auteur</th>
									<th>Note</th>
								</tr>
							</thead>
							<tbody>
								<%List<Lesson> lessons = new LessonRessource().getlessons(10);
                  					for(Lesson lesson : lessons) {%>
								<tr>
									<td>
										<% out.print(lesson.getId()); %>
									</td>
									<td>
										<a href="#"><% out.print(lesson.getTitle()); %></a>
									</td>
									<td>
										<% out.print(lesson.getAuthor()); %>
									</td>
									<td>
										<% out.print(lesson.getCertified()); %>
									</td>
								</tr>
								<%} %>
							</tbody>
						</table>
					</div>
					<!-- /example -->
				</div>
			</div>
		</div>

		<footer>
		<div class="row">
		<hr>
			<div class="col-lg-12">&copy L'amphi 2015 - Projet Agile</div>
		</div>
		</footer>


	</div>


	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="../assets/js/bootswatch.js"></script>
	<script type="text/javascript">
/* <![CDATA[ */
(function(){try{var s,a,i,j,r,c,l=document.getElementsByTagName("a"),t=document.createElement("textarea");for(i=0;l.length-i;i++){try{a=l[i].getAttribute("href");if(a&&a.indexOf("/cdn-cgi/l/email-protection") > -1  && (a.length > 28)){s='';j=27+ 1 + a.indexOf("/cdn-cgi/l/email-protection");if (a.length > j) {r=parseInt(a.substr(j,2),16);for(j+=2;a.length>j&&a.substr(j,1)!='X';j+=2){c=parseInt(a.substr(j,2),16)^r;s+=String.fromCharCode(c);}j+=1;s+=a.substr(j,a.length-j);}t.innerHTML=s.replace(/</g,"&lt;").replace(/>/g,"&gt;");l[i].setAttribute("href","mailto:"+t.value);}}catch(e){}}}catch(e){}})();
/* ]]> */
</script>
</body>
</html>