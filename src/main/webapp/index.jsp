<%@page import="fr.lamphi.api.LessonRessource"%>
<%@page import="fr.lamphi.api.Lesson"%>
<%@page import="java.util.List"%>
<<<<<<< HEAD
<%@page import="java.io.*"%>
=======
>>>>>>> branch 'master' of https://github.com/lamphi-agile/site.git

<%@ include file="include/header.jsp" %>

  <body>
	<%@ include file="include/navbar.jsp" %>
    

 	<!-- Page Content -->
    <div class="container">
    <!-- Page Header -->
        <div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<h1>Les cours</h1>
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
								<%List<Lesson> lessons = new LessonRessource().getlessons(10);
                  					for(Lesson lesson : lessons) {%>
								<tr>
									<td>
										<% out.print(lesson.getId()); %>
									</td>
									<td>
										<a href="lesson.jsp?id=<%out.print(lesson.getId());%>"><% out.print(lesson.getTitle()); %></a>
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

        <hr>
		<%@ include file="include/footer.jsp" %>
       
    </div>
    <!-- /.container -->



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>
