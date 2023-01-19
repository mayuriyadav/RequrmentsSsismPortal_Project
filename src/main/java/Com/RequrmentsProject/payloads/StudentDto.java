package Com.RequrmentsProject.payloads;

import java.util.UUID;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class StudentDto {
	
	private String stuId = UUID.randomUUID().toString();
	private String studentName ;
	private String ssismGroup ;
	private String email ;
	private String std ;
	private String classYear ;
	private String gender;
	private String profileImage;
	private String mobileNo;
	private String qualification ;
	private String linkedinUrl ;
	private String address;
	private Boolean enabled;
    //private Set<Role> role = new HashSet<>();
}
