package com.api.locadoraveiculos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "cliente_emprego")
public class ClienteEmpregoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "emprego_id")
    EmpregoModel emprego;


}
