package com.api.locadoraveiculos.services;

import com.api.locadoraveiculos.models.ClienteEmpregoModel;
import com.api.locadoraveiculos.repositories.ClienteEmpregoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteEmpregoService {

    final ClienteEmpregoRepository clienteEmpregoRepository;

    public ClienteEmpregoService(ClienteEmpregoRepository clienteEmpregoRepository) {
        this.clienteEmpregoRepository = clienteEmpregoRepository;
    }

    @Transactional
    public ClienteEmpregoModel save(ClienteEmpregoModel clienteEmpregoModel) {
        return clienteEmpregoRepository.save(clienteEmpregoModel);
    }


    public Page<ClienteEmpregoModel> findAll(Pageable pageable) {
        return clienteEmpregoRepository.findAll(pageable);
    }

    public Optional<ClienteEmpregoModel> findById(UUID id) {
        return clienteEmpregoRepository.findById(id);
    }

    @Transactional
    public void delete(ClienteEmpregoModel clienteEmpregoModel) {
        clienteEmpregoRepository.delete(clienteEmpregoModel);
    }
}