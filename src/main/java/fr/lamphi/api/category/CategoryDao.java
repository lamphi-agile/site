package fr.lamphi.api.category;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import fr.lamphi.api.lesson.Lesson;

/** TODO **/
public interface CategoryDao {
	@SqlUpdate("create table categories(id integer primary key autoincrement, name text, image text, parentid int, foreign key(parentid) references categories(id))")
	void createCategoriesTable();

	@SqlUpdate("insert into categories (name, image, parentid) values (:name, :image, :parentid)")
	@GetGeneratedKeys
	int insert(@Bind("name") String name, @Bind("image") String image, @Bind("parentid") int idparent);

	@SqlQuery("select * from categories where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
	Category findById(@Bind("id") int id);
	
	@SqlQuery("select * from categories limit :limit")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<Category> getCategories(@Bind("limit") int limit);

	@SqlUpdate("drop table if exists categories")
	void dropCategoryTable(); 
	
	void close();
}
