package com.dio.live.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.live.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
