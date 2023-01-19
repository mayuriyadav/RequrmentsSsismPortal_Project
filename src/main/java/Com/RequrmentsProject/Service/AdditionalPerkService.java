package Com.RequrmentsProject.Service;

import java.util.List;

import Com.RequrmentsProject.Entity.AdditionalPerk;




public interface AdditionalPerkService {

	AdditionalPerk createperk(AdditionalPerk additionalPerks);

	AdditionalPerk updateperk(AdditionalPerk additionalPerks, String additionalPerkId);

	List<AdditionalPerk> getallperks();

	void deleteperk(String additionalPerkId);

}
