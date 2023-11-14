package com.example.LDC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LDC.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long > {

}
