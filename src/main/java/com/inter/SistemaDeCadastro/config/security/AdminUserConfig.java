package com.inter.SistemaDeCadastro.config.security;

import com.inter.SistemaDeCadastro.interfaces.RoleRepository;
import com.inter.SistemaDeCadastro.interfaces.UserRepository;
import com.inter.SistemaDeCadastro.interfaces.UsuarioRoleRepository;
import com.inter.SistemaDeCadastro.models.RoleModel;
import com.inter.SistemaDeCadastro.models.UserModel;
import com.inter.SistemaDeCadastro.models.UsuarioRoleModel;
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

    @Autowired
    UsuarioRoleRepository usuarioRoleRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        createAdminIfNotExist();
    }

    private void createAdminIfNotExist() {
        Optional<UserModel> userAdmin = userRepository.findByNome("Adm do Sistema");

        if (userAdmin.isEmpty()) {
            RoleModel roleAdmin = roleRepository.findByNome("ADMIN");
            if (roleAdmin == null) {
                roleAdmin = new RoleModel();
                roleAdmin.setNome("ADMIN");
                roleRepository.save(roleAdmin);
            }

            UserModel admin = new UserModel();
            admin.setNome("Adm do Sistema");
            admin.setSenha(passwordEncoder.encode("7870"));
            userRepository.save(admin);

            UsuarioRoleModel vinculo = new UsuarioRoleModel();
            vinculo.setUser(admin);
            vinculo.setRole(roleAdmin);

            usuarioRoleRepository.save(vinculo);

            System.out.println("ADMIN do sistema criado.");
        } else {
            System.out.println("ADMIN já existe no sistema");
        }
    }
}