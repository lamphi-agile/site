package fr.lamphi.api.certification;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface CertficationDao {
	@SqlUpdate("create table certifications(id integer primary key autoincrement, userid int, lessonid int, foreign key(userid) references users(id), foreign key(lessonid) references lessons(id))")
	void createCertficationsTable();

	@SqlUpdate("insert into certifications(userid, lessonid) values (:userid, :lessonid)")
	@GetGeneratedKeys
	int certifiate(@Bind("userid") int userid, @Bind("lessonid") int lessonid);

	@SqlQuery("select count(*) from certifications where lessonid = :lessonid")
	int getNbCertificationsForLesson(@Bind("lessonid") int lessonid);
	
	@SqlQuery("select lessonid from certifications group by lessonid having count(lessonid) > 1")
	List<Integer> getCertifications();

	@SqlUpdate("drop table if exists certifications")
	void dropCertficationsTable(); 
	
	void close();
}