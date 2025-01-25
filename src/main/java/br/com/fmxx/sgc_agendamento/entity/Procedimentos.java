package br.com.fmxx.sgc_agendamento.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "tb_procedimentos")
public class Procedimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cl_id")
    private Long id;

    @Column(name = "cl_nome_procedimento")
    private String nomeProcedimento;
    @Column(name = "cl_desc_procedimento")
    private String descricaoProcedimento;
    @Column(name = "cl_duracao_minutos_procedimento")
    private Integer duracaoMinutosProcedimento;
    @Column(name = "cl_valor_procedimento")
    private BigDecimal valorProcedimento;
}
