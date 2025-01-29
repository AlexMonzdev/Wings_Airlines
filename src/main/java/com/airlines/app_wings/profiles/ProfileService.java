package com.airlines.app_wings.profiles;

import com.airlines.app_wings.users.User;
import com.airlines.app_wings.users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileByUserId(Long userId) {
        return profileRepository.findByUserId(userId);
    }

    public Optional<Profile> getProfileByPassportId(String passportId) {
        return profileRepository.findByPassportId(passportId);
    }

    public Profile createProfile(Profile profile) {
        Optional<User> user = userRepository.findById(profile.getUser().getId());
        if (user.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + profile.getUser().getId());
        }
        profile.setUser(user.get());  // Asociar el perfil con el usuario
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Long id, Profile profileDetails) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found with ID: " + id));

        profile.setName(profileDetails.getName());
        profile.setPhone(profileDetails.getPhone());
        profile.setNationality(profileDetails.getNationality());
        profile.setDateOfBirth(profileDetails.getDateOfBirth());
        profile.setPassportId(profileDetails.getPassportId());

        return profileRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        if (!profileRepository.existsById(id)) {
            throw new RuntimeException("Profile not found with ID: " + id);
        }
        profileRepository.deleteById(id);
    }



}
