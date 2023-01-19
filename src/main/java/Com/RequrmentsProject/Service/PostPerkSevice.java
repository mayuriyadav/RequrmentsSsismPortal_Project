package Com.RequrmentsProject.Service;

import Com.RequrmentsProject.Entity.PostPerk;

public interface PostPerkSevice {
       
	PostPerk CreatePerk(PostPerk postperk);
	
	void deletePerk( String postperkId);
}
