<%@page import="fr.lamphi.api.*"%>
<%@page import="javax.ws.rs.WebApplicationException"%>
<%@ include file="include/header.jsp" %>
    <link rel="stylesheet"  href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/star-rating.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="/js/star-rating.js" type="text/javascript"></script>
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
				<input id="input-2d" class="rating" min="0" max="5" step="0.5" data-size="sm"
           		data-symbol="&#xf19d;" data-glyphicon="false" data-rating-class="rating-fa" data-default-caption="{rating} sur 5" data-star-captions="{}">
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
    <script>
    jQuery(document).ready(function () {
        $("#input-21f").rating({
            starCaptions: function(val) {
                if (val < 3) {
                    return val;
                } else {
                    return 'high';
                }
            },
            starCaptionClasses: function(val) {
                if (val < 3) {
                    return 'label label-danger';
                } else {
                    return 'label label-success';
                }
            },
            hoverOnClear: false
        });
        
        $('#rating-input').rating({
              min: 0,
              max: 5,
              step: 1,
              size: 'lg',
              showClear: false
           });
           
        $('#btn-rating-input').on('click', function() {
            $('#rating-input').rating('refresh', {
                showClear:true, 
                disabled:true
            });
        });
        
        
        $('.btn-danger').on('click', function() {
            $("#kartik").rating('destroy');
        });
        
        $('.btn-success').on('click', function() {
            $("#kartik").rating('create');
        });
        
        $('#rating-input').on('rating.change', function() {
            alert($('#rating-input').val());
        });
        
        
        $('.rb-rating').rating({'showCaption':true, 'stars':'3', 'min':'0', 'max':'3', 'step':'1', 'size':'xs', 'starCaptions': {0:'status:nix', 1:'status:wackelt', 2:'status:geht', 3:'status:laeuft'}});
    });
</script>
   
  </body>
</html>
