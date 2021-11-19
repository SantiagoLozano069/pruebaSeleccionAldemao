package com.aldemao.pruebaSeleccionAldemao.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ARRAYS")
public class ArraysEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "input_array")
    private String inputArray;

}
