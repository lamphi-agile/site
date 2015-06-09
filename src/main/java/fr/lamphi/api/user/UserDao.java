package fr.lamphi.api.user;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface UserDao {
	@SqlUpdate("create table users(id integer primary key autoincrement, name text, surname text, email text, pseudo text, password text, sex text, status text, create_date datetime)")
	void createUserTable();

	@SqlUpdate("insert into users (name, surname, email, pseudo, password, sex, status) values (:name, :surname, :email, :pseudo, :password, :sex, :status)")
	@GetGeneratedKeys
	int insert(@Bind("name") String name, @Bind("surname") String surname, @Bind("email") String email, @Bind("pseudo") String pseudo, @Bind("password") String password, @Bind("sex") String sex, @Bind("status") String status);

	@SqlQuery("select * from users where id = :id limit 1")
    @RegisterMapperFactory(BeanMapperFactory.class)
	User findById(@Bind("id") int id);
	
	@SqlQuery("select * from users where pseudo = :username and password = :password")
    @RegisterMapperFactory(BeanMapperFactory.class)
	User findByLoginPassword(@Bind("username") String username, @Bind("password") String password);
	
	@SqlQuery("select * from users limit :limit")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<User> getUsers(@Bind("limit") int limit);

	@SqlUpdate("drop table if exists users")
	void dropUserTable(); 
	
	void close();
}
