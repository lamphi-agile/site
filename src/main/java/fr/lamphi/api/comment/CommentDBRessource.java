package fr.lamphi.api.comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.lamphi.api.App;

/** TODO **/
@Path("/commentdb")
@Produces(MediaType.APPLICATION_JSON)
public class CommentDBRessource {
	private static CommentDao dao = App.dbi.open(CommentDao.class);

	public CommentDBRessource () {
		try {
			dao.createLessonsTable();
		}
		catch (Exception e) {
			System.out.println("La table LESSONS existe déjà !");
		}
	}

	@POST
	public Comment createComment(Comment comment) {
		int id = dao.insert(comment.getId(), comment.getIdUser(),
				comment.getIdLesson(), comment.getMessage(),new Date(System.currentTimeMillis()).toString());
		
		comment.setId(id+1);
		return comment;
	}
	
	protected List<Comment> getCommentsByLesson(int id){
		ArrayList<Comment> list = new ArrayList<Comment>();
		
		for(Entry<Integer, Comment> comments : commentaires.entrySet())
			if(comments.getValue().getIdLesson() == id)
				list.add(comments.getValue());
		
		return list;
	}
	
	@GET
	@Path("/{idLesson}")
	public List<Comment> getComments(@PathParam("idLesson") int id ) {
		return getCommentsByLesson(id);
	}
}
