<%@page import="fr.lamphi.api.*"%>
<div class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a href="index.jsp" class="navbar-brand"><img
				src="img/logo_lamphi.png" width="70px" /></a>
			<button class="navbar-toggle" type="button" data-toggle="collapse"
				data-target="#navbar-main">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse" id="navbar-main">
			<ul class="nav navbar-nav">
				<li><a href="addlesson.jsp">Ajouter un cours</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<% if(session.getAttribute("user") == null) {	%>
				<li><a href="register.jsp" target="_blank">Inscription</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" id="themes">Connexion <span
						class="caret"></span></a>
					<ul class="dropdown-menu" aria-labelledby="themes">
						<li><a href="Connexion?status=prof">En tant que professeur...</a></li>
						<li><a href="Connexion?status=etu">En tant qu'étudiant...</a></li>
					</ul></li>
				<% } else { %>
				<li><a href="Connexion?deconnect=1">Se déconnecter</a></li>
				<li><a href="profil.jsp">Mon profile <img src="http://www.gravatar.com/avatar/<%out.print(MD5Util.md5Hex(((User)session.getAttribute("user")).getEmail()));%>?s=17"/></a></li>
				<% }%>
			</ul>
		</div>
	</div>
</div>