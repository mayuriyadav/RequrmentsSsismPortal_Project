package Com.RequrmentsProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import Com.RequrmentsProject.Exception.ApiException;
import Com.RequrmentsProject.Service.UserService;
import Com.RequrmentsProject.payloads.JwtAuthRequest;
import Com.RequrmentsProject.payloads.JwtAuthResponse;
import Com.RequrmentsProject.payloads.UserDto;
import Com.RequrmentsProject.security.JwtTokenHelper;


@RestController
@RequestMapping("/api/v1/auth/")

public class AuthController {
	
@Autowired
	private  JwtTokenHelper jwtTokenHelper;
 	
@Autowired
	private UserService userService;

@Autowired
     private UserDetailsService  userDetailsService ;
 
@Autowired
       private AuthenticationManager authenticationManager ;
 
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
		
		this.authenticate(request.getUsername(),request.getPassword());
		
		UserDetails  userDetails =this. userDetailsService .loadUserByUsername(request.getUsername());
	       
		String token = this.jwtTokenHelper.generateTkon(userDetails);
	         
		JwtAuthResponse response =new JwtAuthResponse();
	         
		response.setToken(token);
	         
		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
	}
	
	private void authenticate(String username,String password) throws Exception {
			
		UsernamePasswordAuthenticationToken authenticationToken =new UsernamePasswordAuthenticationToken(username,password);
	try {
		this.authenticationManager.authenticate(authenticationToken);
	
	}catch (BadCredentialsException e) {
		System.out.println("Invalid detials !!!");
		
		throw new ApiException("Invalid username or password");
	}
}
	
	//register new user api
//	@PostMapping("/register")
//	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
//		
//		UserDto registeredUser = this.userService.registerNewUser(userDto);
//		return new ResponseEntity<UserDto>(registeredUser ,HttpStatus.CREATED);
//	}
}
