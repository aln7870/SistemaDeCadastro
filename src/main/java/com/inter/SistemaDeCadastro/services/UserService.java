package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.Userdto;
import com.inter.SistemaDeCadastro.interfaces.RoleRepository;
import com.inter.SistemaDeCadastro.interfaces.UserRepository;
import com.inter.SistemaDeCadastro.models.RoleModel;
import com.inter.SistemaDeCadastro.models.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    public List<UserModel> listarUsers() {
        return userRepository.findAll();
    }

    // POST
    public UserModel criarUser(Userdto userdto) {
        UserModel user = new UserModel();
        var role = roleRepository.findByNome(RoleModel.values.USER.name());
        BeanUtils.copyProperties(userdto, user);
        user.setRoles(Set.of(role));
        user.setSenha(passwordEncoder.encode(userdto.senha()));
        return userRepository.save(user);
    }

    // GET
    public Optional<UserModel> buscarUserPorId(Long id) {
        return userRepository.findById(id);
    }

    // PUT
    public UserModel atualizarUser(Long id, Userdto userdto) {
        UserModel userModel = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user não encontrado"));
        BeanUtils.copyProperties(userdto, userModel);
        userModel.setSenha(passwordEncoder.encode(userdto.senha()));

        if (userdto.role() != null && !userdto.role().isBlank()) {
            RoleModel novaRole = roleRepository.findByNome(userdto.role());
            if (novaRole != null) {
                Set<RoleModel> rolesAtuais = userModel.getRoles();
                if (rolesAtuais == null) {
                    rolesAtuais = new HashSet<>();
                }

                if (!rolesAtuais.contains(novaRole)) {
                    rolesAtuais.add(novaRole);
                    userModel.setRoles(rolesAtuais);
                }
            } else {
                throw new IllegalArgumentException("Role informada não existe: " + userdto.role());
            }
        }
        return userRepository.save(userModel);
    }

    //DELETE
    public UserModel deleteUser(Long id) {
       UserModel userModel = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User não encontrado."));
        userRepository.delete(userModel);
        return userModel;
    }

}
