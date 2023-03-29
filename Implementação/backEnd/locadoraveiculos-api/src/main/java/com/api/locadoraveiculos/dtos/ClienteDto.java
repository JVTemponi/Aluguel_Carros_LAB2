package com.api.locadoraveiculos.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteDto {

    @NotBlank
    private String cpf;
    @NotBlank
    private String nome;
    @NotBlank
    private String cnh;
    @NotBlank
    private String endereco;
    @NotBlank
    private String dataNascimento;
    @NotBlank
    private String rg;
    @NotBlank
    private String profissao;
    @NotBlank
    private String rendimentos;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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
