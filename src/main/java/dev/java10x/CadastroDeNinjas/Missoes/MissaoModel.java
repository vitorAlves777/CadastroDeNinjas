package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missao")
public class MissaoModel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String rank;

    // Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninja;

    public MissaoModel() {
    }

    public MissaoModel(String nome, String rank) {
        this.nome = nome;
        this.rank = rank;
    }

    public MissaoModel(String nome, String rank, List<NinjaModel> ninja) {
        this.nome = nome;
        this.rank = rank;
        this.ninja = ninja;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}
