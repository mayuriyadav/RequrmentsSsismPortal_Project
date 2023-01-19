package Com.RequrmentsProject.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name ="JobCity")
@Setter
@Getter
@NoArgsConstructor
public class JobCity {
	@Id
	private String jobcityId ;
	private String jobcityName ;
	

}
