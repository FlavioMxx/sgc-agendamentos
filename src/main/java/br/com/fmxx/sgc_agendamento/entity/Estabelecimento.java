package br.com.fmxx.sgc_agendamento.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "tb_estabelecimento")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cl_id")
    private Long id;

    @NotNull
    @Column(name = "cl_nome_estab")
    private String nomeEstabelecimento;
    @NotNull
    @Column(name = "cl_endereco_estab")
    private String enderecoEstabelecimento;
    @NotNull
    @Column(name = "cl_contato_estab")
    private String contatoEstabelecimento;
    @NotNull
    @Column(name = "cl_ativo")
    private Boolean ativo;
}
