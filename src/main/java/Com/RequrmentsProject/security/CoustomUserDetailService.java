package Com.RequrmentsProject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Com.RequrmentsProject.Entity.User;
import Com.RequrmentsProject.Exception.ResourceNotFoundException;
import Com.RequrmentsProject.Repo.UserRepo;

@Service
public class CoustomUserDetailService  implements UserDetailsService {
   @Autowired
   private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//loading user from database by username
	User user =	this.userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User"," email: "+ username, null));
		return user;
	}

}
