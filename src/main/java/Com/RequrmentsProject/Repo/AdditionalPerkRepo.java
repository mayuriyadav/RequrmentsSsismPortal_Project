package Com.RequrmentsProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Com.RequrmentsProject.Entity.AdditionalPerk;




public interface AdditionalPerkRepo extends JpaRepository<AdditionalPerk, String> {

	@Query("SELECT A FROM AdditionalPerk A WHERE A.additionalPerkId =:additionalPerkId")
	
	AdditionalPerk findByAddperkid(@Param("additionalPerkId") String additionalPerkId);

}
