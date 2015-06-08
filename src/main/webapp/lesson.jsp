<%@page import="fr.lamphi.api.*"%>
<%@page import="javax.ws.rs.WebApplicationException"%>

<%@ include file="include/header.jsp"%>


<body>
	<%@ include file="include/navbar.jsp"%>


	<%
		LessonRessource ressource = new LessonRessource();
		Lesson lesson = null;
		if (request.getParameter("id") != null) {
			try {
				lesson = ressource.getlesson(Integer.parseInt(request
						.getParameter("id")));
			} catch (WebApplicationException e) {
				response.sendRedirect("404.jsp");
			}
		} else {
			response.sendRedirect("index.jsp");
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
							out.print(lesson.getTitle());
						%>
						<small>
							<%
								out.print(lesson.getAuthor());
							%>
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
					<div id="contenu">
						<%
							out.print(lesson.getContenu());
						%>
					</div>
				</div>
				<input id="inputRating" class="rating" data-symbol="&#xf19d;" data-glyphicon="false" data-rating-class="rating-fa">
				<a href=" http://www.facebook.com" target="_blank">
					<img src="img/facebook.png"  alt="facebook" width = "50px" heigth = "50px"/>
				</a> 
				<a href=" http://www.twitter.com" target="_blank">
					<img src="img/twitter.png"  alt="twitter" width = "50px" heigth = "50px"/>
				</a> 
				<a href=" http://www.google.com/intl/fr/+/learnmore/" target="_blank">
					<img src="img/gmail.png"  alt="googleplus" width = "50px" heigth = "50px"/>
				</a> 
				<a href=" http://www.linkedin.com" target="_blank">
					<img src="img/linkedin.png"  alt="linkedin" width = "50px" heigth = "50px"/>
				</a> 
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
	<script src="js/star-rating.js" type="text/javascript"></script>


	<script type="text/javascript"
		src="http://lab.lepture.com/editor/editor.js"></script>
	<script type="text/javascript"
		src="http://lab.lepture.com/editor/marked.js"></script>

	<script type="text/javascript">
		$("#inputRating").rating({
			min: 0,
            max: 5,
            step: 0.5,
            size: "sm",
            symbol:"&#xf19d;",
            glyphicon:false,
            ratingClass:"rating-fa",
			defaultCaption:"{rating} sur 5",
			starCaptions : {}
		});
		
	    $('#inputRating').rating('update', 2.6);
	
	    $('#inputRating').on('rating.change', function(event, value, caption) {
	        console.log(value);
	        console.log(caption);
   		});

	</script>
	

</body>
</html>
