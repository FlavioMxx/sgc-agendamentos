package br.com.fmxx.sgc_agendamento.service;

import br.com.fmxx.sgc_agendamento.dto.EstabelecimentoDTO;
import br.com.fmxx.sgc_agendamento.entity.Estabelecimento;
import br.com.fmxx.sgc_agendamento.exceptions.EntidadeInexistenteException;
import br.com.fmxx.sgc_agendamento.mapper.EstabelecimentoMapper;
import br.com.fmxx.sgc_agendamento.repository.EstabelecimentoRepository;
import br.com.fmxx.sgc_agendamento.validator.DadosInvalidosValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoRepository repository;
    private final EstabelecimentoMapper mapper;

    public EstabelecimentoDTO criarEstabelecimento(EstabelecimentoDTO estabelecimentoDTO) throws IllegalAccessException {

        DadosInvalidosValidator.validar(estabelecimentoDTO);

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

    public String deletarEstabelecimentoPorID(Long id) {
    	
    	Estabelecimento estabelecimento = repository.findById(id)
                .orElseThrow(() -> new EntidadeInexistenteException("Estabelecimento nao existe: id" + id));

        repository.deleteById(id);

		return "Estabelecimento " + estabelecimento.getNomeEstabelecimento()
                + "\nid " + estabelecimento.getId()
                + "\nDELETADO COM SUCESSO!";
    }
}
