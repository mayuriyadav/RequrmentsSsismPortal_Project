package Com.RequrmentsProject.ServiceImpl;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Com.RequrmentsProject.Entity.AdditionalPerk;
import Com.RequrmentsProject.Entity.Company;
import Com.RequrmentsProject.Entity.Createpost;
import Com.RequrmentsProject.Entity.Skills;
import Com.RequrmentsProject.Exception.ResourceNotFoundException;
import Com.RequrmentsProject.Repo.CompanyRepo;
import Com.RequrmentsProject.Repo.CreatepostRepo;
import Com.RequrmentsProject.Repo.PostPerkRepo;
import Com.RequrmentsProject.Repo.PostSkillRequiredRepo;
import Com.RequrmentsProject.Service.CreatepostService;
import Com.RequrmentsProject.payloads.CreatepostDto;


@Service
public class CreatepostServiceimpl  implements CreatepostService{

	@Autowired
	private CreatepostRepo createpostRepo;

	@Autowired	
	private CompanyRepo companyRepo;
	@Autowired
	private PostSkillRequiredRepo postSkillRequiredRepo;
	@Autowired
	private PostPerkRepo postPerkRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	private Logger logger=LoggerFactory.getLogger(CreatepostServiceimpl.class);
	
	
	
	@Override
	public Createpost createPost(Createpost createpost, String cmpId) {
		
		logger.info("CreatepostServiceimpl,createPost() method started");
		
		Company companyId = this.companyRepo.findCompanybyId(cmpId);
		if(companyId==null) {
			throw new ResourceNotFoundException("Company","cmpId", cmpId);
		}
	
		Createpost save = this.createpostRepo.save(createpost);
		save.setCmpId(cmpId);
		
		Createpost createpost1 = this.createpostRepo.save(save);

		 logger.info("CreatepostServiceimpl,createPost() method ended");
		 return createpost1;
	}
	
	@Override
	public Createpost updatePost(Createpost createpost) {
		
		logger.info("PostServiceImpl,updatePost() method started");
		Createpost postId = this.createpostRepo.findbypostId(createpost.getPostId());
		if(postId==null) {
			throw new ResourceNotFoundException("Createpost","postId",createpost.getPostId());
		}
		
		Createpost save = this.createpostRepo.save(createpost);
	   
		logger.info("PostServiceImpl,updatePost() method ended");
	      return save;
	}
	
	
	
	@Override
	public List<CreatepostDto> getAllPost() {
		
		logger.info("PostServiceImpl, getAllPost() method started");
		 List<CreatepostDto> allposts = this.createpostRepo.getAllPosts();
	
		for(CreatepostDto A:allposts) {
		List<AdditionalPerk>  findAllAdditionlperk = this.postPerkRepo.findAllPostPerkByPostId(A.getPostId());

		  List<Skills> findAllPostSkills = this.postSkillRequiredRepo.findAllPostSkillByPostId(A.getPostId());

		  A.setAdditonalperk(findAllAdditionlperk);
            
		  A.setSkillRequired(findAllPostSkills);
		
		}
		logger.info("CreatepostServiceImpl, getAllPost() method ended");
	return allposts;
	}
	
	
	
	@Override
	public CreatepostDto getByPostId(String postId) {
		
		logger.info("PostServiceImpl,getByPostId() method started");
		 
		Createpost getpost = this.createpostRepo.findbypostId(postId);
		
		  CreatepostDto savepost = this.modelMapper.map(getpost,CreatepostDto.class);
		    List<AdditionalPerk> getsingleAddpost = this.postPerkRepo.findAllPostPerkByPostId(getpost.getPostId());
		    
		    List<Skills> getsingleskillpost = this.postSkillRequiredRepo.findAllPostSkillByPostId(getpost.getPostId());
		
		  	savepost.setAdditonalperk(getsingleAddpost);
		  	savepost.setSkillRequired(getsingleskillpost);
			   logger.info("PostServiceImpl,getByPostId() method ended");
			  
			   return savepost;
			  
		}
	}
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//@Override
//	public CreatepostDto CreatePost(CreatepostDto createpostDto) {
//		Createpost createpost=this.modelMapper.map(createpostDto, Createpost.class);
//		
//		List <AdditionalPerk> perks = new ArrayList<AdditionalPerk>();
//		for (AdditionalPerk perk :createpost.getAdditionalPerk()) {
//            AdditionalPerk addperk = this.additionalPerkRepo.findByName(perk.getAddperkName());
//            if (addperk == null) {
//                perks.add(perk);
//                additionalPerkRepo.save(perk);
//
//               PostPerk pp = new PostPerk();
//                pp.setPostId(createpost.getPostId());
//                pp.setAddperkId(perk.getAddperkId());
//                postPerkRepo.save(pp);
//            } else {  
//                PostPerk pp = new PostPerk();
//                pp.setPostId(createpost.getPostId());
//                pp.setAddperkId(addperk.getAddperkId());
//                postPerkRepo.save(pp);
//            }
//        }
//
//		
//		Createpost saveCreatepost = this.createpostRepo.save(createpost);		
//		return this.modelMapper.map(saveCreatepost, CreatepostDto.class);
//	
//}
//	
//
//	@Override
//	public List<CreatepostDto> getAllCreatepost() {
//		
//		return null;
//	}
//
//
//	@Override
//	public CreatepostDto updateCreatepost(CreatepostDto createpostDto, String createPostId) {
//		
//		return null;
//	}
//
//
//
//	@Override
//	public CreatepostDto getSinglPost(String postId) {
//		
//		return null;
//	}






