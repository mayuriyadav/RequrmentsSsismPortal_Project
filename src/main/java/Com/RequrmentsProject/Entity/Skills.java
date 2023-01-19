package Com.RequrmentsProject.Entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Skills {
	@Id
	private String skillId = UUID.randomUUID().toString();
	
	private String skillName;

}
