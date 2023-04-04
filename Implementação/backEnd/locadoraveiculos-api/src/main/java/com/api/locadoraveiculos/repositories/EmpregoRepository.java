package com.api.locadoraveiculos.repositories;

import com.api.locadoraveiculos.models.EmpregoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmpregoRepository extends JpaRepository<EmpregoModel, UUID> {

}
