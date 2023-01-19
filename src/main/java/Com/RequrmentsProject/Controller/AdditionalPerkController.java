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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.RequrmentsProject.ApiResponse.ApiResponse;
import Com.RequrmentsProject.Entity.AdditionalPerk;
import Com.RequrmentsProject.Service.AdditionalPerkService;


@RestController
@RequestMapping("/addperks")
public class AdditionalPerkController {

	@Autowired
	private AdditionalPerkService additionalPerksService;

	@PostMapping("/")
	public ResponseEntity<AdditionalPerk> createUser(@RequestBody AdditionalPerk additionalPerks) {
		AdditionalPerk createuser = this.additionalPerksService.createperk(additionalPerks);
		return new ResponseEntity<AdditionalPerk>(createuser, HttpStatus.CREATED);
	}

	@PutMapping("/{additionalPerkId}")
	public ResponseEntity<AdditionalPerk> updateUser(@PathVariable("additionalPerkId") String additionalPerkId,
			@RequestBody AdditionalPerk additionalPerks) {
		AdditionalPerk updatedUser = this.additionalPerksService.updateperk(additionalPerks, additionalPerkId);
		return ResponseEntity.ok(updatedUser);
	}

	@GetMapping("/")
	public ResponseEntity<List<AdditionalPerk>> getAllUsers() {
		return ResponseEntity.ok(this.additionalPerksService.getallperks());
	}

	@DeleteMapping("/{additionalPerkId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("additionalPerkId") String additionalPerkId) {
		this.additionalPerksService.deleteperk(additionalPerkId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted successfully", true), HttpStatus.OK);
	}

}
