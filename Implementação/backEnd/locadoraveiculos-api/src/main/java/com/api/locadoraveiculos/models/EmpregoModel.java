package com.api.locadoraveiculos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "emprego")
public class EmpregoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true, length = 150)
    private String descricao;

    @Column(nullable = true)
    private double renda;
    @Column(nullable = true)
    private boolean ativo;

    @OneToMany(mappedBy = "emprego")
    Set<ClienteEmpregoModel> clienteEmprego;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
