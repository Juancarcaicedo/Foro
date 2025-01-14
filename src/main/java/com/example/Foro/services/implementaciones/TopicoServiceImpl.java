package com.example.Foro.services.implementaciones;

import com.example.Foro.config.Enum.Curso;
import com.example.Foro.entity.Topico;
import com.example.Foro.entity.Usuario;
import com.example.Foro.repository.TopicosRepository;
import com.example.Foro.repository.UsuarioRepository;
import com.example.Foro.services.DTO.Request.TopicosReqDTO;
import com.example.Foro.services.DTO.Response.TopicosResponseDTO;
import com.example.Foro.services.TopicoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoServiceImpl implements TopicoService {
    private  final  TopicosRepository topicosRepository;
    private  final UsuarioRepository usuarioRepository;
    public TopicoServiceImpl(TopicosRepository topicoRepository, UsuarioRepository usuarioRepository) {
        this.topicosRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
    }



    @Override
    public List<TopicosResponseDTO> listarTopicos() {
        List<Topico> topicos = topicosRepository.findAll();
        if (topicos.isEmpty()) {
            throw new RuntimeException("No hay tópicos disponibles");
        }
        return topicos.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TopicosResponseDTO crearTopico(TopicosReqDTO topicoRequestDTO) {
        Usuario usuario = usuarioRepository.findById(topicoRequestDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Topico topico = new Topico();
        topico.setTitulo(topicoRequestDTO.getTitulo());
        topico.setDescripcion(topicoRequestDTO.getDescripcion());
        topico.setUsuario(usuario);
        topico.setCurso(Curso.valueOf(topicoRequestDTO.getCurso()));
        topico = topicosRepository.save(topico);
        topico.setFechaCreacion(LocalDate.now());
        return mapToResponseDTO(topico);
    }

    @Override
    public TopicosResponseDTO actualizarTopico(Long id, TopicosReqDTO topicoRequestDTO) {
        Topico topico = topicosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
        topico.setTitulo(topicoRequestDTO.getTitulo());
        topico.setDescripcion(topicoRequestDTO.getDescripcion());
        topico.setCurso(Curso.valueOf(topicoRequestDTO.getCurso())); // Asumiendo que Curso es un Enum

        if (topicoRequestDTO.getUsuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(topicoRequestDTO.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            topico.setUsuario(usuario);
        }
        topico = topicosRepository.save(topico);
        return mapToResponseDTO(topico);
    }

    private TopicosResponseDTO mapToResponseDTO(Topico topico) {
        TopicosResponseDTO responseDTO = new TopicosResponseDTO();
        responseDTO.setId(topico.getId());
        responseDTO.setTitulo(topico.getTitulo());
        responseDTO.setDescripcion(topico.getDescripcion());
        responseDTO.setFechaCreacion(topico.getFechaCreacion());
        responseDTO.setCurso(topico.getCurso().name());
        responseDTO.setEmail(topico.getUsuario().getEmail());
        return responseDTO;
    }
}
