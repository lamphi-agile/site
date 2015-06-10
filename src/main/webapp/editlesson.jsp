<%@page import="fr.lamphi.api.category.CategoryDBRessource"%>
<%@page import="fr.lamphi.api.lesson.*"%>
<%@page import="fr.lamphi.api.category.*"%>
<%@page import="fr.lamphi.api.user.*"%>
<%@page import="fr.lamphi.api.certification.*"%>
<%@page import="fr.lamphi.api.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Random"%>
<%@page import="java.io.*"%>
<%@page import="javax.ws.rs.WebApplicationException"%>

<%
	LessonDBRessource ressource = new LessonDBRessource();
	User currentUser = (User) session.getAttribute("user");
	Lesson lesson = null;
	if (currentUser != null) {
		try {
			lesson = ressource.getLesson(Integer.parseInt(request
					.getParameter("id")));
		} catch (WebApplicationException e) {
			response.sendRedirect("404.jsp");
		}
	} else {
		response.sendRedirect("index.jsp");
	}
	
	if (currentUser.getId() != lesson.getIdAuthor()) {
		response.sendRedirect("index.jsp");
	}
	
	session.setAttribute("lessonUpdateId", lesson.getId());
%>
<%@ include file="include/header.jsp"%>

<body>
	<%@ include file="include/navbar.jsp"%>

	<!-- Page Content -->
	<div class="container">
		<!-- Page Header -->
		<div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<h1>Modifier un cours</h1>
				</div>
			</div>
		</div>

		<form method="post" action="/EditLesson">
			<div class="form-group">
				<label for="inputTitle">Titre</label> <input type="text"
					name="title" class="form-control" id="inputTitle"
					value="<% out.print(lesson.getTitle()); %>" placeholder="Titre">
			</div>
			<div class="form-group">
				<label for="inputTitle">Catégorie</label> <select
					class="form-control" name="category">
					<%
				List<Category> categories = new CategoryDBRessource().getCategories(50);
				
				for(Category category : categories){
				%>
					<option value="<% out.print(category.getId()); %>">
						<% out.print(category.getName()); %>
					</option>
					<% } %>
				</select>
			</div>

			<div class="form-group">
				<label for="inputContenu">Contenu</label>
				<textarea name="contenu" id="contenu" class="form-control" rows="3">
					<% out.print(lesson.getContent()); %>
				</textarea>
			</div>
			<button type="submit" class="btn btn-default">Modifier</button>
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


	<script type="text/javascript"
		src="http://lab.lepture.com/editor/editor.js"></script>
	<script type="text/javascript"
		src="http://lab.lepture.com/editor/marked.js"></script>

	<script type="text/javascript">
		new Editor({
			element : document.getElementById('contenu')
		});
	</script>

</body>
</html>
