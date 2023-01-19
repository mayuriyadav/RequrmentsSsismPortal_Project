package Com.RequrmentsProject.ServiceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.RequrmentsProject.Entity.Skills;
import Com.RequrmentsProject.Repo.SkillsRepo;
import Com.RequrmentsProject.Service.SkillsService;



@Service
public class SkillsServiceImpl implements SkillsService {

	@Autowired
	private SkillsRepo skillsRepo;

	@Override
	public Skills createSkills(Skills skill) {
		Skills savedSkills = this.skillsRepo.save(skill);

		return savedSkills;

	}

	@Override
	public Skills updateskills(Skills skill, String skillId) {
		Skills ski = this.skillsRepo.getbyskillId(skillId);
		ski.setSkillName(skill.getSkillName());
		Skills savedskills = this.skillsRepo.save(ski);
		return savedskills;
	}

	@Override
	public void deleteSkills(String skillId) {
		Skills ski = this.skillsRepo.getbyskillId(skillId);
		this.skillsRepo.delete(ski);
	}

	@Override
	public List<Skills> getAllSkills() {
		List<Skills> skills = this.skillsRepo.findAll();

		return skills;

	}


}
