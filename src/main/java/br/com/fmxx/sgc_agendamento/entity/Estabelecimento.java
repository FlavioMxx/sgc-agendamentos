package br.com.fmxx.sgc_agendamento.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Column(name = "cl_procedimentos")
    private List<Procedimentos> procedimentos = new ArrayList<>();
}
