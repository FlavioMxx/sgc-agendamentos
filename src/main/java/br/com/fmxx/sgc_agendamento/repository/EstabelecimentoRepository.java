package br.com.fmxx.sgc_agendamento.repository;

import br.com.fmxx.sgc_agendamento.entity.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> { }