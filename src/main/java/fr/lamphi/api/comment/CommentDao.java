package fr.lamphi.api.comment;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import fr.lamphi.api.lesson.Lesson;

/** TODO **/
public interface CommentDao {
	@SqlUpdate("create table comments(id integer primary key autoincrement, userid int, message text, lessonid int, createddate datetime, foreign key(lessonid) references lessons(id), foreign key(userid) references users(id))")
	void createCommentsTable();

	@SqlUpdate("insert into comments (userid, message, lessonid, createddate) values (:userid, :message, :lessonid, date('now'))")
	@GetGeneratedKeys
	int insert(@Bind("userid") String userid, @Bind("message") String message, @Bind("lessonid") int lessonid);

	@SqlQuery("select * from comments where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
	Comment findById(@Bind("id") int id);
	
	@SqlQuery("select * from comments limit :limit")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<Comment> getComments(@Bind("limit") int limit);

	@SqlUpdate("drop table if exists comments")
	void dropCommentsTable(); 
	
	void close();
}
