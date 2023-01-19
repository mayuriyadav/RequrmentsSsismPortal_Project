package Com.RequrmentsProject.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.RequrmentsProject.Entity.PostSkillRequired;
import Com.RequrmentsProject.Repo.PostSkillRequiredRepo;
import Com.RequrmentsProject.Service.PostSkillRequiredService;

@Service
public class PostSkillRequiredServiceimpl implements PostSkillRequiredService {

	@Autowired
	private PostSkillRequiredRepo postSkillRequiredRepo;

	@Override
	public PostSkillRequired CreatePostSkill(PostSkillRequired postSkillRequired) {
		PostSkillRequired postSkill = this.postSkillRequiredRepo.save(postSkillRequired);
		return postSkill;
	}

	@Override
	public void deletePostSkill(String postSkillId) {
	this.postSkillRequiredRepo.deleteById(postSkillId);
		
	}
	
}
