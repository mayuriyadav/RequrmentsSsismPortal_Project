package Com.RequrmentsProject.Entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "CreatePost")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Createpost {
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
}
	

//@Transient
//private List<String>addtonalperk;
//
//@Transient
//private List<String>skillRequired;
//
//