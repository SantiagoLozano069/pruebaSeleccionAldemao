package com.aldemao.pruebaSeleccionAldemao.dtos;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ResponseDTO implements Serializable {

    private String codeMessage;
    private String message;
    private List<Integer> response;
}
