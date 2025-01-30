package com.airlines.app_wings.users;

import com.airlines.app_wings.roles.Role;
import com.airlines.app_wings.roles.RoleService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserRequestDto userRequestDto) {
        // Buscar el rol CUSTOMER en la base de datos
        Role customerRole = roleService.findByRole("ROLE_CUSTOMER")
                .orElseThrow(() -> new RuntimeException("Role CUSTOMER not found"));

        // Crear el usuario
        User user = new User();
        user.setUsername(userRequestDto.user());
        user.setPassword(passwordEncoder.encode(userRequestDto.password()));
        // Asegurar que la lista de roles no sea null
        user.setRoles(new HashSet<>());

        // Agregar el rol CUSTOMER al usuario
        user.getRoles().add(customerRole);

        // Guardar el usuario en la base de datos
        return userRepository.save(user);
    }


//    public User updateUserRole(Long userId, String roleName) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Optional<Role> role = roleService.findByRole(roleName);
//        if (role.isEmpty()) {
//            throw new RuntimeException("Role not found: " + roleName);
//        }
//
//        user.getRoles().clear(); // Remueve roles previos
//        user.getRoles().add(role.get()); // Agrega el nuevo rol
//        return userRepository.save(user);
//    }


}
