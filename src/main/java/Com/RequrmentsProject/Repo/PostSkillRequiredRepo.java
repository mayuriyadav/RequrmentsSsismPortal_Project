package Com.RequrmentsProject.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Com.RequrmentsProject.Entity.PostSkillRequired;
import Com.RequrmentsProject.Entity.Skills;


public interface PostSkillRequiredRepo extends JpaRepository<PostSkillRequired, String>{
	
	@Query("select P From PostSkillRequired v,Skills P WHERE v.skillId=P.skillId AND v.postId=:postId")
	
	  List<Skills> findAllPostSkillByPostId(@Param("postId") String postId);
	

}
