package com.api.locadoraveiculos.dtos;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class EmpregoDto {

    @NotBlank
    private String descricao;
    @NotBlank
    private double renda;
    @NotBlank
    private boolean ativo;

    @NotBlank
    private Set<ClienteEmpregoDto> clienteEmprego;

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
