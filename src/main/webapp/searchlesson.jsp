<%@page import="fr.lamphi.api.lesson.*"%>
<%@page import="fr.lamphi.api.user.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Random"%>
<%@page import="java.io.*"%>

<%@ include file="include/header.jsp"%>
<%
	String keywords = request.getParameter("keywords");
	if (keywords == null) {
		response.sendRedirect("index.jsp");
	}
	List<Lesson> lessons = new LessonDBRessource().search(keywords);
%>

<body>
	<%@ include file="include/navbar.jsp"%>


	<!-- Page Content -->
	<div class="container">
		<!-- Page Header -->
		<div class="page-header" id="banner">
			<div class="row">
				<%
					if (lessons.size() == 0) {
				%>
				<div class="alert alert-warning" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Fermer">
						<span aria-hidden="true">&times;</span>
					</button>
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span>
					Aucun résultat n'a été trouvé
				</div>
				<%
					} else { %>
				<div class="alert alert-info" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Fermer">
						<span aria-hidden="true">&times;</span>
					</button>
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span>
					<%out.print(lessons.size()); %> résultat(s) trouvé(s)
				</div>		
				<%
					}
				%>
				<div class="col-md-8">
					<h1>
						Recherche de cours <small>"<%
						out.print(keywords);
					%>"
						</small>
					</h1>
				</div>
			</div>
		</div>

		<!-- Tables
      ================================================== -->
		<div class="bs-docs-section">
			<div class="row">
				<div class="col-lg-12">
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
