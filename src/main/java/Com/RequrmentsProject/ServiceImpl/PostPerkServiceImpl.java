package Com.RequrmentsProject.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.RequrmentsProject.Entity.PostPerk;

import Com.RequrmentsProject.Repo.PostPerkRepo;
import Com.RequrmentsProject.Service.PostPerkSevice;

@Service
public class PostPerkServiceImpl implements PostPerkSevice {

	@Autowired
	private PostPerkRepo postPerkRepo ;

	@Override
	public PostPerk CreatePerk(PostPerk postperk) {		
		PostPerk  savePerk =this.postPerkRepo.save(postperk) ;
		return savePerk;
	}
     @Override
   public void deletePerk(String postperkId) {

	this.postPerkRepo.deleteById(postperkId);
	
}

	

}
