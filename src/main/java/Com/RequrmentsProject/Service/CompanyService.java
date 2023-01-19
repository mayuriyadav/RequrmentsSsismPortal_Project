package Com.RequrmentsProject.Service;

import java.util.List;

import Com.RequrmentsProject.Entity.Company;



public interface CompanyService {

	Company registerCompany(Company company);
	
	Company updateCompany(Company companyD, String cmpId);
	
	Company getbyCompnyId(String cmpId);
	
	List<Company> getAllCompany();
}
