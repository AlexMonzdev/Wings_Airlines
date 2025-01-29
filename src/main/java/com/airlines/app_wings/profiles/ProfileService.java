package com.airlines.app_wings.profiles;

import com.airlines.app_wings.roles.Role;
import com.airlines.app_wings.roles.RoleRepository;
import com.airlines.app_wings.users.User;
import com.airlines.app_wings.users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
        // Validar que el usuario no sea nulo y tenga un ID válido
        if (profile.getUser() == null || profile.getUser().getId() == null) {
            throw new IllegalArgumentException("El perfil debe estar asociado a un usuario válido.");
        }

        // Buscar el usuario por su ID
        User user = userRepository.findById(profile.getUser().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + profile.getUser().getId()));

        // Validar que el rol no sea nulo
        if (profile.getRole() == null || profile.getRole().getId() == null) {
            throw new IllegalArgumentException("El perfil debe estar asociado a un rol válido.");
        }

        // Buscar el rol por su ID
        Role role = roleRepository.findById(profile.getRole().getId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + profile.getRole().getId()));

        // Asociar el usuario y el rol al perfil
        profile.setUser(user);
        profile.setRole(role);

        // Guardar el perfil
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
