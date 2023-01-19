package Com.RequrmentsProject.Repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Com.RequrmentsProject.Entity.AdditionalPerk;
import Com.RequrmentsProject.Entity.PostPerk;

public interface PostPerkRepo extends JpaRepository<PostPerk, String> {
	
//	@Query("select p from PostPerk p where p.postperkId=:postperkId")
//	PostPerk findbyperkId(@Param("postperkId") String postperkId);
	
	@Query("select P From PostPerk v,AdditionalPerk P WHERE v.additionalPerkId=P.additionalPerkId AND v.postId=:postId")
	
	  List<AdditionalPerk> findAllPostPerkByPostId(@Param("postId") String postId);

}
