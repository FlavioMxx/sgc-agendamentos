package br.com.fmxx.sgc_agendamento.controller;

import br.com.fmxx.sgc_agendamento.dto.ProcedimentosRequestDTO;
import br.com.fmxx.sgc_agendamento.dto.ProcedimentosResponseDTO;
import br.com.fmxx.sgc_agendamento.service.ProcedimentosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procedimentos")
@RequiredArgsConstructor
public class ProcedimentosController {

    private final ProcedimentosService service;

    @PostMapping
    public ResponseEntity<ProcedimentosResponseDTO> criarProcedimento(@RequestBody ProcedimentosRequestDTO procedimentos) throws IllegalAccessException {

        ProcedimentosResponseDTO novoProcedimento = service.criarProcedimentos(procedimentos);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novoProcedimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcedimentosResponseDTO> atualizarProcedimentos(@PathVariable Long id, @RequestBody ProcedimentosRequestDTO procedimentos) throws IllegalAccessException {

        ProcedimentosResponseDTO procedimentoAtualizado = service.atualizarProcedimentos(id, procedimentos);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(procedimentoAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<ProcedimentosResponseDTO>> buscarProcedimentos() {
        List<ProcedimentosResponseDTO> procedimentosList = service.buscarProcedimentos();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(procedimentosList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProcedimentoPorID(@PathVariable Long id) {

        String mensagemRetorno = service.deletarProcedimentoPorID(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mensagemRetorno);
    }
}
