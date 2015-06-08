<%@page import="org.eclipse.persistence.internal.oxm.record.json.JSONReader"%>
<%@page import="fr.lamphi.api.*"%>
<%@page import="java.util.List"%>
<%@page import="java.io.*"%>

<%@ include file="include/header.jsp"%>

<body>
	<%@ include file="include/navbar.jsp"%>


	<!-- Page Content -->
	<div class="container">
		<!-- Page Header -->
		<div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<h1>Inscription</h1>
				</div>
			</div>
		</div>
		<!-- /.row -->


		<!-- Projects Row -->
		<ul>

		</ul>
		<!-- /.row -->


		<form method='post' action='inscription'>
			<div class="form-group">
				<label for="inputNom" class="col-sm-2 control-label">Nom</label>
				<div class="col-sm-10">
					<input type="text" name="name" placeholder="Nom" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputNom" class="col-sm-2 control-label">Prenom</label>
				<div class="col-sm-10">
					<input type="text" name="surname" placeholder="Prenom" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputNom" class="col-sm-2 control-label">Pseudo</label>
				<div class="col-sm-10">
					<input type="text" name="pseudo" placeholder="Pseudo" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputNom" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<input type="mail" name="email" placeholder="Email" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputNom" class="col-sm-2 control-label">Mot de
					passe</label>
				<div class="col-sm-10">
					<input type="password" name="password" placeholder="Mot de passe"
						required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputNom" class="col-sm-2 control-label">Sexe </label>
				<div class="col-sm-10">
					<select name="sex" id="sex">
						<option value="Femme">Femme</option>
						<option value="Homme">Homme</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputNom" class="col-sm-2 control-label">Statut ? </label>
				<div class="col-sm-10">
					<select name="status" id="status">
						<option value="ens">Enseignant</option>
						<option value="etu">Etudiant</option>
					</select>
				</div>
			</div>
			<div class="form-group">
   				 <div class="col-sm-offset-2 col-sm-10">
     				 <button type="submit" class="btn btn-default">Inscription</button>
   				 </div>
  			</div>
		</form>




		<hr>
		<%@ include file="include/footer.jsp"%>

	</div>
	<!-- /.container -->



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>
