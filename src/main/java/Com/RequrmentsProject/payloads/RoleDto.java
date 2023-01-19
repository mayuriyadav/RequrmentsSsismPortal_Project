package Com.RequrmentsProject.payloads;

import java.util.UUID;

import javax.persistence.Id;

import lombok.Data;

@Data
public class RoleDto {
@Id
	private String id = UUID.randomUUID().toString();
	private String  name ;
}
