package Com.RequrmentsProject.payloads;

import java.util.List;
import java.util.UUID;

import javax.persistence.Id;


//import Com.RequrmentsProject.Entity.Compensation;
//import Com.RequrmentsProject.Entity.JobCity;
import Com.RequrmentsProject.Entity.AdditionalPerk;
import Com.RequrmentsProject.Entity.Skills;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatepostDto {
	@Id
private String postId=UUID.randomUUID().toString();
	
	private String cmpId;
	
	private String jobcityId;
	
	private String compensationId;
	
	private String jobRole;
	
	private String typeofJob;
	
	private int noofOpenings;
	
	private String area;
	
	private String jobTiming;
	
	private String completeAddress;
	
	private String anyOther;
	
	private String salaryperAnnum;
	
	private String month;

	private Boolean joiningFeeForCandidate;
	
	private String minimumEducation;
	
	private String gender;
	
	private String experienceRequiered;
	
	private String jobDescription;
	
	private String interviewerDetails;
	
	private String typeofInterview;	
	
	private String enabled ;
	
	private String companyName ;
	
	private String jobcityName ;
	
	private String compensationName;
	
	public CreatepostDto(String postId, String cmpId, String jobcityId, String compensationId, String jobRole,
			String typeofJob, int noofOpenings, String area, String jobTiming, String completeAddress, String anyOther,
			String salaryperAnnum, String month, Boolean joiningFeeForCandidate, String minimumEducation, String gender,
			String experienceRequiered, String jobDescription, String interviewerDetails, String typeofInterview,
			String enabled, String companyName, String jobcityName, String compensationName) {
		super();
		this.postId = postId;
		this.cmpId = cmpId;
		this.jobcityId = jobcityId;
		this.compensationId = compensationId;
		this.jobRole = jobRole;
		this.typeofJob = typeofJob;
		this.noofOpenings = noofOpenings;
		this.area = area;
		this.jobTiming = jobTiming;
		this.completeAddress = completeAddress;
		this.anyOther = anyOther;
		this.salaryperAnnum = salaryperAnnum;
		this.month = month;
		this.joiningFeeForCandidate = joiningFeeForCandidate;
		this.minimumEducation = minimumEducation;
		this.gender = gender;
		this.experienceRequiered = experienceRequiered;
		this.jobDescription = jobDescription;
		this.interviewerDetails = interviewerDetails;
		this.typeofInterview = typeofInterview;
		this.enabled = enabled;
		this.companyName = companyName;
		this.jobcityName = jobcityName;
		this.compensationName = compensationName;
	}

	
	private List<AdditionalPerk>additonalperk;
	
	private List<Skills>skillRequired;

	

	 }
