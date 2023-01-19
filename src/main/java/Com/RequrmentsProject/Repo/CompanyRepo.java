package Com.RequrmentsProject.Repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Com.RequrmentsProject.Entity.Company;

public interface CompanyRepo extends JpaRepository<Company, String>{

	@Query("select C From Company C WHERE C.cmpId=:v")
	public Company findCompanybyId(@Param("v")String cmpId) ;

	 @Query("select c From Company c WHERE c.cmpId=:cmpId")
	public Company findCompanyGetbyId(@Param("cmpId")String cmpId) ;

	 @Query(value = "SELECT c FROM Company c ")
	    List<Company>findCompanygetAll();
	 
	   @Modifying
	   @Transactional
	   @Query("update Company c set c.companyName=:companyName,c.owenerName=:owenerName,c.email=:email,c.registrationDate=:registrationDate,c.websiteUrl=:websiteUrl,c.compamyLogo=:compamyLogo,c.industryType=:industryType,c.about=:about,c.enabled=:enabled where c.cmpId=:cmpId")
	   public void updatecompany(@Param("cmpId")String cmpId,@Param("companyName")String companyName,@Param("owenerName")String owenerName,@Param("email")String email,@Param("registrationDate")String registrationDate,@Param("websiteUrl")String websiteUrl,@Param("compamyLogo")String compamyLogo,@Param("industryType")String industryType,@Param("enabled")boolean enabled);
}
