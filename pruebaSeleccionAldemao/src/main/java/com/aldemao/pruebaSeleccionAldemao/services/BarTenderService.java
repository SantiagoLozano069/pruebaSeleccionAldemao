package com.aldemao.pruebaSeleccionAldemao.services;

import com.aldemao.pruebaSeleccionAldemao.dtos.InputDTO;
import com.aldemao.pruebaSeleccionAldemao.dtos.ResponseDTO;
import com.aldemao.pruebaSeleccionAldemao.entities.ArraysEntity;
import com.aldemao.pruebaSeleccionAldemao.repository.barTenderImpl.IBartenderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarTenderService implements IBarTenderService {

    final List<Integer> arregloPrimos = Arrays.asList(2, 3, 5, 7, 11, 13, 17);
    private final IBartenderFacade bartenderFacade;

    @Autowired
    public BarTenderService(IBartenderFacade bartenderFacade) {
        this.bartenderFacade = bartenderFacade;
    }

    @Override
    public ResponseDTO barTender(InputDTO inputDTO) {
        if (validacionEntrada(inputDTO)) {
            saveDate();
            ArraysEntity arraysEntity = bartenderFacade.getArrayById(inputDTO.getId());
            List<String> list = Arrays.asList(arraysEntity.getInputArray().split(","));
            List<Integer> listDB = list.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
            List<Integer> respuesta = new ArrayList<>();
            List<Integer> ai = new ArrayList<>();
            List<Integer> aiDelete = new ArrayList<>();
            int cont = 1;

            while (cont <= inputDTO.getQ()) {
                if (cont == 1) {
                    for (Integer arr : listDB) {
                        float cociente = (float) arr / arregloPrimos.get(cont - 1);
                        if (cociente == (int) cociente) {
                            respuesta.add(0, arr);
                        } else {
                            ai.add(arr);
                        }
                    }
                } else {
                    for (Integer arr : ai) {
                        float cociente = (float) arr / arregloPrimos.get(cont - 1);
                        if (cociente == (int) cociente) {
                            respuesta.add(arr);
                            aiDelete.add(arr);
                        }
                    }
                    if (!aiDelete.isEmpty()) {
                        ai.removeAll(aiDelete);
                    }
                }
                if (cont == inputDTO.getQ()) {
                    respuesta.addAll(ai);
                }
                cont++;
            }
            return ResponseDTO.builder().codeMessage("200").message("Success").response(respuesta).build();
        } else {
            return ResponseDTO.builder().codeMessage("400").message("Bad Request. El atributo id es mayor a 5").response(null).build();
        }
    }

    //metodo para llenar la BD temporal H2 con la información dada
    public void saveDate() {
        List<ArraysEntity> arraysEntities = new ArrayList<>();
        ArraysEntity arraysEntity1 = ArraysEntity.builder().inputArray("2,4,5,6,7,8").build();
        ArraysEntity arraysEntity2 = ArraysEntity.builder().inputArray("3,7,9,5,4,2").build();
        ArraysEntity arraysEntity3 = ArraysEntity.builder().inputArray("5,7,9,11,13").build();
        ArraysEntity arraysEntity4 = ArraysEntity.builder().inputArray("6,4,2,12,15").build();
        ArraysEntity arraysEntity5 = ArraysEntity.builder().inputArray("7,10,15,11,9").build();
        ArraysEntity arraysEntityEjemplo6 = ArraysEntity.builder().inputArray("2,3,4,5,6,7").build();
        arraysEntities.add(arraysEntity1);
        arraysEntities.add(arraysEntity2);
        arraysEntities.add(arraysEntity3);
        arraysEntities.add(arraysEntity4);
        arraysEntities.add(arraysEntity5);
        arraysEntities.add(arraysEntityEjemplo6);
        bartenderFacade.saveArrays(arraysEntities);
    }

    public boolean validacionEntrada(InputDTO inputDTO) {
        if (inputDTO.getId() <= 5) {
            return true;
        } else {
            return false;
        }
    }
}
