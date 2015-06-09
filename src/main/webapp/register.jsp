<%@ include file="include/header.jsp"%>
<body>
	<%@ include file="include/navbar.jsp"%>
	<!-- Page Content -->
	<div class="container">
		<!-- Page Header -->
		<div class="page-header" id="banner">
			<div class="row">
				<%if(request.getAttribute("alert") != null) {%>
					<div class="alert alert-danger" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Fermer"><span aria-hidden="true">&times;</span></button><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> <%out.print(request.getAttribute("alert")); %></div>
				<%} %>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<h1>Connexion</h1>
					<form method='post' action='Connexion'>
						<div class="form-group">
							<label for="login" class="col-sm-4 control-label">Login </label>
							<div class="col-sm-8">
								<input class="form-control" type="text" name="login"
									value="<%out.print(request.getParameter("login")!=null?request.getParameter("login"):""); %>" placeholder="Login" required>
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-sm-4 control-label">Mot
								de passe </label>
							<div class="col-sm-8">
								<input class="form-control" type="password" name="password"
									placeholder="Mot de passe" required>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
								<button type="submit" class="btn btn-info">Connexion</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<h1>Inscription</h1>
					<form method='post' action='inscription'>
						<div class="form-group">
							<label for="inputNom" class="col-sm-4 control-label">Nom</label>
							<div class="col-sm-8">
								<input class="form-control" type="text" name="name"
									value="<%out.print(request.getParameter("name")!=null?request.getParameter("name"):""); %>" placeholder="Nom" required>
							</div>
						</div>
						<div class="form-group">
							<label for="inputNom" class="col-sm-4 control-label">Prénom</label>
							<div class="col-sm-8">
								<input class="form-control" type="text" name="surname"
									value="<%out.print(request.getParameter("surname")!=null?request.getParameter("surname"):""); %>" placeholder="Prénom" required>
							</div>
						</div>
						<div class="form-group">
							<label for="inputNom" class="col-sm-4 control-label">Login</label>
							<div class="col-sm-8">
								<input class="form-control" type="text" name="pseudo"
									value="<%out.print(request.getParameter("pseudo")!=null?request.getParameter("pseudo"):""); %>" placeholder="Pseudo" required>
							</div>
						</div>
						<div class="form-group">
							<label for="inputNom" class="col-sm-4 control-label">Email</label>
							<div class="col-sm-8">
								<input class="form-control" type="email" name="email"
									value="<%out.print(request.getParameter("email")!=null?request.getParameter("email"):""); %>" placeholder="Email" required>
							</div>
						</div>
						<div class="form-group">
							<label for="inputNom" class="col-sm-4 control-label">Mot
								de passe</label>
							<div class="col-sm-8">
								<input class="form-control" type="password" name="password"
									placeholder="Mot de passe" required>
							</div>
						</div>
						<div class="form-group">
							<label for="inputNom" class="col-sm-4 control-label">Sexe
							</label>
							<div class="col-sm-8">
								<select class="form-control" name="sex" id="sex">
									<option value="fem">Femme</option>
									<option value="hom">Homme</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputNom" class="col-sm-4 control-label">Statut
								? </label>
							<div class="col-sm-8">
								<select class="form-control" name="status" id="status">
									<option value="ens">Enseignant</option>
									<option value="etu">Etudiant</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
								<button type="submit" class="btn btn-primary">Inscription</button>
							</div>
						</div>
					</form>
				</div>
			</div>

		</div>

		<%@ include file="include/footer.jsp"%>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>