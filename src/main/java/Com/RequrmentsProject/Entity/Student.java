package Com.RequrmentsProject.Entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name ="student")
public class Student {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	   @GenericGenerator(name="system-uuid", strategy = "uuid")
	
	private String stuId = UUID.randomUUID().toString();
	private String studentName ;
	private String ssismGroup ;
	private String std ;
	private String email ;
	private String classYear ;
	private String gender;
	private String profileImage;
	private String mobileNo;
	private String qualification ;
	private String linkedinUrl ;
	private String address;
	private Boolean enabled;
	@ManyToOne
    private User user;
	// private Set<Role> role = new HashSet<>();
}
