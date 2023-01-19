package Com.RequrmentsProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Com.RequrmentsProject.Entity.JobCity;

public interface JobCityRepo extends JpaRepository<JobCity , String> {

	@Query("select j From JobCity j WHERE j.jobcityId=:c")
	
    public JobCity findbyjobcityId(@Param("c")String jobcityId);
}
