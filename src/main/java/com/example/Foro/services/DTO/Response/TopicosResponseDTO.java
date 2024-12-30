package com.example.Foro.services.DTO.Response;

import com.example.Foro.entity.Usuario;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TopicosResponseDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private UsuarioResponseDTO usuarioResponseDTO;
}
