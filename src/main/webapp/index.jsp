<%@page import="org.eclipse.persistence.internal.oxm.record.json.JSONReader"%>
<%@page import="fr.lamphi.api.*"%>
<%@page import="java.util.List"%>
<%@page import="java.io.*"%>

<%@ include file="include/header.jsp" %>

  <body>
	<%@ include file="include/navbar.jsp" %>
    

 	<!-- Page Content -->
    <div class="container">
    <!-- Page Header -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Liste des cours  <% out.println("Coucou les gars"); %>
                </h1>
            </div>
        </div>
        
       
        
        <!-- /.row -->
       <% List<Lesson> lessons = new LessonRessource().getlessons(10); %>
        <!-- Projects Row -->
       	<ul>
       		<% for(Lesson lesson : lessons){ 
       			out.print("<li>"+lesson.getTitle()+"</li>"); 
       		} %>
       	</ul>
        <!-- /.row -->

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
