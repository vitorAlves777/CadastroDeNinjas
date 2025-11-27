package dev.java10x.CadastroDeNinjas.Missoes;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_missao")
public class MissaoModel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String rank;

    public MissaoModel() {
    }


}
