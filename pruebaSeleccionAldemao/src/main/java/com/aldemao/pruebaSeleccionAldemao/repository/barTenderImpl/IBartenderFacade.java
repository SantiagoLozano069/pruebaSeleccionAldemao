package com.aldemao.pruebaSeleccionAldemao.repository.barTenderImpl;

import com.aldemao.pruebaSeleccionAldemao.entities.ArraysEntity;

import java.util.List;

public interface IBartenderFacade {

    ArraysEntity getArrayById(Integer id);

    void saveArrays(List<ArraysEntity> arraysEntity);
}
