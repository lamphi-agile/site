<%@page import="fr.lamphi.api.category.*"%>
<%@page import="fr.lamphi.api.lesson.*"%>
<%@page import="fr.lamphi.api.user.*"%>
<%@page import="fr.lamphi.api.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Random"%>
<%@page import="java.io.*"%>
<%@page import="javax.ws.rs.WebApplicationException"%>

<%@ include file="include/header.jsp"%>

<body>
	<%@ include file="include/navbar.jsp"%>

	<%
		LessonDBRessource ressource = new LessonDBRessource();
	
		Category category = null;
	
		List<Lesson> lessons = null;
		if (request.getParameter("id") != null) {
			try {
				category = new CategoryDBRessource().getCategory(Integer.parseInt(request.getParameter("id")));
				lessons = ressource.getLessonsByCategory(Integer.parseInt(request.getParameter("id")));
			} catch (WebApplicationException e) {
				response.sendRedirect("404.jsp");
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	%>
	<!-- Page Content -->
	<div class="container">
		<!-- Page Header -->
		<div class="page-header" id="banner">
			<div class="row">
				<div class="col-md-8">
					<h1>Liste des cours de la catégorie <% out.print(category.getName()); %></h1>
				</div>
			</div>
		</div>

		<!-- Tables
      ================================================== -->
		<div class="bs-docs-section">

			<div class="row">
				<div class="col-lg-12">

					<h2>Liste des Cours</h2>
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
								<%
									for (Lesson lesson : lessons) {
								%>
								<tr>
									<td>
										<%
											out.print(lesson.getId());
										%>
									</td>
									<td><a href="lesson.jsp?id=<%out.print(lesson.getId());%>">
											<%
												out.print(lesson.getTitle());
											%>
									</a></td>
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
										<%
											out.print(lesson.getNote());
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
