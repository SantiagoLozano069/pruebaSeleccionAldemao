package com.aldemao.pruebaSeleccionAldemao.repository.barTenderImpl;

import com.aldemao.pruebaSeleccionAldemao.entities.ArraysEntity;
import com.aldemao.pruebaSeleccionAldemao.repository.IBarTenderRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BarTenderImpl implements IBartenderFacade{

    private final IBarTenderRepository barTenderRepository;

    public BarTenderImpl(IBarTenderRepository barTenderRepository){
        this.barTenderRepository = barTenderRepository;
    }

    @Override
    public ArraysEntity getArrayById(Integer id) {
        return barTenderRepository.getById(id) ;
    }

    @Override
    public void saveArrays(List<ArraysEntity> arraysEntity) {
        barTenderRepository.saveAll(arraysEntity);
    }
}
