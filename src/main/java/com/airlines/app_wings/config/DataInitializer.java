package com.airlines.app_wings.config;

import com.airlines.app_wings.roles.Role;
import com.airlines.app_wings.roles.RoleRepository;
import jakarta.annotation.PostConstruct;

public class DataInitializer {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void init() {
        if (roleRepository.findByRole("ROLE_CUSTOMER").isEmpty()) {
            Role customerRole = new Role();
            customerRole.setRole("ROLE_CUSTOMER");
            roleRepository.save(customerRole);
        }
    }
}
