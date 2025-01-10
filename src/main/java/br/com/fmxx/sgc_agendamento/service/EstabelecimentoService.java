package br.com.fmxx.sgc_agendamento.service;

import br.com.fmxx.sgc_agendamento.dto.EstabelecimentoDTO;
import br.com.fmxx.sgc_agendamento.entity.Estabelecimento;
import br.com.fmxx.sgc_agendamento.mapper.EstabelecimentoMapper;
import br.com.fmxx.sgc_agendamento.repository.EstabelecimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoRepository repository;
    private final EstabelecimentoMapper mapper;

    public EstabelecimentoDTO criarEstabelecimento(EstabelecimentoDTO estabelecimentoDTO) {

        //TODO validacoes dos campos internos nulos ou vazios.

        Estabelecimento novoEstabelecimento = repository.save(mapper.dtoToEntity(estabelecimentoDTO));

        return mapper.entityToDto(novoEstabelecimento);
    }

    public List<EstabelecimentoDTO> buscarEstabelecimentos() {
        List<Estabelecimento> estabelecimentoList = repository.findAll();

        return estabelecimentoList
                .stream()
                .map(mapper::entityToDto)
                .toList();
    }
}
