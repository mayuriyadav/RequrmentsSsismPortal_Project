package Com.RequrmentsProject.Entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@Table (name ="PostPerk")
@Data
@NoArgsConstructor
public class PostPerk {
	
	@Id
	private String postperkId = UUID.randomUUID().toString();

    private String postId ;
    
    private String additionalPerkId;
   

	

}
