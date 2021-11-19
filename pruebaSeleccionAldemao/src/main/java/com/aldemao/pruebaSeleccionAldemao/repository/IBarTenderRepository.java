package com.aldemao.pruebaSeleccionAldemao.repository;

import com.aldemao.pruebaSeleccionAldemao.entities.ArraysEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBarTenderRepository extends JpaRepository<ArraysEntity, Integer> {
}
