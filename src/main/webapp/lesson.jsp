<%@page import="fr.lamphi.api.*"%>
<%@page import="javax.ws.rs.WebApplicationException"%>
<%@ include file="include/header.jsp" %>

  <body>
	<%@ include file="include/navbar.jsp" %>
    	
    
    <% 
    	LessonRessource ressource = new LessonRessource(); 
   		Lesson lesson = null;
    	if( request.getParameter("id") != null ){
    		try{
   			lesson = ressource.getlesson(Integer.parseInt(request.getParameter("id")));
    		}
    		catch(WebApplicationException e){
    			response.sendRedirect("404.jsp");
    		}
    	}else{
    		response.sendRedirect("index.jsp");
    	}
   	%>

 	<!-- Page Content -->
    <div class="container">
      <!-- Page Header -->
        <div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<h1><% out.print(lesson.getTitle()); %> <small><% out.print(lesson.getAuthor()); %></small></h1>
				</div>
			</div>
		</div>

		<!-- Tables
      ================================================== -->
		<div class="bs-docs-section">

			<div class="row">
				<div class="col-lg-12">
					<% out.print(lesson.getContenu()); %>
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
