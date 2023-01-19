package Com.RequrmentsProject.Service;

import java.util.List;

import Com.RequrmentsProject.Entity.User;
import Com.RequrmentsProject.Exception.UserNotFoundException;
import Com.RequrmentsProject.payloads.UserDto;


public interface UserService {

 //  UserDto registerNewUser(UserDto userDto);
	UserDto CreateUser(UserDto userDto);
	
	UserDto UpdateUser(UserDto userDto ,String  userId);
	
	UserDto getByUserId( String userId);
	
	List<UserDto> getAllUser();
	
	void deleteUser(String  userId);
		
	public void updateResetPasswordToken(String token, String email) throws UserNotFoundException;
	
	 User getByResetPasswordToken(String token);
	 
	 public void updatePassword(User user,String newPassword);

	User get(String token);

	
	
}
