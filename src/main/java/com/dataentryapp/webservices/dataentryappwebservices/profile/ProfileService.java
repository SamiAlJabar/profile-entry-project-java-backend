package com.dataentryapp.webservices.dataentryappwebservices.profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProfileService {
	private static List<Profile> profiles = new ArrayList<Profile>();
	private static int idCounter = 0;
	
	static {
		profiles.add(new Profile(++idCounter, 123, "Sami", "Jabar", new Date(), "297 Woodbine Ave", "Toronto", "Ontario", "Canada"));
		profiles.add(new Profile(++idCounter, 123, "Afia", "Noshin", new Date(), "808 Fetchison Drive", "Oshawa", "Ontario", "Canada"));
		profiles.add(new Profile(++idCounter, 123, "Tajbir", "Boney", new Date(), "24/1 Tajmohal Road", "Dhaka", "Dhaka", "Bangladesh"));
	}
	
	public List<Profile> getAllProfile(long creator_id) {
		List <Profile> temp = new ArrayList<>();
		profiles.forEach((profile) -> {
            if(profile.getCreatorId() == creator_id) {
            	temp.add(profile);
            }
        });
		return temp;
	}
	
	public Profile deleteProfileById(long profileId) {
		Profile profile = findById(profileId);
		if(profile == null) {
			return null;
		}
		if(profiles.remove(profile)) {
			return profile;
		}
		return null;
	}

	public Profile findById(long profileId) {
		for(Profile profile:profiles) {
			if(profile.getProfileId() == profileId) {
				return profile;
			}
		}
		return null;
	}

	public List<Profile> getProfile(long creator_id, String full_name) {
		List<Profile> prof = new ArrayList<>();
		for(Profile profile: profiles) {
			if(profile.getCreatorId() == creator_id && profile.getFullName().toLowerCase().contains(full_name)) {
				prof.add(profile);
			}
		}
//		if(prof.size() < 1) return null;
		return prof;
	}

	public Profile save(Profile profile, long id) {
		if(profile.getProfileId() == -1 || profile.getProfileId() == 0) {
			profile.setProfileId(++idCounter);
			profile.setCreatorId(id);
			profiles.add(profile);
		} else {
			deleteProfileById(profile.getProfileId());
			profiles.add(profile);
		}
		return profile;
	}
}
