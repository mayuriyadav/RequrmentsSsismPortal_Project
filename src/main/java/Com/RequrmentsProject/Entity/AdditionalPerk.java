package Com.RequrmentsProject.Entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalPerk {

	@Id
	private String additionalPerkId = UUID.randomUUID().toString();
	
	private String additionalPerkName;

}
