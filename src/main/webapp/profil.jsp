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
					<h1>Profil <img src="http://www.gravatar.com/avatar/<%out.print(MD5Util.md5Hex(user.getEmail()));%>?s=40"/>   <small><% out.print(user.getPseudo()); %></small></h1>
				</div>
			</div>
		</div>
		<!-- Projects Row -->
		<ul>
			<li><% out.print("ID : "+user.getId()); %></li>
			<li><% out.print("Name : "+user.getName());%></li>
			<li><% out.print("Surname : "+user.getSurname());%></li>
			<li><% out.print("Email : "+user.getEmail());%></li>
			<li><% out.print("Type  d'utilisateur : "+user.getStatus());%></li>
			<li><% out.print("Sexe : "+user.getSex());%></li>
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
