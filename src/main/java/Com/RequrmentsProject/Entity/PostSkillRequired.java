package Com.RequrmentsProject.Entity;

import java.util.UUID;

import javax.persistence.Entity;

import javax.persistence.Id;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PostSkillRequired {
	@Id
	private String postSkillId=UUID.randomUUID().toString();
	
    private String skillId;
    
	private String postId;
	

}
