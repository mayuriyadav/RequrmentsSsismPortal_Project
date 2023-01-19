package Com.RequrmentsProject.Entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;

//import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Company")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Company {


	@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(generator="system-uuid")
	   @GenericGenerator(name="system-uuid", strategy = "uuid")
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
