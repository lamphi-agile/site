<%@page import="fr.lamphi.api.category.CategoryDBRessource"%>
<%@page import="fr.lamphi.api.lesson.*"%>
<%@page import="fr.lamphi.api.user.*"%>
<%@page import="fr.lamphi.api.certification.*"%>
<%@page import="fr.lamphi.api.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Random"%>
<%@page import="java.io.*"%>
<%@page import="javax.ws.rs.WebApplicationException"%>

<%@ include file="include/header.jsp"%>

<body>
	<%@ include file="include/navbar.jsp"%>


	<!-- Page Content -->
	<div class="container">
		<!-- Page Header -->
		<div class="page-header" id="banner">
			<div class="row">
				<%
					if (request.getAttribute("alert") != null) {
				%>
				<div class="alert alert-danger" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Fermer">
						<span aria-hidden="true">&times;</span>
					</button>
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span>
					<%
						out.print(request.getAttribute("alert"));
					%>
				</div>
				<%
					}
				%>
				<div class="col-md-8">
					<h1>Les cours</h1>
				</div>
				<div class="col-md-2 col-md-offset-2">
					<p class="text-right">
						<a href="addlesson.jsp" class="btn btn-success"
							style="margin-top: 1.7em"><i class="fa fa-plus-square"></i>
							Ajouter un cours</a>
					</p>
				</div>
			</div>
		</div>

		<div class="bs-docs-section">

			<div class="row">
				<div class="col-sm-8">

					<h2>Liste des Cours</h2>
					<div class="bs-component">
						<table class="table table-striped table-hover ">
							<thead>
								<tr>
									<th>#</th>
									<th>Titre</th>
									<th>Catégorie</th>
									<th>Auteur</th>
									<th>Note</th>
									<th>Vues</th>
								</tr>
							</thead>
							<tbody>
								<%
									List<Lesson> lessons = new LessonDBRessource().getLessons(10);
									CategoryDBRessource cdbr = new CategoryDBRessource();
									CertficationDBRessource cdbressource = new CertficationDBRessource();

									for (Lesson lesson : lessons) {
								%>
								<tr>
									<td>
										<%
											out.print(lesson.getId());
										%>
									</td>
									<td>
									<a href="lesson.jsp?id=<%out.print(lesson.getId());%>"><%int nbCertifications = cdbressource.getNbCertfications(lesson.getId());
										if(nbCertifications > 1) {
											out.print("<i class=\"fa fa-certificate\"></i>");
										}%>
											<%
												out.print(lesson.getTitle());
											%>
									</a></td>
									<td>
										<%
											try {
													out.print("<a href='category.jsp?id="
															+ lesson.getCategory() + "'>"
															+ cdbr.getCategory(lesson.getCategory()).getName()
															+ "</a>");
												} catch (WebApplicationException e) {
													out.print("Aucune catégorie");
												}
										%>
									</td>
									<td>
										<%
											User lessonUser = lesson.getAuthor();
										%> <a href="profil.jsp?id=<%out.print(lessonUser.getId());%>">
											<img
											src="http://www.gravatar.com/avatar/<%out.print(MD5Util.md5Hex(lessonUser.getEmail()));%>?s=17" />
											<%
												out.print(lessonUser);
											%>
									</a>
									</td>
									<td>
										<span class="badge">
										<%
											out.print(lesson.getNote());
										%>
										 sur 5</span>
									</td>
									<td>
										<%
											out.print(lesson.getViews());
										%>
									</td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
					</div>
					<!-- /example -->
				</div>
				<div class="col-sm-4">

					<h2>Ca vous intéresse ?</h2>
					<div class="bs-component">
						<%
							List<Lesson> lessonsR = new LessonDBRessource().getLessons(10);
							Random rand = new Random();

							Lesson lessonR = lessonsR.get((int) rand.nextInt(lessonsR.size()));
						%>

						<div class="row">
							<div class="col-md-12">
								<div class="thumbnail">
									<img src="http://lorempicsum.com/futurama/350/200/1">
									<div class="caption">
										<h3><% out.print(lessonR.getTitle()); %></h3>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae dolor at magna dignissim convallis. Aenean eget felis nisl. Nullam maximus, erat eu luctus eleifend, orci ligula laoreet nulla, a volutpat augue neque at velit. Donec sit amet nullam. </p>
										<p>
											<a href="lesson.jsp?id=<%out.print(lessonR.getId());%>" class="btn btn-primary" role="button">Voir le cours</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

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
