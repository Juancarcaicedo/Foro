package com.example.Foro.services;

import com.example.Foro.services.DTO.Request.TopicosReqDTO;
import com.example.Foro.services.DTO.Response.TopicosResponseDTO;

import java.util.List;

public interface TopicoService {
    List<TopicosResponseDTO>listarTopicos();
    TopicosResponseDTO crearTopico(TopicosReqDTO topicoRequestDTO);
    TopicosResponseDTO actualizarTopico(Long id, TopicosReqDTO topicoRequestDTO);
}
