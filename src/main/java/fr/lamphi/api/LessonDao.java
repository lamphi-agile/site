package fr.lamphi.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface LessonDao {
	@SqlUpdate("create table lessons(id integer primary key autoincrement, title text, content text, idauthor int, cptvalide int default 0, createddate datetime, category int, foreign key(idauthor) references users(id))")
	void createLessonsTable();

	@SqlUpdate("insert into lessons (title, content, idauthor, createddate, category) values (:title, :content, :idauthor, date('now'), :category)")
	@GetGeneratedKeys
	int insert(@Bind("title") String title, @Bind("content") String content, @Bind("idauthor") int idUser, @Bind("category") int idCategoryord);

	@SqlQuery("select * from lessons where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
	Lesson findById(@Bind("id") int id);
	
	@SqlQuery("select * from lessons limit :limit")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<Lesson> getLessons(@Bind("limit") int limit);

	@SqlUpdate("drop table if exists lessons")
	void dropLessonsTable(); 
	
	void close();
}
