package fr.lamphi.api.comment;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.lamphi.api.App;
import fr.lamphi.api.user.User;

/** TODO **/
@Path("/commentdb")
@Produces(MediaType.APPLICATION_JSON)
public class CommentDBRessource {
	private static CommentDao dao = App.dbi.open(CommentDao.class);

	public CommentDBRessource () {
		try {
			dao.createCommentsTable();
			
			Comment com1= new Comment(0, 1, 1,"Commentaire de la mort","2015-06-08");
			Comment com2= new Comment(0, 1, 2,"Commentaire de la mort 2","2015-06-08");
			Comment com3= new Comment(0, 2, 1,"Commentaire de la mort 3","2015-06-08");
			Comment com4= new Comment(0, 2, 2,"Commentaire de la mort 4","2015-06-08");
			
			createComment(com1);
			createComment(com2);
			createComment(com3);
			createComment(com4);
		}
		catch (Exception e) {
		}
	}

	@POST 
	public Comment createComment(Comment comment) {
		int id = dao.insert(comment.getUserid(),
				comment.getLessonid(), comment.getMessage());
		
		comment.setId(id+1);
		return comment;
	}
	
	@GET
	@Path("/{idLesson}")
	public List<Comment> getCommentsByLesson(@PathParam("idLesson") int id ) {
		return dao.getCommentsByLesson(id);
	}
	
	@GET
	public List<Comment> getComments(@QueryParam("id") int id) {
		return dao.getCommentsByLesson(id);
	}
}
