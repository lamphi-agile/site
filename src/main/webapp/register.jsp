<%@page
	import="org.eclipse.persistence.internal.oxm.record.json.JSONReader"%>
<%@page import="fr.lamphi.api.*"%>
<%@page import="java.util.List"%>
<%@page import="java.io.*"%>

<%@ include file="include/header.jsp"%>

<body>
	<%@ include file="include/navbar.jsp"%>


	<!-- Page Content -->
	<div class="container">
		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Inscription</h1>
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
				<label for="inputNom" class="col-sm-2 control-label">Mot de
					passe</label>
				<div class="col-sm-10">
					<input type="text" name="password" placeholder="Mot de passe"
						required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputNom" class="col-sm-2 control-label">Sexe</label>
				<div class="col-sm-10">
					<input type="text" name="sex" placeholder="Sexe" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputNom" class="col-sm-2 control-label">Quel
					est votre Statut ? </label>
				<div class="col-sm-10">
					<select name="status" id="status">
						<option value="Enseignant">Enseignant</option>
						<option value="Etudiant">Etudiant</option>
					</select>
				</div>
			</div>
			<input type="submit" value="Inscription">
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
