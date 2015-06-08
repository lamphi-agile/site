<%@page import="fr.lamphi.api.LessonDivisionRessource"%>
<%@page import="fr.lamphi.api.LessonDivision"%>
<%@page import="java.util.List"%>
<%@page import="java.io.*"%>

<%@ include file="include/header.jsp" %>

  <body>
	<%@ include file="include/navbar.jsp" %>
    

 	<!-- Page Content -->
    <div class="container">
    <!-- Page Header -->
        <div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<h1>Les Catégories</h1>
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
									<th>Categorie</th>									
								</tr>
							</thead>
							<tbody>
								<%List<LessonDivision> lessondiv= new LessonDivisionRessource().getListLessonDiv(10);
                  					for(LessonDivision lesson : lessondiv) {%>
								<tr>									
									</td>
									<td>
										<a href="lesson.jsp?id=<%out.print(lesson.getId());%>"><% out.print(lesson.getCategory()); %></a>
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
