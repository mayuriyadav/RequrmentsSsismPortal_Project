package Com.RequrmentsProject.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Com.RequrmentsProject.Entity.User;
import Com.RequrmentsProject.payloads.UserDto;



public interface UserRepo extends JpaRepository<User, String >{
        
	Optional <User> findByEmail(String email);
	
	 @Query("SELECT u FROM  User u WHERE u.email = ?1")
	User  getByEmail(String email);
	
	 @Query("SELECT u FROM  User u WHERE u.resetPasswordToken = ?1")
	 User findByResetPasswordToken(String token);

	//void save(UserDto userDto);
	
}
