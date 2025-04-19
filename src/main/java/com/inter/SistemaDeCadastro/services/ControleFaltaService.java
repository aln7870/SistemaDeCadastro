package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.ControleFaltaDto;
import com.inter.SistemaDeCadastro.interfaces.ControleFaltaRepository;
import com.inter.SistemaDeCadastro.interfaces.InscricaoModalidadeRepository;
import com.inter.SistemaDeCadastro.interfaces.UserRepository;
import com.inter.SistemaDeCadastro.models.ControleFaltaModel;
import com.inter.SistemaDeCadastro.models.InscricaoModalidadeModel;
import com.inter.SistemaDeCadastro.models.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ControleFaltaService {

    @Autowired
    private ControleFaltaRepository controleFaltaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InscricaoModalidadeRepository inscricaoModalidadeRepository;

    public List<ControleFaltaModel> listarTodos() {
        return controleFaltaRepository.findAll();
    }

    public Optional<ControleFaltaModel> buscarPorId(Long id) {
        return controleFaltaRepository.findById(id);
    }

    public ControleFaltaModel criar(ControleFaltaDto dto) {
        ControleFaltaModel model = new ControleFaltaModel();
        BeanUtils.copyProperties(dto, model, "user", "inscricaoModalidade");

        UserModel user = userRepository.findById(dto.codUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        InscricaoModalidadeModel inscricao = inscricaoModalidadeRepository.findById(dto.codInscricaoModalidade())
                .orElseThrow(() -> new RuntimeException("Inscrição de modalidade não encontrada"));

        model.setUser(user);
        model.setInscricaoModalidade(inscricao);

        return controleFaltaRepository.save(model);
    }

    public ControleFaltaModel atualizar(Long id, ControleFaltaDto dto) {
        ControleFaltaModel model = controleFaltaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Controle de falta não encontrado"));

        BeanUtils.copyProperties(dto, model, "codControleFalta", "user", "inscricaoModalidade");

        UserModel user = userRepository.findById(dto.codUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        InscricaoModalidadeModel inscricao = inscricaoModalidadeRepository.findById(dto.codInscricaoModalidade())
                .orElseThrow(() -> new RuntimeException("Inscrição de modalidade não encontrada"));

        model.setUser(user);
        model.setInscricaoModalidade(inscricao);

        return controleFaltaRepository.save(model);
    }
}
