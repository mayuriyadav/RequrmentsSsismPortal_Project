package Com.RequrmentsProject.Service;

import java.util.List;

import Com.RequrmentsProject.Entity.Createpost;
import Com.RequrmentsProject.payloads.CreatepostDto;


public interface CreatepostService {

    Createpost createPost(Createpost createpost, String cmpId);

	List<CreatepostDto> getAllPost();
	
	Createpost updatePost(Createpost createpost);
	
	CreatepostDto getByPostId(String postId);
}
