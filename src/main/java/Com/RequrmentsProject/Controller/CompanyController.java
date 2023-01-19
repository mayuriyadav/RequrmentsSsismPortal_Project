package Com.RequrmentsProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.RequrmentsProject.Entity.Company;
import Com.RequrmentsProject.Service.CompanyService;

@RestController
@RequestMapping ("/api/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService ;
	
	@PostMapping("/")
	public ResponseEntity<Company> regiseterCompany(@RequestBody Company company)
	{
		Company com = this.companyService.registerCompany(company);
		return new ResponseEntity<Company>(com,HttpStatus.CREATED);
				
	}
	@PutMapping("/{cmpId}")
	public ResponseEntity<Company>updateCompany(@RequestBody Company company,@PathVariable String  cmpId){
		Company com = this.companyService.updateCompany(company, cmpId);
		return new ResponseEntity<Company>(com,HttpStatus.OK);
	}
	
	
	@GetMapping("/{cmpId}")	
	public ResponseEntity<Company>  getbyCompnyId(  @PathVariable  String  cmpId)
	{
		Company com = this.companyService.getbyCompnyId(cmpId);
		return new ResponseEntity<Company>(com,HttpStatus.OK);
				
	}
	@GetMapping("/")
	public ResponseEntity<List<Company>>getAllCompany(){
		List<Company> com = this.companyService.getAllCompany();
		return new ResponseEntity<List<Company>>(com,HttpStatus.OK);
	}
	
}
