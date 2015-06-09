package fr.lamphi.api.comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

@Path("/comment")
@Produces(MediaType.APPLICATION_JSON)
public class CommentRessource {
private static Map<Integer, Comment> commentaires = new HashMap<>();

	static{
		Comment com1= new Comment(1, 1, 1,"Commentaire de la mort","2015-06-08");
		Comment com2= new Comment(2, 1, 2,"Commentaire de la mort 2","2015-06-08");
		Comment com3= new Comment(3, 2, 1,"Commentaire de la mort 3","2015-06-08");
		Comment com4= new Comment(4, 2, 2,"Commentaire de la mort 4","2015-06-08");

		commentaires.put(com1.getId(), com1);
		commentaires.put(com2.getId(), com2);
		commentaires.put(com3.getId(), com3);
		commentaires.put(com4.getId(), com4);
		
	}
	
	@POST
	public Comment createCom(Comment com) {
		int id = commentaires.size();
		com.setId(id+1);
		commentaires.put(com.getId(), com);
		return com;
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteCom(@PathParam("id") Integer id) {
		if (commentaires.containsKey(id)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	} 
	 
	
	protected List<Comment> getCommentsByLesson(int id){
		ArrayList<Comment> list = new ArrayList<Comment>();
		
		for(Entry<Integer, Comment> comments : commentaires.entrySet())
			if(comments.getValue().getLessonid() == id)
				list.add(comments.getValue());
		
		return list;
	}
	
	@GET
	@Path("/{idLesson}")
	public List<Comment> getComments(@PathParam("idLesson") int id ) {
		return getCommentsByLesson(id);
	}
} 