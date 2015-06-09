<%@page import="fr.lamphi.api.lesson.*"%>
<%@page import="fr.lamphi.api.user.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Random"%>
<%@page import="java.io.*"%>

<%@ include file="include/header.jsp" %>

  <body>
	<%@ include file="include/navbar.jsp" %>
    

 	<!-- Page Content -->
    <div class="container">
    <!-- Page Header -->
        <div class="page-header" id="banner">
			<div class="row">
				<div class="col-md-8">
					<h1>Les cours</h1>
				</div>
				<div class="col-md-2 col-md-offset-2">
					<p class="text-right"><a href="addlesson.jsp" class="btn btn-success" style="margin-top:2em"><i class="fa fa-plus-square"></i>
				 Ajouter un cours</a></p>
				</div>
			</div>
		</div>

		<!-- Tables
      ================================================== -->
		<div class="bs-docs-section">

			<div class="row">
				<div class="col-lg-12">
				
				<h2>Ca vous intéresse ?</h2>
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
								<%List<Lesson> lessonsR = new LessonDBRessource().getLessons(10);
								Random rand = new Random();
								
								
                  					Lesson lessonR = lessonsR.get((int) rand.nextInt(lessonsR.size()));
                  				%>
								<tr>
									<td>
										<% out.print(lessonR.getId()); %>
									</td>
									<td>
										<a href="lesson.jsp?id=<%out.print(lessonR.getId());%>"><% out.print(lessonR.getTitle()); %></a>
									</td>
									<td>
										<% User lessonUserR = lessonR.getAuthor();%>
										<a href="profil.jsp?id=<%out.print(lessonUserR.getId());%>">
											<img src="http://www.gravatar.com/avatar/<%out.print(MD5Util.md5Hex(lessonUserR.getEmail()));%>?s=17"/>
											<% out.print(lessonUserR); %>
										</a>
									</td>
									<td>
										<% out.print(lessonR.getNote()); %>
									</td>
								</tr>
							
							</tbody>
						</table>
					</div>
				
				
				
				
				
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
								<%List<Lesson> lessons = new LessonDBRessource().getLessons(10);
                  					for(Lesson lesson : lessons) {%>
								<tr>
									<td>
										<% out.print(lesson.getId()); %>
									</td>
									<td>
										<a href="lesson.jsp?id=<%out.print(lesson.getId());%>"><% out.print(lesson.getTitle()); %></a>
									</td>
									<td>
										<% User lessonUser = lesson.getAuthor();%>
										<a href="profil.jsp?id=<%out.print(lessonUser.getId());%>">
											<img src="http://www.gravatar.com/avatar/<%out.print(MD5Util.md5Hex(lessonUser.getEmail()));%>?s=17"/>
											<% out.print(lessonUser); %>
										</a>
									</td>
									<td>
										<% out.print(lesson.getNote()); %>
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
