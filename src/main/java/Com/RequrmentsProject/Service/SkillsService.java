package Com.RequrmentsProject.Service;

import java.util.List;

import Com.RequrmentsProject.Entity.Skills;


public interface SkillsService {

	Skills createSkills(Skills skills);

	Skills updateskills(Skills skills, String skillId);

	List<Skills> getAllSkills();

	void deleteSkills(String skillId);
}
