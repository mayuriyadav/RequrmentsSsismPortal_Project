package Com.RequrmentsProject.payloads;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class CompanyDto {
	private String cmpId =  UUID.randomUUID().toString();
	private String companyName ;
	private String owenerName;
	private String email ;
	private String registrationDate ;
	private String websiteUrl ;
	private String compamyLogo ;
	private String industryType ;
	private String about;
	private Boolean enabled;
}
