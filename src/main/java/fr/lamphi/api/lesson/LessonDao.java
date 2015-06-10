package fr.lamphi.api.lesson;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface LessonDao {
	@SqlUpdate("create table lessons(id integer primary key autoincrement, title text, content text, idauthor int, createddate datetime, category int, note double default 0, views int default 0, foreign key(idauthor) references users(id))")
	void createLessonsTable();
	@SqlUpdate("create table lessons(id integer primary key autoincrement, title text, content text, idauthor int, createddate datetime, category int, note double default 0, foreign key(idauthor) references users(id))")
	void createNotesTable();

	@SqlUpdate("insert into lessons (title, content, idauthor, createddate, category) values (:title, :content, :idauthor, date('now'), :category)")
	@GetGeneratedKeys
	int insert(@Bind("title") String title, @Bind("content") String content, @Bind("idauthor") int idUser, @Bind("category") int idCategoryord);

	@SqlQuery("select * from lessons where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
	Lesson findById(@Bind("id") int id);
	
	@SqlQuery("select * from lessons where title like '%' || :keywords || '%'")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<Lesson> search(@Bind("keywords") String keywords);
	
	@SqlQuery("select * from lessons limit :limit")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<Lesson> getLessons(@Bind("limit") int limit);
	
	@SqlUpdate("update lessons set views=views+1 where id = :id")
	@GetGeneratedKeys
	int incrementViews(@Bind("id")int lessonid);

	@SqlUpdate("drop table if exists lessons")
	void dropLessonsTable(); 
	
	void close();

	@SqlQuery("select * from lessons where category = :categoryId")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<Lesson> getLessonsByCategory(@Bind("categoryId") int categoryId);
}