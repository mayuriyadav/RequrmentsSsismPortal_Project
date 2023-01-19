package Com.RequrmentsProject.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table (name ="Compensation")
@Data
public class Compensation {
	@Id
	private String compensationId;
	
	
	private String compensationName;

}
