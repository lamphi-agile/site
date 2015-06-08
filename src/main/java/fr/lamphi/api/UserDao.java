package fr.lamphi.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface UserDao {
	@SqlUpdate("create table users(id integer primary key autoincrement, name varchar(100), forname varchar(100), email varchar(100), username varchar(100), password varchar(100), sex varchar(1), status varchar(3), create_date datetime)")
	void createUserTable();

	@SqlUpdate("insert into users (name, forname, email, username, password, sex, status) values (:name, :forname, :email, :username, :password, :sex, :status)")
	@GetGeneratedKeys
	int insert(@Bind("name") String name, @Bind("forname") String forname, @Bind("email") String email, @Bind("username") String username, @Bind("password") String password, @Bind("sex") String sex, @Bind("status") String status);

	@SqlQuery("select * from users where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
	User findById(@Bind("id") int id);
	
	@SqlQuery("select * from users limit :limit")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<User> getUsers(@Bind("limit") int limit);

	@SqlUpdate("drop table if exists users")
	void dropUserTable(); 
	
	void close();
}
