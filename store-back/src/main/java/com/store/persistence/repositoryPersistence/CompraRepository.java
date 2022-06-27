package com.store.persistence.repositoryPersistence;

import com.store.persistence.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompraRepository extends JpaRepository<Compra,Long> {

    Optional<List<Compra>> findByIdCliente(String idClient);
}
