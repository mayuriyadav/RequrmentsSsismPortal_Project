package Com.RequrmentsProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Com.RequrmentsProject.Entity.Skills;



public interface SkillsRepo extends JpaRepository<Skills, String> {

	@Query("Select S from Skills S Where S.skillId=:skillId")
	Skills getbyskillId(@Param("skillId") String skilId);

}
