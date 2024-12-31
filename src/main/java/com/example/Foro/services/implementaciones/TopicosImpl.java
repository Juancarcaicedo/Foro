package com.example.Foro.services.implementaciones;

import com.example.Foro.entity.Topico;
import com.example.Foro.repository.TopicosRepository;
import com.example.Foro.services.DTO.Response.TopicosResponseDTO;
import com.example.Foro.services.IServiceTopicos;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TopicosImpl  implements IServiceTopicos {
    private TopicosRepository topicosRepository;
    private ModelMapper modelMapper;
    @Override
    public List<TopicosResponseDTO> listarAllTopicos() {
        List<Topico> listadetopicos = topicosRepository.findAll();
        if (listadetopicos == null || listadetopicos.isEmpty()) {
            throw new RuntimeException("No se encontraron tópicos en la base de datos");
        }
        return listadetopicos.stream()
                .map(topico -> modelMapper.map(topico, TopicosResponseDTO.class))
                .collect(Collectors.toList());
    }

}
