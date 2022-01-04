package com.dataentryapp.webservices.dataentryappwebservices.profile;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ProfileController {
	
	@Autowired
	private ProfileService pService;
	
	@GetMapping(path="/profiles/{creator_id}")
	public List<Profile> getAllProfile(@PathVariable long creator_id) {
		return pService.getAllProfile(creator_id);
	}
	
	@GetMapping(path="/profiles/{creator_id}/profile/{full_name}")
	public List<Profile> getProfile(@PathVariable long creator_id, @PathVariable String full_name) {
		return pService.getProfile(creator_id, full_name.toLowerCase());
	}
	
	@GetMapping(path="/profiles/{creator_id}/id/{profile_id}")
	public Profile getProfileById(@PathVariable long creator_id, @PathVariable long profile_id) {
		return pService.findById(profile_id);
	}
	
	@DeleteMapping(path="/profiles/{profile_id}")
	public ResponseEntity<Void> deleteProfile(@PathVariable long profile_id) {
		Profile profile = pService.deleteProfileById(profile_id);
		if(profile != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path="/profiles/{profile_id}")
	public ResponseEntity<Profile> updateProfile(@PathVariable long profile_id, @RequestBody Profile profile) {
		Profile updatedProfile = pService.save(profile, profile_id);
		return new ResponseEntity<Profile>(profile, HttpStatus.OK);
	}
	
	@PostMapping(path="/profiles/{creator_id}")
	public ResponseEntity<Void> createProfile(@PathVariable long creator_id, @RequestBody Profile profile) {
		Profile createdProfile = pService.save(profile, creator_id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/id/{profile_id}").buildAndExpand(createdProfile.getProfileId()).toUri();
		System.out.println("uri - " + uri.toString());
		return ResponseEntity.created(uri).build();
	}
}
