<%@page import="fr.lamphi.api.*"%>
<%@page import="javax.ws.rs.WebApplicationException"%>
<%@ include file="include/header.jsp"%>

<body>
	<%@ include file="include/navbar.jsp"%>


	<% 
    	User user = null; 
    	UserResource resource = new UserResource();
    	
    	if( request.getParameter("id") != null ){
    		try{
   			user = resource.getUser(Integer.parseInt(request.getParameter("id")));
    		}
    		catch(WebApplicationException e){
    			response.sendRedirect("404.jsp");
    		}
    	}else if(session.getAttribute("user") != null){
    		user = (User)session.getAttribute("user");
    	}else {
    		response.sendRedirect("index.jsp");
    	}
   	%>

	<!-- Page Content -->
	<div class="container">
		<div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<h1>
						<% out.print(user.getPseudo()); %>
					</h1>
				</div>
			</div>
		</div>

		<!-- Projects Row -->
		<ul>
			<% 
       		out.print("ID : "+user.getId());
       		%><br>
			<%
       		out.print("Name : "+user.getName());
       		%><br>
			<%
       		out.print("Surname : "+user.getSurname());
       		%><br>
			<%
       		out.print("Email : "+user.getEmail());
       		%><br>
			<%
       		out.print("Type  d'utilisateur : "+user.getStatus());
       		%><br>
			<%
       		out.print("Sexe : "+user.getSex());	
       		%>
		</ul>
		<!-- /.row -->




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
