package Com.RequrmentsProject.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.RequrmentsProject.Entity.AdditionalPerk;
import Com.RequrmentsProject.Repo.AdditionalPerkRepo;
import Com.RequrmentsProject.Service.AdditionalPerkService;


@Service
public class AdditionalPerksServiceImpl implements AdditionalPerkService {

	@Autowired
	private AdditionalPerkRepo additionalPerksRepo;

	@Override
	public AdditionalPerk createperk(AdditionalPerk additionalPerks) {

		AdditionalPerk savedJob = this.additionalPerksRepo.save(additionalPerks);

		return savedJob;
	}

	@Override
	public AdditionalPerk updateperk(AdditionalPerk additionalPerks, String additionalPerkId) {
		AdditionalPerk additional_Perks1 = this.additionalPerksRepo.findByAddperkid(additionalPerkId);

		additional_Perks1.setAdditionalPerkName(additionalPerks.getAdditionalPerkName());

		AdditionalPerk updatePost = this.additionalPerksRepo.save(additional_Perks1);
		return updatePost;
	}

	@Override
	public List<AdditionalPerk> getallperks() {
		List<AdditionalPerk> additional_Perks = this.additionalPerksRepo.findAll();

		return additional_Perks;
	}

	@Override
	public void deleteperk(String additionalPerkId) {
		AdditionalPerk additional_Perks = this.additionalPerksRepo.findByAddperkid(additionalPerkId);
		this.additionalPerksRepo.delete(additional_Perks);

	}


}
