package com.inter.SistemaDeCadastro.config.security;

import com.inter.SistemaDeCadastro.interfaces.RoleRepository;
import com.inter.SistemaDeCadastro.interfaces.UserRepository;
import com.inter.SistemaDeCadastro.models.RoleModel;
import com.inter.SistemaDeCadastro.models.UserModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        createAdminIfNotExist();
    }

    private void createAdminIfNotExist() {
        Optional<UserModel> userAdmin = userRepository.findByEmail("admin@gmail.com");

        if (userAdmin.isEmpty()) {
            RoleModel roleAdmin = roleRepository.findByNome("ADMIN");
            if (roleAdmin == null) {
                roleAdmin = new RoleModel();
                roleAdmin.setNome("ADMIN");
                roleRepository.save(roleAdmin);
            }

            UserModel admin = new UserModel();
            admin.setNome("Adm do Sistema");
            admin.setEmail("admin@gmail.com");
            admin.setSenha(passwordEncoder.encode("7870"));
            admin.setRoles(Set.of(roleAdmin));
            userRepository.save(admin);
            System.out.println("ADMIN do sistema criado.");
        } else {
            System.out.println("ADMIN já existe no sistema");
        }
    }
}