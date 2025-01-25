package br.com.fmxx.sgc_agendamento.repository;

import br.com.fmxx.sgc_agendamento.entity.Procedimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimentosRepository extends JpaRepository<Procedimentos, Long> { }
