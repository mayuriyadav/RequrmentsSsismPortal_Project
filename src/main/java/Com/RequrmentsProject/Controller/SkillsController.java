package Com.RequrmentsProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Com.RequrmentsProject.Entity.Skills;
import Com.RequrmentsProject.Service.SkillsService;



@RestController
public class SkillsController {

	@Autowired
	private SkillsService skillsService;

	@PostMapping("/skills")
	public ResponseEntity<Skills> createSkills(@RequestBody Skills skills) {
		Skills createSkill = this.skillsService.createSkills(skills);
		return new ResponseEntity<>(createSkill, HttpStatus.CREATED);
	}

	@PutMapping("/skills/{skillId}")
	public ResponseEntity<Skills> updateSkills(@RequestBody Skills skill,
			@PathVariable("skillId") String skillId) {
		Skills updateSkill = this.skillsService.updateskills(skill, skillId);

		return new ResponseEntity<>(updateSkill, HttpStatus.CREATED);
	}

	@GetMapping("/skills")
	public ResponseEntity<List<Skills>> GetAllSkills() {
		List<Skills> gets = this.skillsService.getAllSkills();

		return new ResponseEntity<>(gets, HttpStatus.OK);
	}

	@DeleteMapping("/skills/{skillId}")
	public ResponseEntity deleteSkills(@PathVariable("skillId") String skillId) {
		this.skillsService.deleteSkills(skillId);

		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
