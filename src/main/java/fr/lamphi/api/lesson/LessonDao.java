package fr.lamphi.api.lesson;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface LessonDao {
	@SqlUpdate("create table lessons(id integer primary key autoincrement, title text, content text, idauthor int, createddate datetime, category int, views int default 0, foreign key(idauthor) references users(id))")
	void createLessonsTable();

	@SqlUpdate("create table notes(lessonid int, userid int, rate float, ratedate datetime, primary key(lessonid,userid))")
	void createNotesTable();
	
	@SqlUpdate("replace into notes(lessonid, userid, rate,ratedate) values (:lessonid, :userid, :rate, date('now'))")
	@GetGeneratedKeys
	int insertNote(@Bind("lessonid") int lessonid, @Bind("userid") int userid, @Bind("rate") double rate);


	@SqlUpdate("insert into lessons (title, content, idauthor, createddate, category) values (:title, :content, :idauthor, date('now'), :category)")
	@GetGeneratedKeys
	int insert(@Bind("title") String title, @Bind("content") String content, @Bind("idauthor") int idUser, @Bind("category") int idCategoryord);

	@SqlQuery("select avg(rate) from notes where lessonid = :lessonid")
	double getNoteAverage(@Bind("lessonid") int lessonid);
	
	@SqlQuery("select avg(rate) from notes where lessonid = :lessonid and ratedate > date('now')-7")
	double getNoteWeekAverage(@Bind("lessonid") int lessonid);
	
	@SqlQuery("select *, (select avg(rate) from notes where lessonid = :id) as note from lessons where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
	Lesson findById(@Bind("id") int id);
	
	@SqlQuery("select *, (select avg(rate) from notes where lessonid = lesssons.id) from lessons where title like '%' || :keywords || '%'")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<Lesson> search(@Bind("keywords") String keywords);
	
	@SqlQuery("select *, (select avg(rate) from notes where lessonid = lessons.id) as note from lessons limit :limit")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<Lesson> getLessons(@Bind("limit") int limit);
	
	@SqlUpdate("update lessons set views=views+1 where id = :id")
	@GetGeneratedKeys
	int incrementViews(@Bind("id")int lessonid);

	@SqlUpdate("drop table if exists lessons")
	void dropLessonsTable(); 
	
	void close();

	@SqlQuery("select *, (select avg(rate) from notes where lessonid = lessons.id) from lessons where category = :categoryId")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<Lesson> getLessonsByCategory(@Bind("categoryId") int categoryId);
}