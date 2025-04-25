package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.AlunoCadastroDto;
import com.inter.SistemaDeCadastro.services.AlunoCadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunoCadastro")
public class AlunoCadastroController {

    @Autowired
    private AlunoCadastroService alunoCadastroService;

    // Método para buscar o nome de usuário logado (e.g., através do Spring Security)
    private String getLoggedInUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody @Valid AlunoCadastroDto alunoDto) {
        // Pega o username do usuário logado e converte para o codUsuario
        String createdBy = getLoggedInUsername();
        Integer codUser = Integer.parseInt(createdBy);

        // Criando um novo DTO para passar para o service com o codUser
        AlunoCadastroDto alunoDtoComUsuario = new AlunoCadastroDto(
                alunoDto.nomeAluno(),
                alunoDto.dataNascimento(),
                alunoDto.sexo(),
                alunoDto.cpf(),
                alunoDto.rg(),
                alunoDto.nacionalidade(),
                alunoDto.codEscolaridade(),
                codUser, // Cod do usuário logado
                alunoDto.cep(),
                alunoDto.rua(),
                alunoDto.bairro(),
                alunoDto.cidade(),
                alunoDto.numero(),
                alunoDto.resideCom(),
                alunoDto.outroResideCom(),
                alunoDto.responsavelEmergencial(),
                alunoDto.telefonePrincipal(),
                alunoDto.telefoneEmergencial(),
                alunoDto.email(),
                alunoDto.descricaoAlergia(),
                alunoDto.descricaoMedicacao(),
                alunoDto.descricaoProblemaSaude(),
                alunoDto.tipoDeficienca(),
                alunoDto.nomeFamiliar(),
                alunoDto.dataNascimentoFamiliar(),
                alunoDto.parentesco(),
                alunoDto.codEscolaridadeFamiliar(),
                alunoDto.codOcupacaoFamiliar(),
                alunoDto.codModalidade(),
                alunoDto.codTurno()
        );

        // Chamando o serviço para salvar o aluno com o DTO completo
        alunoCadastroService.cadastrarAlunoCompleto(alunoDtoComUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body("Aluno cadastrado com sucesso.");
    }
}
