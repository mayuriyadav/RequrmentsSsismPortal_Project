package Com.RequrmentsProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Com.RequrmentsProject.Entity.Compensation;

public interface CompensationRepo extends JpaRepository<Compensation, String>{
	
	@Query("select C From Compensation C WHERE C.compensationId=:v")

    public Compensation findbycompensationId(@Param("v")String compensationId);}
