package com.aldemao.pruebaSeleccionAldemao.dtos;


import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class InputDTO implements Serializable {

    private Integer q; // Numero de itereaciones
    private Integer id; // Id de la pila de datos a trabajar
}
