package Com.RequrmentsProject.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Com.RequrmentsProject.Entity.Createpost;
import Com.RequrmentsProject.payloads.CreatepostDto;

public interface CreatepostRepo  extends JpaRepository<Createpost, String>{


	@Query("select C From Createpost C WHERE C.postId=:p")
    public Createpost findbypostId(@Param("p")String postId);


	@Query("select new Com.RequrmentsProject.payloads.CreatepostDto(p.postId, p.cmpId,jc.jobcityId,p.compensationId, p.jobRole, p.typeofJob, p.noofOpenings, p.area, p.jobTiming, p.completeAddress, p.anyOther, p.salaryperAnnum, p.month, p.joiningFeeForCandidate, p.minimumEducation, p.gender, p.experienceRequiered, p.jobDescription, p.interviewerDetails, p.typeofInterview, p.enabled,  c.companyName,  jc.jobcityName,cp.compensationName) From Createpost p, Company c, JobCity jc, Compensation cp WHERE p.compensationId=cp.compensationId AND p.cmpId=c.cmpId AND p.jobcityId=jc.jobcityId")
  public List<CreatepostDto> getAllPosts();
	
	@Query("select new Com.RequrmentsProject.payloads.CreatepostDto(p.postId, p.cmpId,jc.jobcityId,p.compensationId, p.jobRole, p.typeofJob, p.noofOpenings, p.area, p.jobTiming, p.completeAddress, p.anyOther, p.salaryperAnnum, p.month, p.joiningFeeForCandidate, p.minimumEducation, p.gender, p.experienceRequiered, p.jobDescription, p.interviewerDetails, p.typeofInterview, p.enabled,  c.companyName,  jc.jobcityName,cp.compensationName) From Createpost p, Company c, JobCity jc, Compensation cp WHERE p.compensationId=cp.compensationId AND p.cmpId=c.cmpId AND p.jobcityId=jc.jobcityId AND p.postId=:postId")
	public CreatepostDto getsinglePostById(@Param("postId") String postId);
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


