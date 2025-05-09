package com.teste.primeiro_exemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.primeiro_exemplo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
