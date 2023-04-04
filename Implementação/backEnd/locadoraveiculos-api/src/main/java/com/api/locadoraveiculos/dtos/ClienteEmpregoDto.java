package com.api.locadoraveiculos.dtos;

import javax.validation.constraints.NotBlank;

public class ClienteEmpregoDto {

    @NotBlank
    private ClienteDto cliente;

    @NotBlank
    private EmpregoDto empregoDto;

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public EmpregoDto getEmpregoDto() {
        return empregoDto;
    }

    public void setEmpregoDto(EmpregoDto empregoDto) {
        this.empregoDto = empregoDto;
    }
}