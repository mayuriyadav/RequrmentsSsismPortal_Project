package Com.RequrmentsProject.payloads;


import java.util.UUID;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
	private String userId = UUID.randomUUID().toString();	
    private String email;
    private String password ;
    
    private String resetPasswordToken;
  //  private Set<RoleDto> role = new HashSet<>();
   		 
}
