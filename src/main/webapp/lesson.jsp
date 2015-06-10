<%@page import="fr.lamphi.api.certification.CertficationDBRessource"%>
<%@page import="java.util.List"%>
<%@page import="fr.lamphi.api.*"%>
<%@page import="fr.lamphi.api.lesson.*"%>
<%@page import="fr.lamphi.api.comment.Comment"%>
<%@page import="fr.lamphi.api.comment.CommentDBRessource"%>
<%@page import="fr.lamphi.api.user.*"%>
<%@page import="javax.ws.rs.WebApplicationException"%>

<%@ include file="include/header.jsp"%>

<body>
	<%@ include file="include/navbar.jsp"%>


	<%
		LessonDBRessource ressource = new LessonDBRessource();
		CommentDBRessource cr = new CommentDBRessource();
		CertficationDBRessource cdbressource = new CertficationDBRessource();
		User currentUser = (User)session.getAttribute("user");
		Lesson lesson = null;
		List<Comment> comments = null;
		if (request.getParameter("id") != null) {
			try {
				lesson = ressource.getLesson(Integer.parseInt(request
						.getParameter("id")));
				ressource.incrementViews(lesson);
				comments = cr.getComments(lesson.getId());
			} catch (WebApplicationException e) {
				response.sendRedirect("404.jsp");
			}
		} else {
			response.sendRedirect("index.jsp");
		}	
		if(request.getParameter("certifiate") != null) {
			cdbressource.certifiate((User)session.getAttribute("user"), lesson);
		}
	%>

	<!-- Page Content -->
	<div class="container">
		<!-- Page Header -->
		<div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<h1>
						<%
						int nbcertifications = cdbressource.getNbCertfications(lesson.getId());
							if(nbcertifications > 1) {%>
								<i class="fa fa-certificate"></i>
						<%	}
							out.print(" "+lesson.getTitle());
						%>
						<small> <%
 								out.print(lesson.getAuthor());
 						%>
						</small>				
					</h1>
					<small>
					<%
					if(nbcertifications == 0) {
						out.print("Ce cours n'a pas �t� certifi�");
					} else {
						out.print("Ce cours a �t� certifi� " + nbcertifications+ " fois");
					}
					%>
					- <%out.print(lesson.getViews()); %> vues
					</small>		
				</div>
				<% if(currentUser != null && currentUser.getStatus().equals("ens")) { %>
				<div class="col-md-2 col-md-offset-2">
					<p class="text-right"><a class="btn btn-success" href="lesson.jsp?id=<%out.print(request.getParameter("id"));%>&certifiate=1" style="margin-top:2em"><i class="fa fa-certificate"></i>
				Certifi�</a></p>
				
				</div>
				<%} %>
			</div>
		</div>

		<div class="bs-docs-section">

			<div class="row">
				<div class="col-lg-12">
					<div id="contenu">
<% out.print(lesson.getContent()); %>
					</div>
				</div>

				<input id="inputRating" class="rating" data-symbol="&#xf19d;"
					data-glyphicon="false" data-rating-class="rating-fa"> <a
					href="http://www.facebook.com/share.php?u=http://localhost:8080/lesson.jsp?id=<% out.print(lesson.getId()); %>" target="_blank"> <img
					src="img/facebook.png" alt="facebook" width="50px" heigth="50px" />
				</a> <a href="https://twitter.com/intent/tweet?text=<% out.print("Je viens de lire un super cours sur @lamphi http://localhost:8080/lesson.jsp?id="+lesson.getId()); %>" target="_blank"> <img
					src="img/twitter.png" alt="twitter" width="50px" heigth="50px" />
				</a> <a href=" http://www.google.com/intl/fr/+/learnmore/"
					target="_blank"> <img src="img/gmail.png" alt="googleplus"
					width="50px" heigth="50px" />
				</a> <a href=" http://www.linkedin.com" target="_blank"> <img
					src="img/linkedin.png" alt="linkedin" width="50px" heigth="50px" />
				</a>
				<hr>

				<form action="AddComment" method="post">
					<input type="hidden" name="idLesson"
						value="<%out.print(lesson.getId());%>">
					<textarea name="comment" class="form-control" rows="3"
						style="resize: none;"></textarea>
					<button class="btn btn-primary" type="submit">Ajouter</button>
				</form>

				<%
					for (Comment comment : comments) {
						try{
							
						User commentUser = new UserDBResource().getUser(comment.getUserid());
						
						out.println("<div class='media'>");
						out.println(" <div class='media-left'>");
						out.println("  <img class='media-object' src='http://www.gravatar.com/avatar/"
								+ MD5Util.md5Hex(commentUser.getEmail()) + ";?s=64'/>");
						out.println(" </div>");
						out.println("<div class='media-body'>");
						out.println("<h4 class='media-heading'>"
								+ commentUser.getName() + " "
								+ commentUser.getSurname() + "</h4>");
						out.print(comment.getMessage());
						out.println("</div>");
						out.println("</div>");
						}
						catch(WebApplicationException e){
							out.println("<div class='alert alert-warning' role='alert'>L'utilisateur est introuvable. Le commentaire n'est donc pas affich�.</div>");
						}
					}
				%>
			</div>
			
				
		</div>
		<%@ include file="include/footer.jsp"%>

	</div>
	<!-- /.container -->



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/star-rating.js" type="text/javascript"></script>


	<script type="text/javascript"
		src="http://lab.lepture.com/editor/editor.js"></script>
	<script type="text/javascript"
		src="http://lab.lepture.com/editor/marked.js"></script>


	<script type="text/javascript">
		document.getElementById('contenu').innerHTML =
	      marked(document.getElementById('contenu').textContent);
	</script>
	
	<script type="text/javascript">
		$("#inputRating").rating({
			min : 0,
			max : 5,
			step : 0.5,
			size : "xs",
			defaultCaption : "{rating} sur 5",
			clearCaption : "Non Evalu�",
			showClear : false,
			starCaptions : {}
		});

		$('#inputRating').rating('update', <% out.print(lesson.getNote()); %>);

		$('#inputRating').on('rating.change', function(event, value, caption) {
			console.log(value);
			console.log(caption);
		});
		
	</script>
	<script type="text/javascript">	
		function ajouter(){
			lesson.setCptValue(lesson.getCptValue+1);
		}
	</script>
	
	
	


</body>
</html>
