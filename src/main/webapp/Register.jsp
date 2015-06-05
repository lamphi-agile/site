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
                <h1 class="page-header">Inscription </h1>
            </div>
        </div>
        <!-- /.row -->
        	
       
        <!-- Projects Row -->
       	<ul>
       		
       	</ul>
        <!-- /.row -->
        
       
        <form  method = 'post' action = 'inscription' >
        	<div class = "form-group">
        	<input type="text" name="name" placeholder="Nom" required>
        	<input type="text" name="surname" placeholder="Prenom"required>
        	<input type="text" name="pseudo" placeholder="Pseudo"required>
        	<input type="text" name="password" placeholder="Mot de Passe" required>
        	<input type="text" name="sex" placeholder="Sexe" required>
        	<input type="text" name="status" placeholder="Statut" required>    	
             
	        
	        <input type="submit" value="Inscription">
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

  </body>
</html>
