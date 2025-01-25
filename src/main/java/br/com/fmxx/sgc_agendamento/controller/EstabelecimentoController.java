package br.com.fmxx.sgc_agendamento.controller;

import br.com.fmxx.sgc_agendamento.dto.EstabelecimentoRequestDTO;
import br.com.fmxx.sgc_agendamento.dto.EstabelecimentoResponseDTO;
import br.com.fmxx.sgc_agendamento.service.EstabelecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estabelecimentos")
@RequiredArgsConstructor
public class EstabelecimentoController {

    private final EstabelecimentoService service;

    @PostMapping
    public ResponseEntity<EstabelecimentoResponseDTO> criarEstabelecimento(@RequestBody EstabelecimentoRequestDTO estabelecimento) throws IllegalAccessException {
        EstabelecimentoResponseDTO novoEstabelecimento = service.criarEstabelecimento(estabelecimento);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novoEstabelecimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstabelecimentoResponseDTO> atualizarEstabelecimento(@PathVariable Long id, @RequestBody EstabelecimentoRequestDTO estabelecimento) throws IllegalAccessException {

        EstabelecimentoResponseDTO estabelecimentoAtualizado = service.atualizarEstabelecimento(id, estabelecimento);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(estabelecimentoAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<EstabelecimentoResponseDTO>> buscarEstabelecimentos() {
        List<EstabelecimentoResponseDTO> estabelecimentoList = service.buscarEstabelecimentos();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(estabelecimentoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarEstabelecimentoPorID(@PathVariable Long id) {

        String mensagemRetorno = service.deletarEstabelecimentoPorID(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mensagemRetorno);
    }
}
