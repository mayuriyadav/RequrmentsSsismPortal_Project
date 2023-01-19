package Com.RequrmentsProject.Service;

import Com.RequrmentsProject.Entity.PostSkillRequired;

public interface PostSkillRequiredService {
	
	PostSkillRequired CreatePostSkill(PostSkillRequired postSkillRequired);
	
	void deletePostSkill(String postSkillId);

}
