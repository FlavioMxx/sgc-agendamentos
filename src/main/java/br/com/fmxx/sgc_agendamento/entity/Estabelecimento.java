package br.com.fmxx.sgc_agendamento.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tb_estabelecimento")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cl_id")
    private Long id;

    @Column(name = "cl_nome_estab")
    private String nomeEstabelecimento;
    @Column(name = "cl_endereco_estab")
    private String enderecoEstabelecimento;
    @Column(name = "cl_contato_estab")
    private String contatoEstabelecimento;
    @Column(name = "cl_ativo")
    private Boolean ativo;
}
