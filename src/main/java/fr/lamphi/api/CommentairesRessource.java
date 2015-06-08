package fr.lamphi.api;

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
public class CommentairesRessource {
private static Map<Integer, Commentaires> commentaires = new HashMap<>();

	static{
		Commentaires com1= new Commentaires(1, 1, 1,"Commentaire de la mort","2015-06-08");
		Commentaires com2= new Commentaires(2, 1, 2,"Commentaire de la mort 2","2015-06-08");
		Commentaires com3= new Commentaires(3, 2, 1,"Commentaire de la mort 3","2015-06-08");
		Commentaires com4= new Commentaires(4, 2, 2,"Commentaire de la mort 4","2015-06-08");

		commentaires.put(com1.getId(), com1);
		commentaires.put(com2.getId(), com2);
		commentaires.put(com3.getId(), com3);
		commentaires.put(com4.getId(), com4);
		
	}
	
	@POST
	public Commentaires createCom(Commentaires com) {
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
	 
	
	protected List<Commentaires> getCommentsByLesson(int id){
		ArrayList<Commentaires> list = new ArrayList<Commentaires>();
		
		for(Entry<Integer, Commentaires> comments : commentaires.entrySet())
			if(comments.getValue().getIdLesson() == id)
				list.add(comments.getValue());
		
		return list;
	}
	
	@GET
	@Path("/{idLesson}")
	public List<Commentaires> getComments(@PathParam("idLesson") int id ) {
		return getCommentsByLesson(id);
	}
} 