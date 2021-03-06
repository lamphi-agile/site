package fr.lamphi.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.filter.LoggingFilter;
import org.skife.jdbi.v2.DBI;
import org.sqlite.SQLiteDataSource;

import fr.lamphi.api.comment.CommentDBRessource;
import fr.lamphi.api.comment.CommentRessource;
import fr.lamphi.api.lesson.LessonDBRessource;
import fr.lamphi.api.lesson.LessonRessource;
import fr.lamphi.api.user.UserDBResource;
import fr.lamphi.api.user.UserResource;

@ApplicationPath("/v1/")
public class App extends Application {
    @Override
    public Set<Class<?>> getClasses() {
    	Set<Class<?>> s = new HashSet<Class<?>>();
    	s.add(UserResource.class);
    	s.add(LessonRessource.class);
    	s.add(CommentRessource.class);
    	s.add(LoggingFilter.class);
    	s.add(UserDBResource.class);
    	s.add(LessonDBRessource.class);
    	s.add(CommentDBRessource.class);
    	return s;
    }
    
    public static DBI dbi;
	static {
		SQLiteDataSource ds = new SQLiteDataSource();
		ds.setUrl("jdbc:sqlite:"+System.getProperty("java.io.tmpdir")+System.getProperty("file.separator")+"data.db");
		dbi = new DBI(ds);
		System.out.println("jdbi : "+"jdbc:sqlite:"+System.getProperty("java.io.tmpdir")+System.getProperty("file.separator")+"data.db");
    }
}
