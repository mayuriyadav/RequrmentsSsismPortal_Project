package Com.RequrmentsProject.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Com.RequrmentsProject.App.AppConstants;
import Com.RequrmentsProject.Entity.Company;
import Com.RequrmentsProject.Entity.Role;
import Com.RequrmentsProject.Entity.User;
import Com.RequrmentsProject.Exception.ResourceNotFoundException;
import Com.RequrmentsProject.Repo.CompanyRepo;
import Com.RequrmentsProject.Repo.RoleRepo;
import Com.RequrmentsProject.Repo.UserRepo;
import Com.RequrmentsProject.Service.CompanyService;
import Com.RequrmentsProject.payloads.CompanyDto;


@Service
public class CompanyServiceimpl  implements CompanyService{
	@Autowired
 private CompanyRepo companyRepo;
	@Autowired
	private ModelMapper modelMapper ;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private PasswordEncoder passwordEncoder ;
	@Override
	public Company registerCompany(Company company) {
		
		User user=new User();
	
	Company saveCompany = this.companyRepo.save(company);
	
	user.setEmail(saveCompany.getEmail());
	
	user.setPassword(RandomString.make(8));
	
    String random=RandomString.make(8);
    
    EmailCode.email(user);
    
    user.setPassword(this.passwordEncoder.encode(user.getPassword()));
    
	Role role =this.roleRepo.getByid(AppConstants.COMPANY);
	
	user.getRole().add(role);
	
     this.userRepo.save(user);

     return saveCompany;
	}

	@Override
	public Company updateCompany(Company company, String cmpId) {
		Company com = this.companyRepo.findCompanyGetbyId(cmpId);
if(com==null) {
			
			//logger.warn("CompanyServiceImpl, updateCompany method ended"); 
			
			throw new ResourceNotFoundException("Company","cmpId", cmpId);
}else {
		com.setCmpId(company.getCmpId());
		com.setCompanyName(company.getCompanyName());
		com.setCompamyLogo(company.getCompamyLogo());
		com.setEmail(company.getEmail());
		com.setAbout(company.getAbout());
		com.setIndustryType(company.getIndustryType());
		com.setOwenerName(company.getOwenerName());
		com.setEnabled(false);
		com.setRegistrationDate(company.getRegistrationDate());
		com.setWebsiteUrl(company.getWebsiteUrl());
		 this.companyRepo.save(com);
		 this.companyRepo.updatecompany(cmpId,company.getCompanyName(),company.getOwenerName(),company.getEmail(),company.getRegistrationDate(),company.getWebsiteUrl(),company.getCompamyLogo(), company.getIndustryType(),false);
		return com;
	}
	}

	@Override
	public Company getbyCompnyId( String cmpId) {
		Company com = this.companyRepo.findById(cmpId).orElseThrow(() -> new ResourceNotFoundException("Comany","cmpId",cmpId));
		return com;
	}

	@Override
	public List<Company> getAllCompany() {
		List<Company> companies = this.companyRepo.findCompanygetAll();
		//List<CompanyDto> savCompany = companies.stream().map( c ->this.modelMapper.map(c,CompanyDto.class)).collect(Collectors.toList());
		return companies ;
	}

}
