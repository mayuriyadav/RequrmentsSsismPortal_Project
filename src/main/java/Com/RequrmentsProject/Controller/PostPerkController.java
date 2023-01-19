package Com.RequrmentsProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.RequrmentsProject.ApiResponse.ApiResponse;
import Com.RequrmentsProject.Entity.PostPerk;
import Com.RequrmentsProject.Entity.PostSkillRequired;
import Com.RequrmentsProject.Service.PostPerkSevice;
import Com.RequrmentsProject.Service.PostSkillRequiredService;


@RestController
@RequestMapping("/postperk")
public class PostPerkController {
	@Autowired
	private PostPerkSevice postPerkSevice;
	@Autowired
	private PostSkillRequiredService postSkillRequiredService;
	
	@PostMapping("/")
	public ResponseEntity<PostPerk> Createperk(@RequestBody PostPerk postPerk){
		PostPerk perk = this.postPerkSevice.CreatePerk(postPerk);
		return new ResponseEntity<PostPerk>(perk,HttpStatus.CREATED);
		
	}
	
        @DeleteMapping("/{postperkId}")
        public ResponseEntity<ApiResponse> deletePerk(@PathVariable String postperkId){
        	this.postPerkSevice.deletePerk(postperkId);
        	return new ResponseEntity<ApiResponse>(new ApiResponse("deleted successfully", true),HttpStatus.OK);
        }
        
        // PostSkillRequiredController
        
        @PostMapping("/skill")
        public ResponseEntity<PostSkillRequired> CreatePostSkill( @RequestBody PostSkillRequired postSkillRequired) {
        	PostSkillRequired skillRequired = this.postSkillRequiredService.CreatePostSkill(postSkillRequired);
        	return new ResponseEntity<PostSkillRequired>(skillRequired,HttpStatus.CREATED);
        	
        }
        @DeleteMapping("/skill/{postSkillId}")
        public ResponseEntity<ApiResponse>deletePostSkill(@PathVariable String postSkillId){
        	this.postSkillRequiredService.deletePostSkill(postSkillId);
        	return new ResponseEntity<ApiResponse>(new  ApiResponse("deleted successfully", true),HttpStatus.OK);
        }
}
