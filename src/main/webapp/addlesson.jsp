<%if(session.getAttribute("user") == null) {
	request.setAttribute("alert", "Vous devez être authentifié pour pouvoir ajouter un cours");
	request.getRequestDispatcher("index.jsp").forward(request, response);
	return;
}
	%>
<%@ include file="include/header.jsp" %>

  <body>
	<%@ include file="include/navbar.jsp" %>
    
 	<!-- Page Content -->
    <div class="container">
    <!-- Page Header -->
        <div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<h1>Ajouter un cours</h1>
				</div>
			</div>
		</div>

		<form method="post" action="/AddLesson">
		  <div class="form-group">
		    <label for="inputTitle">Titre</label>
		    <input type="text" name="title" class="form-control" id="inputTitle" placeholder="Titre">
		  </div>
		  <div class="form-group">
		    <label for="inputContenu">Contenu</label>
		    <textarea name="contenu" id="contenu" class="form-control" rows="3"></textarea>
		  </div>
		  <button type="submit" class="btn btn-default">Soumettre</button>
		</form>
		
	<hr>
		<%@ include file="include/footer.jsp" %>
       
    </div>
    <!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

	
<script type="text/javascript" src="http://lab.lepture.com/editor/editor.js"></script>
<script type="text/javascript" src="http://lab.lepture.com/editor/marked.js"></script>

    <script type="text/javascript">
    new Editor({
    	  element: document.getElementById('contenu')
    	})
    </script>

  </body>
</html>
