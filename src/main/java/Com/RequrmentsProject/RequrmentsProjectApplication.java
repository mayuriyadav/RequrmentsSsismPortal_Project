package Com.RequrmentsProject;

import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import Com.RequrmentsProject.App.AppConstants;
import Com.RequrmentsProject.Entity.Role;
import Com.RequrmentsProject.Repo.RoleRepo;


@SpringBootApplication
public class RequrmentsProjectApplication implements CommandLineRunner{

	@Autowired
	 private PasswordEncoder passwordEncoder ;

	@Autowired
	private RoleRepo roleRepo;
	
	

	
	public static void main(String[] args) {
		SpringApplication.run(RequrmentsProjectApplication.class, args);
		

		
	}

@Bean
public ModelMapper modelMapper() {
 
 return new ModelMapper();
}

@Override
public void run(String... args) throws Exception {
	System.out.println(this.passwordEncoder.encode("828qAK5Z"));

	 try {
		  Role role = new Role ();
		  role.setId(AppConstants.ADMIN);
		  role.setName("ADMIN");
		
		  Role role1 = new Role ();
		  role1.setId(AppConstants.COMPANY);
		  role1.setName("COMPANY");
		  
		  Role role2 = new Role ();
		  role2.setId(AppConstants.STUDENT);
		  role2.setName("STUDENT");
		  
		   List<Role> roles = List.of(role, role1,role2);
		   List<Role> res = this.roleRepo.saveAll(roles);
		   res.forEach(r ->{
			   System.out.println(r.getName());
		   });
	} catch (Exception e) {
		
	}
}


}
