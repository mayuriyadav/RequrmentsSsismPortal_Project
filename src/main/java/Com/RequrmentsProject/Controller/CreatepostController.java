package Com.RequrmentsProject.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import Com.RequrmentsProject.Entity.Createpost;
import Com.RequrmentsProject.Service.CreatepostService;
import Com.RequrmentsProject.payloads.CreatepostDto;


@RestController
@RequestMapping("/api")
public class CreatepostController {
 @Autowired
 private CreatepostService createpostService;

 private Logger logger=LoggerFactory.getLogger(CreatepostController.class);
 
	@PostMapping("/Createpost/{cmpId}/postjob")
	public ResponseEntity<Createpost> createPost(@RequestBody Createpost createpost,@PathVariable String cmpId) {
		logger.info("PostController,createPost() method started");
		Createpost createPost = this.createpostService.createPost(createpost, cmpId);
		logger.info("createpostController,createPost() method ended");
		return new ResponseEntity<Createpost>(createPost,HttpStatus.CREATED);
	}

	@GetMapping("/Createpost")
	public ResponseEntity<List<CreatepostDto>>getAllPost(){
		logger.info("createpostController,getAllPost() method started");
		List<CreatepostDto> allPost = this.createpostService.getAllPost();
		logger.info("createpostController,getAllPost() method ended");
		return new ResponseEntity<List<CreatepostDto>>(allPost,HttpStatus.OK);
		
	}
	@PutMapping("/Createpost")
    public ResponseEntity<Createpost>updatePost(@RequestBody Createpost createpost){
    	logger.info("createpostController,updatePost() method started");
    	Createpost updatePost = this.createpostService.updatePost(createpost);
    	logger.info("CreatepostController,updatePost() method ended");
         return new ResponseEntity<Createpost>(updatePost,HttpStatus.OK);
    }
	
	
//	single get post
	@GetMapping("/Createpost/{postId}")
	public ResponseEntity<CreatepostDto>getByPostId(@PathVariable String postId){
		logger.info("createpostController,getByPostId() method started");
		CreatepostDto getbypostId = this.createpostService.getByPostId(postId);
		logger.info("createpostController,getByPostId() method ended");
		return new ResponseEntity<CreatepostDto>(getbypostId,HttpStatus.OK);
	
	}
	
}
