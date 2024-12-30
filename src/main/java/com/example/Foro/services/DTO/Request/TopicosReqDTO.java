package com.example.Foro.services.DTO.Request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TopicosReqDTO {
    private String titulo;
    private  String descripcion;
    private LocalDate fechaCreacion;


}
