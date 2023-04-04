package com.api.locadoraveiculos.repositories;

import com.api.locadoraveiculos.models.ClienteEmpregoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteEmpregoRepository extends JpaRepository<ClienteEmpregoModel, UUID> {

}
