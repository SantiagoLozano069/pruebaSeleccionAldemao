package com.aldemao.pruebaSeleccionAldemao;

import com.aldemao.pruebaSeleccionAldemao.entities.ArraysEntity;
import com.aldemao.pruebaSeleccionAldemao.repository.barTenderImpl.IBartenderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PruebaSeleccionAldemaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaSeleccionAldemaoApplication.class, args);
    }

}
