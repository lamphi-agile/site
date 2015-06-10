<%@page import="fr.lamphi.api.category.*"%>
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

					<%
						CategoryDBRessource cdbr = new CategoryDBRessource();
						List<Category> categories = cdbr.getCategories(100);
						int i = 0;
						for (Category category : categories) {
							if ((i % 3 == 0 && i != 0) || (i > categories.size())) {
								out.println("</div>");
							}

							if (i % 3 == 0 && i != categories.size()) {
								out.println("<div class='row'>");
							}
					%>

					<div class="col-sm-4">
						<a href="category.jsp?id=<%out.print(category.getId());%>">
							<div class="thumbnail">
								<img src="<%out.print(category.getImage());%>"
									alt="<%out.print(category.getName());%>"
									style="width: 250px; height: 100px">
								<div class="caption">
									<h3>
										<%
											out.print(category.getName());
										%>
									</h3>
								</div>
							</div>
						</a>
					</div>

					<%
						i++;
							if (i == categories.size()) {
								out.println("</div>");
							}

						}
					%>
				</div>
				<div class="col-sm-4">

					<h2>Ça vous intéresse ?</h2>
					<div class="bs-component">
						<%
							List<Lesson> lessonsR = new LessonDBRessource().getLessons(10);
							Random rand = new Random();

							Lesson lessonR = lessonsR.get((int) rand.nextInt(lessonsR.size()));
						%>
						<div class="thumbnail">
							<div class="caption">
								<h3>
									<%
										out.print(lessonR.getTitle());
									%>
									<small> <%
 	out.print(lessonR.getAuthor().getSurname() + " "
 			+ lessonR.getAuthor().getName());
 %>
									</small>
								</h3>
								<a href="lesson.jsp?id=<%out.print(lessonR.getId());%>"
									class="btn btn-primary" role="button">Voir le cours</a>
							</div>
						</div>
					</div>
					<h2>Stats</h2>
					<div class="bs-component">
						<%
							UserDBResource usdbressource = new UserDBResource();
							LessonDBRessource lessonRessource = new LessonDBRessource();
							CertficationDBRessource cdbressource = new CertficationDBRessource();
						%><div class="thumbnail">
							<div class="caption">
								Cours <span class="badge"> <%
 	out.print(lessonRessource.getNbOfLessons());
 %>
								</span> Cours certifiés <span class="badge"> <%
 	out.print(cdbressource.getNbCertifications());
 %>
								</span> Utilisateurs <span class="badge"> <%
 	out.print(usdbressource.getNbOfUsers());
 %>
								</span>
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
