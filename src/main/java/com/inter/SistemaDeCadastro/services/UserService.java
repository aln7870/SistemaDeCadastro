package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.Userdto;
import com.inter.SistemaDeCadastro.interfaces.RoleRepository;
import com.inter.SistemaDeCadastro.interfaces.UserRepository;
import com.inter.SistemaDeCadastro.interfaces.UsuarioRoleRepository;
import com.inter.SistemaDeCadastro.models.RoleModel;
import com.inter.SistemaDeCadastro.models.UserModel;
import com.inter.SistemaDeCadastro.models.UsuarioRoleModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UsuarioRoleRepository usuarioRoleRepository;

    public List<UserModel> listarUsers() {
        return userRepository.findAll();
    }

    // POST
    public UserModel criarUser(Userdto userdto) {
        UserModel user = new UserModel();

        var role = roleRepository.findByNome(RoleModel.values.USER.name());

        BeanUtils.copyProperties(userdto, user);
        user.setSenha(passwordEncoder.encode(userdto.senha()));

            UsuarioRoleModel usuarioRole = new UsuarioRoleModel();
            usuarioRole.setUser(user);
            usuarioRole.setRole(role);

            // Adiciona a role ao conjunto de roles do usuário
            user.getUsuarioRoles().add(usuarioRole);

            // Salva a associação entre usuário e role
       //     usuarioRoleRepository.save(usuarioRole);


        return userRepository.save(user);
    }

    // GET
    public Optional<UserModel> buscarUserPorId(Integer id) {
        return userRepository.findById(id);
    }

    // PUT
    public UserModel atualizarUser(Integer id, Userdto userdto) {
        UserModel userModel = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User não encontrado"));
        BeanUtils.copyProperties(userdto, userModel);
        userModel.setSenha(passwordEncoder.encode(userdto.senha()));

        if (userdto.role() != null && !userdto.role().isBlank()) {
            RoleModel novaRole = roleRepository.findByNome(userdto.role());
            if (novaRole != null) {
                // Verifica se a role já está associada ao usuário
                Optional<UsuarioRoleModel> existingRole = userModel.getUsuarioRoles().stream()
                        .filter(ur -> ur.getRole().equals(novaRole))
                        .findFirst();

                if (existingRole.isEmpty()) {
                    // Se a role não existir, cria a associação
                    UsuarioRoleModel usuarioRole = new UsuarioRoleModel();
                    usuarioRole.setUser(userModel);
                    usuarioRole.setRole(novaRole);

                    userModel.getUsuarioRoles().add(usuarioRole);
                    usuarioRoleRepository.save(usuarioRole);
                }
            } else {
                throw new IllegalArgumentException("Role informada não existe: " + userdto.role());
            }
        }

        return userRepository.save(userModel);
    }

    // DELETE
    public UserModel deleteUser(Integer id) {
        UserModel userModel = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User não encontrado."));
        userRepository.delete(userModel);
        return userModel;
    }
}
