package com.aldemao.pruebaSeleccionAldemao.controller;

import com.aldemao.pruebaSeleccionAldemao.dtos.InputDTO;
import com.aldemao.pruebaSeleccionAldemao.dtos.ResponseDTO;
import com.aldemao.pruebaSeleccionAldemao.services.IBarTenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BarTender {


    private final IBarTenderService barTenderService;

    @Autowired
    public BarTender(IBarTenderService barTenderService) {
        this.barTenderService = barTenderService;

    }

    @PostMapping("/barTender")
    public ResponseEntity<ResponseDTO> barTender(@RequestBody InputDTO inputDTO) {
        if (inputDTO.getId() == null || inputDTO.getQ() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(barTenderService.barTender(inputDTO));
    }


}
