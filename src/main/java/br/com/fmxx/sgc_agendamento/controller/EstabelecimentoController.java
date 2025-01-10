package br.com.fmxx.sgc_agendamento.controller;

import br.com.fmxx.sgc_agendamento.dto.EstabelecimentoDTO;
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
    private ResponseEntity<EstabelecimentoDTO> criarEstabelecimento(@RequestBody EstabelecimentoDTO estabelecimento) throws IllegalAccessException {
        EstabelecimentoDTO novoEstabelecimento = service.criarEstabelecimento(estabelecimento);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novoEstabelecimento);
    }

    @GetMapping
    private ResponseEntity<List<EstabelecimentoDTO>> buscarEstabelecimentos() {
        List<EstabelecimentoDTO> estabelecimentoList = service.buscarEstabelecimentos();

        return ResponseEntity
                .ok()
                .body(estabelecimentoList);
    }
}
