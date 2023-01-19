package Com.RequrmentsProject.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Com.RequrmentsProject.Entity.User;
import Com.RequrmentsProject.Exception.ResourceNotFoundException;
import Com.RequrmentsProject.Exception.UserNotFoundException;

import Com.RequrmentsProject.Repo.UserRepo;
import Com.RequrmentsProject.Service.UserService;
import Com.RequrmentsProject.payloads.UserDto;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo ;
	//@Autowired 
//	private RoleRepo roleRepo;
//	@Autowired
	//private PasswordEncoder passwordEncoder;
@Autowired
    private ModelMapper modelMapper;
	@Override
	public UserDto CreateUser(UserDto userDto) {
		   User user = this.modelMapper.map(userDto, User.class);
		  
//		   user.setPassword(this.passwordEncoder.encode(user.getPassword()));
//			//roles
//			Role role =this.roleRepo.findById(502).get();
//			user.getRole().add(role);
			//User newUser = this.userRepo.save(user); 
			User saveuser   = this.userRepo.save(user); 
		   return this.modelMapper.map(saveuser, UserDto.class);
	}

	@Override
	public UserDto UpdateUser(UserDto userDto, String userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		//user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		
		user.setPassword(userDto.getPassword());
		User saveUser = this.userRepo.save(user);
		return this.modelMapper.map(saveUser, UserDto.class);
	}

	@Override
	public UserDto getByUserId(String  userId) {
	User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {
	List<User> user = this.userRepo.findAll();
	List<UserDto> saveuser = user.stream().map(u -> this.modelMapper.map(u,UserDto.class)).collect(Collectors.toList());

		return saveuser;
	}

	@Override
	public void deleteUser(String  userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		this.userRepo.delete(user);
	}

	@Override
	public void updateResetPasswordToken(String token, String email) throws UserNotFoundException {
		
		User user = userRepo.getByEmail(email);
		if(user!=null) {
		user.setResetPasswordToken(token);
	            userRepo.save(user);
		}else {
            throw new UserNotFoundException("Could not find any customer with the email " + email);
        }
	}

	@Override
	public User getByResetPasswordToken(String token) {
		
		return userRepo.findByResetPasswordToken(token);
	}

	@Override
	public void updatePassword(User user, String newPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
       user.setPassword(encodedPassword);
         
        user.setResetPasswordToken(null);
        userRepo.save(user);
		
	}

	@Override
	public User get(String token) {
		User user = userRepo.findByResetPasswordToken(token);
		return user ;
	}

	//@Override
//	public UserDto registerNewUser(UserDto userDto) {
//		User user = this.modelMapper.map(userDto, User.class);
//		// encode the password
//		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
//		//roles
//		Role role =this.roleRepo.findById(502).get();
//		user.getRole().add(role);
//		User newUser = this.userRepo.save(user);
//		return this.modelMapper.map(newUser, UserDto.class);
//	}

}
