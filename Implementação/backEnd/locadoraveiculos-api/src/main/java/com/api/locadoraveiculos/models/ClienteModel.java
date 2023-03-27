package com.api.locadoraveiculos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "cliente")
public class ClienteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true, length = 11)
    private String cpf;
    @Column(nullable = false, length = 11)
    private String cnh;
    @Column(nullable = false, length = 200)
    private String endereco;
    @Column(nullable = false, length = 12)
    private String dataNascimento;
    @Column(nullable = false, length = 12)
    private String rg;
    @Column(nullable = false, length = 50)
    private String profissao;
    @Column(nullable = false, length = 150)
    private String rendimentos;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimeto) {
        this.dataNascimento = dataNascimeto;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getRendimentos() {
        return rendimentos;
    }

    public void setRendimentos(String rendimentos) {
        this.rendimentos = rendimentos;
    }
}
