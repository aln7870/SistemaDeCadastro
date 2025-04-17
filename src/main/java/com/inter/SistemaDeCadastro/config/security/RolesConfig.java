package com.inter.SistemaDeCadastro.config.security;


import com.inter.SistemaDeCadastro.interfaces.RoleRepository;
import com.inter.SistemaDeCadastro.models.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RolesConfig implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        createRolesIfNotExist();
    }

    private void createRolesIfNotExist() {
        createRoleIfNotExist(RoleModel.values.ADMIN);
        createRoleIfNotExist(RoleModel.values.USER);
    }

    private void createRoleIfNotExist(RoleModel.values roleEnum) {
        if (roleRepository.findByNome(roleEnum.name()) == null) {
            RoleModel role = new RoleModel();
            role.setNm_role(roleEnum.name());
            roleRepository.save(role);
            System.out.println("Role " + roleEnum.name() + " criada.");
        } else {
            System.out.println("Role " + roleEnum.name() + " já existe.");
        }

    }

}
