package com.aldemao.pruebaSeleccionAldemao.services;

import com.aldemao.pruebaSeleccionAldemao.dtos.InputDTO;
import com.aldemao.pruebaSeleccionAldemao.dtos.ResponseDTO;

public interface IBarTenderService {

    ResponseDTO barTender(InputDTO inputDTO);
}
